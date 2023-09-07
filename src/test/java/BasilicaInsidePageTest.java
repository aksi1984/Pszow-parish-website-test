import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.pages.BasilicaInside;
import qa.stepclasses.BasilicaInsidePageSteps;
import qa.utils.ExtentReportsManager;
import qa.utils.JSONReader;
import qa.enums.SideMenuURLs;

import java.util.ArrayList;

@Epic("Smoke tests")
@Feature("'Wnętrze bazyliki' link test")
public class BasilicaInsidePageTest extends BaseTest {

    private BasilicaInsidePageSteps basilicaInsidePageSteps;
    private String[] expectedResults;
    @BeforeClass
    public void init() {

        basilicaInsidePageSteps = new BasilicaInsidePageSteps(new BasilicaInside(getDriver()));
        expectedResults = JSONReader.get("URLs", "presbytery");

        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.click(SideMenuURLs.BASILICA_INSIDE.ordinal());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the presbytery page opens after clicking on the 'Prezbiterium' link")
    @Story("Clicking the 'Prezbiterium link'")
    public void presbyteryLink() {

        ExtentReportsManager.setTestName("\"PREZBITERIUM\" link");

        basilicaInsidePageSteps.clickThePresbyteryLink();

        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabs.size() - 1));

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[0]);
    }


}
