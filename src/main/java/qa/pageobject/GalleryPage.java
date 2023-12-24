package qa.pageobject;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class GalleryPage extends BasePage {

    public GalleryPage(Page page) {

        super(page);
    }

    public void clickButton(String name) {

        getPage().getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(name)).click();
    }
}
