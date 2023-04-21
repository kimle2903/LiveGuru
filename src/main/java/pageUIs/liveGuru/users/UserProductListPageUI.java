package pageUIs.liveGuru.users;

public class UserProductListPageUI {
	public static final String PRICE_PRODUCT_BY_NAME = "XPATH=//div[@class='product-info']/h2/a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
	public static final String PRODUCT_LINK = "XPATH=//div[@class='product-info']/h2/a[text()='%s']";
	public static final String ADD_TO_COMPARE_LINK_BY_NAME = "XPATH=//h2[@class='product-name']/a[text()='%s']/parent::h2//following-sibling::div[@class='actions']//a[text()='Add to Compare']";
	public static final String COMPARE_BUTTON = "XPATH=//button[@title='Compare']";
	public static final String MESSAGE_NOTIFY_SUCCESS = "XPATH=//li[@class='success-msg']//span";

	public static final String ADD_TO_WISHLIST_LINK_BY_NAME = "XPATH=//h2[@class='product-name']/a[text()='%s']/parent::h2//following-sibling::div[@class='actions']//a[text()='Add to Wishlist']";

}
