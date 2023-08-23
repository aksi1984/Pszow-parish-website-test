package qa.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;

    private JavascriptExecutor javascriptExecutor;

    protected BasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

        javascriptExecutor = (JavascriptExecutor) driver;
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected void clickElement(WebElement element) {

        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    protected String getURL() {

        return driver.getCurrentUrl();
    }

    protected void wait(int seconds) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
}
