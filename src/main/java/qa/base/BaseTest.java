package qa.base;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.driver.PlaywrightBrowserLauncher;
import qa.driver.PlaywrightProvider;
import qa.enums.Browser;
import qa.enums.URLs;
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

        launcher = PlaywrightProvider.getFactory(Browser.CHROME);
        launcher.create();
        launcher.goToPage(URLs.HOME_PAGE.getName());
    }

    protected void goToPage(String url) {

        launcher.goToPage(url);
    }

    protected Page getPage() {

        return launcher.getPage();
    }

    @AfterMethod
    public void tearDown() {

        launcher.close();
    }
}
