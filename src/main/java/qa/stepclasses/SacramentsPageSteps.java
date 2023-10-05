package qa.stepclasses;

import io.qameta.allure.Step;
import qa.pages.Sacraments;

public class SacramentsPageSteps {

    private final Sacraments sacraments;

    public SacramentsPageSteps(Sacraments sacraments) {

        this.sacraments = sacraments;
    }

    @Step("Click the 'Sakrament chrztu' link")
    public void clickTheSacramentOfBaptismLink() {

        sacraments.click("Sakrament chrztu");
    }

    @Step("Click the 'Eucharystia' link")
    public void clickTheEucharistLink() {

        sacraments.click("Eucharystia");
    }

    @Step("Click the 'Sakrament pokuty' link")
    public void clickTheSacramentOfPenanceLink() {

        sacraments.click("Sakrament pokuty");
    }

    @Step("Click the 'Sakrament bierzmowania' link")
    public void clickTheSacramentOfConfirmationLink() {

        sacraments.click("Sakrament bierzmowania");
    }

    @Step("Click the 'Sakrament małżeństwa' link")
    public void clickTheSacramentOfMarriageLink() {

        sacraments.click("Sakrament małżeństwa");
    }

    @Step("Click the 'Sakrament chorych' link")
    public void clickTheSacramentOfTheSickLink() {

        sacraments.click("Sakrament chorych");
    }
}
