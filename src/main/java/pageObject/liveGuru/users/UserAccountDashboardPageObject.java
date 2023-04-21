package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerateManagers;
import pageUIs.liveGuru.users.UserAccountDashboardPageUI;
import pageUIs.liveGuru.users.UserBasePageUI;

public class UserAccountDashboardPageObject extends BasePage {
	WebDriver driver;

	public UserAccountDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getMessageRegisterSuccess() {
		waitForElementVisible(UserAccountDashboardPageUI.MESSAGE_REGISTER_SUCCESS);
		return getElementText(UserAccountDashboardPageUI.MESSAGE_REGISTER_SUCCESS);
	}

	public String getTitleDashboard() {
		waitForElementVisible(UserAccountDashboardPageUI.TITLE_DASHBOARD);
		return getElementText(UserAccountDashboardPageUI.TITLE_DASHBOARD);
	}

	public String getTextHelloUser() {
		waitForElementVisible(UserAccountDashboardPageUI.TEXT_HELLO);
		return getElementText(UserAccountDashboardPageUI.TEXT_HELLO);
	}

	public UserProductListPageObject clickToTabMobile() {
		waitForElementClickable(UserAccountDashboardPageUI.MOBILE_TAB);
		clickToElement(UserAccountDashboardPageUI.MOBILE_TAB);

		return PageGenerateManagers.getUserProductList(driver);
	}

	public UserProductListPageObject clickToTabTV() {
		waitForElementClickable(UserBasePageUI.TV_TAB);
		clickToElement(UserBasePageUI.TV_TAB);

		return PageGenerateManagers.getUserProductList(driver);
	}
}
