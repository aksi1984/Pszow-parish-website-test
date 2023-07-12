package qa.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.enums.Browser;
import qa.utils.Pair;

import java.util.Arrays;
import java.util.List;

public class Driver {

    private static WebDriver driver = null;

    private static final List<Pair<String, String>> properties = Arrays.asList(

        new Pair<>("chromedriver.exe", "webdriver.chrome.driver"),
        new Pair<>("geckodriver.exe", "webdriver.gecko.driver"),
        new Pair<>("msedgedriver.exe", "webdriver.edge.driver")
    );

    Driver() { }

    public static WebDriver createDriver(Browser browser) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser) {
            case CHROME -> {

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                chromeOptions.merge(capabilities);

                driver = new ChromeDriver(chromeOptions);
            }
            case FIREFOX -> {

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--remote-allow-origins=*");
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                firefoxOptions.merge(capabilities);

                driver = new FirefoxDriver(firefoxOptions);
            }
            case EDGE -> {

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
                edgeOptions.merge(capabilities);

                driver = new EdgeDriver(edgeOptions);
            }
        }

        System.setProperty(properties.get(browser.ordinal()).getFirst(), properties.get(browser.ordinal()).getSecond());

        return driver;
    }
}
