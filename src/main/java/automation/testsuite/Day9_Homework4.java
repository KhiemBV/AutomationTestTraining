package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day9_Homework4 extends CommonBase {
	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("https://www.google.com/");
	}

	@Test
	public void getLocatorByXpath() {
		// button search
		System.out.println("search: " + driver.findElement(By.xpath("(//input[@class='gNO89b' and @value='Tìm trên Google'])[last()]")));
		// first page searched
		System.out.println("first page: " + driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[last()]")));
		// Google
		System.out.println("Google image: " + driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']//img")));
	}

	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
