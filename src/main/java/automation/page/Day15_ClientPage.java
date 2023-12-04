package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day15_ClientPage {
	private WebDriver driver;

	@FindBy (xpath = "//span[text()='Clients']")
	WebElement clientLinks;
	
	@FindBy (xpath = "//a[@title='Add client']")
	WebElement addClientBtn;
	
	@FindBy (id = "type_person")
	WebElement personRadioBtn;
	
	@FindBy (id = "company_name")
	WebElement companyName;
	
	@FindBy (id = "s2id_created_by")
	WebElement ownerDropdown;
	
	@FindBy (xpath = "(//label[normalize-space()='Owner'])[3]/following-sibling::input")
	WebElement ownerTextbox;
	
	@FindBy (xpath = "//button[@type='submit' and normalize-space()='Save']")
	WebElement saveBtn;
	
	@FindBy (xpath = "//a[text()='Clients']")
	WebElement clientsTab;
	
	@FindBy (xpath = "//input[@type='search' and @placeholder='Search']")
	WebElement searchTextbox;
	
	@FindBy (id = "address")
	WebElement addressTextarea;
	
	@FindBy (id = "city")
	WebElement cityTextbox;

	// similar at State, Zip, Country, Phone, Website, VAT number, GST number
	
	@FindBy (xpath = "//div[@id='s2id_group_ids']//input")
	WebElement clientGroupElement;
	
	@FindBy (id = "s2id_currency")
	WebElement currencyDropdown;
	
	@FindBy (xpath = "(//label[text()='Currency'])[3]//following-sibling::input")
	WebElement currencyTextbox;
	
	@FindBy (id = "currency_symbol")
	WebElement currencySymbolTextbox;
	
	@FindBy (xpath = "(//label[text()='Labels'])[2]//following-sibling::input")
	WebElement labelsTextbox;
	
	public Day15_ClientPage(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void AddClientFuntion(String name, String owner) throws InterruptedException {
		// Precondition: Login
		clientLinks.click();
		addClientBtn.click();
		Thread.sleep(2000);
		personRadioBtn.click();
		companyName.sendKeys(name);
		ownerDropdown.click();
		Thread.sleep(2000);
		ownerTextbox.sendKeys(owner);
		ownerTextbox.sendKeys(Keys.TAB);
		//
		addressTextarea.sendKeys("number 1, Pham Van Dong road");
		cityTextbox.sendKeys("Ha Noi");
		clientGroupElement.sendKeys("Gold");
		clientGroupElement.sendKeys(Keys.TAB);
		currencyDropdown.click();
		currencyTextbox.sendKeys("ALL");
		currencyTextbox.sendKeys(Keys.TAB);
		currencySymbolTextbox.sendKeys("aaa");
		labelsTextbox.sendKeys("Potential");
		labelsTextbox.sendKeys(Keys.TAB);
		//
		saveBtn.click();
		//assert
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clientsTab);
		Thread.sleep(2000);
		searchTextbox.sendKeys(name);
	}
}
