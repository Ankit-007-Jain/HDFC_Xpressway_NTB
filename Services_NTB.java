
package xpressway_HDFC_Prod_NTB;

import java.awt.Desktop.Action;
import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Services_NTB {

	public WebDriver services() throws Exception {
		Products_NTB products=new Products_NTB(); //calling previous tab class
		WebDriver driver=products.homepage(); //calling method from created object
		Thread.sleep(3000);
		System.out.println("<<<<<<<<<<<<<<<<<SERVICES_PAGE VALIDATION>>>>>>>>>>>>>>>>>");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Navigating to PanUpdation page
		try {
		 WebElement panUpdation = driver.findElement(By.xpath("//p[contains(text(),'PAN Updation')]"));
//Defining outside if else statement so i can use it throughout my code		
		 ArrayList<String> tabs03=null;
//Here setting value as null and in if else statement i will set the value
		 if(panUpdation.isDisplayed())
		 {
		     // Move to the heading
		     Actions fastTag01 = new Actions(driver);
		     fastTag01.moveToElement(panUpdation).perform();
		     Thread.sleep(2000);
		     
		 //Now, below locator will click the Button next to the text; means it will click the button which is next to the
		     // specified text you located
		     WebElement panUpdationCTA = driver.findElement(By.xpath("//p[contains(text(),'PAN Updation')]/following::a[1]"));
		     // Click the button
		     panUpdationCTA.click(); 
		     tabs03= new ArrayList<String>(driver.getWindowHandles());
		     driver.switchTo().window(tabs03.get(1));
		     Thread.sleep(10000); 
		 
//Validate: LGCODE AND LCCODE IN THE URL
		String actualURL=driver.getCurrentUrl();
		
		if(actualURL.contains("LCCode=7738&LGCode=AYUS12"))
		{
			System.out.println("To Validate: Pan Updation Service URL Link Contains LG and LC code:: Pass");
		}
		else
		{
			System.out.println("To Validate: Pan Updation Service URL Link does not contains LG and LC code:: Fail");
		}}
		else
		{
			System.out.println("To Validate: Pan Updation service is not visible: Fail");
		}
		Thread.sleep(3000);
		driver.close();
		tabs03= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs03.get(0));
		Thread.sleep(4000);
		}
		catch(Exception e)
		{
			System.out.println("Pan Updation service is not visible on screen");
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
	//	To scroll back to the top of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");  // Scroll to top of the page
		Thread.sleep(2000);	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//To click on Explore tab
		WebElement explore= driver.findElement(By.id("guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_1476744642-panel_1876474291-panel_606864485-guidebutton_12888279___widget"));
		if(explore.isDisplayed())
		{
			System.out.println("To Validate: Navigating to Explore Tab:: Pass");
			Thread.sleep(2000);
			explore.click();
		}
		else {
			System.out.println("To Validate: Navigating to Explore Tab:: Fail");
		}

		//	Clicking Whatsapp CTA
		try {
		
		WebElement whatsappCTA = driver.findElement(By.xpath("//*[@id=\"guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_1476744642-panel_1876474291-panel_1430560025-panel_2108029993-imagewithtext_151866___guide-item\"]/div/div/div/div/div[2]/a/p"));
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		action.moveToElement(whatsappCTA).perform();
		Thread.sleep(2000);
		whatsappCTA.click();
	System.out.println("To Validate: Whatsapp function under Explore tab navigation is working:: Pass");
		Thread.sleep(4000);
		
		ArrayList<String> tabs1=new ArrayList<>(driver.getWindowHandles());  
		  driver.switchTo().window(tabs1.get(1));
		  String currentUrl02=driver.getCurrentUrl();
				  
		  if (currentUrl02.contains("LCCode=7738&LGCode=AYUS12")) {
		        System.out.println("To Validate: Whatsapp URL Contains LG and LC code:: Pass");
		    } else {
		        System.out.println("To Validate: Whatsapp URL Does Not Contain LG and LC code:: Fail");
		    }
		  Thread.sleep(5000);
		  driver.close();
		  Thread.sleep(4000);
		  driver.switchTo().window(tabs1.get(0));
		}
		catch(Exception e)
		{
			System.out.println("To Validate:: Whatsapp service is not visible");
		}
	//Clicking on To Top cta	
		Thread.sleep(3000);
		WebElement toTopCTA = driver.findElement(By.xpath("//*[@class='scrolltotop_desktop']"));
		if(toTopCTA.isDisplayed())
		{
			toTopCTA.click();
			Thread.sleep(1000);
			System.out.println("To Validate: To Top CTA under Explore tab is Working :: Pass");
		}
		else {
			System.out.println("To Validate: To Top CTA under Explore tab is Working :: Fail");
		}
		Thread.sleep(2000);
		return driver;		
		 }
	}

