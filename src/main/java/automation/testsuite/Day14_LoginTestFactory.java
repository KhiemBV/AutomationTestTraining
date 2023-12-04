package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.ConstantAccount;
import automation.page.Day14_LoginPageFactory;

public class Day14_LoginTestFactory extends CommonBase{
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(ConstantAccount.RISE_URL);
	}

	@Test(priority = 1)
	public void LoginSuccessfully() {
		Day14_LoginPageFactory login = new Day14_LoginPageFactory(driver);
		login.LoginFuntion("admin@demo.com", "riseDemo");
		assertTrue(isElementPresent(ConstantAccount.DASHBOARD_TEXT));
		
	}

	@Test(priority = 2)
	public void LoginFailIncorrertEmail() {
		Day14_LoginPageFactory login = new Day14_LoginPageFactory(driver);
		login.LoginFuntion("ahihi@demo.com", "riseDemo");
		assertEquals(true, isElementPresent(ConstantAccount.AUTHENICATION_ALERT));
	}
	
	@Test(priority = 3)
	public void LoginFailIncorrertPassword() {
		Day14_LoginPageFactory login = new Day14_LoginPageFactory(driver);
		login.LoginFuntion("admin@demo.com", "ahihi");
		assertEquals(true, isElementPresent(ConstantAccount.AUTHENICATION_ALERT));
	}
	
	@Test(priority = 1)
	public void LogoutSuccessfully() {
		Day14_LoginPageFactory login = new Day14_LoginPageFactory(driver);
		login.LogoutFuntion("admin@demo.com", "riseDemo");
		assertEquals(true, isElementPresent(ConstantAccount.BUTTON_SIGNIN));
	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
