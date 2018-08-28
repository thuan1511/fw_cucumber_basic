package stepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.Data;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pages.AbtractPageObject;
import pages.PageFactory;

public class AbtractPageSteps extends AbstractTest {
	WebDriver driver;
	public static String accountID;
	public static String userID;
	public static final String monneyWithDraw = "15000";
	private AbtractPageObject abtractPageObject;
	private AbstractPage abstractPage;

	public AbtractPageSteps() {
		driver = Hooks.openBrowser();
		abtractPageObject = PageFactory.getAbtractPageObject(driver);
		abstractPage = new AbstractPage();

	}

	@When("^I click to \"(.*?)\" button$")
	public void i_click_to_dynamic_button_and_navigate_to_homepage(String button) {
		abtractPageObject.clickDynamicButton(button);
	}

	@When("^Select item in dynamic dropdow \"(.*?)\" with value \"(.*?)\"$")
	public void selectAcountTypeAndInputDeposit(String locator, String dataValue) {
		abtractPageObject.selectDynamicDropdown(locator, dataValue);
	}

	@When("^I get text UserID \"(.*?)\"$")
	public void getTextUserID(String locator) {
		userID = abtractPageObject.getTextDynamicLabel(locator);
	}

	@When("^I get text dynamic label \"(.*?)\"$")
	public void getTextDynamicLabel(String locator) {
		accountID = abtractPageObject.getTextDynamicLabel(locator);
		System.out.println(accountID);
	}

	@When("^I input to \"(.*?)\" textbox with variable data \"(.*?)\"$")
	public void clearAndInputDataDynamicTextbox(String locator, Data data) {
		switch (data) {
		case USERNAMELOGIN:
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, RegisterSteps.usernameLogin);
			break;
		case PASSWORDLOGIN:
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, RegisterSteps.passwordLogin);
			break;
		case ACCOUNTID:
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, accountID);
			break;
		case ACCOUNTIDPAYEE:
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator,
					String.valueOf((Integer.parseInt(accountID) - 1)));
			break;
		case USERID:
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, userID);
			break;
		case DEPOSITADD:
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, AddDepositSteps.depositAdd);
			break;
		case MONNEYWITHDRAW:
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, monneyWithDraw);
			break;
		case TABKEYS:
			abtractPageObject.clearAndInputKeyWithDynamicTextbox(locator, Keys.TAB);
			break;
		case SPACEKEYS:
			abtractPageObject.clearAndInputKeyWithDynamicTextbox(locator, Keys.SPACE);
			break;
		default:
			break;
		}
	}

	@When("^I input to \"(.*?)\" textbox with data \"(.*?)\"$")
	public void clearAndInputDynamicTextbox(String locator, String dataValue) {
		if (dataValue.equals("randomEmail"))
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, dataValue + randomEmail() + "@gmail.com");
		else if (dataValue.equals("updateEmail"))
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, dataValue + randomEmail() + "@gmail.com");
		else if (dataValue.equals("automation"))
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, dataValue + randomEmail() + "@gmail.com");
		else
			abtractPageObject.clearAndInputDataWithDynamicTextbox(locator, dataValue);
	}

	@When("^I input to \"(.*?)\" date of birth with data \"(.*?)\"$")
	public void inputDynamicTextbox(String locator, String dataValue) {
		abtractPageObject.removeDateProperty("type");
		abtractPageObject.inputDataWithDynamicTextbox(locator, dataValue);
	}

	@Then("^Verify successfully with message \"(.*?)\"$")
	public void verifyCustomerCreatedSuccessfullyWithMessage(String message) {
		verifyTrue(abtractPageObject.isDynamicElementDisplayed(message));
	}

	@Then("^Verify (?:money transfer|current balance|money after withdraw) is \"(.*?)\"$")
	public void verifyCurrentBalanceAfterTransferMoney(String money) {
		verifyTrue(abtractPageObject.isDynamicLabelDisplayed(money));
	}

	@Given("^I open \"(.*?)\" page$")
	public void iOpenNewDynamicPage(String pageName) {
		switch (pageName) {
		case "New Customer":
			abstractPage.openNewCustomerPage(driver);
			break;
		case "Edit Customer":
			abstractPage.openEditCustomerPage(driver);
			break;
		case "New Account":
			abstractPage.openNewAccountPage(driver);
			break;
		case "Deposit":
			abstractPage.openDepositPage(driver);
			break;
		case "Withdrawal":
			abstractPage.openWithDrawPage(driver);
			break;
		case "Fund Transfer":
			abstractPage.openFundTransferPage(driver);
			break;
		case "Balance Enquiry":
			abstractPage.openBalanceEnquiryPage(driver);
			break;
		}
	}
}
