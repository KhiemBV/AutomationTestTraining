package automation.testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_RadioButton extends CommonBase{
	@BeforeTest
	public void openChrome() {
		driver = initChromeDriver("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	}

	@Test(priority = 1)
	public void checkOnRadioButton() {
		// kiem tra gia tri mac dinh cua radio Male va Female la chua check
		WebElement radioMale = driver.findElement(By.xpath("//input[@name='gender' and @value='Male']"));
		WebElement radioFemale = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']"));
		System.out.println("Trang thai cua radio Male la: " + radioMale.isSelected());
		System.out.println("Trang thai cua radio Female la: " + radioFemale.isSelected());
		//kiem tra radio chua duoc check thi click vao
		if (radioMale.isEnabled() && !radioFemale.isSelected()) {
			radioMale.click();
		}
	}

	@AfterTest
	public void closeChrome() {
		driver.close();
	}
}
