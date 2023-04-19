package factoryBrowsers;

import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SafariDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		if (!IS_OS_MAC) {
			throw new BrowserNoSupportedException(System.getProperty("os.name"));
		}
		return WebDriverManager.safaridriver().create();
	}

}
