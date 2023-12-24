package qa.playwright;

import com.microsoft.playwright.BrowserType;

public class ChromePlaywrightBrowserLauncher extends PlaywrightBrowserLauncher {

    @Override
    protected void setBrowser() {

        browser = playwright
                .chromium()
                .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true).setSlowMo(50));

        setBrowserInfo();
    }
}
