import org.testng.Assert;
import qa.base.BaseTest;
import qa.components.MainMenu;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.finalcalsses.MainMenuURLs;
import qa.utils.ExtentReportsManager;
import qa.utils.JSONReader;

public class MainMenuTest extends BaseTest {

    private static MainMenu mainMenu;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        mainMenu = new MainMenu(getDriver());

        JSONReader.read("./src/main/resources/expectedresults.json");
        expectedResults = JSONReader.get("URLs", "mainMenu");
    }

    @Test(priority = 1)
    public void pastoralAnnouncements() {

        ExtentReportsManager.setTestName("OGŁOSZENIA DUSZPASTERSKIE link");

        mainMenu.click("OGŁOSZENIA DUSZPASTERSKIE");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.PASTORAL_ANNOUNCEMENTS]);
    }

    @Test(priority = 2)
    public void massIntentions() {

        ExtentReportsManager.setTestName("INTENCJE MSZALNE link");

        mainMenu.click("INTENCJE MSZALNE");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.MASS_INTENTIONS]);
    }

    @Test(priority = 3)
    public void funerals() {

        ExtentReportsManager.setTestName("POGRZEBY link");

        mainMenu.click("POGRZEBY");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.FUNERALS]);
    }

    @Test(priority = 4)
    public void stewards() {

        ExtentReportsManager.setTestName("SZAFARZE link");

        mainMenu.click("SZAFARZE");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.STEWARDS]);
    }

    @Test(priority = 5)
    public void priests() {

        ExtentReportsManager.setTestName("DUSZPASTERZE link");

        mainMenu.click("DUSZPASTERZE");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.PRIESTS]);
    }

    @Test(priority = 6)
    public void office() {

        ExtentReportsManager.setTestName("KANCELARIA link");

        mainMenu.click("KANCELARIA");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.OFFICE]);
    }

    @Test(priority = 7)
    public void contact() {

        ExtentReportsManager.setTestName("KONTAKT link");

        mainMenu.click("KONTAKT");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.CONTACT]);
    }

    @Test(priority = 8)
    public void parishSupport() {

        ExtentReportsManager.setTestName("WSPARCIE PARAFII link");

        mainMenu.click("WSPARCIE PARAFII");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.PARISH_SUPPORT]);
    }

    @Test(priority = 9)
    public void confession() {

        ExtentReportsManager.setTestName("SPOWIEDŻ W BAZYLICE link");

        mainMenu.click("SPOWIEDŹ W BAZYLICE");

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[MainMenuURLs.CONFESSION]);
    }
}
