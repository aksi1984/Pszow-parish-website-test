package qa.listeners;

import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.extentreports.ExtentReportsManager;

public class Listener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {

        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {

        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {

        ExtentReportsManager.create(iTestContext.getSuite().getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        ExtentReportsManager.setTestEnvironment();
        ExtentReportsManager.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {


    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        ExtentReportsManager.setTestPassed("Test passed on method " + iTestResult.getMethod().getMethodName());

        saveTextLog(getTestMethodName(iTestResult) + "- passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        ExtentReportsManager.setTestFailed(iTestResult.getThrowable().getMessage());

        saveTextLog(getTestMethodName(iTestResult) + "- failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        ExtentReportsManager.setTestSkipped("Test skipped on method " + iTestResult.getMethod().getMethodName());

        saveTextLog(getTestMethodName(iTestResult) + "- skipped");
    }
}
