package qa.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import qa.utils.ExtentReportsManager;

public class Listener implements ITestListener {

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
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        ExtentReportsManager.setTestFailed("Test failed on method " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        ExtentReportsManager.setTestSkipped("Test skipped on method " + iTestResult.getMethod().getMethodName());
    }
}
