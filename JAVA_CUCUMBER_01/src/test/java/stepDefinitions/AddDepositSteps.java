package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import pages.DepositPage;
import pages.PageFactory;

public class AddDepositSteps extends AbstractTest {
	private DepositPage depositPage;
	WebDriver driver;
	public static final String depositAdd = "5000";
	public static int depositInit;
	public static int sumDeposit;

	public AddDepositSteps() {
		driver = Hooks.openBrowser();
		depositPage = PageFactory.getDepositPage(driver);
	}

	@Then("^Verify Current balance is \"(.*?)\"$")
	public void verifyCurrentBalance(String depositMoney) {
		sumDeposit = CreateAccountSteps.depositInit + Integer.parseInt(depositAdd);
		verifyTrue(depositPage.checkCurrentBalance(depositMoney));
	}
}
