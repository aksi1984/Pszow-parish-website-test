import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.Menu;
import qa.data.LinkData;
import qa.dataprovider.DataProviders;
import qa.enums.URLs;
import qa.stepclasses.MenuSteps;


@Epic("E2E")
@Feature("Side menu links tests")
public class SideMenuTest extends BaseTest {

    private MenuSteps menuSteps;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE.getName());

        menuSteps = new MenuSteps(new Menu(getPage()));
    }

    @Test(dataProvider = "sideMenu", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.CRITICAL)
    public void links(LinkData data) throws IllegalAccessException {

        Allure.description("Checking whether the page opens after clicking the '" + data.getLinkName() +  "' link.");
        Allure.story("Clicking the '" + data.getLinkName() + "' link");

        menuSteps.clickLink(data.getData());

        Assert.assertEquals(getPage().url(), data.getUrl(),
                "The page with address: " + data.getUrl() + " has not been opened");
    }
}
