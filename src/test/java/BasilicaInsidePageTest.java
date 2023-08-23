import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.SideMenu;
import qa.pages.BasilicaInside;
import qa.utils.ExtentReportsManager;
import qa.utils.JSONReader;
import qa.enums.SideMenuURLs;

import java.util.ArrayList;

public class BasilicaInsidePageTest extends BaseTest {

    private BasilicaInside basilicaInside;
    private String[] expectedResults;
    @BeforeClass
    public void init() {

        basilicaInside = new BasilicaInside(getDriver());
        expectedResults = JSONReader.get("URLs", "presbytery");

        SideMenu sideMenu = new SideMenu(getDriver());
        sideMenu.click(SideMenuURLs.BASILICA_INSIDE.ordinal());
    }

    @Test
    public void presbyteryLink() {

        ExtentReportsManager.setTestName("\"PREZBITERIUM\" link");

        basilicaInside.clickPresbyteryLink();

        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabs.size() - 1));

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResults[0]);
    }


}
