package automation.testsuite;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import automation.common.CommonBase;

public class Day12_Dropdown extends CommonBase {

	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
	}
	
	@Test(priority = 1)
	public void checkOnDropdown() throws InterruptedException {
		WebElement selecttag = driver.findElement(By.id("select-demo"));
		Select dropdownlist = new Select(selecttag);
		System.out.println("dropdown is multiple: " + dropdownlist.isMultiple());
		System.out.println("dropdown size: " + dropdownlist.getOptions().size());
		// chon Sun day bang cach value
		selecttag.click();
		dropdownlist.selectByValue("Sunday");
		System.out.println("dropdown 1st option is: " + dropdownlist.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		// chon Monday bang cach visible text
		selecttag.click();
		dropdownlist.selectByVisibleText("Monday");
		System.out.println("dropdown 1st option is: " + dropdownlist.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		// chon Tuesday bang cach index
		selecttag.click();
		dropdownlist.selectByIndex(3);
		System.out.println("dropdown 1st option is: " + dropdownlist.getFirstSelectedOption().getText());
		Thread.sleep(2000);
	}

	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
