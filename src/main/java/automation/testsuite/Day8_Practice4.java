package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day8_Practice4 extends CommonBase {
	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}
	
	@Test
	public void getLocatorOnThePage() {
		// name
		System.out.println("name: " + driver.findElement(By.id("name")));
		// address
		System.out.println("address: " + driver.findElement(By.id("address")));
		// email
		System.out.println("email: " + driver.findElement(By.id("email")));
		// password
		System.out.println("password: " + driver.findElement(By.name("password")));
	}
	
	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
