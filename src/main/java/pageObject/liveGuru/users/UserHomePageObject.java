package pageObject.liveGuru.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
