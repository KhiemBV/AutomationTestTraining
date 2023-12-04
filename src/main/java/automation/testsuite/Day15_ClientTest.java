package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Pause;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.ConstantAccount;
import automation.page.Day14_LoginPageFactory;
import automation.page.Day15_ClientPage;

public class Day15_ClientTest extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(ConstantAccount.RISE_URL);
	}

	@Test(priority = 1)
	public void AddClientSuccessfully() throws InterruptedException {
		//login
		Day14_LoginPageFactory login = new Day14_LoginPageFactory(driver);
		login.LoginFuntion("admin@demo.com", "riseDemo");
		assertTrue(isElementPresent(ConstantAccount.DASHBOARD_TEXT));
		//
		Day15_ClientPage client = new Day15_ClientPage(driver);
		client.AddClientFuntion("Khiem company", "Sara Ann");
		Thread.sleep(2000);
		assertTrue(isElementPresent(By.xpath("//a[text()='Khiem company']")));
	}

//	@AfterMethod
//	public void closeChrome() {
//		closeDriver();
//	}
}
