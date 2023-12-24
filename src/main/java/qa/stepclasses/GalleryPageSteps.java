package qa.stepclasses;

import io.qameta.allure.Step;
import qa.pageobject.GalleryPage;


public class GalleryPageSteps {
    private final GalleryPage galleryPage;

    public GalleryPageSteps(GalleryPage galleryPage) {

        this.galleryPage = galleryPage;
    }

    @Step("Click the button")
    public void clickButton(String name) {

        galleryPage.clickButton(name);
    }

    public GalleryPage getGalleryPage() {

        return galleryPage;
    }
}
