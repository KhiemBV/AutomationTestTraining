package automation.testsuite;

import static org.testng.Assert.*;

import org.testng.annotations.*;
import automation.common.CommonBase;
import automation.constant.ConstantAccount;
import automation.page.LoginPage;
import automation.page.Logout;

public class Day13_LogoutTest extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(ConstantAccount.RISE_URL);
	}

	@Test(priority = 1)
	public void LogoutSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.loginFuntion("admin@demo.com", "riseDemo");
		assertEquals(true, driver.findElement(ConstantAccount.DASHBOARD_TEXT).isDisplayed());

		Logout logout = new Logout(driver);
		logout.logoutFuntion();
		assertEquals(true, driver.findElement(ConstantAccount.BUTTON_SIGNIN).isDisplayed());

	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
