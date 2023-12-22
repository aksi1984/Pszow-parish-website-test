package qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);
    }

    public void click(String id) throws IllegalAccessException {

        WebElement element = getDriver().findElement(By.id(id));
        waitUntilElementIsVisible(element);
        element.click();
    }
}
