package eroomrentRegistrationAndLogin;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EroomrentOwnerRegistration
{
	WebDriver driver;
	By Header = By.xpath("//h1");
	By FullName = By.xpath("//input[@id='txtname']");
	By Mobile = By.xpath("//input[@id='txtmobile1']");
	By Password = By.xpath("//input[@id='txtpass']");
	By Confirm =By.xpath("//input[@id='txtcpass']");
	By Email =By.xpath("input[@id='txtEmail']");
	
	public EroomrentOwnerRegistration(WebDriver driver) 
	{
		this.driver = driver;
	}
	public void veryHeader() 
	{
		String getheadertext = driver.findElement(Header).getText().trim();
		assertEquals("Create a FREE Account", getheadertext);
	}
	public void enterFullName(String arg1) 
	{
		driver.findElement(FullName).sendKeys(arg1);
	}
	public void enterMobile(String arg1) 
	{
		driver.findElement(Mobile).sendKeys(arg1);
	}
	public void enterPasswrod(String arg1) 
	{
		driver.findElement(Password).sendKeys(arg1);
	}
	public void enterConfirmPasswrod(String arg1) 
	{
		driver.findElement(Confirm).sendKeys(arg1);
	}
	public void enterEmail(String arg1) 
	{
		driver.findElement(Email).sendKeys(arg1);
	}
}
