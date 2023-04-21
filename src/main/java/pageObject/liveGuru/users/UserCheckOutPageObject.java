package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGenerateManagers;
import pageUIs.liveGuru.users.UserBasePageUI;
import pageUIs.liveGuru.users.UserCheckOutPageUI;

public class UserCheckOutPageObject extends BasePage {
	WebDriver driver;

	public UserCheckOutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterDiscountCode(String discountCode) {
		waitForElementVisible(UserCheckOutPageUI.DISCOUNT_CODE_TEXTBOX);
		sendKeyToElement(UserCheckOutPageUI.DISCOUNT_CODE_TEXTBOX, discountCode);
	}

	public void clickToApplyButton() {
		waitForElementClickable(UserCheckOutPageUI.APPLY_BUTTON);
		clickToElement(UserCheckOutPageUI.APPLY_BUTTON);
	}

	public String getMessageApplyCouponSuccess() {
		waitForElementVisible(UserCheckOutPageUI.MESSAGE_APPLY_DISCOUNT_SUCCESS);
		return getElementText(UserCheckOutPageUI.MESSAGE_APPLY_DISCOUNT_SUCCESS);
	}

	public boolean isDiscountGuruDisplay() {
		waitForElementVisible(UserCheckOutPageUI.PRICE_DISCOUNT);
		return isElementDisplay(UserCheckOutPageUI.PRICE_DISCOUNT);
	}

	public String getDiscountGuru() {
		waitForElementVisible(UserCheckOutPageUI.PRICE_DISCOUNT);
		return getElementText(UserCheckOutPageUI.PRICE_DISCOUNT);
	}

	public String getGrandTotal() {
		waitForElementVisible(UserCheckOutPageUI.GRAND_TOTAL);
		return getElementText(UserCheckOutPageUI.GRAND_TOTAL);
	}

	public void enterToQualityTextBox(String qualityProduct, String productName) {
		waitForElementVisible(UserCheckOutPageUI.QUALITY_TEXTBOX_BY_NAME, productName);
		sendKeyToElement(UserCheckOutPageUI.QUALITY_TEXTBOX_BY_NAME, qualityProduct, productName);
	}

	public String getErrorMessageInProductCart() {
		waitForElementVisible(UserCheckOutPageUI.ERROR_MESSAGE_AT_SHOPPING_CART);
		return getElementText(UserCheckOutPageUI.ERROR_MESSAGE_AT_SHOPPING_CART);
	}

	public String getErrorMessageAtProductItem(String productName) {
		waitForElementVisible(UserCheckOutPageUI.ERROR_MESSAGE_AT_PRODUCT_ITEM, productName);
		return getElementText(UserCheckOutPageUI.ERROR_MESSAGE_AT_PRODUCT_ITEM, productName).trim();
	}

	public void clickToEmptyCartButton() {
		waitForElementClickable(UserCheckOutPageUI.EMPTY_CART_BUTTON);
		clickToElement(UserCheckOutPageUI.EMPTY_CART_BUTTON);
	}

	public String getMessageEmptyInCart() {
		waitForElementVisible(UserCheckOutPageUI.MESSAGE_EMPTY_IN_CART);
		return getElementText(UserCheckOutPageUI.MESSAGE_EMPTY_IN_CART);
	}

	public void clickToUpdateButton(String productName) {
		waitForElementClickable(UserCheckOutPageUI.BUTTON_UPDATE_BY_NAME, productName);
		clickToElement(UserCheckOutPageUI.BUTTON_UPDATE_BY_NAME, productName);
	}

	public UserProductListPageObject clickToTabMobile() {
		waitForElementClickable(UserBasePageUI.MOBILE_TAB);
		clickToElement(UserBasePageUI.MOBILE_TAB);
		return PageGenerateManagers.getUserProductList(driver);
	}

