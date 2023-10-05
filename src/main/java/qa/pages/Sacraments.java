package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;


public class Sacraments extends BasePage {

    public Sacraments(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//div[@class='container pageContent clearfix']")
    WebElement container;

    public void click(String linkText) {

        WebElement element = container.findElement(By.linkText(linkText));
        clickElement(element);
    }
}
