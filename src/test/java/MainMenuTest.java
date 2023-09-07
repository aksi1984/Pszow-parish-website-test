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
    @Description("Test description: opening 'Ogłoszenia duszpasterskie' site with 'Ogłoszenia duszpasterskie' link")
    @Story("Correct opening of page 'Ogłoszenia duszpasterskie'")
    public void pastoralAnnouncements() {

        ExtentReportsManager.setTestName("\"OGŁOSZENIA DUSZPASTERSKIE\" link");

        check(()->mainMenuSteps.clickThePastoraAnnouncementsLink(), MainMenuURLs.PASTORAL_ANNOUNCEMENTS);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: opening 'Intencje mszalne' site with 'Intencje mszalne' link")
    @Story("Correct opening of page 'Intencje mszalne'")
    public void massIntentions() {

        ExtentReportsManager.setTestName("\"INTENCJE MSZALNE\" link");

        check(()->mainMenuSteps.clickTheMassIntentionsLink(), MainMenuURLs.MASS_INTENTIONS);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: opening 'Pogrzeby' site with 'Pogrzeby' link")
    @Story("Correct opening of page 'Pogrzeby'")
    public void funerals() {

        ExtentReportsManager.setTestName("\"POGRZEBY\" link");

        check(()->mainMenuSteps.clickTheFuneralsLink(), MainMenuURLs.FUNERALS);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: opening 'Szafarze' site with 'Szafarze' link")
    @Story("Correct opening of page 'Szafarze'")
    public void stewards() {

        ExtentReportsManager.setTestName("\"SZAFARZE\" link");

        check(()->mainMenuSteps.clickTheStewardsLink(), MainMenuURLs.STEWARDS);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: opening 'Duszpasterze' site with 'Duszpasterze' link")
    @Story("Correct opening of page 'Duszpasterze'")
    public void priests() {

        ExtentReportsManager.setTestName("\"DUSZPASTERZE\" link");

        check(()->mainMenuSteps.clickThePriestsLink(), MainMenuURLs.PRIESTS);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: opening 'Kancelaria' site with 'Kancelaria' link")
    @Story("Correct opening of page 'Kancelaria'")
    public void office() {

        ExtentReportsManager.setTestName("\"KANCELARIA\" link");

        check(()->mainMenuSteps.clickTheOfficeLink(), MainMenuURLs.OFFICE);
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: opening 'Kontakt' site with 'Kontakt' link")
    @Story("Correct opening of page 'Kontakt'")
    public void contact() {

        ExtentReportsManager.setTestName("\"KONTAKT\" link");

        check(()->mainMenuSteps.clickTheContactLink(), MainMenuURLs.CONTACT);
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: opening 'Wsparcie parafii' site with 'Wsparcie parafii' link")
    @Story("Correct opening of page 'Wsparcie parafii'")
    public void parishSupport() {

        ExtentReportsManager.setTestName("\"WSPARCIE PARAFII\" link");

        check(()->mainMenuSteps.clickTheParishSupportLink(), MainMenuURLs.PARISH_SUPPORT);
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: opening 'Spowiedź w bazylice' site with 'Spowiedź w bazylice' link")
    @Story("Correct opening of page 'Spowiedź w bazylice'")
    public void confession() {

        ExtentReportsManager.setTestName("\"SPOWIEDŻ W BAZYLICE\" link");

        check(()->mainMenuSteps.clickTheConfessionLink(), MainMenuURLs.CONFESSION);
    }
}
