package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day17_Practice extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		//
	}

	@Test
	public void handlePopupWindow() {
		driver = initChromeDriver("https://demo.guru99.com/popup.php");
		
		click(By.xpath("//a[text()='Click Here']"));
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		for (String window : windows) {
			if (!mainWindow.equalsIgnoreCase(window)) {
				driver.switchTo().window(window);
				type(By.name("emailid"), "demo@email.com");
				click(By.name("btnLogin"));
				assertEquals(true, isElementPresent(By.xpath("//h2[text()='Access details to demo site.']")));
				click(By.xpath("//a[text()='Click Here']"));
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/popup.php");
	}
	
	@Test
	public void handleIFrame_GuiNgay() {
		driver = initChromeDriver("https://codestar.vn/");
		
		pause(5000);
		int size = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			int elements = driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
			System.out.println("button: " + elements);
			if (elements != 0) {
				type(By.id("account_phone"), "123456789");
				click(By.xpath("//button[text()='Gửi ngay']"));
				assertEquals(true, isElementPresent(By.xpath("//button[text()='Gửi ngay']")));
				driver.switchTo().defaultContent();
			} else 
				driver.switchTo().defaultContent();
		}
	}
	
	@Test
	public void handleIFrame_DangKyNgay() {
		driver = initChromeDriver("https://codestar.vn/");
		
		waitIFramePresent(By.tagName("iframe"));
		int size = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < size; i++) {
			driver.switchTo().frame(i);
			if (isElementPresent(By.xpath("//button[text()='Đăng ký ngay']"))) {
				type(By.id("account_phone"), "123456789");
				click(By.xpath("//button[text()='Đăng ký ngay']"));
				assertEquals(true, isElementPresent(By.xpath("//button[text()='Đăng ký ngay']")));
				driver.switchTo().defaultContent();
			} else 
				driver.switchTo().defaultContent();
		}
	}
	
	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
