import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MiddleMenu;
import qa.stepclasses.MiddleMenuSteps;
import java.util.function.Consumer;

@Epic("Smoke tests")
@Feature("Middle menu links test")
public class MiddleMenuTest extends BaseTest {
    private MiddleMenuSteps middleMenuSteps;

    @BeforeMethod
    public void create() {

        middleMenuSteps = new MiddleMenuSteps(new MiddleMenu(getDriver()));
    }

    private void check(Consumer<MiddleMenuSteps> consumer, String expectedTitle) {

        consumer.accept(middleMenuSteps);

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return document.readyState");

        getDriver().switchTo().window(getTabs().get(getTabs().size() - 1));

        Assert.assertEquals(getDriver().getTitle(), expectedTitle);
    }

    @Test(priority = 3)
    @Parameters({"youtubeTitle"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the camera page opens after clicking on the 'Camera' link.")
    @Story("Clicking the 'Camera' link")
    public void cameraLink(String title) {

        //ExtentReportsManager.setTestName("\"Zobacz kościół z perspektywy NOWEJ kamery online\" link");

        check(MiddleMenuSteps::clickCameraLink, title);
    }

    @Test(priority = 2)
    @Parameters({"facebookTitle"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the Facebook page opens after clicking on the 'Facebook' link.")
    @Story("Clicking the 'Facebook' link")
    public void facebookLink(String title) {

        //ExtentReportsManager.setTestName("\"Zobacz nas na facebook'u!\"");

        check(MiddleMenuSteps::clickFacebookLink, title);
    }

    @Test(priority = 1)
    @Parameters("archdioceseTitle")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the archdiocese page opens after clicking on the 'Archdiocese' link.")
    @Story("Clicking the 'Archdiocese' link")
    public void archdioceseLink(String title) {

        //ExtentReportsManager.setTestName("\"Główna strona Archidiecezji Katowickiej\"");

        middleMenuSteps.clickArchdioceseLink();
        Assert.assertEquals(getDriver().getTitle(), title);
    }
}
