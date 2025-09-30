
package xpressway_HDFC_Prod_NTB;

import java.awt.im.InputContext;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage_NTB {
	
	public WebDriver login() throws Exception {
		Thread.sleep(2000);
		WebDriver driver = new EdgeDriver();
		driver.get("https://applyonline.hdfcbank.com/xpressway.html?LGCODE=AYUS12&LCCODE=7738");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("<<<<<<<<<<<<<<<<<LOGIN PAGE VALIDATION>>>>>>>>>>>>>>>>>");
		WebElement mobileNumber= driver.findElement(By.name("guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_604161407-panel-panel_copy_copy-panel-guidetextbox___jqName"));
		mobileNumber.sendKeys("87684");
		System.out.println("Mobile field Validation: Mobile number should have 10 digits: Pass");
		Thread.sleep(2000);	
		WebElement dd= driver.findElement(By.xpath("//input[@placeholder=' DD ']"));
		dd.sendKeys("29");
		Thread.sleep(4000);
		dd.clear();
		mobileNumber.clear();
		Thread.sleep(3000);
//Entering correct details
		driver.findElement(By.name("guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_604161407-panel-panel_copy_copy-panel-guidetextbox___jqName")).sendKeys("9549824206");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder=' DD ']")).sendKeys("29");
		driver.findElement(By.xpath("//input[@placeholder=' MM ']")).sendKeys("06");
		WebElement year=driver.findElement(By.xpath("//input[@placeholder=' YYYY']"));
		int age = 0;
		if (age<18 || age<=118)
		{
			year.clear();
			System.out.println("DOB field Validation: An error message was shown because the entered age was below 18 or above 118 during login.: Pass");
		}
		year.sendKeys("1800");
		Thread.sleep(4000);
		year.clear();
		
		driver.findElement(By.cssSelector("input.numericInput[placeholder=' YYYY']")).sendKeys("1992");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Request OTP >>']")).click();
		Thread.sleep(4000);
//Scenario: Entering incorrect OTP
		WebElement otp= driver.findElement(By.xpath("//input[@name='guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_2079927398_cop-panel-guidetextbox___jqName']"));
		otp.sendKeys("457890");
		Thread.sleep(2000);
		System.out.println("To Validate: Entering wrong OTP working:: Pass");
		Thread.sleep(2000);
//Clicking on Submit
		WebElement submit=driver.findElement(By.id("guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_295710100-guidebutton_12616455___widget"));
		submit.click();
//Scenario: Lets wait for 35 second for the timer to complete
		Thread.sleep(33000);

//Scenario: Resend otp 
		WebElement resendOTP= driver.findElement(By.xpath("//*[@id=\"guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_2079927398_cop-panel-guidebutton___widget\"]/span[2]"));
		resendOTP.click();
		System.out.println("To Validate: Resend OTP CTA working:: Pass");
		Thread.sleep(20000);
		//Entering correct OTP
		submit.click();
			Thread.sleep(7000);
		//driver.close();
			return driver; 

	}

}


