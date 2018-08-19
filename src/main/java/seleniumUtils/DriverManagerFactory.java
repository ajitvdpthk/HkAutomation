package seleniumUtils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utils.BrowserType;

public class DriverManagerFactory {

	public static DriverManager getDriver(BrowserType type) {
		DriverManager driverManager = null;
		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new ChromeDriverManager();
			break;
		case INTERNETEXPLORER:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}
}
