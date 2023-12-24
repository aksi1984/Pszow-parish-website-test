package qa.stepclasses;

import io.qameta.allure.Step;
import qa.pageobject.Menu;

public class MenuSteps {

    private final Menu menu;

    public MenuSteps(Menu menu) {

        this.menu = menu;
    }

    @Step("Click the link")
    public void clickLink(String linkText) throws IllegalAccessException {

        menu.click(linkText);
    }
}
