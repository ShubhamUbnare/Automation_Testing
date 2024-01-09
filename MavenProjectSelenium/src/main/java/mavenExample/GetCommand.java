package mavenExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCommand {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://shivatutorial.in/");		
	}

}
