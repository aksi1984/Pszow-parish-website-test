import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MainMenu;
import qa.components.SearchEngine;
import qa.components.SearchResultPage;
import qa.stepclasses.SearchEngineSteps;
import qa.utils.ExtentReportsManager;
import qa.utils.Provider;

import java.util.function.Consumer;


@Epic("Smoke tests")
@Feature("Search engine tests")
public class SearchEngineTest extends BaseTest {

    private SearchEngine searchEngine;
    private SearchResultPage searchResultPage;
    private SearchEngineSteps searchEngineSteps;

    @BeforeClass
    public void init() {

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

        Assert.assertEquals(searchEngine.getFieldValue(), "");
    }

    private void check(String[] data, Consumer<Boolean> consumer) {

        for (String phrase : data) {

            searchEngineSteps.enterPhrase(phrase);
            searchEngineSteps.pressTheEnterKey();

            boolean state = searchResultPage.isContainerPageContentPresent();
            back();
            consumer.accept(state);
        }
    }

    @Test(priority = 2, dataProvider = "correctPhrase", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: testing whether articles will be found after searching with with a correct phrase")
    @Epic("Searching with a correct phrase")
    public void correctPhrase(String[] data) {

        ExtentReportsManager.setTestName("Searching with correct phrase");

        check(data, Assert::assertTrue);
    }

    @Test(priority = 3, dataProvider = "incorrectPhrase", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: testing whether articles will be found after searching with with an incorrect phrase")
    @Epic("Searching with an incorrect phrase")
    public void incorrectPhrase(String[] data) {

        ExtentReportsManager.setTestName("Searching with incorrect phrase");

        check(data, Assert::assertFalse);
    }
}
