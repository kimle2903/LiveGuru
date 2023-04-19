package factoryBrowsers;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager implements BrowserFactory {

	@Override
	public WebDriver getBrowserDriver() {
		return WebDriverManager.edgedriver().create();
	}

}
