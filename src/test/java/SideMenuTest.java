import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.finalcalsses.SideMenuURLs;
import qa.utils.ExtentReportsManager;
import qa.utils.Function_1;
import qa.utils.JSONReader;

public class SideMenuTest extends BaseTest {

    private SideMenu sideMenu;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        sideMenu = new SideMenu(getDriver());

        expectedResults = JSONReader.get("URLs", "sideMenu");
    }

    private void check(Function_1 function, int index) {

        function.run();

        String currentURL = getDriver().getCurrentUrl();

        back();
        Assert.assertEquals(currentURL, expectedResults[index]);
    }

    @Test(priority = 1)
    public void newArchbishopLink() {

        ExtentReportsManager.setTestName("NOWY ARCYBISKUP link");

        check(()->{sideMenu.clickNewArchbishopLink();}, SideMenuURLs.NEW_ARCHBISHOP);
    }

    @Test(priority = 2)
    public void parishStatisticsLink() {

        ExtentReportsManager.setTestName("\"STATYSTYKA PARAFIALNA 2022\" link");

        check(()->{sideMenu.clickParishStatisticsLink();}, SideMenuURLs.PARISH_STATISTICS);
    }

    @Test(priority = 3)
    public void retransmissionLink() {

        ExtentReportsManager.setTestName("\"RETRANSMISJA RÓŻAŃCA Z PSZOWA - TVP KATOWICE, 01-10-22 R.\" link");

        check(()->{sideMenu.clickRetransmissionLink();}, SideMenuURLs.RETRANSMISSION);
    }

    @Test(priority = 4)
    public void forgivenessReportLink() {

        ExtentReportsManager.setTestName("\"RELACJE Z ODPUSTU KU CZCI NARODZENIA NMP - 11 WRZEŚNIA 2022\" link");

        check(()->{sideMenu.clickForgivenessReportLink();}, SideMenuURLs.FORGIVENESS_REPORT);
    }

    @Test(priority = 5)
    public void plenaryIndulgenceLink() {

        ExtentReportsManager.setTestName("\"ODPUST ZUPEŁNY W CZASIE JUBILEUSZU W PSZOWIE\" link");

        check(()->{sideMenu.clickPlenaryIndulgenceLink();}, SideMenuURLs.PLENARY_INDULGENCE);
    }

    @Test(priority = 6)
    public void litanyLink() {

        ExtentReportsManager.setTestName("\"LITANIA DO PANI UŚMIECHNIĘTEJ\" link");

        check(()->{sideMenu.clickLitanyLink();}, SideMenuURLs.LITANY);
    }

    @Test(priority = 7)
    public void parishHistoryLink() {

        ExtentReportsManager.setTestName("\"HISTORIA PARAFII\" link");

        check(()->{sideMenu.clickParishHistoryLink();}, SideMenuURLs.PARISH_HISTORY);
    }

    @Test(priority = 8)
    public void yesterdayAndNowLink() {

        ExtentReportsManager.setTestName("\"PARAFIA WCZORAJ I DZIŚ\" link");

        check(()->{sideMenu.clickYesterdayAndNowLink();}, SideMenuURLs.YESTERDAY_AND_NOW);
    }

    @Test(priority = 9)
    public void basilicaInsideLink() {

        ExtentReportsManager.setTestName("\"WNĘTRZE BAZYLIKI - PANORAMA\" link");

        check(()->{sideMenu.clickBasilicaInsideLink();}, SideMenuURLs.BASILICA_INSIDE);
    }

    @Test(priority = 10)
    public void parishCommunityLink() {

        ExtentReportsManager.setTestName("\"WSPÓLNOTY PARAFIALNE\" link");

        check(()->{sideMenu.clickParishCommunityLink();}, SideMenuURLs.PARISH_COMMUNITY);
    }

    @Test(priority = 11)
    public void sacramentsInfoLink() {

        ExtentReportsManager.setTestName("\"SAKRAMENTY - INFORMACJE\" link");

        check(()->{sideMenu.clickSacramentsInfoLink();}, SideMenuURLs.SACRAMENTS);
    }

    @Test(priority = 12)
    public void calvaryLink() {

        ExtentReportsManager.setTestName("\"KALWARIA PSZOWSKA\" link");

        check(()->{sideMenu.clickCalvaryLink();}, SideMenuURLs.CALVARY);
    }

    @Test(priority = 13)
    public void photoGalleryLink() {

        ExtentReportsManager.setTestName("\"GALERIA ZDJĘĆ\" link");

        check(()->{sideMenu.clickPhotoGalleryLink();}, SideMenuURLs.PHOTO_GALLERY);
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

        check(()->{sideMenu.clickEveningWithJesusLink();}, SideMenuURLs.EVENING_WITH_JESUS);
    }

    @Test(priority = 15)
    public void cemeteryRegulationsLink() {

        ExtentReportsManager.setTestName("\"REGULAMIN CMENTARZA\" link");

        check(()->{sideMenu.clickCemeteryRegulationsLink();}, SideMenuURLs.CEMENTERY_REGULATIONS);
    }

    @Test(priority = 16)
    public void delegateLink() {

        ExtentReportsManager.setTestName("\"DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY\" link");

        check(()->{sideMenu.clickDelegateLink();}, SideMenuURLs.DELEGATE);
    }

    @Test(priority = 17)
    public void parishCharitableActivitiesLink() {

        ExtentReportsManager.setTestName("\"DZIAŁALNOŚĆ CHARYTATYWNA PARAFII\" link");

        check(()->{sideMenu.clickParishCharitableActivitiesLink();}, SideMenuURLs.PARISH_CHARITABLE_ACTIVITIES);
    }
}
