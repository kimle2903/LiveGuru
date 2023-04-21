package com.liveGuru.commons;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGenerateManagers;
import pageObject.liveGuru.users.UserAccountDashboardPageObject;
import pageObject.liveGuru.users.UserAccountInfomationPageObject;
import pageObject.liveGuru.users.UserHomePageObject;
import pageObject.liveGuru.users.UserRegisterPageObject;

public class Common_01_Register_Success extends BaseTest {
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage;
	private UserAccountDashboardPageObject userAccountDashboardPage;
	private UserAccountInfomationPageObject userAccountInformationPage;

	WebDriver driver;
	private String pageName, pageNameInSizeBar;
	public static String firstName, lastName, emailAddress, password, confirmPassword;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		userHomePage = PageGenerateManagers.getUserHomePO(driver);

		pageName = "Register";
		pageNameInSizeBar = "Account Information";
		firstName = "Kim";
		lastName = "Le" + randomInt();
		emailAddress = "automation" + randomInt() + "@gmail.com";
		password = "123123";
		confirmPassword = "123123";

		userHomePage.clickToAccountHeaderLink();
		userHomePage.openPageInAccountHeaderByName(pageName);
	}

	@Test
	public void TC_01_Register() {
		userRegisterPage = PageGenerateManagers.getUserRegisterPO(driver);
		userRegisterPage.enterToFirstNameTextBox(firstName);
		userRegisterPage.enterToLastNameTextBox(lastName);
		userRegisterPage.enterToEmailAddressTextBox(emailAddress);
		userRegisterPage.enterToPasswordTextBox(password);
		userRegisterPage.enterToConfirmPasswordTextBox(confirmPassword);

		userRegisterPage.clickToRegisterButton();
		userAccountDashboardPage = PageGenerateManagers.getUserAccountDashboardPO(driver);

		Assert.assertEquals(userAccountDashboardPage.getMessageRegisterSuccess(), "Thank you for registering with Main Website Store.");
	}

	@Test
	public void TC_02_Verify_Information_User() {
		userAccountDashboardPage.openPageInSizeBarByName(pageNameInSizeBar);
		userAccountInformationPage = PageGenerateManagers.getUserAccountInfomationPO(driver);

		Assert.assertEquals(userAccountInformationPage.getInfoFirstNameTextName(), firstName);
		Assert.assertEquals(userAccountInformationPage.getInfoLastNameTextName(), lastName);
		Assert.assertEquals(userAccountInformationPage.getInfoEmailAddressTextName(), emailAddress);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
