package operations;

import java.util.Properties; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Operation 
{
	WebDriver driver;
	public Operation(WebDriver driver)
	{
		this.driver = driver;
	}
	public void perform(Properties p,String operation,
			String objectName,String objectType,String value) throws Exception
	{
		switch (operation.toUpperCase())
		{
		case "CLICK":                                                                                             //Perform click
			driver.findElement(this.getObject(p,objectName,objectType)).click();
			break;
		case "SETTEXT":                                                                                         //Set text on control
			driver.findElement(this.getObject(p,objectName,objectType)).sendKeys(new String(value));
			break;
		case "GOTOURL":                                                                                          //Get url of application	
			driver.get(p.getProperty(value));
			break;
		case "GETTEXT":                                                                                            //Get text of an element
			driver.findElement(this.getObject(p,objectName,objectType)).getText();
			break;
		case "DROPDOWN":                                                                                            // Select Dropdown List
			Select sk =new Select(driver.findElement(this.getObject(p,objectName,objectType)));
			sk.selectByVisibleText(value);
			break;
		default:
			break;
		}
	}
	private By getObject(Properties p,String objectName,String objectType) throws Exception
	{
		if(objectType.equalsIgnoreCase("XPATH"))                                                                 //Find by xpath
		{
			return By.xpath(p.getProperty(objectName));
		}
		else if(objectType.equalsIgnoreCase("ID"))                                                                            //find by ID
		{
			return By.id(p.getProperty(objectName));
		}
		else if(objectType.equalsIgnoreCase("CLASSNAME"))                                                           //find by class
		{
			return By.className(p.getProperty(objectName));
		}
		else if(objectType.equalsIgnoreCase("NAME"))                                                               //find by name
		{
			return By.name(p.getProperty(objectName));
		}
		else if(objectType.equalsIgnoreCase("CSS"))                                                                //Find by css
		{
			return By.cssSelector(p.getProperty(objectName));
		}
		else if(objectType.equalsIgnoreCase("LINK"))                                                              	//find by link
		{ 
			return By.linkText(p.getProperty(objectName));
		}
		else if(objectType.equalsIgnoreCase("PARTIALLINK"))                                                         //find by partial link
		{
			return By.partialLinkText(p.getProperty(objectName));
		}
		else
		{
			throw new Exception("Wrong object type");
		}
	}
}