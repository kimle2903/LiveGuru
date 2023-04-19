package factoryBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		return WebDriverManager.chromedriver().capabilities(options).create();
	}

}
