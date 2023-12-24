package qa.pageobject;

import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class Menu extends BasePage {

    public Menu(Page page) {

        super(page);
    }

    public void click(String id) throws IllegalAccessException {

        getPage().locator("#" + id).click();
    }
}
