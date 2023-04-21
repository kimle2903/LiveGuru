package pageUIs.liveGuru.users;

public class UserCheckOutPageUI {
	public static final String DISCOUNT_CODE_TEXTBOX = "css=input#coupon_code";
	public static final String APPLY_BUTTON = "xpath=//button[@title='Apply']";
	public static final String MESSAGE_APPLY_DISCOUNT_SUCCESS = "xpath=//li[@class='success-msg']//span";
	public static final String PRICE_DISCOUNT = "xpath=//table[@id='shopping-cart-totals-table']//tbody/tr/td[contains(text(), 'Discount (GURU50)')]/following-sibling::td/span";
	public static final String GRAND_TOTAL = "xpath=//table[@id='shopping-cart-totals-table']//tfoot//span[@class='price']";

	public static final String QUALITY_TEXTBOX_BY_NAME = "xpath=//h2/a[text()='%s']/parent::h2/parent::td/following-sibling::td[@class='product-cart-actions']/input";
	public static final String BUTTON_UPDATE_BY_NAME = "xpath=//h2/a[text()='%s']/parent::h2/parent::td/following-sibling::td[@class='product-cart-actions']/button[@title='Update']";
	public static final String ERROR_MESSAGE_AT_SHOPPING_CART = "xpath=//li[@class='error-msg']//span";
	public static final String ERROR_MESSAGE_AT_PRODUCT_ITEM = "xpath=//h2/a[text()='%s']/parent::h2/following-sibling::p";
	public static final String EMPTY_CART_BUTTON = "xpath=//button[@id='empty_cart_button']";
	public static final String MESSAGE_EMPTY_IN_CART = "xpath=//div[@class='cart-empty']/p[1]";

	public static final String MIBILE_TAB = "xpath=//div[@class='cart-empty']/p[1]";
	public static final String COUNTRY_DROPDOWN = "css=select#country";
	public static final String PROVINCE_DROPDOWN = "css=select#region_id";
	public static final String ZIP_TEXTBOX = "css=input#postcode";
	public static final String ESTIMATE_BUTTON = "xpath=//button[@title='Estimate']";

	public static final String FORM_FLAT_RATE = "XPATH=//form[@id='co-shipping-method-form']";
	public static final String UPDATE_TOTAL_BUTTON = "XPATH=//form[@id='co-shipping-method-form']//button[@title='Update Total']";
	public static final String FLAT_RATE_RADIO = "XPATH=//form[@id='co-shipping-method-form']//input[@id='s_method_flatrate_flatrate']";
	public static final String SUB_TOTAL = "XPATH=//tr/td[contains(text(), 'Subtotal')]/following-sibling::td/span";
	public static final String FEE_SHIPPING = "XPATH=//tr/td[contains(text(), 'Shipping & Handling (Flat Rate - Fixed)')]/following-sibling::td/span";
	public static final String PROCEED_TO_CHECKOUT = "XPATH=//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']";

	public static final String ADDRESS_TEXTBOX_IN_BILLING = "xpath=//input[@id='billing:street1']";
	public static final String CITY_TEXTBOX_IN_BILLING = "xpath=//input[@id='billing:city']";
	public static final String ZIP_TEXTBOX_IN_BILLING = "xpath=//input[@id='billing:postcode']";
	public static final String TELEPHONE_TEXTBOX_IN_BILLING = "xpath=//input[@id='billing:telephone']";
	public static final String STATE_DROPDOWN_IN_BILLING = "xpath=//select[@id='billing:region_id']";
	public static final String COUNTRY_DROPDOWN_IN_BILLING = "xpath=//select[@id='billing:country_id']";
	public static final String TYPE_SHIPPING_RADIO_BUTTON_IN_BILLING = "xpath=//li[@class='control']/label[text()='Ship to different address']/preceding-sibling::input";
	public static final String CONTINUE_BUTTON_IN_BILLING = "xpath=//div[@id='billing-buttons-container']/button";

	public static final String FIRSTNAME_TEXTBOX_IN_SHIPPING = "XPATH=//input[@id='shipping:firstname']";
	public static final String LASTNAME_TEXTBOX_IN_SHIPPING = "XPATH=//input[@id='shipping:lastname']";
	public static final String ADDRESS_TEXTBOX_IN_SHIPPING = "XPATH=//input[@id='shipping:street1']";
	public static final String CITY_TEXTBOX_IN_SHIPPING = "XPATH=//input[@id='shipping:city']";
	public static final String TELEPHONE_TEXTBOX_IN_SHIPPING = "XPATH=//input[@id='shipping:telephone']";
	public static final String CONTINUE_BUTTON_IN_SHIPPING = "xpath=//div[@id='shipping-buttons-container']/button";

	public static final String FEE_SHIP_IN_SHIPPING_METHOD = "xpath=//div[@id='checkout-shipping-method-load']//label/span[@class='price']";
	public static final String CONTINUE_BUTTON_IN_SHIPPING_METHOD = "xpath=//div[@id='shipping-method-buttons-container']/button";
	public static final String TYPE_PAYMENT_IN_PAYMENT = "xpath=//dt//label[text()='Check / Money order ']/preceding-sibling::input";
	public static final String CONTINUE_BUTTON_IN_PAYMENT = "xpath=//div[@id='payment-buttons-container']/button";

	public static final String GRAND_TOTAL_IN_ORDER_REVIEW = "xpath=//td/strong[text()='Grand Total']/parent::td/following-sibling::td//span[@class='price']";
	public static final String PLACE_ORDER_BUTTON = "xpath=//div[@id='checkout-review-submit']//button";
	public static final String MESSAGE_TITLE_ORDER_SUCCESS = "xpath=//div[@class='page-title']/h1";
	public static final String MESSAGE_SUB_TITLE_ORDER_SUCCESS = "xpath=//h2[@class='sub-title']";

}
