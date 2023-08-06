import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MainMenu;
import qa.components.SearchEngine;
import qa.components.SearchResultPage;
import qa.utils.ExtentReportsManager;
import qa.utils.Function_2;
import qa.utils.Provider;

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

    private void check(String[] data, Function_2 function) {

        for (String phrase : data) {

            searchEngine.setPhrase(phrase);
            boolean state = searchResultPage.isContainerPageContentPresent();
            back();
            function.run(state);
        }
    }

    @Test(priority = 2, dataProvider = "correctPhrase", dataProviderClass = Provider.class)
    public void correctPhrase(String[] data) {

        ExtentReportsManager.setTestName("Searching with correct phrase");

        check(data, (a)->{Assert.assertTrue(a);});
    }

    @Test(priority = 3, dataProvider = "incorrectPhrase", dataProviderClass = Provider.class)
    public void incorrectPhrase(String[] data) {

        ExtentReportsManager.setTestName("Searching with incorrect phrase");

        check(data, (a)->{Assert.assertFalse(a);});
    }
}
