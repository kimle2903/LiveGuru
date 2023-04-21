package pageObject.liveGuru.users;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.liveGuru.users.UserAdvanceSearchPageUI;

public class UserAdvanceSearchPageObject extends BasePage {
	WebDriver driver;

	public UserAdvanceSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToPriceTextBox(String price) {
		waitForElementVisible(UserAdvanceSearchPageUI.PRICE_TEXTBOX);
		sendKeyToElement(UserAdvanceSearchPageUI.PRICE_TEXTBOX, price);
	}

	public void enterToProceToTextBox(String priceTo) {
		waitForElementVisible(UserAdvanceSearchPageUI.PRICE_TO_TEXTBOX);
		sendKeyToElement(UserAdvanceSearchPageUI.PRICE_TO_TEXTBOX, priceTo);
	}

	public void clickToButtonSearch() {
		waitForElementClickable(UserAdvanceSearchPageUI.SEARCH_BUTTON);
		clickToElement(UserAdvanceSearchPageUI.SEARCH_BUTTON);
	}

	public boolean isAllProductReturnedCorrect(String price, String priceTo) {
		Boolean check = true;
		waitForAllElementVisible(UserAdvanceSearchPageUI.PRODUCT_PRICE_RESULT);
		List<WebElement> listProductPrice = getListWebElement(UserAdvanceSearchPageUI.PRODUCT_PRICE_RESULT);
		int iPrice = Integer.parseInt(price.replace("$", "").replace(".00", ""));
		int iPriceTo = Integer.parseInt(priceTo.replace("$", "").replace(".00", ""));
		System.out.println("iPrice: " + iPrice);
		System.out.println("iPriceTo: " + iPriceTo);
		for (WebElement webElement : listProductPrice) {
			int priceReturn = Integer.parseInt(webElement.getText().replace("$", "").replace(".00", ""));
			System.out.println("priceReturn: " + priceReturn);
			if (priceReturn < iPrice || priceReturn > iPriceTo) {
				check = false;
			}
		}
		return check;
	}

}
