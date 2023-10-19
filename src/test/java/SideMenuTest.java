import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.stepclasses.SideMenuSteps;
import qa.utils.ExtentReportsManager;
import qa.utils.Message;

import java.util.function.Consumer;


@Epic("Smoke tests")
@Feature("Side menu links tests")
public class SideMenuTest extends BaseTest {

    private SideMenuSteps sideMenuSteps;
    @BeforeMethod
    public void create() {

        sideMenuSteps = new SideMenuSteps(new SideMenu(getDriver()));
    }

    private void check(Consumer<SideMenuSteps> consumer, String expectedURL, String assertMessage) {

        consumer.accept(sideMenuSteps);

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedURL, assertMessage);
    }

    @Test(priority = 6)
    @Parameters({"litanyPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the litany page opens after clicking on the 'LITANIA DO PANI UŚMIECHNIĘTEJ' link.")
    @Story("Clicking the 'LITANIA DO PANI UŚMIECHNIĘTEJ' link")
    public void litanyLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"LITANIA DO PANI UŚMIECHNIĘTEJ\" link");

        check(SideMenuSteps::clickTheLitanyLink, url, Message.getMessage(url));
    }

    @Test(priority = 7)
    @Parameters({"historyPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the parish history page opens after clicking on the 'HISTORIA PARAFII' link.")
    @Story("Clicking the 'HISTORIA PARAFII' link")
    public void parishHistoryLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"HISTORIA PARAFII\" link");

        check(SideMenuSteps::clickTheParishHistoryLink, url, Message.getMessage(url));
    }

    @Test(priority = 8)
    @Parameters({"yesterdayAndNowPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the parish yesterday and now page opens after clicking on the 'PARAFIA WCZORAJ I DZIŚ' link.")
    @Story("Clicking the 'PARAFIA WCZORAJ I DZIŚ' link")
    public void yesterdayAndNowLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"PARAFIA WCZORAJ I DZIŚ\" link");

        check(SideMenuSteps::clickTheParishYesterdayAndNowLink, url, Message.getMessage(url));
    }

    @Test(priority = 9)
    @Parameters("basilicaInsidePageURL")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the basilica inside and now page opens after clicking on the 'WNĘTRZE BAZYLIKI' link.")
    @Story("Clicking the 'WNĘTRZE BAZYLIKI' link")
    public void basilicaInsideLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"WNĘTRZE BAZYLIKI - PANORAMA\" link");

        check(SideMenuSteps::clickTheBasilicaInsideLink, url, Message.getMessage(url));
    }

    @Test(priority = 10)
    @Parameters({"communityPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the parish community page opens after clicking on the 'WSPÓLNOTY PARAFIALNE' link.")
    @Story("Clicking the 'WSPÓLNOTY PARAFIALNE' link")
    public void parishCommunityLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"WSPÓLNOTY PARAFIALNE\" link");

        check(SideMenuSteps::clickTheParishCommunityLink, url, Message.getMessage(url));
    }

    @Test(priority = 11)
    @Parameters({"sacramentsPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the sacraments page opens after clicking on the 'SAKRAMENTY - INFORMACJE' link.")
    @Story("Clicking the 'SAKRAMENTY - INFORMACJE' link")
    public void sacramentsInfoLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"SAKRAMENTY - INFORMACJE\" link");

        check(SideMenuSteps::clickTheSacramentsLink, url, Message.getMessage(url));
    }

    @Test(priority = 12)
    @Parameters({"calvaryPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the calvary page opens after clicking on the 'KALWARIA PSZOWSKA' link.")
    @Story("Clicking the 'KALWARIA PSZOWSKA' link")
    public void calvaryLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"KALWARIA PSZOWSKA\" link");

        check(SideMenuSteps::clickTheCalvaryLink, url, Message.getMessage(url));
    }

    @Test(priority = 13)
    @Parameters({"photosPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the photo gallery page opens after clicking on the 'GALERIA ZDJĘĆ' link.")
    @Story("Clicking the 'GALERIA ZDJĘĆ' link")
    public void photoGalleryLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"GALERIA ZDJĘĆ\" link");

        check(SideMenuSteps::clickThePhotoGalleryLink, url, Message.getMessage(url));
    }

    @Test(priority = 18)
    @Parameters({"moviesPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the photo gallery page opens after clicking on the 'GALERIA FILMÓW' link.")
    @Story("Clicking the 'GALERIA FILMÓW' link")
    public void filmsLink(String url) throws InterruptedException {

        ExtentReportsManager.setTestName("Clicking the \"GALERIA FILMÓW\" link");

        check(SideMenuSteps::clickTheFilmsLink, url, Message.getMessage(url));
    }

    @Test(priority = 14)
    @Parameters({"eveningPageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the evening with Jesus page opens after clicking on the 'WIECZÓR Z JEZUSEM' link.")
    @Story("Clicking the 'WIECZÓR Z JEZUSEM' link")
    public void eveningWithJesusLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"WIECZÓR Z JEZUSEM\" link");

        check(SideMenuSteps::clickTheEveningWithJesusLink, url, Message.getMessage(url));
    }

    @Test(priority = 15)
    @Parameters("cemeteryPageURL")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the cemetery regulations page opens after clicking on the 'REGULAMIN CMENTARZA' link.")
    @Story("Clicking the 'REGULAMIN CMENTARZA' link")
    public void cemeteryRegulationsLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"REGULAMIN CMENTARZA\" link");

        check(SideMenuSteps::clickTheCemeteryRegulationsLink, url, Message.getMessage(url));
    }

    @Test(priority = 16)
    @Parameters({"delegatePageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the delegate page opens after clicking on the 'DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY' link.")
    @Story("Clicking the 'DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY' link")
    public void delegateLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY\" link");

        check(SideMenuSteps::clickTheDelegateLink, url, Message.getMessage(url));
    }

    @Test(priority = 17)
    @Parameters({"charitablePageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the parish charitable activities page opens after clicking on the 'DZIAŁALNOŚĆ CHARYTATYWNA PARAFII' link.")
    @Story("Clicking the 'DZIAŁALNOŚĆ CHARYTATYWNA PARAFII' link")
    public void parishCharitableActivitiesLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"DZIAŁALNOŚĆ CHARYTATYWNA PARAFII\" link");

        check(SideMenuSteps::clickTheParishCharitableActivitiesLink, url, Message.getMessage(url));
    }
}
