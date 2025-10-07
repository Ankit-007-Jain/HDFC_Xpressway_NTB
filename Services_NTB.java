
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Services_NTB {

	public WebDriver services() throws Exception {
		Products_NTB homey=new Products_NTB(); //calling previous tab class
		WebDriver driver=homey.homepage(); //calling method from created object
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
//		else
//		{
//			System.out.println("To Validate: Pan Updation service is not visible: Fail");
//		}
		Thread.sleep(3000);
		driver.close();
		tabs03= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs03.get(0));
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("Pan Updation service is not visible on screen");
		}
		
		//	To scroll back to the top of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");  // Scroll to top of the page
		Thread.sleep(3000);	
		
////////////////////////////////////////////////////////////////////////////////////////////////////////
//Selecting Loans from Filter and clicking on "Update Mobile Number"
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement filter = driver.findElement(By.cssSelector("select[aria-label='Service Grouping Filter']"));
WebElement filter1= driver.findElement(By.id("guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_1476744642-panel_1876474291-panel_897830868_copy-panel_50963200-guidedropdownlist___widget")
);
filter1.click();
Thread.sleep(4000);
			//If you want to select any value from dropdown so first locate the filter down arrow and
			// then use select method to select the value from the dropdown
Select select1 = new Select(filter);
select1.selectByVisibleText("Loans");
Thread.sleep(4000);
WebElement selectLoans= driver.findElement(By.xpath("//option[@value='Loans']"));
selectLoans.click();
Thread.sleep(4000);
			//Select select = new Select(filter);
			//select.selectByVisibleText("Loans");
			System.out.println("Loans filter selected successfully ::Pass");
			Thread.sleep(5000);
					
			//Clicking Update Mobile Number
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(4000);
		WebElement updateMobileNumber= driver.findElement(By.xpath("//*[contains(text(),'Update Mobile Number')]"));
		Actions actionss= new Actions(driver);
		actionss.moveToElement(updateMobileNumber).build().perform();
		Thread.sleep(4000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", updateMobileNumber);
		Thread.sleep(4000);

	/*	WebElement updateNowCTA = driver.findElement(By.xpath("//a[@class='xpressway_imagewithtext_rightSection-cta' and contains(@href,'journey=106') and .//p[normalize-space(text())='Update Now']]"));
		updateNowCTA.click();
			Thread.sleep(3000);
			WebElement updateNowCTA1 = driver.findElement(By.cssSelector("a.xpressway_imagewithtext_rightSection-cta[href*='journey=106']"));
			updateNowCTA1.click();
			*/
	
	/*	// Wait until the Update Now CTA is visible
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js11 = (JavascriptExecutor) driver;

		// Wait for CTA to be present and visible
		WebElement updateNowCTA = wait1.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//a[@class='xpressway_imagewithtext_rightSection-cta' and contains(@href,'journey=106') and .//p[normalize-space(text())='Update Now']]")));
		System.out.println("Update Now CTA located successfully.");

		// Scroll to the element to make sure it’s in viewport
		js11.executeScript("arguments[0].scrollIntoView({block: 'center'});", updateNowCTA);
		Thread.sleep(1500);

		// Move mouse to the element (for hover/focus behavior)
		Actions actions = new Actions(driver);
		actions.moveToElement(updateNowCTA).perform();
		Thread.sleep(1000);

		// Use JS click to handle overlays or dynamic layers
		js11.executeScript("arguments[0].click();", updateNowCTA);
		System.out.println("Clicked on Update Now CTA successfully.");

		// Wait for new tab to open
		Thread.sleep(5000);
		
		ArrayList<String> tabs04= new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs04.get(1));
	    Thread.sleep(10000); 

	////Validate: LGCODE AND LCCODE IN THE URL
	String actualURL=driver.getCurrentUrl();
	//
	if(actualURL.contains("LCCode=7738&LGCode=AYUS12"))
	{
		System.out.println("To Validate: User selects Loans Filter and clicked on Update Mobile Number whereas, URL contains LG Code and LC Code :: Pass");
	}
	else
	{
		System.out.println("To Validate: User selects Loans Filter and clicked on Update Mobile Number whereas, URL contains LG Code and LC Code:: Fail");
	}
	Thread.sleep(3000);
	driver.close();
	//tabs04= new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs04.get(0));
	Thread.sleep(5000);}
	*/
		}
		catch (Exception e)
		{
			System.out.println("To validate: Update Mobile Number service is visible ::Pass");
		}
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////		
	//	To scroll back to the top of the page
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("window.scrollTo(0, 0);");  // Scroll to top of the page
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

