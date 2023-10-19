package qa.utils;

public class Message {

    public static String getMessage(String url) {

        return "The page with the address \"" + url + "\" has not been opened";
    }

    public static String getMessage2(String title) {

        return "The page with the title \"" + title + "\" has not been opened";
    }
}
