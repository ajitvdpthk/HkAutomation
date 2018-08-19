package seleniumUtils;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserType;
import utils.ErrorCodes;
import utils.ExceptionUtility;
import utils.FileReader;

public class Browser {

    private static Browser intance = null;
    private WebDriver driver;
    private FileReader po;

    private Browser(BrowserType value) {
    	po=new FileReader();
        launchBrowser(value);
    }
    private Browser() {
    	
    }

    public static Browser instanceOfBrowser(BrowserType browserType) {
        if (intance == null) {
            intance = new Browser(browserType);
        }
        return intance;
    }
    public static Browser instanceOfBrowser() {
        if (intance == null) {
            intance = new Browser();
        }
        return intance;
    }

    public WebDriver driver() {
        return driver;
    }

    private void launchBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", po.getDriverPath(browserType.CHROME));
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case FIREFOX:
                System.setProperty("webdriver.chrome.driver", po.getDriverPath(browserType.FIREFOX));
                driver = new FirefoxDriver();
                break;
            case INTERNETEXPLORER:
                System.setProperty("webdriver.chrome.driver", po.getDriverPath(browserType.INTERNETEXPLORER));
                driver = new InternetExplorerDriver();
                break;
        }
    }

    public void closeTheBrowser() {
        if (driver != null) {
            driver.close();

        }
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void maximizeTheBrowserWindow() {
        driver.manage().window().maximize();
    }

    public String switchToFrame(WebElement element) throws ExceptionUtility {
        String framName = "";
        try {
            WebDriver frame = driver.switchTo().frame(element);
            framName = frame.getTitle();

        } catch (NoSuchFrameException noFram) {
            throw new ExceptionUtility(ErrorCodes.FRAMNOTFOUND);
        }

        return framName;
    }

    public void switchToFrame(String framName) throws ExceptionUtility {
        try {
            driver.switchTo().frame(framName);
        } catch (NoSuchFrameException noFram) {
            throw new ExceptionUtility(ErrorCodes.FRAMNOTFOUND);

        }
    }

    public boolean switchToWindow(String windowName) throws ExceptionUtility {
        boolean ifSwitched = true;
        try {

            driver.switchTo().window(windowName);

        } catch (NoSuchWindowException noWindow) {
            ifSwitched = false;
            throw new ExceptionUtility(ErrorCodes.FRAMNOTFOUND);
        }
        return ifSwitched;
    }

    public void getScreeshot() throws IOException {
        TakesScreenshot screenshot;

        screenshot = ((TakesScreenshot) driver);
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(""));


    }

    public void waitForPageToLoad(long timeToWait, TimeUnit unit) {
       driver.manage().timeouts().implicitlyWait(timeToWait,unit);

    }
    public void waitForPageToLoad(WebElement element) throws NoSuchElementException {

        WebDriverWait wait=new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForPageToLoad(){
        Wait wait=new FluentWait(driver);
        ((FluentWait) wait).withMessage("Waiting For Element").
                withTimeout(30,TimeUnit.SECONDS).
                pollingEvery(5,TimeUnit.SECONDS).
                ignoring(NoSuchElementException.class);
    }

}
