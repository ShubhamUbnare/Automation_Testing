package hybridExecution;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import operations.Operation;
import readexcel.ReadExcel;
import readobject.ReadObject;

public class HybridMainclass 
{
	WebDriver driver = null;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test(dataProvider="hybridData")
	public void testLogin(String testcaseName,String keyword,String objectName,
			String objectType,String value) throws Exception 
	{	
		ReadObject object = new ReadObject();                                        // TODO Auto-generated method stub
		Properties allObjects = object.getObjectRepository();
		Operation operation = new Operation(driver);

		operation.perform(allObjects, keyword, objectName,objectType,value);         //Call perform function to perform operation on UI
		System.out.println(keyword + " "+ objectName +  " " + objectType + " " + value);
	}
	@DataProvider(name="hybridData")
	public Object[][] getDataFromDataprovider() throws IOException
	{
		Object[][] object = null;
		ReadExcel file = new ReadExcel();
		Sheet guru99Sheet = file.readExcel(System.getProperty
				("user.dir")+"\\","registration.xlsx" ,"KeywordFramework");             //Read keyword sheet

		int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();         //Find number of rows in excel file
		object = new Object[rowCount][5];
		for (int i = 0; i < rowCount; i++) 
		{
			Row row = guru99Sheet.getRow(i+1);                                       //Loop over all the rows

			for (int j = 0; j < row.getLastCellNum(); j++)                         	//Create a loop to print cell values in a row
			{ 			
				object[i][j] = row.getCell(j).toString();                           //Print excel data in console
			}
		}
		System.out.println("");
		return object;    
	}
}
