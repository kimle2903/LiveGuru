package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerateManagers;
import pageUIs.liveGuru.users.UserProductListPageUI;

public class UserProductListPageObject extends BasePage {
	WebDriver driver;

	public UserProductListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getPriceProductByName(String productName) {
		waitForElementVisible(UserProductListPageUI.PRICE_PRODUCT_BY_NAME, productName);
		return getElementText(UserProductListPageUI.PRICE_PRODUCT_BY_NAME, productName);
	}

	public UserProductDetailPageObject clickToViewDetailProductByName(String productName) {
		waitForElementClickable(UserProductListPageUI.PRODUCT_LINK, productName);
		clickToElement(UserProductListPageUI.PRODUCT_LINK, productName);

		return PageGenerateManagers.getUserProductDetail(driver);
	}

	public void addToCompareByProductName(String productName) {
		waitForElementClickable(UserProductListPageUI.ADD_TO_COMPARE_LINK_BY_NAME, productName);
		clickToElement(UserProductListPageUI.ADD_TO_COMPARE_LINK_BY_NAME, productName);

	}

	public String getMessageAddToCompareSuccess() {
		waitForElementVisible(UserProductListPageUI.MESSAGE_NOTIFY_SUCCESS);
		return getElementText(UserProductListPageUI.MESSAGE_NOTIFY_SUCCESS);
	}

	public UserCompareProductPageObject clickToCompareButton(String titleName) {
		waitForElementClickable(UserProductListPageUI.COMPARE_BUTTON);
		clickToElement(UserProductListPageUI.COMPARE_BUTTON);
		switchToWindowByTitle(titleName);

		return PageGenerateManagers.getUserComparePO(driver);
	}

	public UserMyWishListPageObject clickToAddToWishlistLinkByName(String productName) {
		waitForElementClickable(UserProductListPageUI.ADD_TO_WISHLIST_LINK_BY_NAME, productName);
		clickToElement(UserProductListPageUI.ADD_TO_WISHLIST_LINK_BY_NAME, productName);

		return PageGenerateManagers.getUserMyWishListPO(driver);
	}

}
