package factoryBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxHeadlessDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("window-size: 1920x1080");
		return WebDriverManager.firefoxdriver().capabilities(options).create();
	}

}
