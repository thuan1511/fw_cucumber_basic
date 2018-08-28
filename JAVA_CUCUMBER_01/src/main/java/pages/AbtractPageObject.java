package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import interfaces.AbstractPageUI;

public class AbtractPageObject extends AbstractPage {
	WebDriver driver;

	public AbtractPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextDynamicElement(String massage) {
		waitForControlVisible(driver, AbstractPageUI.CREATED_EDITED_MSG, massage);
		return getTextElement(driver, AbstractPageUI.CREATED_EDITED_MSG, massage);
	}

	public void removeDateProperty(String attribute) {
		waitForControlVisible(driver, AbstractPageUI.DATEOFBIRTH_DATE);
		removeAttributeInDOM(driver, AbstractPageUI.DATEOFBIRTH_DATE, attribute);
	}

	public boolean isDynamicElementDisplayed(String massage) {
		waitForControlVisible(driver, AbstractPageUI.CREATED_EDITED_MSG, massage);
		return isControlDisplayed(driver, AbstractPageUI.CREATED_EDITED_MSG, massage);
	}

	public boolean isDynamicLabelDisplayed(String massage) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LBL, massage);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_LBL, massage);
	}

	public void clickDynamicButton(String button) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BTN, button);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BTN, button);
	}

	public void clearAndInputDataWithDynamicTextbox(String textboxName, String dataValue) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TXT, textboxName);
		clearAndSendKeyToElementDynamicTextbox(driver, AbstractPageUI.DYNAMIC_TXT, textboxName, dataValue);
	}

	public void clearAndInputKeyWithDynamicTextbox(String textboxName, Keys key) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TXT, textboxName);
		clearAndSendKeyPressToElementDynamicTextbox(driver, AbstractPageUI.DYNAMIC_TXT, textboxName, key);
	}

	public void inputDataWithDynamicTextbox(String textboxName, String dataValue) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TXT, textboxName);
		sendKeyToElementDynamicTextbox(driver, AbstractPageUI.DYNAMIC_TXT, textboxName, dataValue);
	}

	public String getTextDynamicLabel(String labelName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LBL, labelName);
		return getTextDynamicElement(driver, AbstractPageUI.DYNAMIC_LBL, labelName);
	}

	public void selectDynamicDropdown(String dropdownName, String dataValue) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN, dropdownName);
		selectItemInDynamicDropdown(driver, AbstractPageUI.DYNAMIC_DROPDOWN, dropdownName, dataValue);
	}

}
