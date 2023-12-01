package qa.stepclasses;

import io.qameta.allure.Step;
import qa.components.MiddleMenu;

public class MiddleMenuSteps {

    private MiddleMenu middleMenu;

    public MiddleMenuSteps(MiddleMenu middleMenu) {

        this.middleMenu = middleMenu;
    }

    @Step("Click the camera link")
    public void clickCameraLink() throws IllegalAccessException {

        middleMenu.clickCameraLink();
    }

    @Step("Click the facebook link")
    public void clickFacebookLink() throws IllegalAccessException {

        middleMenu.clickFacebookLink();
    }

    @Step("Click the archdiocese link")
    public void clickArchdioceseLink() throws IllegalAccessException {

        middleMenu.clickArchdioceseLink();
    }
}
