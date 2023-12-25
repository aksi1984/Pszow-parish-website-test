package qa.dataprovider;

import org.testng.annotations.DataProvider;
import qa.jsonreader.JSONReader;

public class Provider {

    @DataProvider(name = "mainMenu")
    public Object[] mainMenu() {

        return JSONReader.getLinksData("mainMenu");
    }

    @DataProvider(name = "sideMenu")
    public Object[] sideMenu() {

        return JSONReader.getLinksData("sideMenu");
    }

    @DataProvider(name = "media")
    public Object[] media() {

        return JSONReader.getLinksData("media");
    }

    @DataProvider(name = "GAL_photos")
    public Object[] GAL_photos() {

        return JSONReader.getGalleryButtonNames("photos");
    }

    @DataProvider(name = "correctPhrase")
    public Object[] correctPhrase() {

        return JSONReader.getPhrases("correct");
    }

    @DataProvider(name = "incorrectPhrase")
    public Object[] incorrectPhrase() {

        return  JSONReader.getPhrases("incorrect");
    }
}
