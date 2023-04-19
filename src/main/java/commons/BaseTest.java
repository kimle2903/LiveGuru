package commons;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import factoryEnvironments.BrowserStackFactory;
import factoryEnvironments.LocalFactory;

public class BaseTest {
	WebDriver driver;
	protected final Log log;

	public BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	protected WebDriver getBrowserDriver(String envName, String envServer, String osName, String osVersion, String browserName, String role) {
		switch (envName) {
		case "local":
			driver = new LocalFactory(browserName).createDriver();
			break;
		case "browserStack":
			driver = new BrowserStackFactory(browserName, osName, osVersion).createDriver();
			break;
		default:
			driver = new LocalFactory(browserName).createDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(gerUrlEnvironmentName(envServer, role));

		return driver;
	}

	private String gerUrlEnvironmentName(String environmentName, String role) {
		String url = null;
		EnvironmentList enviroment = EnvironmentList.valueOf(environmentName.toUpperCase());
		if (role.equals("user")) {
			switch (enviroment) {
			case DEV:
				url = GlobalConstants.USER_PAGE_URL;
				break;
			default:
				url = null;
			}

		} else if (role.equals("admin")) {
			switch (enviroment) {
			case DEV:
				url = GlobalConstants.USER_ADMIN_URL;
				break;
			default:
				url = null;
			}

		}

		return url;
	}

	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = GlobalConstants.OS_NAME;

			String driverInstanceName = driver.toString().toLowerCase();

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int randomInt() {
		return new Random().nextInt(9999);
	}

}
