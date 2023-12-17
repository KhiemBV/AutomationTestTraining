package automation.testsuite;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.ConstantAccount;
import automation.page.Day14_Hw_RegisterPage;

public class Day16_Homework extends CommonBase {
	private String email = "admin3@demo.com";
	private String password = "demo13579";
	private String newPassword = "demo13579";

	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
	}

	@Test(priority = 1)
	public void Alada_ChangePasswordSuccessfully() {
		driver.get(ConstantAccount.ALADA_URL);
		// change password
		Day14_Hw_RegisterPage register = new Day14_Hw_RegisterPage(driver);
		register.ChangePasswordFuntion(email, password, newPassword);
		// verify alert
		waitAlertPresent();
		String alertTextString = driver.switchTo().alert().getText();
		assertEquals(alertTextString, "Cập nhật mật khẩu mới thành công!");
		driver.switchTo().alert().accept();
		// verify title
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "");
	}
	
	@Test (priority = 2)
	public void SeleniumPractice_AlertDemo() {
		driver.get("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
		
		click(By.xpath("//button[text()='Try it']"));
		waitAlertPresent();
		String alertMsg = driver.switchTo().alert().getText();
		assertEquals(alertMsg, "Welcome to Selenium WebDriver Tutorials");
		driver.switchTo().alert().accept();
	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
