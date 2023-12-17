package automation.testsuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day7_Practice1 extends CommonBase{
	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get("https://bepantoan.vn/");
	}
	
	@Test
	public void test() {
		System.out.println("Hello my first project!");
	}
	
	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
