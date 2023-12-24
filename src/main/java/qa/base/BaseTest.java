package qa.base;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.playwright.PlaywrightBrowserLauncher;
import qa.playwright.PlaywrightProvider;
import qa.enums.BrowserType;
import qa.jsonreader.JSONReader;

import java.io.IOException;


public class BaseTest {

    private PlaywrightBrowserLauncher launcher;

    @BeforeClass
    public void readJSONFile() throws IOException {

        JSONReader.read();
    }

    @BeforeMethod
    public void launch() {

        launcher = PlaywrightProvider.getFactory(BrowserType.CHROME);
        launcher.create();
    }

    protected void goToPage(String url) {

        launcher.goToPage(url);
    }

    protected BrowserContext getBrowserContext() {

        return launcher.getBrowserContext();
    }

    protected Page getPage() {

        return launcher.getPage();
    }

    @AfterMethod
    public void tearDown() {

        launcher.close();
    }
}
