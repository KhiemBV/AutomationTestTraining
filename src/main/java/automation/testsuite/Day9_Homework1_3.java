package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day9_Homework1_3 extends CommonBase {
	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
	}

	@Test
	// Bai 1
	public void getLocatorByXpath_1() {
		// user email
		System.out.println("user email: " + driver.findElement(By.xpath("//input[@id='userId']")));
		// password
		System.out.println("password: " + driver.findElement(By.xpath("//input[@id='pass' and @name='Password']")));
		// company
		System.out.println("company: "
				+ driver.findElement(By.xpath("//div[@class='element-companyId']//input[@name='company']")));
		// mobile number
		System.out.println("mobile: "
				+ driver.findElement(By.xpath("//div[@class='element-companyId']//input[@name='mobile number']")));
		// submit button
		System.out.println("submit button: " + driver.findElement(By.xpath("//input[@value='Submit']")));
	}

	@Test
	// Bai 3
	public void getLocatorByXpath_3() {
		// John Smith
		System.out.println("John Smith: " + driver.findElement(By.xpath("//td[text()='John Smith']/..")));
		// Jordan Mathews
		System.out.println("Jordan Mathews: " + driver.findElement(By.xpath("//a[text()='Jordan.Mathews']/../..")));
		// Kevin Mathews
		System.out.println("Kevin Mathews: "
				+ driver.findElement(By.xpath("(//tr[@class='plan rit'])[last()]")));
	}

	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
