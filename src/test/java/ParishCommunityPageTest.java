import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.pages.ParishCommunity;
import qa.utils.JSONReader;
import qa.enums.SideMenuURLs;
import qa.enums.ParishCommunityURLs;

public class ParishCommunityPageTest extends BaseTest {

    private ParishCommunity parishCommunity;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        parishCommunity = new ParishCommunity(getDriver());
        SideMenu sideMenu = new SideMenu(getDriver());

        sideMenu.click(SideMenuURLs.PARISH_COMMUNITY.ordinal());
        expectedResults = JSONReader.get("URLs", "parishCommunity");
    }

    private void check(ParishCommunityURLs index) {

        parishCommunity.click(index.ordinal());

        String currentURL = getDriver().getCurrentUrl();

        back();
        Assert.assertEquals(currentURL, expectedResults[index.ordinal()]);
    }
    @Test
    public void priestsLink() {

        check(ParishCommunityURLs.PRIESTS);
    }

    @Test
    public void pastoralCouncilLink() {

        check(ParishCommunityURLs.PASTORAL_COUNCIL);
    }

    @Test
    public void stewardsLink() {

        check(ParishCommunityURLs.STEWARDS);
    }

    @Test
    public void altarBoysLink() {

        check(ParishCommunityURLs.ALTAR_BOYS);
    }

    @Test
    public void childrenOfMary() {

        check(ParishCommunityURLs.CHILDREN_OF_MARY);
    }

    @Test
    public void youthOasisLink() {

        check(ParishCommunityURLs.YOUTH_OASIS);
    }

    @Test
    public void homeChurchLink() {

        check(ParishCommunityURLs.HOME_CHURCH);
    }

    @Test
    public void adultCatechesisLink() {

        check(ParishCommunityURLs.ADULT_CATECHESIS);
    }

    @Test
    public void legionOfMaryLink() {

        check(ParishCommunityURLs.LEGION_OF_MARY);
    }

    @Test
    public void miraculousySavedLink() {

        check(ParishCommunityURLs.MIRACULOUSY_SAVED);
    }

    @Test
    public void livingRosaryLink() {

        check(ParishCommunityURLs.LIVING_ROSARY);
    }

    @Test
    public void lectioDivinaLink() {

        check(ParishCommunityURLs.LECTIO_DIVINA);
    }

    @Test
    public void secularOrderLink() {

        check(ParishCommunityURLs.SECULAR_ORDER);
    }

    @Test
    public void eveningWithJesusLink() {

        check(ParishCommunityURLs.EVENING_WITH_JESUS);
    }
}
