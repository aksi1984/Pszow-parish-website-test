package qa.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import qa.driver.Driver;
import qa.enums.Browser;
import qa.utils.JSONReader;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;


public class BaseTest {

    private static WebDriver driver;

    @BeforeClass
    public void readJSONFile() throws IOException {

        JSONReader.read();
    }

    @BeforeMethod
    public void startDriver() {

        driver = Driver.createDriver(Browser.CHROME);
        driver.navigate().to("https://bazylika-pszow.pl");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public ArrayList<String> getTabs() {

        return new ArrayList<>(driver.getWindowHandles());
    }

    public static WebDriver getDriver() {

        return driver;
    }

    @AfterMethod
    public void quitDriver() {

        driver.quit();
    }
}
