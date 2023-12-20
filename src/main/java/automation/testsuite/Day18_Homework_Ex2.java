package automation.testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day18_Homework_Ex2 extends CommonBase{
	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(@Optional ("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get("https://bepantoan.vn/");
	}
	
	@Test
	public void testFuntion_ChatNgayVoiChungToi() {
		pause(2000);
		int frames = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < frames; i++) {
			try {
				driver.switchTo().frame(i);
				int elements = driver.findElements(By.xpath("//div[normalize-space()='Chát Ngay Với Chúng Tôi !' and @class='tawk-text-truncate']")).size();
				if (elements != 0) {
					click(By.xpath("//div[normalize-space()='Chát Ngay Với Chúng Tôi !' and @class='tawk-text-truncate']"));
					driver.switchTo().defaultContent();
					for (int j = 0; j < frames; j++) {
						try {
							if (i != j) {
								driver.switchTo().frame(j);
								if (!isElementPresent(By.xpath("//b[normalize-space()='CHÁT ONLINE NHẬN QUÀ KHUYẾN MÃI TRỊ GIÁ']"))) {
									if (isElementPresent(By.xpath("//button[normalize-space()='I accept']"))) {
										click(By.xpath("//button[normalize-space()='I accept']"));
										assertEquals(true, isElementPresent(By.xpath("//b[normalize-space()='CHÁT ONLINE NHẬN QUÀ KHUYẾN MÃI TRỊ GIÁ']")));	
									}
								} else {
									assertEquals(true, isElementPresent(By.xpath("//b[normalize-space()='CHÁT ONLINE NHẬN QUÀ KHUYẾN MÃI TRỊ GIÁ']")));
								}
								driver.switchTo().defaultContent();
							}
						} catch (Exception e) {
							continue;
						}
					}
				}
			} catch (Exception e) {
				continue;
			}
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		closeDriver();
	}
}