	public void chooseCountryInDropdown(String country) {
		waitForElementClickable(UserCheckOutPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdownByVisibleText(UserCheckOutPageUI.COUNTRY_DROPDOWN, country);
	}

	public void chooseStateInDropdown(String state) {
		waitForElementClickable(UserCheckOutPageUI.PROVINCE_DROPDOWN);
		selectItemInDropdownByVisibleText(UserCheckOutPageUI.PROVINCE_DROPDOWN, state);
	}

	public void enterToZipTextBox(String zip) {
		waitForElementVisible(UserCheckOutPageUI.ZIP_TEXTBOX, zip);
		sendKeyToElement(UserCheckOutPageUI.ZIP_TEXTBOX, zip);
	}

	public void clickToEstimateButton() {
		waitForElementClickable(UserCheckOutPageUI.ESTIMATE_BUTTON);
		clickToElement(UserCheckOutPageUI.ESTIMATE_BUTTON);
	}

	public boolean isFlatRateDisplay() {
		waitForElementVisible(UserCheckOutPageUI.FORM_FLAT_RATE);
		return isElementDisplay(UserCheckOutPageUI.FORM_FLAT_RATE);
	}

	public void chooseFixedInCheckBoxFlatRate() {
		waitForElementClickable(UserCheckOutPageUI.FLAT_RATE_RADIO);
		checkToDefaultCheckboxRadio(UserCheckOutPageUI.FLAT_RATE_RADIO);
	}

	public void clickToUpdateTotalButton() {
		waitForElementClickable(UserCheckOutPageUI.UPDATE_TOTAL_BUTTON);
		clickToElement(UserCheckOutPageUI.UPDATE_TOTAL_BUTTON);
	}

	public void clickToProceedToCheckout() {
		waitForElementClickable(UserCheckOutPageUI.PROCEED_TO_CHECKOUT);
		clickToElement(UserCheckOutPageUI.PROCEED_TO_CHECKOUT);
	}

	public void enterToAddressBillingTextBox(String addressBilling) {
		waitForElementVisible(UserCheckOutPageUI.ADDRESS_TEXTBOX_IN_BILLING, addressBilling);
		sendKeyToElement(UserCheckOutPageUI.ADDRESS_TEXTBOX_IN_BILLING, addressBilling);
	}

	public void enterToCityBillingTextBox(String cityBilling) {
		waitForElementVisible(UserCheckOutPageUI.CITY_TEXTBOX_IN_BILLING, cityBilling);
		sendKeyToElement(UserCheckOutPageUI.CITY_TEXTBOX_IN_BILLING, cityBilling);
	}

	public void enterToZipBillingTextBox(String zip) {
		waitForElementVisible(UserCheckOutPageUI.ZIP_TEXTBOX_IN_BILLING, zip);
		sendKeyToElement(UserCheckOutPageUI.ZIP_TEXTBOX_IN_BILLING, zip);
	}

	public void enterToTelephoneBillingTextBox(String telephone) {
		waitForElementVisible(UserCheckOutPageUI.TELEPHONE_TEXTBOX_IN_BILLING, telephone);
		sendKeyToElement(UserCheckOutPageUI.TELEPHONE_TEXTBOX_IN_BILLING, telephone);
	}

	public void choosePrivinceInDropdown(String province) {
		waitForElementClickable(UserCheckOutPageUI.STATE_DROPDOWN_IN_BILLING);
		selectItemInDropdownByVisibleText(UserCheckOutPageUI.STATE_DROPDOWN_IN_BILLING, province);
	}

	public void chooseCountryInDropdownInBilling(String country) {
		waitForElementClickable(UserCheckOutPageUI.COUNTRY_DROPDOWN_IN_BILLING);
		selectItemInDropdownByVisibleText(UserCheckOutPageUI.COUNTRY_DROPDOWN_IN_BILLING, country);
	}

	public void clickToContinueButtonInBilling() {
		waitForElementClickable(UserCheckOutPageUI.CONTINUE_BUTTON_IN_BILLING);
		clickToElement(UserCheckOutPageUI.CONTINUE_BUTTON_IN_BILLING);
	}

	public void enterToFirstNameTextBoxInShipping(String firstName) {
		waitForElementVisible(UserCheckOutPageUI.FIRSTNAME_TEXTBOX_IN_SHIPPING, firstName);
		sendKeyToElement(UserCheckOutPageUI.FIRSTNAME_TEXTBOX_IN_SHIPPING, firstName);
	}

	public void enterToLastNameTextBoxInShipping(String lastName) {
		waitForElementVisible(UserCheckOutPageUI.LASTNAME_TEXTBOX_IN_SHIPPING, lastName);
		sendKeyToElement(UserCheckOutPageUI.LASTNAME_TEXTBOX_IN_SHIPPING, lastName);
	}

	public void enterToAddressShippingTextBox(String addressShipping) {
		waitForElementVisible(UserCheckOutPageUI.ADDRESS_TEXTBOX_IN_SHIPPING, addressShipping);
		sendKeyToElement(UserCheckOutPageUI.ADDRESS_TEXTBOX_IN_SHIPPING, addressShipping);
	}

	public void enterToCityShippingTextBox(String cityShipping) {
		waitForElementVisible(UserCheckOutPageUI.CITY_TEXTBOX_IN_SHIPPING, cityShipping);
		sendKeyToElement(UserCheckOutPageUI.CITY_TEXTBOX_IN_SHIPPING, cityShipping);
	}

	public void enterToPhoneShippingTextBox(String telephone) {
		waitForElementVisible(UserCheckOutPageUI.TELEPHONE_TEXTBOX_IN_SHIPPING, telephone);
		sendKeyToElement(UserCheckOutPageUI.TELEPHONE_TEXTBOX_IN_SHIPPING, telephone);
	}

	public void clickToContinueButtonInShipping() {
		waitForElementClickable(UserCheckOutPageUI.CONTINUE_BUTTON_IN_SHIPPING);
		clickToElement(UserCheckOutPageUI.CONTINUE_BUTTON_IN_SHIPPING);
	}

	public String getFeeShipInShippingMethod() {
		waitForElementVisible(UserCheckOutPageUI.FEE_SHIP_IN_SHIPPING_METHOD);
		return getElementText(UserCheckOutPageUI.FEE_SHIP_IN_SHIPPING_METHOD);
	}

	public void clickToContinueButtonInShippingMethod() {
		waitForElementClickable(UserCheckOutPageUI.CONTINUE_BUTTON_IN_SHIPPING_METHOD);
		clickToElement(UserCheckOutPageUI.CONTINUE_BUTTON_IN_SHIPPING_METHOD);
	}

	public void choosePaymentTypeRadioButton(String paymentType) {
		waitForElementClickable(UserCheckOutPageUI.TYPE_PAYMENT_IN_PAYMENT, paymentType);
		checkToDefaultCheckboxRadio(UserCheckOutPageUI.TYPE_PAYMENT_IN_PAYMENT, paymentType);
	}

	public void clickToContinueButtonInPaymentType() {
		waitForElementClickable(UserCheckOutPageUI.CONTINUE_BUTTON_IN_PAYMENT);
		clickToElement(UserCheckOutPageUI.CONTINUE_BUTTON_IN_PAYMENT);
	}

	public String getGrandTotalInOrderReview() {
		waitForElementVisible(UserCheckOutPageUI.GRAND_TOTAL_IN_ORDER_REVIEW);
		return getElementText(UserCheckOutPageUI.GRAND_TOTAL_IN_ORDER_REVIEW);
	}

	public void clickToPlayOrderButton() {
		waitForElementClickable(UserCheckOutPageUI.PLACE_ORDER_BUTTON);
		clickToElement(UserCheckOutPageUI.PLACE_ORDER_BUTTON);
	}

	public String getSubTotal() {
		waitForElementVisible(UserCheckOutPageUI.SUB_TOTAL);
		return getElementText(UserCheckOutPageUI.SUB_TOTAL);
	}

	public String getFeeShipping() {
		waitForElementVisible(UserCheckOutPageUI.FEE_SHIPPING);
		return getElementText(UserCheckOutPageUI.FEE_SHIPPING);
	}

	public String getMessageTitleOrderSuccess() {
		waitForElementVisible(UserCheckOutPageUI.MESSAGE_TITLE_ORDER_SUCCESS);
		return getElementText(UserCheckOutPageUI.MESSAGE_TITLE_ORDER_SUCCESS);
	}

	public String getMessageSubTitleOrderSuccess() {
		waitForElementVisible(UserCheckOutPageUI.MESSAGE_SUB_TITLE_ORDER_SUCCESS);
		return getElementText(UserCheckOutPageUI.MESSAGE_SUB_TITLE_ORDER_SUCCESS);
	}

	public void chooseOptionBillingRadioButton(String optionShipBilling) {
		waitForElementClickable(UserCheckOutPageUI.TYPE_SHIPPING_RADIO_BUTTON_IN_BILLING, optionShipBilling);
		checkToDefaultCheckboxRadio(UserCheckOutPageUI.TYPE_SHIPPING_RADIO_BUTTON_IN_BILLING, optionShipBilling);
	}

}
