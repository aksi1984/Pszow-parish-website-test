package qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class BasilicaInside extends BasePage {

    public BasilicaInside(WebDriver driver) {

        super(driver);
    }

    @FindBy(linkText = "Prezbiterium")
    WebElement presbyteryLink;

    public void clickPresbyteryLink() {

        presbyteryLink.click();
    }
}
