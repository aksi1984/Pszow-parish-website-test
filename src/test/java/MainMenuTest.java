import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import qa.base.BaseTest;
import org.testng.annotations.Test;
import qa.pageobject.Menu;
import qa.data.Link;
import qa.dataprovider.Provider;
import qa.enums.URLs;
import qa.stepclasses.MenuSteps;
import io.qameta.allure.*;

@Epic("Smoke tests")
@Feature("Main menu links tests")
public class MainMenuTest extends BaseTest {

    private static MenuSteps menuSteps;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE.getName());

        menuSteps = new MenuSteps(new Menu(getPage()));
    }

    @Test(dataProvider = "mainMenu", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the announcements page opens after clicking the main menu link.")
    @Story("Clicking the main menu link")
    public void links(Link link) throws IllegalAccessException {

        menuSteps.clickLink(link.getData());

        Assert.assertEquals(getPage().url(), link.getUrl(),
                "The page with address: " + link.getUrl() + " has not been opened");
    }
}
