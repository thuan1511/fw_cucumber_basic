package pages;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.DepositUI;

public class DepositPage extends AbstractPage {
	WebDriver driver;

	public DepositPage(WebDriver driver) {
		this.driver = driver;
	}

	public Boolean checkCurrentBalance(String currentBalance) {
		waitForControlVisible(driver, DepositUI.CURRENTDEPOSIT_LBL, currentBalance);
		return isControlDisplayed(driver, DepositUI.CURRENTDEPOSIT_LBL, currentBalance);
	}

}
