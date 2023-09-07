import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.utils.ExtentReportsManager;
import qa.enums.SideMenuURLs;
import qa.utils.JSONReader;

public class SideMenuTest extends BaseTest {

    private SideMenu sideMenu;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        sideMenu = new SideMenu(getDriver());

        expectedResults = JSONReader.get("URLs", "sideMenu");
    }

    private void check(SideMenuURLs index) {

        sideMenu.click(index.ordinal());

        String currentURL = getDriver().getCurrentUrl();

        back();
        Assert.assertEquals(currentURL, expectedResults[index.ordinal()]);
    }

    @Test(priority = 1)
    public void archbishopInvitationLink() {

        ExtentReportsManager.setTestName("NOWY ARCYBISKUP link");

        check(SideMenuURLs.ARCHBISHOP_INVITATION);
    }

    @Test(priority = 2)
    public void jubileeIndulgenceLink() {

        ExtentReportsManager.setTestName("\"STATYSTYKA PARAFIALNA 2022\" link");

        check(SideMenuURLs.JUBILEE_INDULGENCE);
    }

    @Test(priority = 5)
    public void plenaryIndulgenceLink() {

        ExtentReportsManager.setTestName("\"ODPUST ZUPEŁNY W CZASIE JUBILEUSZU W PSZOWIE\" link");

        check(SideMenuURLs.PLENARY_INDULGENCE);
    }

    @Test(priority = 6)
    public void litanyLink() {

        ExtentReportsManager.setTestName("\"LITANIA DO PANI UŚMIECHNIĘTEJ\" link");

        check(SideMenuURLs.LITANY);
    }

    @Test(priority = 7)
    public void parishHistoryLink() {

        ExtentReportsManager.setTestName("\"HISTORIA PARAFII\" link");

        check(SideMenuURLs.PARISH_HISTORY);
    }

    @Test(priority = 8)
    public void yesterdayAndNowLink() {

        ExtentReportsManager.setTestName("\"PARAFIA WCZORAJ I DZIŚ\" link");

        check(SideMenuURLs.YESTERDAY_AND_NOW);
    }

    @Test(priority = 9)
    public void basilicaInsideLink() {

        ExtentReportsManager.setTestName("\"WNĘTRZE BAZYLIKI - PANORAMA\" link");

        check(SideMenuURLs.BASILICA_INSIDE);
    }

    @Test(priority = 10)
    public void parishCommunityLink() {

        ExtentReportsManager.setTestName("\"WSPÓLNOTY PARAFIALNE\" link");

        check(SideMenuURLs.PARISH_COMMUNITY);
    }

    @Test(priority = 11)
    public void sacramentsInfoLink() {

        ExtentReportsManager.setTestName("\"SAKRAMENTY - INFORMACJE\" link");

        check(SideMenuURLs.SACRAMENTS);
    }

    @Test(priority = 12)
    public void calvaryLink() {

        ExtentReportsManager.setTestName("\"KALWARIA PSZOWSKA\" link");

        check(SideMenuURLs.CALVARY);
    }

    @Test(priority = 13)
    public void photoGalleryLink() {

        ExtentReportsManager.setTestName("\"GALERIA ZDJĘĆ\" link");

        check(SideMenuURLs.PHOTO_GALLERY);
    }

    /*@Test(priority = 18)
    public void filmsLink() throws InterruptedException {

        ExtentReportsManager.setTestName("\"GALERIA FILMÓW\" link");

        sideMenu.clickFilmsLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.FILMS]);

        back();
    }*/

    @Test(priority = 14)
    public void eveningWithJesusLink() {

        ExtentReportsManager.setTestName("\"WIECZÓR Z JEZUSEM\" link");

        check(SideMenuURLs.EVENING_WITH_JESUS);
    }

    @Test(priority = 15)
    public void cemeteryRegulationsLink() {

        ExtentReportsManager.setTestName("\"REGULAMIN CMENTARZA\" link");

        check(SideMenuURLs.CEMENTERY_REGULATIONS);
    }

    @Test(priority = 16)
    public void delegateLink() {

        ExtentReportsManager.setTestName("\"DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY\" link");

        check(SideMenuURLs.DELEGATE);
    }

    @Test(priority = 17)
    public void parishCharitableActivitiesLink() {

        ExtentReportsManager.setTestName("\"DZIAŁALNOŚĆ CHARYTATYWNA PARAFII\" link");

        check(SideMenuURLs.PARISH_CHARITABLE_ACTIVITIES);
    }
}
