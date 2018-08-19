package seleniumUtils;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ErrorCodes;

import utils.ExceptionUtility;

public class SeleniumDriverUtils {

	public void sendKeys(WebElement element,final String textTosend) throws ExceptionUtility{
		try {
			element.clear();
			element.sendKeys(textTosend);
		} catch (NoSuchElementException e) {
			throw new ExceptionUtility(ErrorCodes.NO_SUCH_ELEMENT);
		}
		
	
	}
	
	public void click(WebElement element) throws ExceptionUtility{
		try {
			
			element.click();
		} catch (NoSuchElementException e) {
			throw new ExceptionUtility(ErrorCodes.NO_SUCH_ELEMENT);
		}
		
	}
	
	public boolean verifyIfElementPresent(WebElement ele,By by) throws ExceptionUtility {
		 try
         {
             if (ele.findElements(by).size()!=0)
                 return true;
             else
                 return false;

         } catch (Exception e)  {
             throw new ExceptionUtility(ErrorCodes.NO_SUCH_ELEMENT);
         }
		
	}
}
