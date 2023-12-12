package automation.testsuite;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.ConstantAccount;
import automation.page.Day14_Hw_RegisterPage;

public class Day14_Hw_RegisterTest extends CommonBase {

	private String name = "Bui Viet Khiem";
	private String email = "admin3@demo.com";
	private String password = "demo13579";
	private String phonenumber = "0987123654";
	private String newPassword = "demo13579";

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(ConstantAccount.ALADA_URL);
	}

	@Test(priority = 1)
	public void RegisterSuccessfully() {
		Day14_Hw_RegisterPage register = new Day14_Hw_RegisterPage(driver);
		register.RegisterFuntion(name, email, password, phonenumber);
		assertTrue(isElementPresent(ConstantAccount.ALADA_USER_AVATAR));

	}

	@Test(priority = 2)
	public void ChangePasswordSuccessfully() {
		// change password
		Day14_Hw_RegisterPage register = new Day14_Hw_RegisterPage(driver);
		register.ChangePasswordFuntion(email, password, newPassword);
		pause(2000);
		String alertTextString = driver.switchTo().alert().getText();
		assertEquals(alertTextString, "Cập nhật mật khẩu mới thành công!");
		driver.switchTo().alert().accept();
	}

	@Test(priority = 3)
	public void LoginWithNewPasswordSuccessfully() {
		Day14_Hw_RegisterPage login = new Day14_Hw_RegisterPage(driver);
		login.LoginFuntion(email, newPassword);
		assertTrue(isElementPresent(ConstantAccount.ALADA_USER_AVATAR));
	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
