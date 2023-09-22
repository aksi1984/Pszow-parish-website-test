import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.stepclasses.SideMenuSteps;
import qa.utils.ExtentReportsManager;
import qa.enums.SideMenuURLs;
import qa.utils.JSONReader;

import java.util.function.Consumer;

@Epic("Smoke tests")
@Feature("Side menu tests")
public class SideMenuTest extends BaseTest {

    private SideMenuSteps sideMenuSteps;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        sideMenuSteps = new SideMenuSteps(new SideMenu(getDriver()));

        expectedResults = JSONReader.get("URLs", "sideMenu");
    }

    private void check(Consumer<SideMenuSteps> consumer, SideMenuURLs index) {

        consumer.accept(sideMenuSteps);

        String currentURL = getDriver().getCurrentUrl();

        back();
        Assert.assertEquals(currentURL, expectedResults[index.ordinal()]);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the archbishop invitation page opens after clicking on the 'ZAPROSZENIE KS. ABPA ADRIANA GALBASA NA PIELGRZYMKĘ DO PSZOWA' link.")
    @Story("Clicking the 'ZAPROSZENIE KS. ABPA ADRIANA GALBASA NA PIELGRZYMKĘ DO PSZOWA' link")
    public void archbishopInvitationLink() {

        ExtentReportsManager.setTestName("ZAPROSZENIE KS. ABPA ADRIANA GALBASA NA PIELGRZYMKĘ DO PSZOWA link");

        check(SideMenuSteps::clickTheArchbishopInvitationLink, SideMenuURLs.ARCHBISHOP_INVITATION);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the jubilee indulgence page opens after clicking on the 'JUBILEUSZOWY ODPUST – 10 WRZEŚNIA 2023' link.")
    @Story("Clicking the 'JUBILEUSZOWY ODPUST – 10 WRZEŚNIA 2023' link")
    public void jubileeIndulgenceLink() {

        ExtentReportsManager.setTestName("\"JUBILEUSZOWY ODPUST – 10 WRZEŚNIA 2023\" link");

        check(SideMenuSteps::clickTheJubileeIndulgenceLink, SideMenuURLs.JUBILEE_INDULGENCE);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the plenary indulgence page opens after clicking on the 'ODPUST ZUPEŁNY W CZASIE JUBILEUSZU W PSZOWIE' link.")
    @Story("Clicking the 'ODPUST ZUPEŁNY W CZASIE JUBILEUSZU W PSZOWIE' link")
    public void plenaryIndulgenceLink() {

        ExtentReportsManager.setTestName("\"ODPUST ZUPEŁNY W CZASIE JUBILEUSZU W PSZOWIE\" link");

        check(SideMenuSteps::clickThePlenaryIndulgenceLink, SideMenuURLs.PLENARY_INDULGENCE);
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the litany page opens after clicking on the 'LITANIA DO PANI UŚMIECHNIĘTEJ' link.")
    @Story("Clicking the 'LITANIA DO PANI UŚMIECHNIĘTEJ' link")
    public void litanyLink() {

        ExtentReportsManager.setTestName("\"LITANIA DO PANI UŚMIECHNIĘTEJ\" link");

        check(SideMenuSteps::clickTheLitanyLink, SideMenuURLs.LITANY);
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the parish history page opens after clicking on the 'HISTORIA PARAFII' link.")
    @Story("Clicking the 'HISTORIA PARAFII' link")
    public void parishHistoryLink() {

        ExtentReportsManager.setTestName("\"HISTORIA PARAFII\" link");

        check(SideMenuSteps::clickTheParishHistoryLink, SideMenuURLs.PARISH_HISTORY);
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the parish yesterday and now page opens after clicking on the 'PARAFIA WCZORAJ I DZIŚ' link.")
    @Story("Clicking the 'PARAFIA WCZORAJ I DZIŚ' link")
    public void yesterdayAndNowLink() {

        ExtentReportsManager.setTestName("\"PARAFIA WCZORAJ I DZIŚ\" link");

        check(SideMenuSteps::clickTheParishYesterdayAndNowLink, SideMenuURLs.YESTERDAY_AND_NOW);
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the basilica inside and now page opens after clicking on the 'WNĘTRZE BAZYLIKI' link.")
    @Story("Clicking the 'WNĘTRZE BAZYLIKI' link")
    public void basilicaInsideLink() {

        ExtentReportsManager.setTestName("\"WNĘTRZE BAZYLIKI - PANORAMA\" link");

        check(SideMenuSteps::clickTheBasilicaInsideLink, SideMenuURLs.BASILICA_INSIDE);
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the parish community page opens after clicking on the 'WSPÓLNOTY PARAFIALNE' link.")
    @Story("Clicking the 'WSPÓLNOTY PARAFIALNE' link")
    public void parishCommunityLink() {

        ExtentReportsManager.setTestName("\"WSPÓLNOTY PARAFIALNE\" link");

        check(SideMenuSteps::clickTheParishCommunityLink, SideMenuURLs.PARISH_COMMUNITY);
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacraments page opens after clicking on the 'SAKRAMENTY - INFORMACJE' link.")
    @Story("Clicking the 'SAKRAMENTY - INFORMACJE' link")
    public void sacramentsInfoLink() {

        ExtentReportsManager.setTestName("\"SAKRAMENTY - INFORMACJE\" link");

        check(SideMenuSteps::clickTheSacramentsLink, SideMenuURLs.SACRAMENTS);
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the calvary page opens after clicking on the 'KALWARIA PSZOWSKA' link.")
    @Story("Clicking the 'KALWARIA PSZOWSKA' link")
    public void calvaryLink() {

        ExtentReportsManager.setTestName("\"KALWARIA PSZOWSKA\" link");

        check(SideMenuSteps::clickTheCalvaryLink, SideMenuURLs.CALVARY);
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the photo gallery page opens after clicking on the 'GALERIA ZDJĘĆ' link.")
    @Story("Clicking the 'GALERIA ZDJĘĆ' link")
    public void photoGalleryLink() {

        ExtentReportsManager.setTestName("\"GALERIA ZDJĘĆ\" link");

        check(SideMenuSteps::clickThePhotoGalleryLink, SideMenuURLs.PHOTO_GALLERY);
    }

    /*@Test(priority = 18)
    public void filmsLink() throws InterruptedException {

        ExtentReportsManager.setTestName("\"GALERIA FILMÓW\" link");

        sideMenu.clickFilmsLink();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[SideMenuURLs.FILMS]);

        back();
    }*/

    @Test(priority = 14)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the evening with Jesus page opens after clicking on the 'WIECZÓR Z JEZUSEM' link.")
    @Story("Clicking the 'WIECZÓR Z JEZUSEM' link")
    public void eveningWithJesusLink() {

        ExtentReportsManager.setTestName("\"WIECZÓR Z JEZUSEM\" link");

        check(SideMenuSteps::clickTheEveningWithJesusLink, SideMenuURLs.EVENING_WITH_JESUS);
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the cemetery regulations page opens after clicking on the 'REGULAMIN CMENTARZA' link.")
    @Story("Clicking the 'REGULAMIN CMENTARZA' link")
    public void cemeteryRegulationsLink() {

        ExtentReportsManager.setTestName("\"REGULAMIN CMENTARZA\" link");

        check(SideMenuSteps::clickTheCemeteryRegulationsLink, SideMenuURLs.CEMENTERY_REGULATIONS);
    }

    @Test(priority = 16)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the delegate page opens after clicking on the 'DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY' link.")
    @Story("Clicking the 'DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY' link")
    public void delegateLink() {

        ExtentReportsManager.setTestName("\"DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY\" link");

        check(SideMenuSteps::clickTheDelegateLink, SideMenuURLs.DELEGATE);
    }

    @Test(priority = 17)
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the parish charitable activities page opens after clicking on the 'DZIAŁALNOŚĆ CHARYTATYWNA PARAFII' link.")
    @Story("Clicking the 'DZIAŁALNOŚĆ CHARYTATYWNA PARAFII' link")
    public void parishCharitableActivitiesLink() {

        ExtentReportsManager.setTestName("\"DZIAŁALNOŚĆ CHARYTATYWNA PARAFII\" link");

        check(SideMenuSteps::clickTheParishCharitableActivitiesLink, SideMenuURLs.PARISH_CHARITABLE_ACTIVITIES);
    }
}
