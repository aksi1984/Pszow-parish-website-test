package qa.stepclasses;

import io.qameta.allure.Step;
import qa.components.MainMenu;

public class MainMenuSteps {

    private final MainMenu mainMenu;

    public MainMenuSteps(MainMenu mainMenu) {

        this.mainMenu = mainMenu;
    }

    @Step("Click the 'OGŁOSZENIA DUSZPASTERSKIE' link")
    public void clickThePastoraAnnouncementsLink() {

        mainMenu.click("OGŁOSZENIA DUSZPASTERSKIE");
    }

    @Step("Click the 'INTENCJE MSZALNE' link")
    public void clickTheMassIntentionsLink() {

        mainMenu.click("INTENCJE MSZALNE");
    }

    @Step("Click the 'POGRZEBY' link")
    public void clickTheFuneralsLink() {

        mainMenu.click("POGRZEBY");
    }

    @Step("Click the 'SZAFARZE' link")
    public void clickTheStewardsLink() {

        mainMenu.click("SZAFARZE");
    }

    @Step("Click the 'DUSZPASTERZE' link")
    public void clickThePriestsLink() {

        mainMenu.click("DUSZPASTERZE");
    }

    @Step("Click the 'KANCELARIA' link")
    public void clickTheOfficeLink() {

        mainMenu.click("KANCELARIA");
    }

    @Step("Click the 'KONTAKT' link")
    public void clickTheContactLink() {

        mainMenu.click("KONTAKT");
    }

    @Step("Click the 'WSPARCIE PARAFII' link")
    public void clickTheParishSupportLink() {

        mainMenu.click("WSPARCIE PARAFII");
    }

    @Step("Click the 'SPOWIEDŹ W BAZYLICE' link")
    public void clickTheConfessionLink() {

        mainMenu.click("SPOWIEDŹ W BAZYLICE");
    }
}
