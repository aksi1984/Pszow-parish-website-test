package qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;

    protected BasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {

        return driver;
    }

    public String getURL() {

        return driver.getCurrentUrl();
    }

    public void wait(int seconds) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
