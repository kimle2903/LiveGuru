package factoryBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeHeadlessDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("window-size: 1920x1080");
		return WebDriverManager.chromedriver().capabilities(options).create();
	}

}
