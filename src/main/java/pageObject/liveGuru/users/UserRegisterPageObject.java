package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.users.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToFirstNameTextBox(String firstName) {
		waitForElementVisible(UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextBox(String lastName) {
		waitForElementVisible(UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void enterToEmailAddressTextBox(String emailAddress) {
		waitForElementVisible(UserRegisterPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementVisible(UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(UserRegisterPageUI.REGISTER_BUTTON);
	}

}
