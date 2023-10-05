import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.pages.Sacraments;
import qa.stepclasses.SacramentsPageSteps;
import java.util.function.Consumer;

@Epic("Smoke tests")
@Feature("Sacraments page link tests")
public class SacramentsPageTest extends BaseTest {

    private SacramentsPageSteps sacramentsPageSteps;

    @BeforeMethod
    public void create() {

        sacramentsPageSteps = new SacramentsPageSteps(new Sacraments(getDriver()));
        SideMenu sideMenu = new SideMenu(getDriver());

        sideMenu.click("SAKRAMENTY – INFORMACJE");
    }

    private void check(Consumer<SacramentsPageSteps> consumer, String expectedURL) {

        consumer.accept(sacramentsPageSteps);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
    }

    @Test
    @Parameters({"baptismPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of baptism page opens after clicking on the 'Sakrament chrztu' link.")
    @Story("Clicking the 'Sakrament chrztu' link")
    public void sacramentOfBaptismLink(String url) {

        check(SacramentsPageSteps::clickTheSacramentOfBaptismLink, url);
    }

    @Test
    @Parameters({"eucharistPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the eucharist page opens after clicking on the 'Eucharystia' link.")
    @Story("Clicking the 'Eucharystia' link")
    public void eucharist(String url) {

        check(SacramentsPageSteps::clickTheEucharistLink, url);
    }

    @Test
    @Parameters({"penancePageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of penance page opens after clicking on the 'Sakrament pokuty' link.")
    @Story("Clicking the 'Sakrament pokuty' link")
    public void sacramentOfPenanceLink(String url) {

        check(SacramentsPageSteps::clickTheSacramentOfPenanceLink, url);
    }

    @Test
    @Parameters({"confirmationPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of confirmation page opens after clicking on the 'Sakrament bierzmowania' link.")
    @Story("Clicking the 'Sakrament bierzmowania' link")
    public void confirmation(String url) {

        check(SacramentsPageSteps::clickTheSacramentOfConfirmationLink, url);
    }

    @Test
    @Parameters({"marriagePageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of marriage page opens after clicking on the 'Sakrament małżestwa' link.")
    @Story("Clicking the 'Sakrament małżeństwa' link")
    public void sacramentOfMarriage(String url) {

        check(SacramentsPageSteps::clickTheSacramentOfMarriageLink, url);
    }

    @Test
    @Parameters({"sickPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of the sick page opens after clicking on the 'Sakrament chorych' link.")
    @Story("Clicking the 'Sakrament chorych' link")
    public void sacramentOfTheSick(String url) {

        check(SacramentsPageSteps::clickTheSacramentOfTheSickLink, url);
    }
}
