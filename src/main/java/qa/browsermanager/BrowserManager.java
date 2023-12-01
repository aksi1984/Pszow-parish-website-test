package qa.browsermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class BrowserManager {

    private static final String url = "https://bazylika-pszow.pl";

    public static void start(WebDriver driver) {

        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName() +
                             " " + ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion();

        System.out.println("Opening the \"" + url + "\" website on the \"" + browserName + "\" browser");

        driver.navigate().to("https://bazylika-pszow.pl");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void quit(WebDriver driver) {

        System.out.println("Closing the \"" + url + "\" website");

        driver.quit();
    }
}
