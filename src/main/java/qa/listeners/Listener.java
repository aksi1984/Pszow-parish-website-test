package qa.listeners;

import io.qameta.allure.Attachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener {

    private final Logger logger = LoggerFactory.getLogger(Listener.class);

    private static String getTestMethodName(ITestResult iTestResult) {

        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {

        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {

        logger.info("SUITE: " + iTestContext.getSuite().getName());
        logger.info("-".repeat(60));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        logger.info("FINISH");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        logger.info("Test name: " + iTestResult.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        logger.info("PASSED on method: " + iTestResult.getMethod());
        logger.info("-".repeat(60));
        saveTextLog(getTestMethodName(iTestResult) + "- passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        logger.error("FAILED on method: " + iTestResult.getMethod());
        logger.info("-".repeat(60));
        saveTextLog(getTestMethodName(iTestResult) + "- failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        logger.info("SKIPPED on method: " + iTestResult.getMethod());
        logger.info("-".repeat(60));
        saveTextLog(getTestMethodName(iTestResult) + "- skipped");
    }
}
