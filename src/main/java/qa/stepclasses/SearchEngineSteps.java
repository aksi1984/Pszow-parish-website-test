package qa.stepclasses;

import io.qameta.allure.Step;
import qa.components.SearchEngine;

public class SearchEngineSteps {

    private final SearchEngine searchEngine;

    public SearchEngineSteps(SearchEngine searchEngine) {

        this.searchEngine = searchEngine;
    }

    @Step("Enter a phrase")
    public void enterPhrase(String phrase) {

        searchEngine.setPhrase(phrase);
    }

    @Step("Press the 'Enter' key")
    public void pressTheEnterKey() throws IllegalAccessException {

        searchEngine.submit();
    }
}
