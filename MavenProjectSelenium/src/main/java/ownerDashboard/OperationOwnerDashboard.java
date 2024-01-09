package ownerDashboard;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OperationOwnerDashboard 
{
	WebDriver driver;
	OwnerLogindashboard obj;
	
	@BeforeTest
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://eroomrent.in");
	}
	
	@Test
	public void performAction() {
		obj = new OwnerLogindashboard(driver); 
			obj.actionperform();
			obj.EnterUserName("skub12@gmail.com");
			obj.EnterPassword("12345678");
			obj.Enterbutton();
			obj.EnterAddroom();
			obj.EnterSLocation();
			obj.Entercategory();
			obj.Entersubcategory();
			obj.EnterRoomDes("2 bhk flat available");
			obj.EnterChoosefile("D:\\essentia-luxury-hotel.jpg");
			obj.EnterRoomprice("8963");
			obj.EnterRoomfacility("fully furnised");
			obj.EnterInsert();
			obj.EnterViewRoom();
			obj.EnterBooking();
			obj.Enterlogout();
		}
}
