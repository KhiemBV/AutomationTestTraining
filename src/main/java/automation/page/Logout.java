package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constant.ConstantAccount;

public class Logout {
	private WebDriver driver;

	public Logout(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void logoutFuntion() {
		WebElement userElement = driver.findElement(ConstantAccount.USER_OPTIONS);
		if (userElement.isEnabled()) {
			userElement.click();
		}
		WebElement logoutButtonElement = driver.findElement(ConstantAccount.BUTTON_LOGOUT);
		if (logoutButtonElement.isEnabled()) {
			logoutButtonElement.click();
		}
	}
}
