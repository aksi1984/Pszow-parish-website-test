import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MiddleMenu;
import qa.finalcalsses.MiddleMenuURLs;
import qa.utils.ExtentReportsManager;
import qa.utils.Function_1;
import qa.utils.JSONReader;
import java.util.ArrayList;

public class MiddleMenuTest extends BaseTest {

    private MiddleMenu middleMenu;

    private String[] expectedResults;

    @BeforeClass
    public void init() {

        middleMenu = new MiddleMenu(getDriver());
        expectedResults = JSONReader.get("URLs", "middleMenu");
    }

    private ArrayList<String> getTabs() {

        return new ArrayList<>(getDriver().getWindowHandles());
    }
    private void check(Function_1 function_1, Function_1 function_2, int index) throws InterruptedException {

        function_1.run();

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return document.readyState");

        getDriver().switchTo().window(getTabs().get(getTabs().size() - 1));
        String currentTitle = getDriver().getTitle();
        System.out.println(currentTitle);
        function_2.run();

        Assert.assertEquals(currentTitle, expectedResults[index]);
    }

    @Test(priority = 3)
    public void cameraLink() throws InterruptedException {

        ExtentReportsManager.setTestName("\"Zobacz kościół z perspektywy NOWEJ kamery online\" link");

        check(()->{middleMenu.clickCameraLink();}, ()->{ }, MiddleMenuURLs.CAMERA);
    }

    @Test(priority = 2)
    public void facebookLink() throws InterruptedException {

        ExtentReportsManager.setTestName("\"Zobacz nas na facebook'u!\"");

        check(()->{middleMenu.clickFacebookLink();},
              ()->{ getDriver().switchTo().window(getTabs().get(0)); },
                    MiddleMenuURLs.FACEBOOK);
    }

    @Test(priority = 1)
    public void archdioceseLink() throws InterruptedException {

        ExtentReportsManager.setTestName("\"Główna strona Archidiecezji Katowickiej\"");

        check(()->{middleMenu.clickArchdioceseLink();}, this::back, MiddleMenuURLs.ARCHDIOCESE);
    }
}
