import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.MiddleMenu;
import qa.stepclasses.MiddleMenuSteps;
import qa.extentreports.ExtentReportsManager;
import qa.utils.Message;
import qa.utils.MyConsumer;


@Epic("Smoke tests")
@Feature("Middle menu links test")
public class MiddleMenuTest extends BaseTest {
    private MiddleMenuSteps middleMenuSteps;

    @BeforeMethod
    public void create() {

        middleMenuSteps = new MiddleMenuSteps(new MiddleMenu(getDriver()));
    }

    private void check(MyConsumer<MiddleMenuSteps> consumer, String expectedTitle, String assertMessage) throws IllegalAccessException {

        consumer.accept(middleMenuSteps);

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return document.readyState");

        getDriver().switchTo().window(getTabs().get(getTabs().size() - 1));

        Assert.assertEquals(getDriver().getTitle(), expectedTitle, assertMessage);
    }

    @Test(priority = 3)
    @Parameters({"youtubeTitle"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the camera page opens after clicking on the 'Camera' link.")
    @Story("Clicking 'Camera'")
    public void cameraLink(String title) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking \"Zobacz kościół z perspektywy NOWEJ kamery online\"");

        check(MiddleMenuSteps::clickCameraLink, title, Message.getMessage2(title));
    }

    @Test(priority = 2)
    @Parameters({"facebookTitle"})
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the Facebook page opens after clicking on the 'Facebook' link.")
    @Story("Clicking 'Facebook'")
    public void facebookLink(String title) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking \"Zobacz nas na facebook'u!\"");

        check(MiddleMenuSteps::clickFacebookLink, title, Message.getMessage2(title));
    }

    @Test(priority = 1)
    @Parameters("archdioceseTitle")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test description: checking if the archdiocese page opens after clicking on the 'Archdiocese' link.")
    @Story("Clicking 'Archdiocese'")
    public void archdioceseLink(String title) throws IllegalAccessException {

        ExtentReportsManager.setTestName("Clicking \"Główna strona Archidiecezji Katowickiej\"");

        middleMenuSteps.clickArchdioceseLink();
        Assert.assertEquals(getDriver().getTitle(), title, Message.getMessage2(title));
    }
}
