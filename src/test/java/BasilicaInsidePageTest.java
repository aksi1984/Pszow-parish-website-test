import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.pages.BasilicaInside;
import qa.stepclasses.BasilicaInsidePageSteps;
import qa.utils.ExtentReportsManager;
import qa.utils.Message;

import java.util.ArrayList;

@Epic("Smoke tests")
@Feature("'Wnętrze bazyliki' link test")
public class BasilicaInsidePageTest extends BaseTest {

    private BasilicaInsidePageSteps basilicaInsidePageSteps;

    @BeforeMethod
    public void create() {

        basilicaInsidePageSteps = new BasilicaInsidePageSteps(new BasilicaInside(getDriver()));

        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.click("WNĘTRZE BAZYLIKI – PANORAMA");
    }

    @Test
    @Parameters({"basilicaInsidePageURL"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the presbytery page opens after clicking on the 'Prezbiterium' link")
    @Story("Clicking the 'Prezbiterium link'")
    public void presbyteryLink(String url) {

        ExtentReportsManager.setTestName("Clicking the \"PREZBITERIUM\" link");

        basilicaInsidePageSteps.clickThePresbyteryLink();

        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabs.size() - 1));

        Assert.assertEquals(getDriver().getCurrentUrl(), url, Message.getMessage(url));
    }


}
