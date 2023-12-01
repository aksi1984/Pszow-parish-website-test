import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.pages.Sacraments;
import qa.stepclasses.SacramentsPageSteps;
import qa.utils.ExtentReportsManager;
import qa.utils.Message;
import qa.utils.MyConsumer;


@Epic("Smoke tests")
@Feature("Sacraments page link tests")
public class SacramentsPageTest extends BaseTest {

    private SacramentsPageSteps sacramentsPageSteps;

    @BeforeMethod
    public void create() throws IllegalAccessException {

        sacramentsPageSteps = new SacramentsPageSteps(new Sacraments(getDriver()));
        SideMenu sideMenu = new SideMenu(getDriver());

        sideMenu.click("SAKRAMENTY – INFORMACJE");
    }

    private void check(MyConsumer<SacramentsPageSteps> consumer, String expectedURL, String assertMessage) throws IllegalAccessException {

        consumer.accept(sacramentsPageSteps);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL, assertMessage);
    }

    @Test
    @Parameters({"baptismPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of baptism page opens after clicking on the 'Sakrament chrztu' link.")
    @Story("Clicking the 'Sakrament chrztu' link")
    public void sacramentOfBaptismLink(String url) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking the \"Sakrament chrztu\" link");

        check(SacramentsPageSteps::clickTheSacramentOfBaptismLink, url, Message.getMessage(url));
    }

    @Test
    @Parameters({"eucharistPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the eucharist page opens after clicking on the 'Eucharystia' link.")
    @Story("Clicking the 'Eucharystia' link")
    public void eucharist(String url) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking the \"Eucharystia\" link");

        check(SacramentsPageSteps::clickTheEucharistLink, url, Message.getMessage(url));
    }

    @Test
    @Parameters({"penancePageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of penance page opens after clicking on the 'Sakrament pokuty' link.")
    @Story("Clicking the 'Sakrament pokuty' link")
    public void sacramentOfPenanceLink(String url) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking the \"Sakrament pokuty\" link");

        check(SacramentsPageSteps::clickTheSacramentOfPenanceLink, url, Message.getMessage(url));
    }

    @Test
    @Parameters({"confirmationPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of confirmation page opens after clicking on the 'Sakrament bierzmowania' link.")
    @Story("Clicking the 'Sakrament bierzmowania' link")
    public void confirmation(String url) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking the \"Sakrament bierzmowania\" link");

        check(SacramentsPageSteps::clickTheSacramentOfConfirmationLink, url, Message.getMessage(url));
    }

    @Test
    @Parameters({"marriagePageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of marriage page opens after clicking on the 'Sakrament małżestwa' link.")
    @Story("Clicking the 'Sakrament małżeństwa' link")
    public void sacramentOfMarriage(String url) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking the \"Sakrament małżeństwa\" link");

        check(SacramentsPageSteps::clickTheSacramentOfMarriageLink, url, Message.getMessage(url));
    }

    @Test
    @Parameters({"sickPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of the sick page opens after clicking on the 'Sakrament chorych' link.")
    @Story("Clicking the 'Sakrament chorych' link")
    public void sacramentOfTheSick(String url) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking the \"Sakrament chorych\" link");

        check(SacramentsPageSteps::clickTheSacramentOfTheSickLink, url, Message.getMessage(url));
    }
}
