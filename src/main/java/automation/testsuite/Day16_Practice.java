package automation.testsuite;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day16_Practice extends CommonBase {

	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
	}

	@Test(priority = 1)
	public void deleteCustomerSuccessfully() {
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		
		type(By.xpath("//input[@name='cusid']"), "1234");
		click(By.xpath("//input[@name='submit']"));
		String msgConfirm = driver.switchTo().alert().getText();
		assertEquals(msgConfirm, "Do you really want to delete this Customer?");
		driver.switchTo().alert().accept();
		String msgInform = driver.switchTo().alert().getText();
		assertEquals(msgInform, "Customer Successfully Delete!");
	}
	
	@Test(priority = 2)
	public void handleTextboxAlert() {
		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		click(By.xpath("//a[normalize-space()='Alert with OK']"));
		click(By.xpath("//div[@id='OKTab']//button"));
		assertEquals(driver.switchTo().alert().getText(), "I am an alert box!");
		driver.switchTo().alert().accept();
		
		click(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
		click(By.xpath("//div[@id='CancelTab']//button"));
		assertEquals(driver.switchTo().alert().getText(), "Press a Button !");
		driver.switchTo().alert().accept();
		assertTrue(isElementPresent(By.xpath("//p[contains(text(), 'You pressed Ok')]")));
		
		click(By.xpath("//a[normalize-space()= 'Alert with Textbox']"));
		click(By.xpath("//div[@id='Textbox']//button"));
		assertEquals(driver.switchTo().alert().getText(), "Please enter your name");
		driver.switchTo().alert().sendKeys("Aladeen");
		driver.switchTo().alert().accept();
		assertTrue(isElementPresent(By.xpath("//p[contains(text(), 'Aladeen')]")));
	}
	
	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
