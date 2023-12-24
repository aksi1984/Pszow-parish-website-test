package qa.playwright;

import org.reflections.Reflections;
import qa.enums.BrowserType;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class PlaywrightProvider {

    public static PlaywrightBrowserLauncher getFactory(BrowserType browserType) {

        String packages = PlaywrightBrowserLauncher.class.getPackage().getName();
        Reflections reflections = new Reflections(packages);

        Set<Class<? extends PlaywrightBrowserLauncher>> factories = reflections.getSubTypesOf(PlaywrightBrowserLauncher.class);

        Class<? extends PlaywrightBrowserLauncher> inherited = factories
                .stream()
                .filter(i -> i.getName().toLowerCase().contains(browserType.getName().toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Could not find factory with name: " + browserType.getName()));

        String inheritedClassName = inherited.getName();

        try {

            return (PlaywrightBrowserLauncher) Class.forName(inheritedClassName).getConstructor().newInstance();

        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                 IllegalAccessException | NoSuchMethodException e) {

            throw new IllegalStateException(e);
        }
    }
}
