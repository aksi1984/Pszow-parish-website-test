import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import qa.base.BaseTest;
import qa.components.MainMenu;
import org.testng.annotations.Test;
import qa.stepclasses.MainMenuSteps;
import qa.utils.ExtentReportsManager;
import io.qameta.allure.*;
import qa.utils.Message;

@Epic("Smoke tests")
@Feature("Main menu links tests")
public class MainMenuTest extends BaseTest {

    private static MainMenuSteps mainMenuSteps;

    @BeforeMethod
    public void create() {

        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenuSteps = new MainMenuSteps(mainMenu);
    }

    @Test(priority = 1)
    @Parameters({"pastoralURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the announcements page opens after clicking on the 'Ogłoszenia' link.")
    @Story("Clicking the 'Ogłoszenia duszpasterskie' link")
    public void pastoralAnnouncements(String url) {

        ExtentReportsManager.setTestName("Clicking the \"OGŁOSZENIA DUSZPASTERSKIE\" link");

        mainMenuSteps.clickThePastoraAnnouncementsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }

    @Test(priority = 2)
    @Parameters({"intentionsURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the mass intentions page opens after clicking on the 'Intencje mszalne' link.")
    @Story("Clicking the 'Intencje mszalne' link")
    public void massIntentions(String url) {

        ExtentReportsManager.setTestName("Clicking the \"INTENCJE MSZALNE\" link");

        mainMenuSteps.clickTheMassIntentionsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }

    @Test(priority = 3)
    @Parameters({"funeralsURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the funerals page opens after clicking on the 'Pogrzeby' link.")
    @Story("Clicking the 'Pogrzeby' link")
    public void funerals(String url) {

        ExtentReportsManager.setTestName("Clicking the \"POGRZEBY\" link");

        mainMenuSteps.clickTheFuneralsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }

    @Test(priority = 4)
    @Parameters({"stewardsURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the stevards page opens after clicking on the 'Szafarze' link.")
    @Story("Clicking the 'Szafarze' link")
    public void stewards(String url) {

        ExtentReportsManager.setTestName("Clicking the \"SZAFARZE\" link");

        mainMenuSteps.clickTheStewardsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }

    @Test(priority = 5)
    @Parameters({"priestsURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'Duszpasterze' link.")
    @Story("Clicking the 'Duszpasterze' link")
    public void priests(String url) {

        ExtentReportsManager.setTestName("Clicking the \"DUSZPASTERZE\" link");

        mainMenuSteps.clickThePriestsLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }

    @Test(priority = 6)
    @Parameters({"officeURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the office page opens after clicking on the 'Kancelaria' link.")
    @Story("Clicking the 'Kancelaria' link")
    public void office(String url) {

        ExtentReportsManager.setTestName("Clicking the \"KANCELARIA\" link");

        mainMenuSteps.clickTheOfficeLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }

    @Test(priority = 7)
    @Parameters({"contactURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the contact page opens after clicking on the 'Kontakt' link.")
    @Story("Clicking the 'Kontakt' link")
    public void contact(String url) {

        ExtentReportsManager.setTestName("Clicking the \"KONTAKT\" link");

        mainMenuSteps.clickTheContactLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }

    @Test(priority = 8)
    @Parameters({"supportURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the parish support page opens after clicking on the 'Wsparcie parafii' link.")
    @Story("Clicking the 'Wsparcie parafii' link")
    public void parishSupport(String url) {

        ExtentReportsManager.setTestName("Clicking the \"WSPARCIE PARAFII\" link");

        mainMenuSteps.clickTheParishSupportLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }

    @Test(priority = 9)
    @Parameters({"confessionURL"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the confession page opens after clicking on the 'Spowiedź w bazylice' link.")
    @Story("Clicking the 'Spowiedź w bazylice' link")
    public void confession(String url) {

        ExtentReportsManager.setTestName("Clicking the \"SPOWIEDŻ W BAZYLICE\" link");

        mainMenuSteps.clickTheConfessionLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }
}
