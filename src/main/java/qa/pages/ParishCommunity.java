package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class ParishCommunity extends BasePage {

    public ParishCommunity(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//div[@class='container pageContent clearfix']")
    WebElement container;

    public void click(int index) throws IllegalAccessException {

        List<WebElement> elements = container.findElements(By.xpath("//img[@class]"));
        waitUntilElementIsVisible(elements.get(0));
        clickElement(elements.get(index));
    }
}
