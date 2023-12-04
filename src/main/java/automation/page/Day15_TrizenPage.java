package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Day15_TrizenPage {
	private WebDriver driver;
	
	@FindBy (xpath = "(//label[text()='Departing'])[1]/following-sibling::div//input")
	WebElement textDepartingDate;
	
	@FindBy (xpath = "(//label[text()='Passengers'])[1]/following-sibling::div/div")
	WebElement dropboxPassenger;
	
	@FindBy (xpath = "(//label[text()='Adults'])[1]/following-sibling::div//i[@class='la la-plus']")
	WebElement addAdult;
	
	@FindBy (id = "one-way-tab")
	WebElement oneWayRadioBtn;
	
	@FindBy (xpath = "(//label[normalize-space()='Flying from'])[1]/following-sibling::div//input")
	WebElement flyingFromElement;
	
	@FindBy (xpath = "(//label[normalize-space()='Flying to'])[1]/following-sibling::div//input")
	WebElement flyingToElement;
	
	@FindBy (xpath = "(//a[text()='Search Now'])[1]")
	WebElement searchBtn;
	
	@FindBy (xpath = "(//label[normalize-space()='Coach'])[1]/following-sibling::div//select")
	WebElement coachDropdown;
	
	public Day15_TrizenPage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void HandleDateTimeAndDropdownList(String flyFrom, String flyTo, String date, String coach) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//
		js.executeScript("arguments[0].click();", oneWayRadioBtn);
		//
		flyingFromElement.sendKeys(flyFrom);
		//
		flyingToElement.sendKeys(flyTo);
		//
		js.executeScript("arguments[0].removeAttribute('readonly','readonly');", textDepartingDate);
		textDepartingDate.clear();
		textDepartingDate.sendKeys(date);
		textDepartingDate.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		//
		dropboxPassenger.click();
		addAdult.click();
		//
		js.executeScript("arguments[0].click();", coachDropdown);
		Select coachSelect = new Select(coachDropdown);
		coachSelect.selectByVisibleText(coach);
		//
		searchBtn.click();
	}
}
