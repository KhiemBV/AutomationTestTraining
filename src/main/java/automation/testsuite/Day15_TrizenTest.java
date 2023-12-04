package automation.testsuite;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.ConstantAccount;
import automation.page.Day15_TrizenPage;

public class Day15_TrizenTest extends CommonBase{
	
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(ConstantAccount.TRIZEN_URL);
	}

	@Test(priority = 1)
	public void searchFlySuccessfully() throws InterruptedException {
		Day15_TrizenPage trizen = new Day15_TrizenPage(driver);
		trizen.HandleDateTimeAndDropdownList("Ha Noi", "Ho Chi Minh", "01012024", "Business");
		assertTrue(isElementPresent(ConstantAccount.SEARCH_RESULT));
	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
