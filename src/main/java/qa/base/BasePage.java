package qa.base;

import com.microsoft.playwright.Page;

public class BasePage {

    private final Page page;

    protected BasePage(Page page) {

        this.page = page;
    }

    protected Page getPage() {

        return page;
    }
}
