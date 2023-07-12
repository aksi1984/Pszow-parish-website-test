import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MainMenu;
import qa.components.SearchEngine;
import qa.components.SearchResultPage;

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

        String phrase = "KANCELARIA";

        searchEngine.clickOnField();
        searchEngine.setPhrase(phrase);

        Assert.assertEquals(searchEngine.getFieldValue(), phrase);
    }

    @Test(priority = 2)
    public void correctPhrase() {

        searchEngine.setPhrase("Kancelaria");

        Assert.assertTrue(searchResultPage.isContainerPageContentPresent());
    }

    @Test(priority = 3)
    public void incorrectPhrase() {

        searchEngine.setPhrase("bbbbbb");

        Assert.assertFalse(searchResultPage.isContainerPageContentPresent());
    }
}
