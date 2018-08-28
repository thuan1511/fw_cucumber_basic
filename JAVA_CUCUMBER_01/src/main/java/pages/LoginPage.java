package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.LoginPageUI;

public class LoginPage extends AbstractPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageUrl() {
		return getCurrentUrl(driver);
	}

	public RegisterPage clickHereLink() {
		// if (driver.toString().toLowerCase().contains("internetexplorer")) {
		// try {
		// Thread.sleep(3000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageFactory.getRegisterPage(driver);
	}

}
