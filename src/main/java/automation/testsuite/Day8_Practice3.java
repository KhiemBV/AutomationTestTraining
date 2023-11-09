package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day8_Practice3 extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
	}
	
	@Test
	public void getLocatorOnThePage() {
		// user email
		System.out.println("email: " + driver.findElement(By.id("userId")));
		// password
		System.out.println("pass: " + driver.findElement(By.id("pass")));
		// company
		System.out.println("company: " + driver.findElement(By.name("company")));
		// mobile number
		System.out.println("mobile: " + driver.findElement(By.name("mobile number")));
	}
	
	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
