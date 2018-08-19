package homePageTests;

import org.testng.annotations.BeforeTest;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import com.dyafysis.gmail.com.dyafysis.gmail.AppPages;
import com.dyafysis.gmail.com.dyafysis.gmail.GmailAutomationMain;

import pagefactory.HomePage;
import pagefactory.LogInPage;

public class HomePageTest {
	
	@Test
	public void verifyIfUserCanSend400Email() throws IllegalAccessException, InstantiationException {
		
		AppPages<LogInPage> page = new GmailAutomationMain<LogInPage>();
		try {
			page.getInstance(LogInPage.class).logInToAccount();
			new GmailAutomationMain<HomePage>().getInstance(HomePage.class).sendEmail("uyfucd");
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 	}

}
