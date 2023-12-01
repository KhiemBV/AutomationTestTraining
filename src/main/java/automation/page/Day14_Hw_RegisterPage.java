package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_Hw_RegisterPage {
	private WebDriver driver;
	
	@FindBy (xpath = "//a[text()='Đăng Ký']")
	WebElement registerBtnElement;
	
	@FindBy (xpath = "//a[text()='Đăng Nhập']")
	WebElement loginBtnElement;
	
	@FindBy (id = "txtFirstname")
	WebElement textNameElement;
	
	@FindBy (id = "txtEmail")
	WebElement textEmailElement;
	
	@FindBy (id = "txtCEmail")
	WebElement textCEmailElement;
	
	@FindBy (id = "txtPassword")
	WebElement textPasswordElement;
	
	@FindBy (id = "txtCPassword")
	WebElement textCPasswordElement;
	
	@FindBy (id = "txtPhone")
	WebElement textPhoneElement;
	
	@FindBy (xpath = "//button[text()='ĐĂNG KÝ' and @type='submit']")
	WebElement registerSubmitBtnElement;
	
	@FindBy (id = "txtLoginUsername")
	WebElement loginEmailElement;
	
	@FindBy (id = "txtLoginPassword")
	WebElement loginPasswordElement;
	
	@FindBy (xpath = "//button[text()='ĐĂNG NHẬP' and @type='submit']")
	WebElement loginSubmitBtnElement;
	
	@FindBy (xpath = "//li[@id='showsub']")
	WebElement userAvaterElement;
	
	@FindBy (xpath = "//a[text()='Chỉnh sửa thông tin']")
	WebElement editInforBtnElement;
	
	@FindBy (id = "txtnewpass")
	WebElement newPasswordElement;
	
	@FindBy (id = "txtrenewpass")
	WebElement renewPasswordElement;
	
	@FindBy (id = "txtpassword")
	WebElement currentPasswordElement;
	
	@FindBy (xpath = "//button[text()='Lưu mật khẩu mới']")
	WebElement saveNewPassBtnElement;
	
	public Day14_Hw_RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterFuntion(String name,String email, String password, String number) {
		registerBtnElement.click();
		textNameElement.sendKeys(name);
		textEmailElement.sendKeys(email);
		textCEmailElement.sendKeys(email);
		textPasswordElement.sendKeys(password);
		textCPasswordElement.sendKeys(password);
		textPhoneElement.sendKeys(number);
		registerSubmitBtnElement.click();
	}
	
	public void LoginFuntion(String email, String password) {
		loginBtnElement.click();
		loginEmailElement.sendKeys(email);
		loginPasswordElement.sendKeys(password);
		loginSubmitBtnElement.click();
	}
	
	public void ChangePasswordFuntion(String email, String password, String newpassword) {
		LoginFuntion(email, password);
		
		userAvaterElement.click();
		editInforBtnElement.click();
		currentPasswordElement.sendKeys(password);
		newPasswordElement.sendKeys(newpassword);
		renewPasswordElement.sendKeys(newpassword);
		saveNewPassBtnElement.click();
	}
}
