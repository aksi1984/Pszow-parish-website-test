package qa.stepclasses;

import io.qameta.allure.Step;
import qa.pages.BasilicaInside;

public class BasilicaInsidePageSteps {

    private BasilicaInside basilicaInside;

    public BasilicaInsidePageSteps(BasilicaInside basilicaInside) {

        this.basilicaInside = basilicaInside;
    }

    @Step("Click the 'Prezbiterium' link")
    public void clickThePresbyteryLink() throws IllegalAccessException {

        basilicaInside.clickPresbyteryLink();
    }
}
