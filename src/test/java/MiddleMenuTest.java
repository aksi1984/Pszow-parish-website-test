import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MiddleMenu;
import qa.enums.MiddleMenuURLs;
import qa.stepclasses.MiddleMenuSteps;
import qa.utils.ExtentReportsManager;
import qa.utils.Function;
import qa.utils.JSONReader;
import java.util.function.Consumer;

@Epic("Smoke tests")
@Feature("Middle menu links test")
public class MiddleMenuTest extends BaseTest {
    private MiddleMenuSteps middleMenuSteps;
    private String[] expectedResults;

    @BeforeClass
    public void init() {

        middleMenuSteps = new MiddleMenuSteps(new MiddleMenu(getDriver()));
        expectedResults = JSONReader.get("URLs", "middleMenu");
    }

    private void check(Consumer<MiddleMenuSteps> function1, Function function2, MiddleMenuURLs index) {

        function1.accept(middleMenuSteps);

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return document.readyState");

        getDriver().switchTo().window(getTabs().get(getTabs().size() - 1));
        String currentTitle = getDriver().getTitle();
        function2.accept();

        Assert.assertEquals(currentTitle, expectedResults[index.ordinal()]);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the camera page opens after clicking on the 'Camera' link.")
    @Story("Clicking the 'Camera' link")
    public void cameraLink() {

        //ExtentReportsManager.setTestName("\"Zobacz kościół z perspektywy NOWEJ kamery online\" link");

        check(MiddleMenuSteps::clickCameraLink, ()->{ }, MiddleMenuURLs.CAMERA);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the Facebook page opens after clicking on the 'Facebook' link.")
    @Story("Clicking the 'Facebook' link")
    public void facebookLink() {

        //ExtentReportsManager.setTestName("\"Zobacz nas na facebook'u!\"");

        check(MiddleMenuSteps::clickFacebookLink, ()->{getDriver().switchTo().window(getTabs().get(0));}, MiddleMenuURLs.FACEBOOK);
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the archdiocese page opens after clicking on the 'Archdiocese' link.")
    @Story("Clicking the 'Archdiocese' link")
    public void archdioceseLink() {

        //ExtentReportsManager.setTestName("\"Główna strona Archidiecezji Katowickiej\"");

        check(MiddleMenuSteps::clickArchdioceseLink, this::back, MiddleMenuURLs.ARCHDIOCESE);
    }
}
