package qa.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public abstract class PlaywrightBrowserLauncher {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    protected void setPlaywright() {

        playwright = Playwright.create();
    }

    protected void setPage() {

        page = browser.newPage();
    }

    protected abstract void setBrowser();

    public void create() {

        setPlaywright();
        setBrowser();
        setPage();
    }

    public void goToPage(String url) {

        page.navigate(url);
    }

    public Page getPage() {

        return page;
    }

    public void close() {

        page.close();
    }
}
