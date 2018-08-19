package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumUtils.Browser;
import seleniumUtils.SeleniumDriverUtils;
import utils.BrowserType;
import utils.ExceptionUtility;
import utils.FileReader;

public class LogInPage {

	WebDriver driver;

	@FindBy(name = "identifier")
	WebElement loginBox;

	@FindBy(id = "identifierNext")
	WebElement loginNextBtn;

	@FindBy(name = "password")
	WebElement loginPasswordBox;

	@FindBy(xpath = "//*[@class='RveJvd snByac']")
	WebElement signbtn;

		
	public LogInPage() {
		this.driver=Browser.instanceOfBrowser(BrowserType.CHROME).driver();
		
		PageFactory.initElements(driver, this);
	}

	SeleniumDriverUtils util = new SeleniumDriverUtils();

	public void logInToAccount() {
		try {
			
			driver.get("https:\\www.gmail.com");
			Browser.instanceOfBrowser().waitForPageToLoad();
			util.sendKeys(loginBox, "tdem414@gmail.com");
			util.click(loginNextBtn);
			util.sendKeys(loginPasswordBox, "test@789");
			util.click(signbtn);
		} catch (ExceptionUtility e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
