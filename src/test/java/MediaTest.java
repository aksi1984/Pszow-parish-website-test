import com.microsoft.playwright.Page;
import io.qameta.allure.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.Media;
import qa.data.Link;
import qa.dataprovider.Provider;
import qa.enums.URLs;
import qa.stepclasses.MediaIconsSteps;


@Epic("Smoke tests")
@Feature("Middle menu links test")
public class MediaTest extends BaseTest {

    private MediaIconsSteps mediaIconsSteps;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE.getName());

        mediaIconsSteps = new MediaIconsSteps(new Media(getPage()));
    }

    private void check(Link link) {

        Page page = getPage().waitForPopup(() -> {
            mediaIconsSteps.clickIcon(link.getData());
        });

        Assert.assertTrue(page.url().contains(link.getUrl()));
    }

    @Test(dataProvider = "media", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the page opens after clicking on the media icon.")
    @Story("Clicking the media icon")
    public void icon(Link link) {

        check(link);
    }
}
