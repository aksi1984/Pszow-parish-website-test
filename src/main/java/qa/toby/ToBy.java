package qa.toby;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.lang.reflect.Proxy;

public class ToBy {

    private static String FOUND_BY = "foundBy";

    public static void get(WebElement element) throws IllegalAccessException {

        if (element instanceof Proxy proxy) {
            
            System.out.println("PROXY");

        } else if (element instanceof RemoteWebElement remoteWebELement) {

            Object field = FieldUtils.readField(remoteWebELement, FOUND_BY, true);
            String[] split = field.toString().split("-> ");


        } else {

            System.out.println("OTHER");
        }
    }
}
