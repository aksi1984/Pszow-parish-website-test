package qa.driver;

import org.reflections.Reflections;
import qa.enums.Browser;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class WebDriverProvider {

    public static WebDriverFactory getFactory(Browser browser) {

        String packages = WebDriverFactory.class.getPackage().getName();
        Reflections reflections = new Reflections(packages);

        Set<Class<? extends WebDriverFactory>> factories = reflections.getSubTypesOf(WebDriverFactory.class);

        Class<? extends WebDriverFactory> inherited = factories
                .stream()
                .filter(i -> i.getName().toLowerCase().contains(browser.getName().toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Could not find factory with name: " + browser.getName()));

        String inheritedClassName = inherited.getName();

        try {

            return (WebDriverFactory) Class.forName(inheritedClassName).getConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }
}
