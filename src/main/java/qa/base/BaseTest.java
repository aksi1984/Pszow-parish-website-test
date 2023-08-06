package qa.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import qa.driver.Driver;
import qa.enums.Browser;
import qa.utils.JSONReader;

import java.time.Duration;


public class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public void startDriver() {

        System.out.println("Starting driver");

        driver = Driver.createDriver(Browser.CHROME);
        driver.navigate().to("https://bazylika-pszow.pl");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        JSONReader.read("./src/main/resources/data.json");
    }

    public void back() {

        driver.navigate().back();
    }

    public static WebDriver getDriver() {

        return driver;
    }

    @AfterClass
    protected void quitDriver() {

        System.out.println("Quit driver");
        driver.quit();
    }
}
