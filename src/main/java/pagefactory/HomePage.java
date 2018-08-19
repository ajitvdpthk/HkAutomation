package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dyafysis.gmail.com.dyafysis.gmail.AppPages;

import seleniumUtils.Browser;
import seleniumUtils.SeleniumDriverUtils;
import utils.BrowserType;
import utils.ExcelReader;
import utils.ExceptionUtility;
import utils.FileReader;

public class HomePage{

	WebDriver driver;

	@FindBy(name = "identifier")
	WebElement loginBox;

	@FindBy(id = "identifierNext")
	WebElement loginNextBtn;

	@FindBy(name = "password")
	WebElement loginPasswordBox;

	@FindBy(xpath = "//*[@class='RveJvd snByac']")
	WebElement signbtn;

	@FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
	WebElement composeBtn;

	@FindBy(xpath = "//textarea[@name='to']")
	WebElement sendEmailTo;

	@FindBy(xpath = "//input[@name='subjectbox']")
	WebElement subjectBox;

	@FindBy(xpath = "//div[@class='Am Al editable LW-avf']")
	WebElement bodyTextBox;

	@FindBy(css="td.gU.Up div.J-J5-Ji.btA")
	WebElement sendBtn;
	public HomePage() {
		this.driver = Browser.instanceOfBrowser(BrowserType.CHROME).driver();

		PageFactory.initElements(driver, this);
	}

	SeleniumDriverUtils util = new SeleniumDriverUtils();

	public void sendEmail(String textToSend) {
		try {
			util.click(composeBtn);
			util.sendKeys(sendEmailTo, "tdem414@gmail.com");
			util.sendKeys(subjectBox, "Demo");
			util.sendKeys(bodyTextBox, "Demo");
			util.click(sendBtn);
		} catch (ExceptionUtility e) {
			e.printStackTrace();
		}
	}

	
}
