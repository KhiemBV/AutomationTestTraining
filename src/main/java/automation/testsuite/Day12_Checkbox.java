package automation.testsuite;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day12_Checkbox extends CommonBase {

	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}

	@Test(priority = 1)
	public void clickOnSingleCheckbox() {
		// kiem tra Default check box da dc check
		WebElement DefaultCheckbox = driver.findElement(By.xpath("//label[contains(normalize-space(),'Default Checked')]/child::input"));
		boolean ischecked = DefaultCheckbox.isSelected();
		System.out.println("Default checkbox is checked: " + ischecked);
		
		// kiem tra checkbox CLick on this check box chua dc checked thi se dc check
		WebElement clickOnThisCheckbox = driver.findElement(By.xpath("//label[contains(normalize-space(),'Default Checked')]/preceding-sibling::label//input"));
		if ( clickOnThisCheckbox.isSelected() == false) {
			clickOnThisCheckbox.click();
			System.out.println("Click on this checkbox is checked");
		}
	}
	
	@Test(priority = 2)
	public void clickOnMultiCheckbox() {
		List<WebElement> listCheckbox = driver.findElements(By.xpath("//div[normalize-space()= 'Multiple Checkbox Demo']/following-sibling::div[@class='panel-body']/child::div[@class='checkbox']//input"));
		for (WebElement checkbox : listCheckbox) {
			if (!checkbox.isSelected()) {
				checkbox.click();
				System.out.println("checkbox da dc checked");
			}
		}
	}

	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
