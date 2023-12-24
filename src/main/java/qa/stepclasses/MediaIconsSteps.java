package qa.stepclasses;

import io.qameta.allure.Step;
import qa.pageobject.Media;

public class MediaIconsSteps {

    private final Media media;

    public MediaIconsSteps(Media media) {

        this.media = media;
    }

    @Step("Click icon")
    public void clickIcon(String text) {

        media.clickIcon(text);
    }
}