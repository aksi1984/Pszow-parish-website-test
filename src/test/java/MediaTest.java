import com.microsoft.playwright.Page;
import io.qameta.allure.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.pageobject.Media;
import qa.data.LinkData;
import qa.dataprovider.Provider;
import qa.enums.URLs;
import qa.stepclasses.MediaIconsSteps;


@Epic("E2E")
@Feature("Media icons tests")
public class MediaTest extends BaseTest {

    private MediaIconsSteps mediaIconsSteps;

    @BeforeMethod
    public void create() {

        goToPage(URLs.HOME_PAGE.getName());

        mediaIconsSteps = new MediaIconsSteps(new Media(getPage()));
    }

    private void check(LinkData data) {

        Page page = getPage().waitForPopup(() -> {
            mediaIconsSteps.clickIcon(data.getData());
        });

        Assert.assertTrue(page.url().contains(data.getUrl()));
    }

    @Test(dataProvider = "media", dataProviderClass = Provider.class)
    @Severity(SeverityLevel.CRITICAL)
    public void icon(LinkData data) {

        Allure.description("Checking whether the page opens after clicking on the '" + data.getLinkName() +  "' icon.");
        Allure.story("Clicking the '" + data.getLinkName() + "' icon");

        check(data);
    }
}
