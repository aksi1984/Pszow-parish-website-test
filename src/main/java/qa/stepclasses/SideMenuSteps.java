package qa.stepclasses;

import io.qameta.allure.Step;
import qa.components.SideMenu;
import qa.enums.SideMenuURLs;

public class SideMenuSteps {

    private final SideMenu sideMenu;

    public SideMenuSteps(SideMenu sideMenu) {

        this.sideMenu = sideMenu;
    }

    @Step("Click the 'ZAPROSZENIE KS. ABPA ADRIANA GALBASA NA PIELGRZYMKĘ DO PSZOWA' link")
    public void clickTheArchbishopInvitationLink() {

        sideMenu.click(SideMenuURLs.ARCHBISHOP_INVITATION.ordinal());
    }

    @Step("Click the 'JUBILEUSZOWY ODPUST – 10 WRZEŚNIA 2023' link")
    public void clickTheJubileeIndulgenceLink() {

        sideMenu.click(SideMenuURLs.JUBILEE_INDULGENCE.ordinal());
    }

    @Step("Click the 'ODPUST ZUPEŁNY W CZASIE JUBILEUSZU W PSZOWIE' link")
    public void clickThePlenaryIndulgenceLink() {

        sideMenu.click(SideMenuURLs.PLENARY_INDULGENCE.ordinal());
    }

    @Step("Click the 'LITANIA DO PANI UŚMIECHNIĘTEJ' link")
    public void clickTheLitanyLink() {

        sideMenu.click(SideMenuURLs.LITANY.ordinal());
    }

    @Step("Click the 'HISTORIA PARAFII' link")
    public void clickTheParishHistoryLink() {

        sideMenu.click(SideMenuURLs.PARISH_HISTORY.ordinal());
    }

    @Step("Click the 'PARAFIA WCZORAJ I DZIŚ' link")
    public void clickTheParishYesterdayAndNowLink() {

        sideMenu.click(SideMenuURLs.YESTERDAY_AND_NOW.ordinal());
    }

    @Step("Click the 'WNĘTRZE BAZYLIKI – PANORAMA' link")
    public void clickTheBasilicaInsideLink() {

        sideMenu.click(SideMenuURLs.BASILICA_INSIDE.ordinal());
    }

    @Step("Click the 'WSPÓLNOTY PARAFIALNE' link")
    public void clickTheParishCommunityLink() {

        sideMenu.click(SideMenuURLs.PARISH_COMMUNITY.ordinal());
    }

    @Step("Click the 'SAKRAMENTY – INFORMACJE' link")
    public void clickTheSacramentsLink() {

        sideMenu.click(SideMenuURLs.SACRAMENTS.ordinal());
    }

    @Step("Click the 'KALWARIA PSZOWSKA' link")
    public void clickTheCalvaryLink() {

        sideMenu.click(SideMenuURLs.CALVARY.ordinal());
    }

    @Step("Click the 'GALERIA ZDJĘĆ' link")
    public void clickThePhotoGalleryLink() {

        sideMenu.click(SideMenuURLs.PHOTO_GALLERY.ordinal());
    }

    @Step("Click the 'GALERIA FILMÓW' link")
    public void clickTheFilmsLink() {

        sideMenu.click(SideMenuURLs.FILMS.ordinal());
    }

    @Step("Click the 'WIECZÓR Z JEZUSEM' link")
    public void clickTheEveningWithJesusLink() {

        sideMenu.click(SideMenuURLs.EVENING_WITH_JESUS.ordinal());
    }

    @Step("Click the 'REGULAMIN CMENTARZA' link")
    public void clickTheCemeteryRegulationsLink() {

        sideMenu.click(SideMenuURLs.CEMENTERY_REGULATIONS.ordinal());
    }

    @Step("Click the 'DELEGAT DS. OCHRONY DZIECI I MŁODZIEŻY' link")
    public void clickTheDelegateLink() {

        sideMenu.click(SideMenuURLs.DELEGATE.ordinal());
    }

    @Step("Click the 'DZIAŁALNOŚĆ CHARYTATYWNA PARAFII' link")
    public void clickTheParishCharitableActivitiesLink() {

        sideMenu.click(SideMenuURLs.PARISH_CHARITABLE_ACTIVITIES.ordinal());
    }
}
