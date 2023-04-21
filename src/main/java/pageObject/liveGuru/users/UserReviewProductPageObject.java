package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerateManagers;
import pageUIs.liveGuru.users.UserReviewProductPageUI;

public class UserReviewProductPageObject extends BasePage {
	WebDriver driver;

	public UserReviewProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void chooseRateProduct(String numberRate) {
		waitForElementVisible(UserReviewProductPageUI.RATE_RADIO_CHECKBOX, numberRate);
		checkToDefaultCheckboxRadio(UserReviewProductPageUI.RATE_RADIO_CHECKBOX, numberRate);
	}

	public void enterToThoughtTextBox(String thoughtText) {
		waitForElementVisible(UserReviewProductPageUI.THOUGHT_TEXTBOX);
		sendKeyToElement(UserReviewProductPageUI.THOUGHT_TEXTBOX, thoughtText);
	}

	public void enterToReviewTextBox(String reviewText) {
		waitForElementVisible(UserReviewProductPageUI.REVIEW_TEXTBOX);
		sendKeyToElement(UserReviewProductPageUI.REVIEW_TEXTBOX, reviewText);
	}

	public void enterToNickNameTextBox(String nickName) {
		waitForElementVisible(UserReviewProductPageUI.NICKNAME_TEXTBOX);
		sendKeyToElement(UserReviewProductPageUI.NICKNAME_TEXTBOX, nickName);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(UserReviewProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(UserReviewProductPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getMessageReviewSuccess() {
		waitForElementVisible(UserReviewProductPageUI.MESSAGE_SUCCESS);
		return getElementText(UserReviewProductPageUI.MESSAGE_SUCCESS);
	}

	public UserMyWishListPageObject clickToAddToWishListLink() {
		waitForElementClickable(UserReviewProductPageUI.ADD_TO_WISHLIST_LINK);
		clickToElement(UserReviewProductPageUI.ADD_TO_WISHLIST_LINK);
		return PageGenerateManagers.getUserMyWishListPO(driver);
	}

}
