package browserStackExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OperationBrowserStack 
{
	WebDriver driver;
	BrowserStackHomePage objBrowserStackHomePage;
	BrowserStackSignUpPage objBrowserStackSignUpPage;
	
	@BeforeTest
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.browserstack.com/");
	}

	@Test(priority = 1)
	public void navigate_to_homepage_click_on_getstarted() 
	{
		objBrowserStackHomePage = new BrowserStackHomePage(driver);
		objBrowserStackHomePage.veryHeader();
		objBrowserStackHomePage.clickOnGetStarted();
	}

	@Test(priority = 2)
	public void enter_userDetails() 
	{
		objBrowserStackSignUpPage = new BrowserStackSignUpPage(driver);
		objBrowserStackSignUpPage.veryHeader();
		objBrowserStackSignUpPage.enterFullName("TestUser");
		objBrowserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
		objBrowserStackSignUpPage.enterPasswrod("TestUserPassword");
	}
}
