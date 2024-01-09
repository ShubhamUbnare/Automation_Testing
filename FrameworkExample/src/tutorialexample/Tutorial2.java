package tutorialexample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tutorial2 
{
	ChromeDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	 @BeforeTest
	  public void TestSetup()
	 {	  
	   System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("https://eroomrent.in/login.php");
	   driver.manage().window().maximize();
	   }
  @Test
  public void f() {
	  try
	  {
		   File src=new File("d://framework1.xlsx"); 
		   FileInputStream finput = new FileInputStream(src);
		   workbook = new XSSFWorkbook(finput);
		   sheet= workbook.getSheetAt(0);
		   for(int i=1; i<=sheet.getLastRowNum(); i++)
		   {
			   cell = sheet.getRow(i).getCell(0);
			   cell.setCellType(CellType.STRING);
			   driver.findElement(By.name("txtEmail")).sendKeys(cell.getStringCellValue());
			   cell = sheet.getRow(i).getCell(1);
			   cell.setCellType(CellType.STRING);
			  driver.findElement(By.name("txtPassword")).sendKeys(cell.getStringCellValue());
			   WebElement we = driver.findElement(By.name("btnsubmit"));
			   we.click();
			   String s = driver.switchTo().alert().getText();
			   driver.switchTo().alert().accept();
			   System.out.println(s);
			   if(s.equals("Invalid userid and password"))
			   {
				   System.out.println("fail");
			   }
			   else
			   {
				   System.out.println("pass");
			   }
			   finput.close();
			   cell = sheet.getRow(i).createCell(2);
			   //cell.setCellType(CellType.STRING);
			   cell.setCellValue(s);
			FileOutputStream fout = new FileOutputStream(src); 
			workbook.write(fout);
			fout.close();
		   }
	  }
	  catch(Exception ex)
	  {
		  System.out.print(ex.getMessage().toString());
	  }
  }
}
