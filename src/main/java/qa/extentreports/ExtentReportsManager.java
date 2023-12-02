package qa.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.remote.RemoteWebDriver;
import qa.base.BaseTest;

public class ExtentReportsManager {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;
    private static final String path = "./reports/";

    public static void create(String filename) {

        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path + filename);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports.attachReporter(extentSparkReporter);
    }

    public static void setTestName(String testName) {

        extentTest = extentReports.createTest(testName);
    }

    public static void setTestEnvironment() {

        extentReports.setSystemInfo("Available processors (cores)", String.valueOf(Runtime.getRuntime().availableProcessors()));
        extentReports.setSystemInfo("Maximum memory", String.valueOf(Runtime.getRuntime().maxMemory()));
        extentReports.setSystemInfo("Free memory", String.valueOf(Runtime.getRuntime().freeMemory()));
        extentReports.setSystemInfo("System property", System.getProperty("user.dir"));
        extentReports.setSystemInfo("Operating system", System.getProperty("os.name") + " " + System.getProperty("os.arch"));
        extentReports.setSystemInfo("Browser", ((RemoteWebDriver) BaseTest.getDriver()).getCapabilities().getBrowserName() + " " +
                ((RemoteWebDriver) BaseTest.getDriver()).getCapabilities().getBrowserVersion());
        extentReports.setSystemInfo("Java runtime version", System.getProperty("java.runtime.version"));
    }
    public static void setTestInfo(String message) {

        extentTest.log(Status.INFO, message);
    }

    public static void setTestPassed(String message) {

        extentTest.log(Status.PASS, message);
    }

    public static void setTestFailed(String message) {

        extentTest.log(Status.FAIL, message);
    }

    public static void setTestSkipped(String message) {

        extentTest.log(Status.SKIP, message);
    }

    public static void flush() {

        extentReports.flush();
    }
}
