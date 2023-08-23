import org.testng.Assert;
import qa.base.BaseTest;
import qa.components.MainMenu;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.enums.MainMenuURLs;
import qa.utils.ExtentReportsManager;
import qa.utils.JSONReader;

public class MainMenuTest extends BaseTest {

    private static MainMenu mainMenu;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        mainMenu = new MainMenu(getDriver());

        JSONReader.read("./src/main/resources/data.json");
        expectedResults = JSONReader.get("URLs", "mainMenu");
    }

    private void check(String linkText, MainMenuURLs index) {

        mainMenu.click(linkText);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[index.ordinal()]);
    }

    @Test(priority = 1)
    public void pastoralAnnouncements() {

        ExtentReportsManager.setTestName("\"OGŁOSZENIA DUSZPASTERSKIE\" link");

        check("OGŁOSZENIA DUSZPASTERSKIE", MainMenuURLs.PASTORAL_ANNOUNCEMENTS);
    }

    @Test(priority = 2)
    public void massIntentions() {

        ExtentReportsManager.setTestName("\"INTENCJE MSZALNE\" link");

        check("INTENCJE MSZALNE", MainMenuURLs.MASS_INTENTIONS);
    }

    @Test(priority = 3)
    public void funerals() {

        ExtentReportsManager.setTestName("\"POGRZEBY\" link");

        check("POGRZEBY", MainMenuURLs.FUNERALS);
    }

    @Test(priority = 4)
    public void stewards() {

        ExtentReportsManager.setTestName("\"SZAFARZE\" link");

        check("SZAFARZE", MainMenuURLs.STEWARDS);
    }

    @Test(priority = 5)
    public void priests() {

        ExtentReportsManager.setTestName("\"DUSZPASTERZE\" link");

        check("DUSZPASTERZE", MainMenuURLs.PRIESTS);
    }

    @Test(priority = 6)
    public void office() {

        ExtentReportsManager.setTestName("\"KANCELARIA\" link");

        check("KANCELARIA", MainMenuURLs.OFFICE);
    }

    @Test(priority = 7)
    public void contact() {

        ExtentReportsManager.setTestName("\"KONTAKT\" link");

        check("KONTAKT", MainMenuURLs.CONTACT);
    }

    @Test(priority = 8)
    public void parishSupport() {

        ExtentReportsManager.setTestName("\"WSPARCIE PARAFII\" link");

        check("WSPARCIE PARAFII", MainMenuURLs.PARISH_SUPPORT);
    }

    @Test(priority = 9)
    public void confession() {

        ExtentReportsManager.setTestName("\"SPOWIEDŻ W BAZYLICE\" link");

        check("SPOWIEDŹ W BAZYLICE", MainMenuURLs.CONFESSION);
    }
}
