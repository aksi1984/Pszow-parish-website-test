package qa.dataprovider;

import org.testng.annotations.DataProvider;
import qa.jsonreader.JSONReader;

public class DataProviders {

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

    @DataProvider(name = "GAL_alwaysExpanded")
    public Object[] GAL_alwaysExpanded() {

        return JSONReader.getGalleryButtonNames("alwaysExpanded");
    }

    @DataProvider(name = "GAL_alwaysClosed")
    public Object[] GAL_alwaysClosed() {

        return JSONReader.getGalleryButtonNames("alwaysClosed");
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
