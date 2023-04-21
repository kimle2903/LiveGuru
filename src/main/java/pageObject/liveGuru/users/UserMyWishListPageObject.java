package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerateManagers;
import pageUIs.liveGuru.users.UserBasePageUI;
import pageUIs.liveGuru.users.UserMyWishListPageUI;

public class UserMyWishListPageObject extends BasePage {
	WebDriver driver;

	public UserMyWishListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getMessageSuccess() {
		waitForElementVisible(UserMyWishListPageUI.MESSAGE_NOTIFY_SUCCESS);
		return getElementText(UserMyWishListPageUI.MESSAGE_NOTIFY_SUCCESS);
	}

	public void clickShareWishListButton() {
		waitForElementClickable(UserMyWishListPageUI.SHARE_WISHLIST_BUTTON);
		clickToElement(UserMyWishListPageUI.SHARE_WISHLIST_BUTTON);
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(UserMyWishListPageUI.EMAIL_TEXTAREA);
		sendKeyToElement(UserMyWishListPageUI.EMAIL_TEXTAREA, email);
	}

	public void enterToMessageTextBox(String message) {
		waitForElementVisible(UserMyWishListPageUI.MESSAGE_TEXTAREA);
		sendKeyToElement(UserMyWishListPageUI.MESSAGE_TEXTAREA, message);
	}

	public int getTotalProduct() {
		waitForElementVisible(UserMyWishListPageUI.PRODUCT_NAME);
		return getElementSize(UserMyWishListPageUI.PRODUCT_NAME);
	}

	public UserProductListPageObject clickToTabTV() {
		waitForElementClickable(UserBasePageUI.TV_TAB);
		clickToElement(UserBasePageUI.TV_TAB);

		return PageGenerateManagers.getUserProductList(driver);
	}

	public UserCheckOutPageObject clickToAddToCartButton() {
		waitForElementClickable(UserMyWishListPageUI.ADD_TO_CART_BUTTON);
		clickToElement(UserMyWishListPageUI.ADD_TO_CART_BUTTON);

		return PageGenerateManagers.getUserCheckoutPO(driver);
	}

}
