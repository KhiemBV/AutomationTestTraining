package automation.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
	public WebDriver driver;
	private int initWaitTime = 10;

	public WebDriver initChromeDriver(String URL) {
//		ChromeOptions options = new ChromeOptions();
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.get(URL);
//		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//		return driver;
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		return driver;
	}

	public boolean isElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.TimeoutException e2) {
			return false;
		}
	}

	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
