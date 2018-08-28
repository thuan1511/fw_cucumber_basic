package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import pages.NewAccountPage;
import pages.PageFactory;

public class CreateAccountSteps extends AbstractTest {
	private NewAccountPage newAccountPage;
	WebDriver driver;
	public static final String deposit = "50000";
	public static String accountID;
	public static int depositInit;

	public CreateAccountSteps() {
		driver = Hooks.openBrowser();
		newAccountPage = PageFactory.getNewAccountPage(driver);
	}

	@Then("^Verify deposit with value \"(.*?)\"$")
	public void verifyDepositWithValue(String depositMsg) {
		verifyEquals(depositMsg, newAccountPage.getTextDeposit());
		depositInit = Integer.parseInt(deposit);
	}
}
