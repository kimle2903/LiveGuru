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
import pageObject.liveGuru.users.UserAdvanceSearchPageObject;
import pageObject.liveGuru.users.UserCheckOutPageObject;
import pageObject.liveGuru.users.UserHomePageObject;
import pageObject.liveGuru.users.UserLoginPageObject;
import pageObject.liveGuru.users.UserMyWishListPageObject;
import pageObject.liveGuru.users.UserProductDetailPageObject;
import pageObject.liveGuru.users.UserProductListPageObject;
import pageObject.liveGuru.users.UserReviewProductPageObject;

public class User_02_Font_End extends BaseTest {
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserAccountDashboardPageObject userAccountDashboardPage;
	private UserProductListPageObject userProductListPage;
	private UserProductDetailPageObject userProductDetail;
	private UserMyWishListPageObject userMyWishListPage;
	private UserReviewProductPageObject userReviewProductPage;
	private UserCheckOutPageObject userCheckoutPage;
	private UserAdvanceSearchPageObject userAdvanceSearchPage;

	WebDriver driver;
	private String productName, productNameTwo, email, message, thoughtText, reviewText, nickName, numberRate;
	private String country, state, zip, subTotal, fee_shipping, paymentType;
	private String addressBilling, cityBilling, telephone, optionShipBilling, province, addressShipping, cityShipping;
	private String priceOne, priceOneTo, priceTwo, priceTwoTo;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser", "role" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("user") String role) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName, role);
		userHomePage = PageGenerateManagers.getUserHomePO(driver);

		productName = "LG LCD";
		productNameTwo = "Samsung LCD";
		email = "test" + randomInt() + "@gmail.com";
		message = "Test share wishlist";

		thoughtText = "I trying";
		reviewText = "good";
		nickName = "Cum cum";
		numberRate = "3";

		country = "United States";
		state = "New York";
		zip = "123432";

		addressBilling = "123 nguyen trai";
		cityBilling = "HN";
		province = "Alaska";
		telephone = "0345551111";
		optionShipBilling = "Ship to different address";
		paymentType = "Check / Money order ";
		addressShipping = "Hoang hoa tham";
		cityShipping = "Thanh hoa";

		priceOne = "0";
		priceOneTo = "150";
		priceTwo = "151";
		priceTwoTo = "1000";

		userHomePage.clickToAccountHeaderLink();
		userHomePage.openPageInAccountHeaderByName("Log In");
		userLoginPage = PageGenerateManagers.getUserLoginPO(driver);

		userLoginPage.enterToEmailAddressTextBox(Common_01_Register_Success.emailAddress);
		userLoginPage.enterToPasswordTextBox(Common_01_Register_Success.password);
		userLoginPage.clickToLoginButton();

