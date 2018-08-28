package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AccountUI;

public class NewAccountPage extends AbstractPage {
	WebDriver driver;

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextDeposit() {
		waitForControlVisible(driver, AccountUI.CURRENTDEPOSIT_LBL);
		return getTextElement(driver, AccountUI.CURRENTDEPOSIT_LBL);
	}

}
