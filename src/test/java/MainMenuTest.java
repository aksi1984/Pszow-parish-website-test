import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import qa.base.BaseTest;
import qa.components.MainMenu;
import org.testng.annotations.Test;
import qa.data.Link;
import qa.dataprovider.Provider;
import qa.stepclasses.MainMenuSteps;
import io.qameta.allure.*;

@Epic("Smoke tests")
@Feature("Main menu links tests")
public class MainMenuTest extends BaseTest {

    private static MainMenuSteps mainMenuSteps;

    @BeforeMethod
    public void create() {

        MainMenu mainMenu = new MainMenu(getDriver());
        mainMenuSteps = new MainMenuSteps(mainMenu);
    }

    @Test(dataProvider = "mainMenu", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the announcements page opens after clicking the main menu link.")
    @Story("Clicking the main menu link")
    public void links(Link link) throws IllegalAccessException {

        mainMenuSteps.clickLink(link.getData());

        Assert.assertEquals(getDriver().getCurrentUrl(), link.getUrl(),
                "The page with address: " + link.getUrl() + " has not been opened");
    }
}
