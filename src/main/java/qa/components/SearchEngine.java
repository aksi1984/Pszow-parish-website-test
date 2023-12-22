package qa.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import qa.base.BasePage;

public class SearchEngine extends BasePage {

    private final Locator icon;
    private final Locator searchField;
    public SearchEngine(Page page) {

        super(page);

        icon = page.locator(".search-toggle-li");
        searchField = page.locator("#ocean-search-form-1");
    }

    public void clickIcon() {

        icon.click();
    }

    public void setPhrase(String phrase) {

        searchField.fill(phrase);
    }

    public void submit() {

        searchField.press("Enter");
    }

    public Locator getSearchField() {

        return searchField;
    }
}
