import qa.base.BaseTest;
import qa.components.MainMenu;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainMenuTest extends BaseTest {

    private static MainMenu mainMenu;

    @BeforeClass
    public void init() {

        mainMenu = new MainMenu(getDriver());
    }

    @Test(priority = 1)
    public void pastoralAnnouncements() {

        mainMenu.click("OGŁOSZENIA DUSZPASTERSKIE");
    }

    @Test(priority = 2)
    public void massIntentions() {

        mainMenu.click("INTENCJE MSZALNE");
    }

    @Test(priority = 3)
    public void funerals() {

        mainMenu.click("POGRZEBY");
    }

    @Test(priority = 4)
    public void stewards() {

        mainMenu.click("SZAFARZE");
    }

    @Test(priority = 5)
    public void priests() {

        mainMenu.click("DUSZPASTERZE");
    }

    @Test(priority = 6)
    public void office() {

        mainMenu.click("KANCELARIA");
    }

    @Test(priority = 7)
    public void contact() {

        mainMenu.click("KONTAKT");
    }

    @Test(priority = 8)
    public void parishSupport() {

        mainMenu.click("WSPARCIE PARAFII");
    }

    @Test(priority = 9)
    public void confession() {

        mainMenu.click("SPOWIEDŹ W BAZYLICE");
    }
}
