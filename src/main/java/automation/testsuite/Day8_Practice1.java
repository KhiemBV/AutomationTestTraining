package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day8_Practice1 extends CommonBase {
	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("https://rise.fairsketch.com/signin");
	}
	
	@Test
	public void getLocatorByID_Name_Class() {
		WebElement email = driver.findElement(By.id("email"));
		System.out.println("Email: " + email);
		
		WebElement password = driver.findElement(By.name("password"));
		System.out.println("Password: " + password);
		
		WebElement button = driver.findElement(By.className("w-100"));
		System.out.println("Signin button: " + button);
	}
	
	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
