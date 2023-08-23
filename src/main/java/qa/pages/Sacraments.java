package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class Sacraments extends BasePage {

    public Sacraments(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//div[@class='container pageContent clearfix']")
    WebElement container;

    public void click(int index) {

        List<WebElement> elements = container.findElements(By.tagName("a"));
        clickElement(elements.get(index));
    }
}