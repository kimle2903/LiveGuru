package com.liveGuru.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.liveGuru.commons.Common_01_Register_Success;

import commons.BaseTest;
import commons.PageGenerateManagers;
import pageObject.liveGuru.users.UserAccountDashboardPageObject;
import pageObject.liveGuru.users.UserCheckOutPageObject;
import pageObject.liveGuru.users.UserCompareProductPageObject;
import pageObject.liveGuru.users.UserHomePageObject;
import pageObject.liveGuru.users.UserLoginPageObject;
import pageObject.liveGuru.users.UserProductDetailPageObject;
import pageObject.liveGuru.users.UserProductListPageObject;

public class User_01_Font_End extends BaseTest {
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserAccountDashboardPageObject userAccountDashboardPage;
	private UserProductListPageObject userProductListPage;
	private UserProductDetailPageObject userProductDetailPage;
	private UserCheckOutPageObject userCheckoutPage;
	private UserCompareProductPageObject userComparePage;

	WebDriver driver;

	private String costOfProductInProductList, costOfProductInDetail, productName, productNameTwo, discountCode, qualityProduct;
	private String titleName;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		userHomePage = PageGenerateManagers.getUserHomePO(driver);

		productName = "Sony Xperia";
		productNameTwo = "IPhone";
		discountCode = "GURU50";
		qualityProduct = "501";
		titleName = "Products Comparison List - Magento Commerce";
	}

	@Test
	public void TC_03_Login_Success() {
		userHomePage.clickToAccountHeaderLink();
		userHomePage.openPageInAccountHeaderByName("Log In");
		userLoginPage = PageGenerateManagers.getUserLoginPO(driver);
		userLoginPage.enterToEmailAddressTextBox(Common_01_Register_Success.emailAddress);
		userLoginPage.enterToPasswordTextBox(Common_01_Register_Success.password);
		userLoginPage.clickToLoginButton();

		userAccountDashboardPage = PageGenerateManagers.getUserAccountDashboardPO(driver);
		Assert.assertEquals(userAccountDashboardPage.getTitleDashboard(), "MY DASHBOARD");
		Assert.assertEquals(userAccountDashboardPage.getTextHelloUser(), "Hello, " + Common_01_Register_Success.firstName + " " + Common_01_Register_Success.lastName + "!");
	}

	@Test
	public void TC_04_Verify_Cost_Of_Product() {
		userProductListPage = userAccountDashboardPage.clickToTabMobile();

		costOfProductInProductList = userProductListPage.getPriceProductByName(productName);
		userProductDetailPage = userProductListPage.clickToViewDetailProductByName(productName);
		costOfProductInDetail = userProductDetailPage.getPriceProductDetail();

		Assert.assertEquals(costOfProductInProductList, costOfProductInDetail);
	}

	@Test
	public void TC_05_Verify_Discount_Coupon_Work_Correctly() {
		userCheckoutPage = userProductDetailPage.clickToAddToCartButton();
		userCheckoutPage.enterDiscountCode(discountCode);
		userCheckoutPage.clickToApplyButton();

		Assert.assertEquals(userCheckoutPage.getMessageApplyCouponSuccess(), "Coupon code \"GURU50\" was applied.");
		Assert.assertTrue(userCheckoutPage.isDiscountGuruDisplay());
		Assert.assertEquals(userCheckoutPage.getDiscountGuru(), "-$5.00");
		Assert.assertEquals(userCheckoutPage.getGrandTotal(), "$95.00");

	}

	@Test
	public void TC_06_Verify_Add_500_Item_Of_Product() {
		userCheckoutPage.enterToQualityTextBox(qualityProduct, productName);
		userCheckoutPage.clickToUpdateButton(productName);

		Assert.assertEquals(userCheckoutPage.getErrorMessageInProductCart(), "Some of the products cannot be ordered in requested quantity.");
		Assert.assertEquals(userCheckoutPage.getErrorMessageAtProductItem(productName), "* The maximum quantity allowed for purchase is 500.");

		userCheckoutPage.clickToEmptyCartButton();
		Assert.assertEquals(userCheckoutPage.getMessageEmptyInCart(), "You have no items in your shopping cart.");
	}

	@Test
	public void TC_07_Compare_Two_Product() {
		userProductListPage = userCheckoutPage.clickToTabMobile();
		userProductListPage.addToCompareByProductName(productName);
		Assert.assertEquals(userProductListPage.getMessageAddToCompareSuccess(), "The product " + productName + " has been added to comparison list.");

		userProductListPage.addToCompareByProductName(productNameTwo);
		Assert.assertEquals(userProductListPage.getMessageAddToCompareSuccess(), "The product " + productNameTwo + " has been added to comparison list.");

		userComparePage = userProductListPage.clickToCompareButton(titleName);
		Assert.assertEquals(userComparePage.getTitleHeader(), "COMPARE PRODUCTS");
		Assert.assertTrue(userComparePage.isProductItemByNameDisplay(productName));
		Assert.assertTrue(userComparePage.isProductItemByNameDisplay(productNameTwo));

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
