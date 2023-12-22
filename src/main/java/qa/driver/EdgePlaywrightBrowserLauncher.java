package qa.driver;

import com.microsoft.playwright.BrowserType;

public class EdgePlaywrightBrowserLauncher extends PlaywrightBrowserLauncher {


    @Override
    protected void setBrowser() {

        browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(50));
    }
}
