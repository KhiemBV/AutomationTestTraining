package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day18_Homework_Ex1 extends CommonBase{
	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("firefox") String browser) {
		driver = setupDriver(browser);
		driver.get("https://dienmaynhapkhaugiare.com.vn/");
	}
	
	@Test
	public void testZaloConnectFuntion() {
		clickByJS(By.xpath("//div[@id='zalo-vr']//a"));
		String mainWindow = driver.getWindowHandle();
		Set<String> listWindow = driver.getWindowHandles();
		
		for (String window : listWindow) {
			if (!mainWindow.equalsIgnoreCase(window)) {
				driver.switchTo().window(window);
				pause(2000);
				String url = driver.getCurrentUrl();
				assertEquals(url, "https://zalo.me/0988169282");
				driver.switchTo().window(mainWindow);
			}
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		closeDriver();
	}

}
