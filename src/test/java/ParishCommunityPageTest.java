import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.pages.ParishCommunity;
import qa.stepclasses.ParishCommunityPageSteps;
import qa.utils.JSONReader;
import qa.enums.SideMenuURLs;
import qa.enums.ParishCommunityURLs;

@Epic("Smoke tests")
@Feature("'Wspólnoty parafialne' page image links test")
public class ParishCommunityPageTest extends BaseTest {

    private ParishCommunityPageSteps parishCommunityPageSteps;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        ParishCommunity parishCommunity = new ParishCommunity(getDriver());
        parishCommunityPageSteps = new ParishCommunityPageSteps(parishCommunity);

        SideMenu sideMenu = new SideMenu(getDriver());

        sideMenu.click(SideMenuURLs.PARISH_COMMUNITY.ordinal());
        expectedResults = JSONReader.get("URLs", "parishCommunity");
    }

    private void check(ParishCommunityURLs index) {

        parishCommunityPageSteps.clickTheImage(index);

        String currentURL = getDriver().getCurrentUrl();

        back();
        Assert.assertEquals(currentURL, expectedResults[index.ordinal()]);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'DUSZPASTERZE' image")
    @Story("Clicking the 'DUSZPASTERZE' image")
    public void priestsLink() {

        check(ParishCommunityURLs.PRIESTS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the pastoral council page opens after clicking on the 'PARAFIALNA RADA DUSZPASTERSKA' image")
    @Story("Clicking the 'PARAFIALNA RADA DUSZPASTERSKA' image")
    public void pastoralCouncilLink() {

        check(ParishCommunityURLs.PASTORAL_COUNCIL);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'NADZWYCZAJNI SZAFARZE KOMUNII ŚWIĘTEJ' image")
    @Story("Clicking the 'NADZWYCZAJNI SZAFARZE KOMUNII ŚWIĘTEJ' image")
    public void stewardsLink() {

        check(ParishCommunityURLs.STEWARDS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'MINISTRANCI' image")
    @Story("Clicking the 'MINISTRANCI' image")
    public void altarBoysLink() {

        check(ParishCommunityURLs.ALTAR_BOYS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'DZIECI MARYI' image")
    @Story("Clicking the 'DZIECI MARYI' image")
    public void childrenOfMary() {

        check(ParishCommunityURLs.CHILDREN_OF_MARY);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'OAZA MŁODZIEŻOWA' image")
    @Story("Clicking the 'OAZA MŁODZIEŻOWA' image")
    public void youthOasisLink() {

        check(ParishCommunityURLs.YOUTH_OASIS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'DOMOWY KOŚCIÓŁ' image")
    @Story("Clicking the 'DOMOWY KOŚCIÓŁ' image")
    public void homeChurchLink() {

        check(ParishCommunityURLs.HOME_CHURCH);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'KATECHEZA DOROSŁYCH' image")
    @Story("Clicking the 'KATECHEZA DOROSŁYCH' image")
    public void adultCatechesisLink() {

        check(ParishCommunityURLs.ADULT_CATECHESIS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'LEGION MARYI' image")
    @Story("Clicking the 'LEGION MARYI' image")
    public void legionOfMaryLink() {

        check(ParishCommunityURLs.LEGION_OF_MARY);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'PSZOWSKIE OGNISKO CUDOWNIE OCALONYCH' image")
    @Story("Clicking the 'PSZOWSKI OGNISKO CUDOWNIE OCALONYCH' image")
    public void miraculousySavedLink() {

        check(ParishCommunityURLs.MIRACULOUSY_SAVED);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'ŻYWY RÓŻANIEC' image")
    @Story("Clicking the 'ŻYWY RÓŻANIEC' image")
    public void livingRosaryLink() {

        check(ParishCommunityURLs.LIVING_ROSARY);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'LECTIO DIVINA' image")
    @Story("Clicking the 'LECTIO DIVINA' image")
    public void lectioDivinaLink() {

        check(ParishCommunityURLs.LECTIO_DIVINA);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'III FRANCISZKAŃSKI ZAKON ŚWIECKICH' image")
    @Story("Clicking the 'III FRANCISZKAŃSKI ZAKON ŚWIECKICH' image")
    public void secularOrderLink() {

        check(ParishCommunityURLs.SECULAR_ORDER);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the priests page opens after clicking on the 'WIECZÓR Z JEZUSEM' image")
    @Story("Clicking the 'WIECZÓR Z JEZUSEM' image")
    public void eveningWithJesusLink() {

        check(ParishCommunityURLs.EVENING_WITH_JESUS);
    }
}
