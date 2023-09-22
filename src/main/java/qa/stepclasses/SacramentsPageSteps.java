package qa.stepclasses;

import io.qameta.allure.Step;
import qa.enums.SacramentsPageURLs;
import qa.pages.Sacraments;

public class SacramentsPageSteps {

    private final Sacraments sacraments;

    public SacramentsPageSteps(Sacraments sacraments) {

        this.sacraments = sacraments;
    }

    @Step("Click the 'Sakrament chrztu' link")
    public void clickTheSacramentOfBaptismLink() {

        sacraments.click(SacramentsPageURLs.SACRAMENT_OF_BAPTISM.ordinal());
    }

    @Step("Click the 'Eucharystia' link")
    public void clickTheEucharistLink() {

        sacraments.click(SacramentsPageURLs.EUCHARIST.ordinal());
    }

    @Step("Click the 'Sakrament pokuty' link")
    public void clickTheSacramentOfPenanceLink() {

        sacraments.click(SacramentsPageURLs.SACRAMENT_OF_PENANCE.ordinal());
    }

    @Step("Click the 'Sakrament bierzmowania' link")
    public void clickTheSacramentOfConfirmationLink() {

        sacraments.click(SacramentsPageURLs.CONFIRMATION.ordinal());
    }

    @Step("Click the 'Sakrament małżeństwa' link")
    public void clickTheSacramentOfMarriageLink() {

        sacraments.click(SacramentsPageURLs.SACRAMENT_OF_MARRIAGE.ordinal());
    }

    @Step("Click the 'Sakrament chorych' link")
    public void clickTheSacramentOfTheSickLink() {

        sacraments.click(SacramentsPageURLs.SACRAMENT_OF_THE_SICK.ordinal());
    }
}
