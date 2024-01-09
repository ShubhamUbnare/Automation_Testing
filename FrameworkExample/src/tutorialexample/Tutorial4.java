package tutorialexample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tutorial4 
{
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	@BeforeTest
	public void TestSetup()
	{
		System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");  
	}
	@Test
	public void setData() 
	{
		try
		{
			File src=new File("d://framework1.xlsx"); 
			FileInputStream finput = new FileInputStream(src);

			workbook = new XSSFWorkbook(finput);
			sheet= workbook.getSheetAt(0);
			for(int i=1; i<=sheet.getLastRowNum(); i++)
			{
				driver = new ChromeDriver();
				driver.get("https://eroomrent.in/ownerlogin.php");
				driver.manage().window().maximize();
				cell = sheet.getRow(i).getCell(0);
				cell.setCellType(CellType.STRING);
				driver.findElement(By.name("txtEmail")).sendKeys(cell.getStringCellValue());
				cell = sheet.getRow(i).getCell(1);
				cell.setCellType(CellType.STRING);
				driver.findElement(By.name("txtPassword")).sendKeys(cell.getStringCellValue());
				WebElement we = driver.findElement(By.name("btnsubmit"));
				we.click();
				String result="";
				if(driver.getCurrentUrl().toString().equals("https://eroomrent.in/ownerlogin.php"))
				{
					result = "fail";
				}
				else
				{
					result="pass";
				}
				FileOutputStream fout = new FileOutputStream("d://framework1.xlsx"); 
				cell = sheet.getRow(i).createCell(2);
				cell.setCellType(CellType.STRING); 
				cell.setCellValue(result);

				workbook.write(fout);
				fout.close();
			}
		}
		catch(Exception ex)
		{
			System.out.print(ex.getMessage().toString());
		}
	}
	@AfterTest
	public void TestSetupclose()
	{
		driver.quit();
	}

}
