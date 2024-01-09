package tutorialexample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tutorial3 {
	 WebDriver driver;
	  XSSFWorkbook workbook;
	  XSSFSheet sheet;
	  XSSFCell cell;
	  
	  @BeforeTest
	  public void TestSetup()
	 {	  
	   System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("https://eroomrent.in/login.php");
	   driver.manage().window().maximize();
	 }
	 
	  @Test
	  public void setData() {
	   try
	   {
	   File src=new File("d://framework1.xlsx");
	  
	   // Load the file.
	   FileInputStream finput = new FileInputStream(src);
	  
	   // Load he workbook.
	  workbook = new XSSFWorkbook(finput);
	  
	      // Load the sheet in which data is stored.
	   sheet= workbook.getSheetAt(0);
	  
	   for(int i=1; i<=sheet.getLastRowNum(); i++)
	   {
	    // Import data for Email.
	    cell = sheet.getRow(i).getCell(0);
	    cell.setCellType(CellType.STRING);
	    driver.findElement(By.name("txtEmail")).sendKeys(cell.getStringCellValue());
	   
	    // Import data for the password.
	    cell = sheet.getRow(i).getCell(1);
	    cell.setCellType(CellType.STRING);
	    driver.findElement(By.name("txtPassword")).sendKeys(cell.getStringCellValue());
	    WebElement we = driver.findElement(By.name("btnsubmit"));
	    we.click();
	         }
	   }
	   catch(IOException ex)
	   {
		   System.out.print(ex.getMessage().toString());
	   }

}
}
