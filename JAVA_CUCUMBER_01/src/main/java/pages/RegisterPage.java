package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.RegisterPageUI;

public class RegisterPage extends AbstractPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getUserIDInfo() {
		waitForControlVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordIDInfo() {
		waitForControlVisible(driver, RegisterPageUI.PASSWORD_ID_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_ID_TEXT);
	}

	public LoginPage openLoginPage(String url) {
		openUrl(driver, url);
		return PageFactory.getLoginPage(driver);
	}
}
