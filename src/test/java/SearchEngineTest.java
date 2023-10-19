import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MainMenu;
import qa.components.SearchEngine;
import qa.components.SearchResultPage;
import qa.stepclasses.SearchEngineSteps;
import qa.utils.Provider;
import java.util.function.Consumer;
import qa.utils.ExtentReportsManager;

@Epic("Smoke tests")
@Feature("Search engine tests")
public class SearchEngineTest extends BaseTest {

    private SearchEngine searchEngine;
    private SearchResultPage searchResultPage;
    private SearchEngineSteps searchEngineSteps;

    @BeforeMethod
    public void create() {

        MainMenu mainMenu = new MainMenu(getDriver());
        searchEngine = new SearchEngine(getDriver());
        searchResultPage = new SearchResultPage(getDriver());
        searchEngineSteps = new SearchEngineSteps(searchEngine);

        mainMenu.click("KONTAKT");
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Testing whether the placeholder disappears when the field is clicked")
    @Story("Clicking on the search engine field")
    public void clickingOnField() {

        ExtentReportsManager.setTestName("Clicking on the search engine field");

        searchEngine.clickOnField();

        Assert.assertEquals(searchEngine.getFieldValue(), "", "Placeholder does not disappear when clicking the search box");
    }

    private void check(String phrase, Consumer<SearchResultPage> consumer) {

        searchEngineSteps.enterPhrase(phrase);
        searchEngineSteps.pressTheEnterKey();

        consumer.accept(searchResultPage);
    }

    @Test(priority = 2, dataProvider = "correctPhrase", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: testing whether articles will be found after searching with with a correct phrase")
    @Epic("Searching with a correct phrase")
    public void correctPhrase(String phrase) {

        ExtentReportsManager.setTestName("Searching results with \"" + phrase + "\" as a correct phrase");

        check(phrase, (SearchResultPage srp)->{  Assert.assertTrue(srp.isContainerPageContentPresent(), "No results after entering the correct phrase: \"" + phrase + "\""); });
    }

    @Test(priority = 3, dataProvider = "incorrectPhrase", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: testing whether articles will be found after searching with with an incorrect phrase")
    @Epic("Searching with an incorrect phrase")
    public void incorrectPhrase(String phrase) {

        ExtentReportsManager.setTestName("Searching results with \"" + phrase + "\" as an incorrect phrase");

        check(phrase, (SearchResultPage srp)->{ Assert.assertFalse(srp.isContainerPageContentPresent(), "Results found after entering the incorrect phrase: \"" + phrase + "\""); });
    }
}
