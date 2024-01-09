package eroomrentRegistrationAndLogin;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EroomrentHomePage 
{
	WebDriver driver;
	By Header=By.xpath("//h1");
	By getStarted=By.xpath("//*[@id='Owner-GloginButton']");
	public EroomrentHomePage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public void header() 
	{
		String getheadertext=driver.findElement(Header).getText();
		assertEquals("find the room", getheadertext);
	}
	public void clickOnGetStarted() 
	{
		driver.findElement(getStarted).click();
	}
}


                                  