package qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);
    }

    public void click(String linkText) {

        getDriver().findElement(By.linkText(linkText)).click();
    }
}
