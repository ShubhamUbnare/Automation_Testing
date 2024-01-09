package executions;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import operations.Operation;
import readexcel.ReadExcel;
import readobject.ReadObject;

public class RegistrationExecutionMain
{
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void mainMathod() throws Exception 
	{
		ReadExcel file = new ReadExcel();
		ReadObject object = new ReadObject();
		Properties allObjects = object.getObjectRepository();
		Operation operation = new Operation(driver);

		Sheet sheet = file.readExcel(System.getProperty
				("user.dir")+"\\","registration.xlsx" ,"KeywordFramework");
		int rowCount =sheet.getLastRowNum()-sheet.getFirstRowNum();
		for (int i = 1; i < rowCount+1; i++) 
		{
			Row row = sheet.getRow(i);
			if(row.getCell(0).toString().length()==0)
			{
				System.out.println(row.getCell(1).toString()+"----"+ row.getCell(2).toString()+"----"+
						row.getCell(3).toString()+"----"+ row.getCell(4).toString());
				operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(), 
						row.getCell(3).toString(), row.getCell(4).toString());
			}
			else
			{
				System.out.println("New Testcase->"+row.getCell(0).toString() +" Started");
			}
		}	   
	}
	@AfterMethod
	public void afterMethod() 
	{     
		driver.switchTo().alert().accept();
		driver.close();
	}
}
