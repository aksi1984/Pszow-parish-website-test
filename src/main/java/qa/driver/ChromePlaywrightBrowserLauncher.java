package qa.driver;

import com.microsoft.playwright.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromePlaywrightBrowserLauncher extends PlaywrightBrowserLauncher {

    @Override
    protected void setBrowser() {

        browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50));
    }
}
