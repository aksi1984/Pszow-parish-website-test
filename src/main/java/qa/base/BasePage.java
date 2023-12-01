package qa.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.toby.ToBy;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;
    private final JavascriptExecutor javascriptExecutor;
    private final WebDriverWait wait;

    protected BasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

        javascriptExecutor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected WebDriver getDriver() {

        return driver;
    }

    protected void waitUntilElementIsVisible(WebElement element) throws IllegalAccessException {

        ToBy.get(element);
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
