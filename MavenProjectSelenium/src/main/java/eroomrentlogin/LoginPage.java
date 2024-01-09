package eroomrentlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
	WebDriver driver;
	By username = By.name("txtEmail");
	By password = By.name("txtPassword");
	By btn = By.name("btnsubmit");

	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void enterUsername(String arg1)
	{
		driver.findElement(username).sendKeys(arg1);
	}
	public void enterPassword(String arg1) 
	{
		driver.findElement(password).sendKeys(arg1);
	}
	public void clickOnGetStarted() 
	{
		driver.findElement(btn).click();
	}
}
