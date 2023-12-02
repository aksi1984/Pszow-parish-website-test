package qa.toby;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ToBy {

    private static final String FOUND_BY = "foundBy";
    private static final String LOCATOR = "locator";
    private static final String BY = "by";

    public static By get(WebElement element) throws IllegalAccessException {

        if (element instanceof Proxy proxy) {

            InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxy);
            Object locator = FieldUtils.readField(invocationHandler, LOCATOR, true);
            Object by = FieldUtils.readField(locator, BY, true);

            return FromString.get(by.toString());

        } else if (element instanceof RemoteWebElement remoteWebELement) {

            Object field = FieldUtils.readField(remoteWebELement, FOUND_BY, true);
            String[] split = field.toString().split("-> ");

            return FromString.get(split[1]);

        } else {

            return (By) FieldUtils.readField(element, BY, true);
        }
    }
}
