package qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class SideMenu extends BasePage {

    public SideMenu(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = ".//div[@class='menu-nawigacja-lewa-container']")
    WebElement container;

    public void click(String linkText) throws IllegalAccessException {

        WebElement element = container.findElement(By.linkText(linkText));
        waitUntilElementIsVisible(element);
        clickElement(element);
    }
}
