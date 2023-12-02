package qa.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.browsermanager.BrowserManager;
import qa.driver.WebDriverProvider;
import qa.enums.Browser;
import qa.jsonreader.JSONReader;

import java.io.IOException;
import java.util.ArrayList;


public class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public void readJSONFile() throws IOException {

        JSONReader.read();
    }

    @BeforeMethod
    public void startDriver() {

        driver = WebDriverProvider.getFactory(Browser.CHROME).createDriver();
        BrowserManager.start(driver);
    }

    public ArrayList<String> getTabs() {

        return new ArrayList<>(driver.getWindowHandles());
    }

    public static WebDriver getDriver() {

        return driver;
    }

    @AfterMethod
    public void quitDriver() {

        BrowserManager.quit(driver);
    }
}
