package qa.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PlaywrightBrowserLauncher {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    private final Logger logger = LoggerFactory.getLogger(PlaywrightBrowserLauncher.class);

    protected void setBrowserInfo() {

        logger.info("Browser: " + browser.browserType().name() + " " + browser.version());
    }

    protected void setPlaywright() {

        playwright = Playwright.create();
    }

    protected void setBrowserContext() {

        browserContext = browser.newContext();
    }

    protected void setPage() {

        page = browserContext.newPage();
    }

    protected abstract void setBrowser();

    public void create() {

        setPlaywright();
        setBrowser();
        setBrowserContext();
        setPage();
    }

    public void goToPage(String url) {

        logger.info("Opening page with url: " + url + " ...");

        page.navigate(url);
    }

    public Page getPage() {

        return page;
    }

    public Browser getBrowser() {

        return browser;
    }

    public void close() {

        logger.info("Closing page...");

        page.close();
    }
}
