package qa.browsermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserManager {

    private static final String url = "https://bazylika-pszow.pl";
    private static final Logger logger = LoggerFactory.getLogger(BrowserManager.class);

    public static void start(WebDriver driver) {

        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName() +
                             " " + ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion();

        logger.info("Opening the \"" + url + "\" website on the \"" + browserName + "\" browser");

        driver.navigate().to("https://bazylika-pszow.pl");
        driver.manage().window().maximize();
    }

    public static void quit(WebDriver driver) {

        logger.info("Closing the \"" + url + "\" website");

        driver.quit();
    }
}
