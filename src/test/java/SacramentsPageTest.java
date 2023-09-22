import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.enums.SacramentsPageURLs;
import qa.pages.Sacraments;
import qa.enums.SideMenuURLs;
import qa.stepclasses.SacramentsPageSteps;
import qa.utils.JSONReader;

import java.util.function.Consumer;

@Epic("Smoke tests")
@Feature("Sacraments page link tests")
public class SacramentsPageTest extends BaseTest {

    private SacramentsPageSteps sacramentsPageSteps;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        sacramentsPageSteps = new SacramentsPageSteps(new Sacraments(getDriver()));
        SideMenu sideMenu = new SideMenu(getDriver());

        sideMenu.click(SideMenuURLs.SACRAMENTS.ordinal());

        expectedResults = JSONReader.get("URLs", "sacraments");
    }

    private void check(Consumer<SacramentsPageSteps> consumer, SacramentsPageURLs index) {

        consumer.accept(sacramentsPageSteps);

        String currentURL = getDriver().getCurrentUrl();

        back();
        Assert.assertEquals(currentURL, expectedResults[index.ordinal()]);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of baptism page opens after clicking on the 'Sakrament chrztu' link.")
    @Story("Clicking the 'Sakrament chrztu' link")
    public void sacramentOfBaptismLink() {

        check(SacramentsPageSteps::clickTheSacramentOfBaptismLink, SacramentsPageURLs.SACRAMENT_OF_BAPTISM);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the eucharist page opens after clicking on the 'Eucharystia' link.")
    @Story("Clicking the 'Eucharystia' link")
    public void eucharist() {

        check(SacramentsPageSteps::clickTheEucharistLink, SacramentsPageURLs.EUCHARIST);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of penance page opens after clicking on the 'Sakrament pokuty' link.")
    @Story("Clicking the 'Sakrament pokuty' link")
    public void sacramentOfPenanceLink() {

        check(SacramentsPageSteps::clickTheSacramentOfPenanceLink, SacramentsPageURLs.SACRAMENT_OF_PENANCE);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of confirmation page opens after clicking on the 'Sakrament bierzmowania' link.")
    @Story("Clicking the 'Sakrament bierzmowania' link")
    public void confirmation() {

        check(SacramentsPageSteps::clickTheSacramentOfConfirmationLink, SacramentsPageURLs.CONFIRMATION);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of marriage page opens after clicking on the 'Sakrament małżestwa' link.")
    @Story("Clicking the 'Sakrament małżeństwa' link")
    public void sacramentOfMarriage() {

        check(SacramentsPageSteps::clickTheSacramentOfMarriageLink, SacramentsPageURLs.SACRAMENT_OF_MARRIAGE);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacrament of the sick page opens after clicking on the 'Sakrament chorych' link.")
    @Story("Clicking the 'Sakrament chorych' link")
    public void sacramentOfTheSick() {

        check(SacramentsPageSteps::clickTheSacramentOfTheSickLink, SacramentsPageURLs.SACRAMENT_OF_THE_SICK);
    }
}
