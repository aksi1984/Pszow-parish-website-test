package qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//div[@class='container pageContent clearfix']")
    List<WebElement> containers;

    public boolean isContainerPageContentPresent() {

        return !containers.isEmpty();
    }
}