		userAccountDashboardPage = PageGenerateManagers.getUserAccountDashboardPO(driver);

	}

	@Test
	public void TC_08_Verify_Share_Wishlist() {
		userProductListPage = userAccountDashboardPage.clickToTabTV();
		userMyWishListPage = userProductListPage.clickToAddToWishlistLinkByName(productName);
		Assert.assertEquals(userMyWishListPage.getMessageSuccess(), "LG LCD has been added to your wishlist. Click here to continue shopping.");

		userMyWishListPage.clickShareWishListButton();

		userMyWishListPage.enterToEmailTextBox(email);
		userMyWishListPage.enterToMessageTextBox(message);

		userMyWishListPage.clickShareWishListButton();
		Assert.assertEquals(userMyWishListPage.getMessageSuccess(), "Your Wishlist has been shared.");

		Assert.assertEquals(userMyWishListPage.getTotalProduct(), 1);
	}

	@Test
	public void TC_09_Verify_Add_Your_Review() {
		userProductListPage = userMyWishListPage.clickToTabTV();
		userProductDetail = userProductListPage.clickToViewDetailProductByName(productNameTwo);
		userReviewProductPage = userProductDetail.clickToAddYourReviewLink();

		userReviewProductPage.chooseRateProduct(numberRate);
		userReviewProductPage.enterToThoughtTextBox(thoughtText);
		userReviewProductPage.enterToReviewTextBox(reviewText);
		userReviewProductPage.enterToNickNameTextBox(nickName);

		userReviewProductPage.clickToSubmitReviewButton();

		Assert.assertEquals(userReviewProductPage.getMessageReviewSuccess(), "Your review has been accepted for moderation.");
	}

	@Test
	public void TC_10_Verify_Able_Purchase_Product() {
		userMyWishListPage = userReviewProductPage.clickToAddToWishListLink();
		userCheckoutPage = userMyWishListPage.clickToAddToCartButton();
		userCheckoutPage.chooseCountryInDropdown(country);
		userCheckoutPage.chooseStateInDropdown(state);
		userCheckoutPage.enterToZipTextBox(zip);

		userCheckoutPage.clickToEstimateButton();
		Assert.assertTrue(userCheckoutPage.isFlatRateDisplay());
		userCheckoutPage.chooseFixedInCheckBoxFlatRate();
		userCheckoutPage.clickToUpdateTotalButton();

		subTotal = userCheckoutPage.getSubTotal();
		fee_shipping = userCheckoutPage.getFeeShipping();
		Assert.assertEquals(userCheckoutPage.getFeeShipping(), "$5.00");
		Assert.assertEquals(userCheckoutPage.getGrandTotal(), "$620.00");

		userCheckoutPage.clickToProceedToCheckout();

		userCheckoutPage.enterToAddressBillingTextBox(addressBilling);
		userCheckoutPage.enterToCityBillingTextBox(cityBilling);
		userCheckoutPage.enterToZipBillingTextBox(zip);
		userCheckoutPage.enterToTelephoneBillingTextBox(telephone);
		userCheckoutPage.choosePrivinceInDropdown(province);
		userCheckoutPage.chooseCountryInDropdownInBilling(country);
		userCheckoutPage.chooseOptionBillingRadioButton(optionShipBilling);
		userCheckoutPage.clickToContinueButtonInBilling();

		userCheckoutPage.enterToFirstNameTextBoxInShipping(Common_01_Register_Success.firstName);
		userCheckoutPage.enterToLastNameTextBoxInShipping(Common_01_Register_Success.lastName);
		userCheckoutPage.enterToAddressShippingTextBox(addressShipping);
		userCheckoutPage.enterToCityShippingTextBox(cityShipping);
		userCheckoutPage.enterToPhoneShippingTextBox(telephone);

		userCheckoutPage.clickToContinueButtonInShipping();

		Assert.assertEquals(userCheckoutPage.getFeeShipInShippingMethod(), "$5.00");
		userCheckoutPage.clickToContinueButtonInShippingMethod();

		userCheckoutPage.choosePaymentTypeRadioButton(paymentType);
		userCheckoutPage.clickToContinueButtonInPaymentType();

		Assert.assertEquals(userCheckoutPage.getGrandTotalInOrderReview(), "$620.00");
		userCheckoutPage.clickToPlayOrderButton();

		sleepInSecond(5);
		Assert.assertEquals(userCheckoutPage.getMessageTitleOrderSuccess(), "YOUR ORDER HAS BEEN RECEIVED.");
		Assert.assertEquals(userCheckoutPage.getMessageSubTitleOrderSuccess(), "THANK YOU FOR YOUR PURCHASE!");
	}

	@Test
	public void TC_11_Verify_Search_Funtion() {
		userCheckoutPage.openPageInFooterByName("Advanced Search");
		userAdvanceSearchPage = PageGenerateManagers.getUserAdvanceSearchPO(driver);
		userAdvanceSearchPage.enterToPriceTextBox(priceOne);
		userAdvanceSearchPage.enterToProceToTextBox(priceOneTo);
		userAdvanceSearchPage.clickToButtonSearch();
		Assert.assertTrue(userAdvanceSearchPage.isAllProductReturnedCorrect(priceOne, priceOneTo));

		userAdvanceSearchPage.openPageInFooterByName("Advanced Search");
		userAdvanceSearchPage.enterToPriceTextBox(priceTwo);
		userAdvanceSearchPage.enterToProceToTextBox(priceTwoTo);
		userAdvanceSearchPage.clickToButtonSearch();
		Assert.assertTrue(userAdvanceSearchPage.isAllProductReturnedCorrect(priceTwo, priceTwoTo));

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
