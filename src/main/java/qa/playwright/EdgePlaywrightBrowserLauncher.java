package qa.playwright;

import com.microsoft.playwright.BrowserType;

public class EdgePlaywrightBrowserLauncher extends PlaywrightBrowserLauncher {


    @Override
    protected void setBrowser() {

        browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true).setSlowMo(50));

        setBrowserInfo();
    }
}
