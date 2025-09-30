package xpressway_HDFC_Prod_NTB;

import org.openqa.selenium.WebDriver;

public class MainMethod_NTB {

	public static void main(String[] args) throws Exception {
		DigitalPlatform_NTB digits= new DigitalPlatform_NTB();
		WebDriver driver= digits.digital();

	}

}
