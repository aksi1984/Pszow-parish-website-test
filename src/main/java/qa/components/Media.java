package qa.components;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import qa.base.BasePage;

public class Media extends BasePage {

    public Media(Page page) {

        super(page);
    }

    public void clickIcon(String text) {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(text)).click();
    }
}
