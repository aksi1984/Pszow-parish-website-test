package qa.stepclasses;

import io.qameta.allure.Step;
import qa.pageobject.SearchEngine;

public class SearchEngineSteps {

    private final SearchEngine searchEngine;

    public SearchEngineSteps(SearchEngine searchEngine) {

        this.searchEngine = searchEngine;
    }

    @Step("Click the icon")
    public void clickIcon() {

        searchEngine.clickIcon();
    }

    @Step("Enter a phrase")
    public void enterPhrase(String phrase) {

        searchEngine.setPhrase(phrase);
    }

    @Step("Press the 'Enter' key")
    public void pressTheEnterKey() {

        searchEngine.submit();
    }

    public SearchEngine getSearchEngine() {

        return searchEngine;
    }
}
