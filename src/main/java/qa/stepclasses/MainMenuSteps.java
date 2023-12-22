package qa.stepclasses;

import io.qameta.allure.Step;
import qa.components.MainMenu;

public class MainMenuSteps {

    private final MainMenu mainMenu;

    public MainMenuSteps(MainMenu mainMenu) {

        this.mainMenu = mainMenu;
    }

    @Step("Click the link")
    public void clickLink(String linkText) throws IllegalAccessException {

        mainMenu.click(linkText);
    }
}
