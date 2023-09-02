import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MainMenu;
import qa.components.SearchEngine;
import qa.components.SearchResultPage;
import qa.utils.ExtentReportsManager;
import qa.utils.Provider;

import java.util.function.Consumer;

public class SearchEngineTest extends BaseTest {

    private SearchEngine searchEngine;
    private SearchResultPage searchResultPage;

    @BeforeClass
    public void init() {

        MainMenu mainMenu = new MainMenu(getDriver());
        searchEngine = new SearchEngine(getDriver());
        searchResultPage = new SearchResultPage(getDriver());

        mainMenu.click("KONTAKT");
    }

    @Test(priority = 1)
    public void clicking() {

        ExtentReportsManager.setTestName("Clicking on the search engine field");
        searchEngine.clickOnField();

        Assert.assertEquals(searchEngine.getFieldValue(), "");
    }

    private void check(String[] data, Consumer<Boolean> consumer) {

        for (String phrase : data) {

            searchEngine.setPhrase(phrase);
            boolean state = searchResultPage.isContainerPageContentPresent();
            back();
            consumer.accept(state);
        }
    }

    @Test(priority = 2, dataProvider = "correctPhrase", dataProviderClass = Provider.class)
    public void correctPhrase(String[] data) {

        ExtentReportsManager.setTestName("Searching with correct phrase");

        check(data, Assert::assertTrue);
    }

    @Test(priority = 3, dataProvider = "incorrectPhrase", dataProviderClass = Provider.class)
    public void incorrectPhrase(String[] data) {

        ExtentReportsManager.setTestName("Searching with incorrect phrase");

        check(data, Assert::assertFalse);
    }
}
