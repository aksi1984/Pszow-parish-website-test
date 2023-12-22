import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.Menu;
import qa.data.Link;
import qa.dataprovider.Provider;
import qa.stepclasses.MenuSteps;


@Epic("Smoke tests")
@Feature("Side menu links tests")
public class SideMenuTest extends BaseTest {

    private MenuSteps menuSteps;

    @BeforeMethod
    public void create() {

        menuSteps = new MenuSteps(new Menu(getPage()));
    }

    @Test(dataProvider = "sideMenu", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if page opens after clicking on the side menu link.")
    @Story("Clicking the side menu link")
    public void links(Link link) throws IllegalAccessException {

        menuSteps.clickLink(link.getData());

        Assert.assertEquals(getPage().url(), link.getUrl(),
                "The page with address: " + link.getUrl() + " has not been opened");
    }
}
