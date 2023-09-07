import org.testng.Assert;
import qa.base.BaseTest;
import qa.components.MainMenu;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.enums.MainMenuURLs;
import qa.stepclasses.MainMenuSteps;
import qa.utils.ExtentReportsManager;
import qa.utils.Function;
import qa.utils.JSONReader;
import io.qameta.allure.*;

@Epic("Smoke tests")
@Feature("Main menu links tests")
public class MainMenuTest extends BaseTest {

    private static MainMenuSteps mainMenuSteps;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenuSteps = new MainMenuSteps(mainMenu);

        JSONReader.read("./src/main/resources/data.json");
        expectedResults = JSONReader.get("URLs", "mainMenu");
    }

    private void check(Function function, MainMenuURLs index) {

        function.accept();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[index.ordinal()]);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the announcements page opens after clicking on the 'Ogłoszenia' link.")
    @Story("Clicking the 'Ogłoszenia duszpasterskie' link")
    public void pastoralAnnouncements() {

        ExtentReportsManager.setTestName("\"OGŁOSZENIA DUSZPASTERSKIE\" link");

        check(()->mainMenuSteps.clickThePastoraAnnouncementsLink(), MainMenuURLs.PASTORAL_ANNOUNCEMENTS);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the mass intentions page opens after clicking on the 'Intencje mszalne' link.")
    @Story("Clicking the 'Intencje mszalne' link")
    public void massIntentions() {

        ExtentReportsManager.setTestName("\"INTENCJE MSZALNE\" link");

        check(()->mainMenuSteps.clickTheMassIntentionsLink(), MainMenuURLs.MASS_INTENTIONS);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the funerals page opens after clicking on the 'Pogrzeby' link.")
    @Story("Clicking the 'Pogrzeby' link")
    public void funerals() {

        ExtentReportsManager.setTestName("\"POGRZEBY\" link");

        check(()->mainMenuSteps.clickTheFuneralsLink(), MainMenuURLs.FUNERALS);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the stevards page opens after clicking on the 'Szafarze' link.")
    @Story("Clicking the 'Szafarze' link")
    public void stewards() {

        ExtentReportsManager.setTestName("\"SZAFARZE\" link");

        check(()->mainMenuSteps.clickTheStewardsLink(), MainMenuURLs.STEWARDS);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'Duszpasterze' link.")
    @Story("Clicking the 'Duszpasterze' link")
    public void priests() {

        ExtentReportsManager.setTestName("\"DUSZPASTERZE\" link");

        check(()->mainMenuSteps.clickThePriestsLink(), MainMenuURLs.PRIESTS);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the office page opens after clicking on the 'Kancelaria' link.")
    @Story("Clicking the 'Kancelaria' link")
    public void office() {

        ExtentReportsManager.setTestName("\"KANCELARIA\" link");

        check(()->mainMenuSteps.clickTheOfficeLink(), MainMenuURLs.OFFICE);
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the contact page opens after clicking on the 'Kontakt' link.")
    @Story("Clicking the 'Kontakt' link")
    public void contact() {

        ExtentReportsManager.setTestName("\"KONTAKT\" link");

        check(()->mainMenuSteps.clickTheContactLink(), MainMenuURLs.CONTACT);
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the parish support page opens after clicking on the 'Wsparcie parafii' link.")
    @Story("Clicking the 'Wsparcie parafii' link")
    public void parishSupport() {

        ExtentReportsManager.setTestName("\"WSPARCIE PARAFII\" link");

        check(()->mainMenuSteps.clickTheParishSupportLink(), MainMenuURLs.PARISH_SUPPORT);
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the confession page opens after clicking on the 'Spowiedź w bazylice' link.")
    @Story("Clicking the 'Spowiedź w bazylice' link")
    public void confession() {

        ExtentReportsManager.setTestName("\"SPOWIEDŻ W BAZYLICE\" link");

        check(()->mainMenuSteps.clickTheConfessionLink(), MainMenuURLs.CONFESSION);
    }
}
