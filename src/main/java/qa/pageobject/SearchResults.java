package qa.pageobject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class SearchResults extends BasePage {

    private final Locator content;

    public SearchResults(Page page) {

        super(page);

        content = page.locator("#content");
    }

    public String getTextContent() {

        return content.textContent().trim();
    }

}