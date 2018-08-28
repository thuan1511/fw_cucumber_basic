package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import interfaces.AbstractPageUI;
import pages.DepositPage;
import pages.HomePage;
import pages.NewAccountPage;
import pages.PageFactory;

public class AbstractPage {
	private int timeouts = 20;

	// Web Browser
	protected void openUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	protected String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected void waitForIEBrowser(int Timeouts) {
		try {
			Thread.sleep(Timeouts);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Web Element
	protected void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	protected void clickToElement(WebDriver driver, String locator, String value) {
		String dynamicLocator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.click();
	}

	protected void clickToElement(WebDriver driver, String locator, String value1, String value2) {
		String dynamicLocator = String.format(locator, value1, value2);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		element.click();
	}

	protected String getTextElement(WebDriver driver, String locator, String value) {
		String dynamicLocator = String.format(locator, value);
		return getTextElement(driver, dynamicLocator);
	}

	// Clear and sendkey
	protected void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	protected void clearAndSendKeyToElementDynamicTextbox(WebDriver driver, String locator, String value, String text) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(text);
	}

	protected void clearAndSendKeyPressToElementDynamicTextbox(WebDriver driver, String locator, String value,
			Keys key) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(key);
	}

	protected void sendKeyToElementDynamicTextbox(WebDriver driver, String locator, String value, String text) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(text);
	}

	protected void sendKeyToElement2(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	protected void selectItemInDropdown(WebDriver driver, String locator, String value) {
		Select element = new Select(driver.findElement(By.xpath(locator)));
		element.selectByVisibleText(value);
	}

	protected void selectItemInDynamicDropdown(WebDriver driver, String locator, String value, String valueDropdown) {
		locator = String.format(locator, value);
		Select element = new Select(driver.findElement(By.xpath(locator)));
		element.selectByVisibleText(valueDropdown);
	}

	protected void selectItemInDropdownSpecial(WebDriver driver, String locatorDropdown, String locator, String value) {
		WebElement dropdown = driver.findElement(By.xpath(locatorDropdown));
		dropdown.click();
		List<WebElement> list = driver.findElements(By.xpath(locator));
		for (WebElement element : list) {
			if (element.getText().equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}

	}

	protected String getFirstItemSelected(WebDriver driver, String locator) {
		Select element = new Select(driver.findElement(By.xpath(locator)));
		return element.getFirstSelectedOption().getText();
	}

	protected String getAtribute(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	protected String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	protected String getTextDynamicElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	protected int getSize(WebDriver driver, String locator) {
		List<WebElement> element = driver.findElements(By.xpath(locator));
		return element.size();
	}

	protected void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected())
			element.click();
	}

	protected boolean isControlDisplayed(WebDriver driver, String locator, String value) {
		String dynamicLocator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.isDisplayed();
	}

	protected boolean isControlDisplayed(WebDriver driver, String locator, String value1, String value2) {
		String dynamicLocator = String.format(locator, value1, value2);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		return element.isDisplayed();
	}

	protected boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	protected boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	protected boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	// Alert

	protected void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	protected void cancelAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	protected String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	protected void sendKeyAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	// Windows
	protected void switchWindowByID(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			if (!childWindows.equals(parent)) {
				driver.switchTo().window(childWindows);
				break;
			}
		}
	}

	protected void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}

	// Bonus
	protected boolean closeAllWindowsWithoutParent(WebDriver driver, String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			if (!childWindows.equals(parent)) {
				driver.switchTo().window(childWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parent);

		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	protected String getWindowParentID(WebDriver driver) {
		return driver.getWindowHandle();
	}

	// Iframe
	protected void switchToIframe(WebDriver driver, String locator) {
		WebElement iframe = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(iframe);
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// Actions
	protected void doubleClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	protected void hoverMouse(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	protected void hoverMouse(WebDriver driver, String locator, String value1, String value2) {
		String dynamicLocator = String.format(locator, value1, value2);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	protected void rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	protected void dragAndDrop(WebDriver driver, String locatorFrom, String locatorTarget) {
		WebElement dragFrom = driver.findElement(By.xpath(locatorFrom));
		WebElement target = driver.findElement(By.xpath(locatorTarget));
		Actions builder = new Actions(driver);
		Action dragAndDropAction = builder.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDropAction.perform();
	}

	// Bonus
	protected void clickAndHold(WebDriver driver, int itemFrom, int itemTarget, String locator) {
		List<WebElement> listItems = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.clickAndHold(listItems.get(itemFrom)).clickAndHold(listItems.get(itemTarget)).click().perform();
		action.release();
	}

	// Key Press
	protected void keyDownElement(WebDriver driver, String locator, Keys pressKeyDown) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.keyDown(element, pressKeyDown);
	}

	protected void keyUpElement(WebDriver driver, String locator, Keys pressKeyUp) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.keyUp(element, pressKeyUp);
	}

	protected void sendKeyPress(WebDriver driver, String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(key);
	}

	protected void clearAndSendKeyPress(WebDriver driver, String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(key);
	}

	// Upload
	protected void uploadFile(WebDriver driver, String locator, String firePath) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(firePath);
	}

	// Javascript
	protected Object executeJavascriptToBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	protected Object executeJavascriptToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	protected Object executeJavascriptToElement(WebDriver driver, String locator, String value1, String value2) {
		String dynamicLocator = String.format(locator, value1, value2);
		WebElement element = driver.findElement(By.xpath(dynamicLocator));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	protected Object scrollToBottomPage(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	protected Object scrollToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// Bonus
	protected void highlightElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	// Bonus
	protected Object removeAttributeInDOM(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// Wait
	protected void waitForControlPresence(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	protected void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	protected void waitForIframeVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
	}

	protected void waitForControlVisible(WebDriver driver, String locator, String value) {
		String dynamicLocator = String.format(locator, value);
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(dynamicLocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	protected void waitForControlVisible(WebDriver driver, String locator, String value1, String value2) {
		String dynamicLocator = String.format(locator, value1, value2);
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(dynamicLocator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	protected void waitForControlClickable(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	protected void waitForControlInvisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		By by = By.xpath(locator);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	protected void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, timeouts);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	protected boolean sortElementAcsending(WebDriver driver, String locator) {

		List<WebElement> list = driver.findElements(By.xpath(locator));
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (Integer.parseInt(list.get(i).getText()) <= Integer.parseInt(list.get(i + 1).getText())) {
				return true;
			}
		}
		return false;
	}

	protected boolean sortElementDescending(WebDriver driver, String locator) {

		List<WebElement> list = driver.findElements(By.xpath(locator));
		int length = list.size();
		for (int i = 0; i < length; i++) {
			if (Integer.parseInt(list.get(i).getText()) >= Integer.parseInt(list.get(i + 1).getText())) {
				return true;
			}
		}
		return false;
	}

	protected void swapElement(WebDriver driver, String locator) {

		List<WebElement> list = driver.findElements(By.xpath(locator));
		int temp;
		int position1 = Integer.parseInt(list.get(0).getText());
		int position2 = Integer.parseInt(list.get(1).getText());
		temp = position1;
		position1 = position2;
		position2 = temp;

	}

	protected boolean verifyEquals(Object actual, Object expected, boolean flag) {
		boolean pass = true;
		if (flag == false) {
			try {
				Assert.assertEquals(actual, expected);
			} catch (Throwable e) {
				pass = false;
				Reporter.getCurrentTestResult().setThrowable(e);
			}
		} else {
			Assert.assertEquals(actual, expected);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}

	public void openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGES, "New Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGES, "New Customer");
	}

	public void openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGES, "Edit Customer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGES, "Edit Customer");
	}

	public HomePage openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGES, "Manager");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGES, "Manager");
		return PageFactory.getHomePage(driver);
	}

	public NewAccountPage openNewAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGES, "New Account");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGES, "New Account");
		return PageFactory.getNewAccountPage(driver);
	}

	public DepositPage openDepositPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGES, "Deposit");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGES, "Deposit");
		return PageFactory.getDepositPage(driver);
	}

	public void openWithDrawPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGES, "Withdrawal");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGES, "Withdrawal");
	}

	public void openFundTransferPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGES, "Fund Transfer");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGES, "Fund Transfer");
	}

	public void openBalanceEnquiryPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGES, "Balance Enquiry");
		clickToElement(driver, AbstractPageUI.DYNAMIC_PAGES, "Balance Enquiry");
	}

}
