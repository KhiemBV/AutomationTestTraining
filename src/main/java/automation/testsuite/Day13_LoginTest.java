package automation.testsuite;

import static org.testng.Assert.*;

import org.testng.annotations.*;
import automation.common.CommonBase;
import automation.constant.ConstantAccount;
import automation.page.LoginPage;

public class Day13_LoginTest extends CommonBase{
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(ConstantAccount.RISE_URL);
	}

	@Test(priority = 1)
	public void LoginSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.loginFuntion("admin@demo.com", "riseDemo");
		assertEquals(true, driver.findElement(ConstantAccount.DASHBOARD_TEXT).isDisplayed());
	}

	@Test(priority = 2)
	public void LoginFailIncorrertEmail() {
		LoginPage login = new LoginPage(driver);
		login.loginFuntion("ahihi@demo.com", "riseDemo");
		assertEquals(true, driver.findElement(ConstantAccount.AUTHENICATION_ALERT).isDisplayed());
	}
	
	@Test(priority = 3)
	public void LoginFailIncorrertPassword() {
		LoginPage login = new LoginPage(driver);
		login.loginFuntion("admin@demo.com", "ahihi");
		assertEquals(true, driver.findElement(ConstantAccount.AUTHENICATION_ALERT).isDisplayed());
	}
	
	@Test(priority = 4)
	public void LoginFailIncorrertEmail_Password() {
		LoginPage login = new LoginPage(driver);
		login.loginFuntion("ahihi@demo.com", "ahihi");
		assertEquals(true, driver.findElement(ConstantAccount.AUTHENICATION_ALERT).isDisplayed());
	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
