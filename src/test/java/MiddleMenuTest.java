import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MiddleMenu;
import qa.enums.MiddleMenuURLs;
import qa.utils.ExtentReportsManager;
import qa.utils.Function;
import qa.utils.JSONReader;
import java.util.function.Consumer;

public class MiddleMenuTest extends BaseTest {

    private MiddleMenu middleMenu;

    private String[] expectedResults;

    @BeforeClass
    public void init() {

        middleMenu = new MiddleMenu(getDriver());
        expectedResults = JSONReader.get("URLs", "middleMenu");
    }

    private void check(Consumer<MiddleMenu> function1, Function function2, MiddleMenuURLs index) {

        function1.accept(middleMenu);

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return document.readyState");

        getDriver().switchTo().window(getTabs().get(getTabs().size() - 1));
        String currentTitle = getDriver().getTitle();
        function2.accept();

        Assert.assertEquals(currentTitle, expectedResults[index.ordinal()]);
    }

    @Test(priority = 3)
    public void cameraLink() {

        ExtentReportsManager.setTestName("\"Zobacz kościół z perspektywy NOWEJ kamery online\" link");

        check(MiddleMenu::clickCameraLink, ()->{ }, MiddleMenuURLs.CAMERA);
    }

    @Test(priority = 2)
    public void facebookLink() {

        ExtentReportsManager.setTestName("\"Zobacz nas na facebook'u!\"");

        check(MiddleMenu::clickFacebookLink, ()->{getDriver().switchTo().window(getTabs().get(0));}, MiddleMenuURLs.FACEBOOK);
    }

    @Test(priority = 1)
    public void archdioceseLink() {

        ExtentReportsManager.setTestName("\"Główna strona Archidiecezji Katowickiej\"");

        check(MiddleMenu::clickArchdioceseLink, this::back, MiddleMenuURLs.ARCHDIOCESE);
    }
}
