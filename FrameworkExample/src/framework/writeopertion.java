package framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class writeopertion {
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	@Test
	public void f() throws IOException {
		File src=new File("d://testdata.xlsx"); 
		FileInputStream finput = new FileInputStream(src);

		workbook = new XSSFWorkbook(finput);
		sheet=  workbook.getSheetAt(0);
		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
			cell = sheet.getRow(i).getCell(0);

			//   cell.setCellType(CellType.STRING); 
			driver.findElement(By.name("txtEmail")).sendKeys(cell.getStringCellValue());

			cell = sheet.getRow(i).getCell(1);
			// cell.setCellType(XSSFCell.CELL_TYPE_STRING);
			cell.setCellType(CellType.STRING); 
			driver.findElement(By.name("txtPassword")).sendKeys(cell.getStringCellValue());
			cell.setCellType(CellType.STRING); 
			WebElement we = driver.findElement(By.name("btnsubmit"));
			we.click();
			String s1 = "";
			s1 = "pass";

			XSSFRow row = sheet.getRow(1);
			//  int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			//  XSSFRow newRow = sheet.createRow(1);
			XSSFCell cell = row.createCell(2);
			cell.setCellValue(s1);
			finput.close();

			FileOutputStream fout = new FileOutputStream(src); 
			workbook.write(fout);
			fout.close();
		}
	}
	@BeforeTest
	public void beforeTest() 
	{
		System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
		driver=new ChromeDriver();
	}

	@AfterTest
	public void afterTest() 
	{
		driver.close();
	}

}
