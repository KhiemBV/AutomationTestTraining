package automation.testsuite;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day8_Practice2 extends CommonBase {

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver("https://bepantoan.vn/");
	}

	@Test
	public void getLocatorByText() {
		WebElement text = driver.findElement(By.linkText("Máy Rửa Chén Bát"));
		System.out.println("Text: " + text);

		WebElement partialText = driver.findElement(By.partialLinkText("Cổ Điển"));
		System.out.println("Partial Text : " + partialText);
	}

	@Test
	public void getLocatorByClassName_TagName() {
		System.out.println("ClassName: " + driver.findElement(By.className("cursor-pointer")));
		
		System.out.println("Tagname: " + driver.findElement(By.tagName("input")));
	}

	@AfterMethod
	public void closeChrome() {
		driver.close();
	}
}
