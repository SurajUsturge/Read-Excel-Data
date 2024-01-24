package read_data_from_excel;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Read_excel_data_using_loop 
{
	public static WebDriver driver;
	

	public static void main(String[] args) throws InvalidFormatException, IOException 
	{
		


		File fis=new File("C:\\Users\\Suraj\\Desktop\\testdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
////		String fullname=sheet.getRow(0).getCell(0).getStringCellValue();
//		String email=sheet.getRow(1).getCell(0).getStringCellValue();
//		String mobileno=sheet.getRow(2).getCell(0).getStringCellValue();
//		String password=sheet.getRow(3).getCell(0).getStringCellValue();
		String email = "";
		String fullname = "";
		String mobileno = "";
		String password = "";
		
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\sdet+\\SEED COURSE\\selenium automation testing\\automation programs\\Read_and_enter_test_data_from_excel_file\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/ap/register?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				if(i==0 && j==0)
				{
					fullname=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				else if(i==1 && j==0)
				{
					email=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				else if(i==2 && j==0)
				{
					mobileno=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				else if(i==3 && j==0)
				{
					password=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				
			}
		}
		
		driver.findElement(By.xpath("//input[@name='customerName']")).sendKeys(fullname);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='secondaryLoginClaim']")).sendKeys(mobileno);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			
	}

}