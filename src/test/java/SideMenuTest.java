import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;

public class SideMenuTest extends BaseTest {

    private SideMenu sideMenu;

    @BeforeClass
    public void init() {

        sideMenu = new SideMenu(getDriver());
    }

    @Test
    public void newArchbishopLink() {

        sideMenu.clickNewArchbishopLink();
        back();
    }

    @Test
    public void parishStatisticsLink() {

        sideMenu.clickParishStatisticsLink();
        back();
    }

    @Test
    public void retransmissionLink() {

        sideMenu.clickRetransmissionLink();
        back();
    }

    @Test
    public void forgivenessReportLink() {

        sideMenu.clickForgivenessReportLink();
        back();
    }

    @Test
    public void plenaryIndulgenceLink() {

        sideMenu.clickPlenaryIndulgenceLink();
        back();
    }

    @Test
    public void litanyLink() {

        sideMenu.clickLitanyLink();
        back();
    }

    @Test
    public void parishHistoryLink() {

        sideMenu.clickParishHistoryLink();
        back();
    }

    @Test
    public void basilicaInsodeLink() {

        sideMenu.clickBasilicaInsideLink();
        back();
    }

    @Test
    public void parishCommunityLink() {

        sideMenu.clickParishCommunityLink();
        back();
    }

    @Test
    public void sacramentsInfoLink() {

        sideMenu.clickSacramentsInfoLink();
        back();
    }

    @Test
    public void pszowCalvaryLink() {

        sideMenu.clickPszowCalvaryLink();
        back();
    }

    @Test
    public void photoGalleryLink() {

        sideMenu.clickPhotoGalleryLink();
        back();
    }

    @Test
    public void filmsLink() {

        sideMenu.clickFilmsLink();
        back();
    }

    @Test
    public void eveningWithJesusLink() {

        sideMenu.clickEveningWithJesusLink();
        back();
    }

    @Test
    public void cemeteryRegulationsLink() {

        sideMenu.clickCemeteryRegulationsLink();
        back();
    }

    @Test
    public void delegateLink() {

        sideMenu.clickDelegateLink();
        back();
    }

    @Test
    public void parishCharitableActivitiesLink() {

        sideMenu.clickParishCharitableActivitiesLink();
        back();
    }
}
