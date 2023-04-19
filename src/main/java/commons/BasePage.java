package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageUrl(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageCurrentUrl() {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	protected void forwardToPage() {
		driver.navigate().forward();
	}

	public void refreshToPage() {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence() {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert() {
		waitForAlertPresence().accept();
	}

	protected void cancelAlert() {
		waitForAlertPresence().dismiss();
	}

	protected String getTextAlert() {
		return waitForAlertPresence().getText();
	}

	protected void sendKeyToAlert(String textValue) {
		waitForAlertPresence().sendKeys(textValue);
	}

	protected void switchToWindowByID(String windowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	protected void switchToWindowByTitle(String titleName) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			String titleWindow = driver.switchTo().window(id).getTitle();
			if (titleWindow.equals(titleName)) {
				break;
			}
		}
	}

	protected void closeAllTabWithOutParent(String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id).close();
			}
		}

		driver.switchTo().window(parentID);
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not support");
		}

		return by;
	}

	private String getDynamicByXpath(String locatorType, String... dynamicValues) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPATH=")) {
			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}

		return locatorType;
	}

	protected WebElement getWebElement(String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	protected void clickToElement(String locatorType) {
		getWebElement(locatorType).click();
	}

	protected void clickToElement(String locatorType, String... dynamicValues) {
		getWebElement(getDynamicByXpath(locatorType, dynamicValues)).click();
	}

	protected void sendKeyToElement(String locatorType, String valueText) {
		WebElement element = getWebElement(locatorType);
		element.clear();
		element.sendKeys(valueText);
	}

	protected void sendKeyToElement(String locatorType, String valueText, String... dynamicValues) {
		WebElement element = getWebElement(getDynamicByXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(valueText);
	}

	protected String getElementText(String locatorType) {
		return getWebElement(locatorType).getText();
	}

	protected String getElementText(String locatorType, String... dynamicValues) {
		return getWebElement(getDynamicByXpath(locatorType, dynamicValues)).getText();
	}

	protected String getElementAttribute(String locatorType, String attributeName) {
		return getWebElement(locatorType).getAttribute(attributeName);
	}

	protected String getElementAttribute(String locatorType, String attributeName, String... dynamicValues) {
		return getWebElement(getDynamicByXpath(locatorType, dynamicValues)).getAttribute(attributeName);
	}

	protected String getElementCssValue(String locatorType, String propertyName) {
		return getWebElement(locatorType).getCssValue(propertyName);
	}

	protected String getElementCssValue(String locatorType, String propertyName, String... dynamicValues) {
		return getWebElement(getDynamicByXpath(locatorType, dynamicValues)).getCssValue(propertyName);
	}

	protected String getHexaColorFromRgba(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex().toUpperCase();
	}

	protected List<WebElement> getListWebElement(String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	protected int getElementSize(String locatorType) {
		return getListWebElement(locatorType).size();
	}

	protected int getElementSize(String locatorType, String... dynamicValues) {
		return getListWebElement(getDynamicByXpath(locatorType, dynamicValues)).size();
	}

	protected void selectItemInDropdownByVisibleText(String locatorType, String textItem) {
		new Select(getWebElement(locatorType)).selectByVisibleText(textItem);
	}

	protected void selectItemInDropdownByVisibleText(String locatorType, String textItem, String... dynamicValues) {
		new Select(getWebElement(getDynamicByXpath(locatorType, dynamicValues))).selectByVisibleText(textItem);
	}

	protected void selectItemInDefaultDropdownByValue(String locatorType, String valueText) {
		new Select(getWebElement(locatorType)).selectByValue(valueText);
	}

	protected void selectItemInDefaultDropdownByValue(String locatorType, String valueText, String... dynamicValues) {
		new Select(getWebElement(getDynamicByXpath(locatorType, dynamicValues))).selectByValue(valueText);
	}

	protected String getFirstSelectedItemInDefaultDropdown(String locatorType) {
		return new Select(getWebElement(locatorType)).getFirstSelectedOption().getText();
	}

	protected Boolean isDropdownMultiple(String locatorType) {
		return new Select(getWebElement(locatorType)).isMultiple();
	}

	protected void selectItemInCustomDropdown(String parentXpath, String childXpath, String expectedTextItem) {
		clickToElement(parentXpath);
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		List<WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		for (WebElement webElement : allItem) {
			if (webElement.getText().trim().equals(expectedTextItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView();", webElement);
				sleepInSecond(1);
				jsExecutor.executeScript("arguments[0].click();", webElement);
				break;
			}
		}

	}

	protected void checkToDefaultCheckboxRadio(String locatorType, String... dynamicValues) {
		WebElement element = getWebElement(getDynamicByXpath(locatorType, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void checkToDefaultCheckboxRadio(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void unCheckToDefaultCheckbox(String locatorType) {
		WebElement element = getWebElement(locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	protected void unCheckToListDefaultCheckbox(String locatorType) {
		List<WebElement> elements = getListWebElement(locatorType);
		for (WebElement webElement : elements) {
			if (webElement.isSelected()) {
				webElement.click();
			}
		}
	}

	protected Boolean isElementDisplay(String locatorType) {
		return getWebElement(locatorType).isDisplayed();
	}

	protected Boolean isElementDisplay(String locatorType, String... dynamicValues) {
		return getWebElement(getDynamicByXpath(locatorType, dynamicValues)).isDisplayed();
	}

	protected Boolean isElementEnable(String locatorType) {
		return getWebElement(locatorType).isEnabled();
	}

	protected Boolean isElementSelected(String locatorType) {
		return getWebElement(locatorType).isSelected();
	}

	protected Boolean isElementSelected(String locatorType, String... dynamicValues) {
		return getWebElement(getDynamicByXpath(locatorType, dynamicValues)).isSelected();
	}

	protected Boolean isElementUndisplay(String locatorType) {
		driver.manage().timeouts().implicitlyWait(GlobalConstants.SHORT_TIMEOUT, TimeUnit.SECONDS);
		List<WebElement> elements = getListWebElement(locatorType);
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		}
		return false;
	}

	protected Boolean isElementUndisplay(String locatorType, String... dynamicValues) {
		driver.manage().timeouts().implicitlyWait(GlobalConstants.SHORT_TIMEOUT, TimeUnit.SECONDS);
		List<WebElement> elements = getListWebElement(getDynamicByXpath(locatorType, dynamicValues));
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);

		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		}
		return false;
	}

	protected void switchToFrameIFrame(String locatorType) {
		driver.switchTo().frame(getWebElement(locatorType));
	}

	protected void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	protected void hoverMouseToElement(String locatorType) {
		new Actions(driver).moveToElement(getWebElement(locatorType)).perform();
	}

	protected void hoverMouseToElement(String locatorType, String... dynamicValues) {
		new Actions(driver).moveToElement(getWebElement(getDynamicByXpath(locatorType, dynamicValues))).perform();
	}

	public void pressingByKey(Keys key) {
		new Actions(driver).sendKeys(key).perform();
	}

	protected void scrollToBottomPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(locatorType));
	}

	protected void clickToElementByJS(String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(getDynamicByXpath(locatorType, dynamicValues)));
	}

	protected void scrollToElement(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(locatorType));
	}

	protected void scrollToElement(String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(getDynamicByXpath(locatorType, dynamicValues)));
	}

	protected void removeAttributeInDOM(String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(locatorType));
	}

	protected boolean areJQueryAndJSLoadedSuccess() {
		WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(locatorType));
	}

	protected boolean isImageLoaded(String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isImageLoaded(String locatorType, String... dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(getDynamicByXpath(locatorType, dynamicValues)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	protected void waitForElementVisible(String locatorType) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
		} catch (Exception e) {
			e.getMessage();
		}

	}

	protected void waitForElementVisible(String locatorType, String... dynamicValues) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicByXpath(locatorType, dynamicValues))));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void waitForAllElementVisible(String locatorType) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void waitForAllElementVisible(String locatorType, String... dynamicValues) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicByXpath(locatorType, dynamicValues))));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void waitForElementInVisible(String locatorType) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void waitForElementInVisible(String locatorType, String... dynamicValues) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicByXpath(locatorType, dynamicValues))));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void waitForAllElementInVisible(String locatorType) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(locatorType)));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void waitForAllElementInVisible(String locatorType, String... dynamicValues) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(getDynamicByXpath(locatorType, dynamicValues))));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void waitForElementClickable(String locatorType) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	protected void waitForElementClickable(String locatorType, String... dynamicValues) {
		try {
			WebDriverWait explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
			explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicByXpath(locatorType, dynamicValues))));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public Set<Cookie> getCookie() {
		return driver.manage().getCookies();
	}

	public void setCookie(Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}

		sleepInSecond(1);
		refreshToPage();
	}

	public void uploadMultipleFile(String locatorType, String... fileNames) {
		String fullFileName = "";
		for (String fileName : fileNames) {
			fullFileName = fullFileName + GlobalConstants.UPLOAD_FILE + fileName + "\n";
		}

		fullFileName = fullFileName.trim();
		sendKeyToElement(locatorType, fullFileName);
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
