package qa.stepclasses;

import io.qameta.allure.Step;
import qa.enums.ParishCommunityURLs;
import qa.pages.ParishCommunity;

public class ParishCommunityPageSteps {

    private final ParishCommunity parishCommunity;

    public ParishCommunityPageSteps(ParishCommunity parishCommunity) {

        this.parishCommunity = parishCommunity;
    }

    @Step("Click the image link")
    public void clickTheImage(ParishCommunityURLs parishCommunityURLs) {

        parishCommunity.click(parishCommunityURLs.ordinal());
    }
}
