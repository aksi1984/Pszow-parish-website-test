import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.enums.SacramentsPageURLs;
import qa.pages.Sacraments;
import qa.enums.SideMenuURLs;
import qa.utils.JSONReader;

public class SacramentsPageTest extends BaseTest {

    private Sacraments sacraments;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        sacraments = new Sacraments(getDriver());
        SideMenu sideMenu = new SideMenu(getDriver());

        sideMenu.click(SideMenuURLs.SACRAMENTS.ordinal());

        expectedResults = JSONReader.get("URLs", "sacraments");
    }

    private void check(SacramentsPageURLs index) {

        sacraments.click(index.ordinal());

        String currentURL = getDriver().getCurrentUrl();

        back();
        Assert.assertEquals(currentURL, expectedResults[index.ordinal()]);
    }

    @Test
    public void sacramentOfBaptismLink() {

        check(SacramentsPageURLs.SACRAMENT_OF_BAPTISM);
    }

    @Test
    public void eucharist() {

        check(SacramentsPageURLs.EUCHARIST);
    }

    @Test
    public void sacramentOfPenanceLink() {

        check(SacramentsPageURLs.SACRAMENT_OF_PENANCE);
    }

    @Test
    public void confirmation() {

        check(SacramentsPageURLs.CONFIRMATION);
    }

    @Test
    public void sacramentOfMarriage() {

        check(SacramentsPageURLs.SACRAMENT_OF_MARRIAGE);
    }

    @Test
    public void sacramentOfTheSick() {

        check(SacramentsPageURLs.SACRAMENT_OF_THE_SICK);
    }
}
