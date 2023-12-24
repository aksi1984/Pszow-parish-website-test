import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.SearchEngine;
import qa.pageobject.SearchResults;
import qa.data.Phrase;
import qa.dataprovider.Provider;
import qa.enums.URLs;
import qa.stepclasses.SearchEngineSteps;


@Epic("Smoke tests")
@Feature("Search engine tests")
public class SearchEngineTest extends BaseTest {

    private SearchEngineSteps searchEngineSteps;
    private SearchResults searchResults;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE.getName());

        searchEngineSteps = new SearchEngineSteps(new SearchEngine(getPage()));
        searchResults = new SearchResults(getPage());
    }

    private void fill(String phrase) {

        searchEngineSteps.clickIcon();
        searchEngineSteps.enterPhrase(phrase);
        searchEngineSteps.pressTheEnterKey();
    }
    private int getNumberOfArticles() {

        return getPage().querySelectorAll("[id^='post-']").size();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: testing whether the search field will be visible after clicking the search engine icon")
    @Epic("Checking the search field visibility")
    public void searchFieldVisibility() {

        searchEngineSteps.clickIcon();

        Assert.assertTrue(searchEngineSteps.getSearchEngine().getSearchField().isVisible());
    }

    @Test(priority = 2, dataProvider = "correctPhrase", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: testing whether articles will be found after searching with with a correct phrase")
    @Epic("Searching with a correct phrase")
    public void correctPhrase(Phrase phrase) {

        fill(phrase.getPhrase());

        Assert.assertTrue(getNumberOfArticles() > 0);
        Assert.assertNotEquals(searchResults.getTextContent(), phrase.getMessage());
    }

    @Test(priority = 3, dataProvider = "incorrectPhrase", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: testing whether articles will be found after searching with with an incorrect phrase")
    @Epic("Searching with an incorrect phrase")
    public void incorrectPhrase(Phrase phrase) {

        fill(phrase.getPhrase());

        Assert.assertFalse(getNumberOfArticles() > 0);
        Assert.assertEquals(searchResults.getTextContent(), phrase.getMessage());
    }
}