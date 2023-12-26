import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.dataprovider.DataProviders;
import qa.enums.URLs;
import qa.pageobject.GalleryPage;
import qa.stepclasses.GalleryPageSteps;


@Epic("E2E")
@Feature("Photo gallery page buttons tests")
public class PhotoGalleryPageTest extends BaseTest {

    private GalleryPageSteps galleryPageSteps;

    @BeforeMethod
    public void create() {

        goToPage(URLs.PHOTO_GALLERY.getName());

        galleryPageSteps = new GalleryPageSteps(new GalleryPage(getPage()));
    }

    @Test(dataProvider = "GAL_alwaysExpanded", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether the photo gallery of  is always expanded")
    @Story("")
    public void alwaysExpanded(String name) {

        Allure.description("Checking whether the photo gallery of " + name + " year is always expanded");
        Allure.story("Checking the gallery of " + name + " year");

        Locator region = getPage().getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName(name));
        Assert.assertTrue(region.isVisible());
    }

    @Test(dataProvider = "GAL_alwaysClosed", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.NORMAL)
    public void alwaysClosed(String name) {

        Allure.description("Checking whether the photo gallery list will be expanded after clicking the '" + name + "' button");
        Allure.story("Clicking the '" + name + "' button");

        Locator region = getPage().getByRole(AriaRole.REGION, new Page.GetByRoleOptions().setName(name));
        Assert.assertFalse(region.isVisible());

        galleryPageSteps.clickButton(name);
        Assert.assertTrue(region.isVisible());
    }
}
