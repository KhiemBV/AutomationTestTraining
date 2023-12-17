package automation.testsuite;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import automation.common.CommonBase;

public class Day12_Homework extends CommonBase {
	
	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get("http://demo.seleniumeasy.com/input-form-demo.html");
	}
	
	@Test(priority = 1)
	public void checkOnDropdown() {
		WebElement selectElement = driver.findElement(By.xpath("//form[@id='contact_form']//select[@name='state']"));
		Select dropdownlist = new Select(selectElement);
		// choose 1 option of dropdown list
		selectElement.click();
		dropdownlist.selectByVisibleText("Colorado");
		System.out.println("Choose Colorado on dropdown list");
	}

	@Test(priority = 2)
	public void checkOnCheckbox() {
		WebElement yesElement = driver.findElement(By.xpath("//input[@name='hosting' and @value='yes']"));
		WebElement noElement = driver.findElement(By.xpath("//input[@name='hosting' and @value='no']"));
		// check default status
		System.out.println("Default status of 'Yes' is: " + yesElement.isSelected());
		System.out.println("Default status of 'No' is: " + noElement.isSelected());
		// click button when it is not selected
		if (yesElement.isEnabled() && !yesElement.isSelected()) {
			yesElement.click();
			System.out.println("After click 'Yes', status of 'Yes' is: " + yesElement.isSelected());
		}
		// click button when it is not selected but another is selected
		if (noElement.isEnabled() && yesElement.isSelected()) {
			System.out.print("Status of 'Yes' is: " + yesElement.isSelected() + " ,");
			noElement.click();
			System.out.println("after click 'No', status of 'Yes' change to: " + yesElement.isSelected());
		}
	}

	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
