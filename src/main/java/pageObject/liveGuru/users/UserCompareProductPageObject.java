package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.users.UserCompareProductPageUI;

public class UserCompareProductPageObject extends BasePage {
	WebDriver driver;

	public UserCompareProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTitleHeader() {
		waitForElementVisible(UserCompareProductPageUI.TITLE_HEADER);
		return getElementText(UserCompareProductPageUI.TITLE_HEADER);
	}

	public boolean isProductItemByNameDisplay(String productName) {
		waitForElementVisible(UserCompareProductPageUI.PRODUCT_NAME_TEXT, productName);
		return isElementDisplay(UserCompareProductPageUI.PRODUCT_NAME_TEXT, productName);
	}

}
