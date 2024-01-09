package eroomrentRegistrationAndLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Operation
{
	WebDriver driver;
	EroomrentHomePage objEroomrentHomePage;
	EroomrentOwnerRegistration objEroomrentOwnerRegistration;
	
	@BeforeTest
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://eroomrent.in/index.php");
	}

	@Test(priority = 1)
	public void navigate_to_homepage_click_on_getstarted() 
	{
		objEroomrentHomePage = new EroomrentHomePage(driver);
		objEroomrentHomePage.header();
		objEroomrentHomePage.clickOnGetStarted();
	}
	@Test(priority = 2)
	public void enter_userDetails() 
	{
		objEroomrentOwnerRegistration = new EroomrentOwnerRegistration(driver);
		objEroomrentOwnerRegistration.veryHeader();
		objEroomrentOwnerRegistration.enterFullName("Ramesh Kumar");
		objEroomrentOwnerRegistration.enterMobile("9876543210");
		objEroomrentOwnerRegistration.enterPasswrod("12345678");
		objEroomrentOwnerRegistration.enterConfirmPasswrod("12345678");
		objEroomrentOwnerRegistration.enterEmail("sk12@gmail.com");		
	}
}
