package automation.testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Login extends CommonBase{

	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("https://bepantoan.vn/");
	}
	
	@Test
	public void test() {
		System.out.println("Hello my first project!");
	}
}
