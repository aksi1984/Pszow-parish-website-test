package qa.utils;

import org.testng.annotations.DataProvider;
public class Provider {

    @DataProvider(name = "correctPhrase")
    public Object[] correctPhrase() {

        String[] data = JSONReader.get("searchEngine", "positive");

        return new  Object[] {data};
    }

    @DataProvider(name = "incorrectPhrase")
    public Object[] incorrectPhrase() {

        String[] data = JSONReader.get("searchEngine", "negative");

        return new Object[] {data};
    }
}
