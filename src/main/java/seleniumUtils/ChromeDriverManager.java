package seleniumUtils;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeDriverManager extends DriverManager {
	private ChromeDriverService chService;
	@Override
    public void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	@Override
	public void stopService() {
		if(chService!=null && chService.isRunning()) {
			chService.stop();
		}
		
	}

	@Override
	public void createDriver() {
		driver=new org.openqa.selenium.chrome.ChromeDriver(chService);
		
	}

}
