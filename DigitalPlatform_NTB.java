package xpressway_HDFC_Prod_NTB;

import java.util.ArrayList;

import javax.swing.text.TabableView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DigitalPlatform_NTB {

	public WebDriver digital() throws Exception
	{
		Services_NTB service=new Services_NTB(); //calling previous tab class
		WebDriver driver=service.services(); //calling previous tab method from created object
		
		WebElement digitalPlatform= driver.findElement(By.xpath("//span[text()='Digital Platforms']"));
		digitalPlatform.click();
		System.out.println("<<<<<<<<<<<<<<<<<DigitalPlatforms_PAGE VALIDATION>>>>>>>>>>>>>>>>>");
		Thread.sleep(3000);
///////////////////////////////////////////////////////////////////////////////////////////////////
//Validating HDFC SKY navigation
		try {
			
	WebElement smartWealthCTA=driver.findElement(By.xpath("//*[text()='SmartWealth']"));
	Thread.sleep(2000);

//To navigate to HDFCSky and clicking
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", smartWealthCTA);
	Thread.sleep(8000);
//	hdfcSkyCTA.click();
	
	ArrayList<String> tab= new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tab.get(1));
	Thread.sleep(5000);
	String currentUrl03=driver.getCurrentUrl();
	if (currentUrl03.contains("LCCode=7738") && currentUrl03.contains("LGCode=AYUS12"))
	{  System.out.println("To Validate: Smart Wealth URL Contains LG and LC code:: Pass");  }
	else {
	        System.out.println("To Validate: Smart Wealth URL Does Not Contain LG and LC code:: Fail");
	    }
	driver.close();
	driver.switchTo().window(tab.get(0));
		}
		catch(Exception e)
		{
			System.out.println("To Validate:: Smart Wealth service is not visible:: Fail");
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//CLICKING OFFERS
	
	Thread.sleep(3000);
	System.out.println("<<<<<<<<<<<<<<<<<Offers_PAGE VALIDATION>>>>>>>>>>>>>>>>>");
WebElement offers=driver.findElement(By.xpath("//span[text()='Offers']"));
if(offers.isDisplayed())
{
	offers.click();
	System.out.println("To Validate:: Offers tab is redirecting: Pass");
	Thread.sleep(6000);
}
else {
	System.out.println("To Validate:: Offers tab is not redirecting: Fail");
}
ArrayList<String> offersTab=new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(offersTab.get(1));
driver.close();
driver.switchTo().window(offersTab.get(0));
Thread.sleep(3000);
driver.close();
//write all digital platform functionalities
//lets consider this final tab/class and next lets create main method and call DigitalPlatform class	
		return driver;		
	}

}
