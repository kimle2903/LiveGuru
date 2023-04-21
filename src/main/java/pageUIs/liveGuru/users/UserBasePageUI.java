package pageUIs.liveGuru.users;

public class UserBasePageUI {
	public static final String ACCOUNT_HEADER_LINK = "xpath=//div[@class='account-cart-wrapper']/a/span[text()='Account']";
	public static final String PAGE_LINK_IN_ACCOUNT_HEADER = "xpath=//div[@ID='header-account']//li/a[text()='%s']";
	public static final String PAGE_LINK_IN_SIZEBAR = "xpath=//div[@class='block-content']//li/a[text()='%s']";
	public static final String MOBILE_TAB = "xpath=//ol[@class='nav-primary']/li/a[text()='Mobile']";
	public static final String TV_TAB = "xpath=//ol[@class='nav-primary']/li/a[text()='TV']";

	public static final String PAGE_LINK_IN_FOOTER_BY_NAME = "xpath=//div[@class='footer']//a[text()='%s']";
}
