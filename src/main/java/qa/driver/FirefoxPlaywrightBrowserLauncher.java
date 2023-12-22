package qa.driver;

import com.microsoft.playwright.BrowserType;

public class FirefoxPlaywrightBrowserLauncher extends PlaywrightBrowserLauncher {


    @Override
    protected void setBrowser() {

        browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setSlowMo(50));
    }
}
