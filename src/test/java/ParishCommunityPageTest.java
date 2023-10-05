import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.pages.ParishCommunity;
import qa.stepclasses.ParishCommunityPageSteps;
import qa.enums.ParishCommunityURLs;

@Epic("Smoke tests")
@Feature("'Wspólnoty parafialne' page image links test")
public class ParishCommunityPageTest extends BaseTest {

    private ParishCommunityPageSteps parishCommunityPageSteps;

    @BeforeMethod
    public void create() {

        ParishCommunity parishCommunity = new ParishCommunity(getDriver());
        parishCommunityPageSteps = new ParishCommunityPageSteps(parishCommunity);

        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.click("WSPÓLNOTY PARAFIALNE");
    }

    private void check(ParishCommunityURLs index, String expectedURL) {

        parishCommunityPageSteps.clickTheImage(index);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL);
    }

    @Test
    @Parameters({"priestsPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'DUSZPASTERZE' image")
    @Story("Clicking the 'DUSZPASTERZE' image")
    public void priestsLink(String url) {

        check(ParishCommunityURLs.PRIESTS, url);
    }

    @Test
    @Parameters({"pastoralCouncilPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the pastoral council page opens after clicking on the 'PARAFIALNA RADA DUSZPASTERSKA' image")
    @Story("Clicking the 'PARAFIALNA RADA DUSZPASTERSKA' image")
    public void pastoralCouncilLink(String url) {

        check(ParishCommunityURLs.PASTORAL_COUNCIL, url);
    }

    @Test
    @Parameters({"stewardsPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'NADZWYCZAJNI SZAFARZE KOMUNII ŚWIĘTEJ' image")
    @Story("Clicking the 'NADZWYCZAJNI SZAFARZE KOMUNII ŚWIĘTEJ' image")
    public void stewardsLink(String url) {

        check(ParishCommunityURLs.STEWARDS, url);
    }

    @Test
    @Parameters({"altarBoysPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'MINISTRANCI' image")
    @Story("Clicking the 'MINISTRANCI' image")
    public void altarBoysLink(String url) {

        check(ParishCommunityURLs.ALTAR_BOYS, url);
    }

    @Test
    @Parameters({"childrenOfMaryPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'DZIECI MARYI' image")
    @Story("Clicking the 'DZIECI MARYI' image")
    public void childrenOfMary(String url) {

        check(ParishCommunityURLs.CHILDREN_OF_MARY, url);
    }

    @Test
    @Parameters({"youthOasisPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'OAZA MŁODZIEŻOWA' image")
    @Story("Clicking the 'OAZA MŁODZIEŻOWA' image")
    public void youthOasisLink(String url) {

        check(ParishCommunityURLs.YOUTH_OASIS, url);
    }

    @Test
    @Parameters({"homeChurchPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'DOMOWY KOŚCIÓŁ' image")
    @Story("Clicking the 'DOMOWY KOŚCIÓŁ' image")
    public void homeChurchLink(String url) {

        check(ParishCommunityURLs.HOME_CHURCH, url);
    }

    @Test
    @Parameters({"adultCatechesisPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'KATECHEZA DOROSŁYCH' image")
    @Story("Clicking the 'KATECHEZA DOROSŁYCH' image")
    public void adultCatechesisLink(String url) {

        check(ParishCommunityURLs.ADULT_CATECHESIS, url);
    }

    @Test
    @Parameters({"legionOfMaryPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'LEGION MARYI' image")
    @Story("Clicking the 'LEGION MARYI' image")
    public void legionOfMaryLink(String url) {

        check(ParishCommunityURLs.LEGION_OF_MARY, url);
    }

    @Test
    @Parameters({"miraculousySavedPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'PSZOWSKIE OGNISKO CUDOWNIE OCALONYCH' image")
    @Story("Clicking the 'PSZOWSKI OGNISKO CUDOWNIE OCALONYCH' image")
    public void miraculousySavedLink(String url) {

        check(ParishCommunityURLs.MIRACULOUSY_SAVED, url);
    }

    @Test
    @Parameters({"livingRosaryPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'ŻYWY RÓŻANIEC' image")
    @Story("Clicking the 'ŻYWY RÓŻANIEC' image")
    public void livingRosaryLink(String url) {

        check(ParishCommunityURLs.LIVING_ROSARY, url);
    }

    @Test
    @Parameters({"lectioDivinaPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'LECTIO DIVINA' image")
    @Story("Clicking the 'LECTIO DIVINA' image")
    public void lectioDivinaLink(String url) {

        check(ParishCommunityURLs.LECTIO_DIVINA, url);
    }

    @Test
    @Parameters({"secularOrderPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'III FRANCISZKAŃSKI ZAKON ŚWIECKICH' image")
    @Story("Clicking the 'III FRANCISZKAŃSKI ZAKON ŚWIECKICH' image")
    public void secularOrderLink(String url) {

        check(ParishCommunityURLs.SECULAR_ORDER, url);
    }

    @Test
    @Parameters({"eveningWithJesusPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'WIECZÓR Z JEZUSEM' image")
    @Story("Clicking the 'WIECZÓR Z JEZUSEM' image")
    public void eveningWithJesusLink(String url) {

        check(ParishCommunityURLs.EVENING_WITH_JESUS, url);
    }
}
