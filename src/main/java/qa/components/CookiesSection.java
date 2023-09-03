package qa.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class CookiesSection extends BasePage {

    public CookiesSection(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "cn-accept-cookie")
    WebElement acceptCookieButton;

    public void acceptCookies() {

        acceptCookieButton.click();
    }
}
