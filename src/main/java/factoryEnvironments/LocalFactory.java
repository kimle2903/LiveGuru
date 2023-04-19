package factoryEnvironments;

import org.openqa.selenium.WebDriver;

import factoryBrowsers.BrowserList;
import factoryBrowsers.BrowserNoSupportedException;
import factoryBrowsers.ChromeDriverManager;
import factoryBrowsers.ChromeHeadlessDriverManager;
import factoryBrowsers.EdgeDriverManager;
import factoryBrowsers.FireFoxDriverManager;
import factoryBrowsers.FireFoxHeadlessDriverManager;
import factoryBrowsers.SafariDriverManager;

public class LocalFactory {
	private String browserName;
	private WebDriver driver;

	public LocalFactory(String browserName) {
		this.browserName = browserName;
	}

	public WebDriver createDriver() {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		case CHROME:
			driver = new ChromeDriverManager().getBrowserDriver();
			break;

		case FIREFOX:
			driver = new FireFoxDriverManager().getBrowserDriver();
			break;

		case EDGE:
			driver = new EdgeDriverManager().getBrowserDriver();
			break;

		case SAFARI:
			driver = new SafariDriverManager().getBrowserDriver();
			break;

		case H_CHROME:
			driver = new ChromeHeadlessDriverManager().getBrowserDriver();
			break;

		case H_FIREFOX:
			driver = new FireFoxHeadlessDriverManager().getBrowserDriver();
			break;

		default:
			throw new BrowserNoSupportedException(System.getProperty("os.name"));
		}

		return driver;
	}
}
