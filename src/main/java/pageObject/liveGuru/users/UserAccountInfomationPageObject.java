package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.users.UserAccountInfomationPageUI;

public class UserAccountInfomationPageObject extends BasePage {
	WebDriver driver;

	public UserAccountInfomationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getInfoFirstNameTextName() {
		waitForElementVisible(UserAccountInfomationPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(UserAccountInfomationPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getInfoLastNameTextName() {
		waitForElementVisible(UserAccountInfomationPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(UserAccountInfomationPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getInfoEmailAddressTextName() {
		waitForElementVisible(UserAccountInfomationPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getElementAttribute(UserAccountInfomationPageUI.EMAIL_ADDRESS_TEXTBOX, "value");
	}
}
