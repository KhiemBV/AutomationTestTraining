package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day9_Homework2 extends CommonBase {
	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("https://chercher.tech/practice/dynamic-table");
	}

	@Test
	public void getLocatorByXpath() {
		// blueberry
		System.out.println("Blueberry: " + driver.findElement(By.xpath("//button[@id='blue']")));
		// orange
		System.out.println("Orange: " + driver.findElement(By.xpath("//button[text()='Orange']")));
		// juice
		System.out.println("Juice: " + driver.findElement(By.xpath("//button[text()='Juice']")));
		// banana
		System.out.println("banana: " + driver.findElement(By.xpath("//button[text()='banana']")));
		// Banana "Juice
		System.out.println("Banana Juice: " + driver.findElement(By.xpath("//button[text()='banana']/..//button[last()]")));
		// Zack Snyder
		System.out.println("Zack Snyder: " + driver.findElement(By.xpath("//button[text()='banana']//..//input")));
		// output
		System.out.println("Zack Snyder: " + driver.findElement(By.xpath("//h1[@id='output']")));
	}

	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
