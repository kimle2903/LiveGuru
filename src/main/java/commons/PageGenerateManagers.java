package commons;

import org.openqa.selenium.WebDriver;

import pageObject.liveGuru.users.UserAccountDashboardPageObject;
import pageObject.liveGuru.users.UserAccountInfomationPageObject;
import pageObject.liveGuru.users.UserAdvanceSearchPageObject;
import pageObject.liveGuru.users.UserCheckOutPageObject;
import pageObject.liveGuru.users.UserCompareProductPageObject;
import pageObject.liveGuru.users.UserHomePageObject;
import pageObject.liveGuru.users.UserLoginPageObject;
import pageObject.liveGuru.users.UserMyWishListPageObject;
import pageObject.liveGuru.users.UserProductDetailPageObject;
import pageObject.liveGuru.users.UserProductListPageObject;
import pageObject.liveGuru.users.UserRegisterPageObject;
import pageObject.liveGuru.users.UserReviewProductPageObject;

public class PageGenerateManagers {
	public static UserRegisterPageObject getUserRegisterPO(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserHomePageObject getUserHomePO(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPO(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserAccountDashboardPageObject getUserAccountDashboardPO(WebDriver driver) {
		return new UserAccountDashboardPageObject(driver);
	}

	public static UserAccountInfomationPageObject getUserAccountInfomationPO(WebDriver driver) {
		return new UserAccountInfomationPageObject(driver);
	}

	public static UserProductListPageObject getUserProductList(WebDriver driver) {
		return new UserProductListPageObject(driver);
	}

	public static UserProductDetailPageObject getUserProductDetail(WebDriver driver) {
		return new UserProductDetailPageObject(driver);
	}

	public static UserCheckOutPageObject getUserCheckoutPO(WebDriver driver) {
		return new UserCheckOutPageObject(driver);
	}

	public static UserCompareProductPageObject getUserComparePO(WebDriver driver) {
		return new UserCompareProductPageObject(driver);
	}

	public static UserMyWishListPageObject getUserMyWishListPO(WebDriver driver) {
		return new UserMyWishListPageObject(driver);
	}

	public static UserReviewProductPageObject getUserReviewProductPO(WebDriver driver) {
		return new UserReviewProductPageObject(driver);
	}

	public static UserAdvanceSearchPageObject getUserAdvanceSearchPO(WebDriver driver) {
		return new UserAdvanceSearchPageObject(driver);
	}
}
