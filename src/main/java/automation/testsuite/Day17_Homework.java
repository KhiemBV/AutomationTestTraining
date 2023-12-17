package automation.testsuite;

import static org.testng.Assert.*;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import automation.common.CommonBase;

public class Day17_Homework extends CommonBase {
	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get("https://mediamart.vn/");
	}

	@Test
	public void handleIFrame_MediaMart() {
		// wait
		//waitIFramePresent(By.xpath("//div[@id='chat-plugins']//iframe"));  --> ko hoat dong??
		isElementPresent(By.xpath("//div[@class='chat-plugins']//iframe"));
		
		// switch to frame
		WebElement zaloIFrame = driver.findElement(By.xpath("//div[@id='chat-plugins']//iframe"));
		driver.switchTo().frame(zaloIFrame);
		
		assertEquals(false, isElementPresent(By.xpath("//div[@class='chat-wrapper za-chat__wrapper']")));
		click(By.xpath("//div[@class='logo']"));
		assertEquals(true, isElementPresent(By.xpath("//div[@class='chat-wrapper za-chat__wrapper']")));
		
//		click(By.xpath("//div[normalize-space()='Chat bằng Zalo']"));
//		String alertString = driver.switchTo().alert().getText();
//		System.out.println(alertString);

		assertEquals(false, isElementPresent(By.xpath("//div[@class='card']")));
		click(By.xpath("//div[normalize-space()='Chat nhanh']"));
		assertEquals(true, isElementPresent(By.xpath("//div[@class='card']")));	
	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
