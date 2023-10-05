package qa.utils;

import org.testng.annotations.DataProvider;
public class Provider {

    @DataProvider(name = "correctPhrase")
    public Object[] correctPhrase() {

        return JSONReader.get("searchEngine", "positive");
    }

    @DataProvider(name = "incorrectPhrase")
    public Object[] incorrectPhrase() {

        return  JSONReader.get("searchEngine", "negative");
    }
}
