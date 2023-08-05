import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.finalcalsses.SideMenuURLs;
import qa.utils.ExtentReportsManager;
import qa.utils.JSONReader;

public class SideMenuTest extends BaseTest {

    private SideMenu sideMenu;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        sideMenu = new SideMenu(getDriver());

        JSONReader.read("./src/main/resources/expectedresults.json");
        expectedResults = JSONReader.get("URLs", "sideMenu");
    }

    @Test(priority = 1)
    public void newArchbishopLink() {

        ExtentReportsManager.setTestName("NOWY ARCYBISKUP link");

        sideMenu.clickNewArchbishopLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.NEW_ARCHBISHOP]);

        back();
    }

    @Test(priority = 2)
    public void parishStatisticsLink() {

        ExtentReportsManager.setTestName("\"STATYSTYKA PARAFIALNA 2022\" link");

        sideMenu.clickParishStatisticsLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.PARISH_STATISTICS]);

        back();
    }

    @Test(priority = 3)
    public void retransmissionLink() {

        ExtentReportsManager.setTestName("\"RETRANSMISJA RÓŻAŃCA Z PSZOWA - TVP KATOWICE, 01-10-22 R.\" link");

        sideMenu.clickRetransmissionLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.RETRANSMISSION]);

        back();
    }

    @Test(priority = 4)
    public void forgivenessReportLink() {

        ExtentReportsManager.setTestName("\"RELACJE Z ODPUSTU KU CZCI NARODZENIA NMP - 11 WRZEŚNIA 2022\" link");

        sideMenu.clickForgivenessReportLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.FORGIVENESS_REPORT]);

        back();
    }

    @Test(priority = 5)
    public void plenaryIndulgenceLink() {

        ExtentReportsManager.setTestName("\"ODPUST ZUPEŁNY W CZASIE JUBILEUSZU W PSZOWIE\" link");

        sideMenu.clickPlenaryIndulgenceLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.PLENARY_INDULGENCE]);

        back();
    }

    @Test(priority = 6)
    public void litanyLink() {

        ExtentReportsManager.setTestName("\"LITANIA DO PANI UŚMIECHNIĘTEJ\" link");

        sideMenu.clickLitanyLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.LITANY]);

        back();
    }

    @Test(priority = 7)
    public void parishHistoryLink() {

        ExtentReportsManager.setTestName("\"HISTORIA PARAFII\" link");

        sideMenu.clickParishHistoryLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.PARISH_HISTORY]);

        back();
    }

    @Test(priority = 8)
    public void yesterdayAndNowLink() {

        ExtentReportsManager.setTestName("\"PARAFIA WCZORAJ I DZIŚ\" link");

        sideMenu.clickYesterdayAndNowLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.YESTERDAY_AND_NOW]);

        back();
    }

    @Test(priority = 9)
    public void basilicaInsideLink() {

        ExtentReportsManager.setTestName("\"WNĘTRZE BAZYLIKI - PANORAMA\" link");

        sideMenu.clickBasilicaInsideLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.BASILICA_INSIDE]);

        back();
    }

    @Test(priority = 10)
    public void parishCommunityLink() {

        ExtentReportsManager.setTestName("\"WSPÓLNOTY PARAFIALNE\" link");

        sideMenu.clickParishCommunityLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.PARISH_COMMUNITY]);

        back();
    }

    @Test(priority = 11)
    public void sacramentsInfoLink() {

        ExtentReportsManager.setTestName("\"SAKRAMENTY - INFORMACJE\" link");

        sideMenu.clickSacramentsInfoLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.SACRAMENTS]);

        back();
    }

    @Test(priority = 12)
    public void calvaryLink() {

        ExtentReportsManager.setTestName("\"KALWARIA PSZOWSKA\" link");

        sideMenu.clickCalvaryLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.CALVARY]);

        back();
    }

    @Test(priority = 13)
    public void photoGalleryLink() {

        ExtentReportsManager.setTestName("\"GALERIA ZDJĘĆ\" link");

        sideMenu.clickPhotoGalleryLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.PHOTO_GALLERY]);

        back();
    }

    @Test(priority = 18)
    public void filmsLink() throws InterruptedException {

        ExtentReportsManager.setTestName("\"GALERIA FILMÓW\" link");

        sideMenu.clickFilmsLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.FILMS]);

        back();
    }

    @Test(priority = 14)
    public void eveningWithJesusLink() {

        ExtentReportsManager.setTestName("\"WIECZÓR Z JEZUSEM\" link");

        sideMenu.clickEveningWithJesusLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.EVENING_WITH_JESUS]);

        back();
    }

    @Test(priority = 15)
    public void cemeteryRegulationsLink() {

        ExtentReportsManager.setTestName("\"REGULAMIN CMENTARZA\" link");

        sideMenu.clickCemeteryRegulationsLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.CEMENTERY_REGULATIONS]);

        back();
    }

    @Test(priority = 16)
    public void delegateLink() {

        ExtentReportsManager.setTestName("\"DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY\" link");

        sideMenu.clickDelegateLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.DELEGATE]);

        back();
    }

    @Test(priority = 17)
    public void parishCharitableActivitiesLink() {

        ExtentReportsManager.setTestName("\"DZIAŁALNOŚĆ CHARYTATYWNA PARAFII\" link");

        sideMenu.clickParishCharitableActivitiesLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.PARISH_CHARITABLE_ACTIVITIES]);

        back();
    }
}
