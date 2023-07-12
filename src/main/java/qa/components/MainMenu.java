package qa.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {

        super(driver);
    }

    @FindBy(id = "menu-item-1457")
    WebElement pastoralAnnouncements;

    @FindBy(id = "menu-item-1458")
    WebElement massIntentions;

    @FindBy(id = "menu-item-13836")
    WebElement funerals;

    @FindBy(id = "menu-item-19387")
    WebElement stewards;

    @FindBy(id = "menu-item-1466")
    WebElement priests;

    @FindBy(id = "menu-item-1462")
    WebElement office;

    @FindBy(id = "menu-item-1463")
    WebElement contact;

    @FindBy(id = "menu-item-18194")
    WebElement parishSupport;

    public void click(String linkText) {

        getDriver().findElement(By.linkText(linkText)).click();
    }
    public void clickPastoralAnnouncements() {

        pastoralAnnouncements.click();
    }

    public void clickMassIntentions() {

        massIntentions.click();
    }

    public void clickFunerals() {

        funerals.click();
    }

    public void clickStewards() {

        stewards.click();
    }

    public void clickPriests() {

        priests.click();
    }

    public void clickOffice() {

        office.click();
    }

    public void clickContact() {

        contact.click();
    }

    public void clickParishSupport() {

        parishSupport.click();
    }
}
