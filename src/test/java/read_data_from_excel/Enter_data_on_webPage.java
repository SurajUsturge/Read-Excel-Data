package read_data_from_excel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Enter_data_on_webPage 
{
	public static WebDriver driver;
	//fetch test data from excel sheet and enter on webpage
	
	
//	static screenshot => this method can call at only once.
	public static void screentest() throws IOException
	{
		String filepath="E:\\sdet+\\SEED COURSE\\selenium automation testing\\automation programs\\Read_and_enter_test_data_from_excel_file\\screenshot\\image.jpg";   //image.jpg //image.png
		TakesScreenshot scrshot2=((TakesScreenshot)driver);
		File SrcFile=scrshot2.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(filepath);
		FileHandler.copy(SrcFile, DestFile);
	}

	
	public static void testing() throws IOException
	{
		String filepath="";
		TakesScreenshot ts=((TakesScreenshot)driver);
		File srcfile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(filepath);
		FileHandler.copy(srcfile, destFile);
	}
	
	
	
	public static void main(String[] args) throws InvalidFormatException, IOException 
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\selenium automation testing\\automation programs\\Read_and_enter_test_data_from_excel_file\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);


		File fis=new File("C:\\Users\\Suraj\\Desktop\\testdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		
		String username=sheet.getRow(0).getCell(0).getStringCellValue();
		String password=sheet.getRow(0).getCell(1).getStringCellValue();
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		screentest();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		screentest();
		driver.findElement(By.xpath("//button")).click();
		screentest();
		
	}

}
