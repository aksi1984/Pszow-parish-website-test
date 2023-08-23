package qa.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class MiddleMenu extends BasePage {

    public MiddleMenu(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//a[@href='https://www.youtube.com/channel/UC2yRQAn3eXbBjO7zOQmde2g']")
    WebElement cameraLink;

    @FindBy(xpath = "//a[@href='http://facebook.com/pages/Parafia-Narodzenia-Naj%C5%9Bwi%C4%99tszej-Marii-Panny-w-Pszowie/308144625962391']")
    WebElement facebookLink;

    @FindBy(xpath = "//a[@href='https://www.archidiecezjakatowicka.pl/']")
    WebElement archdioceseLink;

    public void clickCameraLink() {

        clickElement(cameraLink);
    }

    public void clickArchdioceseLink() {

        clickElement(archdioceseLink);
    }

    public void clickFacebookLink() {

        clickElement(facebookLink);
    }
}
