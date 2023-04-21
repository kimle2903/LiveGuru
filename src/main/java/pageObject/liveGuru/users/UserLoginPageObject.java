package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.users.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToEmailAddressTextBox(String emailAddress) {
		waitForElementVisible(UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(UserLoginPageUI.LOGIN_BUTTON);
	}

}
