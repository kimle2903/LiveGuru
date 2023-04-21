package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerateManagers;
import pageUIs.liveGuru.users.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
	WebDriver driver;

	public UserProductDetailPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getPriceProductDetail() {
		waitForElementVisible(UserProductDetailPageUI.PRODUCT_PRICE);
		return getElementText(UserProductDetailPageUI.PRODUCT_PRICE);
	}

	public UserCheckOutPageObject clickToAddToCartButton() {
		waitForElementClickable(UserProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(UserProductDetailPageUI.ADD_TO_CART_BUTTON);

		return PageGenerateManagers.getUserCheckoutPO(driver);
	}

	public UserReviewProductPageObject clickToAddYourReviewLink() {
		waitForElementClickable(UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(UserProductDetailPageUI.ADD_YOUR_REVIEW_LINK);

		return PageGenerateManagers.getUserReviewProductPO(driver);
	}

}
