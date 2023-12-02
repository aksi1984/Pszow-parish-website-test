import io.qameta.allure.*;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.CookiesSection;
import qa.extentreports.ExtentReportsManager;

import java.util.Date;
import java.util.Random;
import java.util.Set;


@Epic("Smoke tests")
@Feature("Cookie tests")
public class CookieTest extends BaseTest {

    @BeforeMethod
    public void init() throws IllegalAccessException {

        CookiesSection cookiesSection = new CookiesSection(getDriver());
        cookiesSection.acceptCookies();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if cookies are empty")
    @Story("Checking the set of cookies size")
    public void setOfCookiesShouldNotBeEmpty() {

        ExtentReportsManager.setTestName("Checking the set of cookies size");

        Set<Cookie> cookies = getDriver().manage().getCookies();

        Assert.assertFalse(cookies.isEmpty(), "The set is empty");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the 'cookie_notice_accepted' cookie exist")
    @Story("Checking the 'cookie_notice_accepted' cookie")
    public void theCookieNoticeAcceptedCookieShouldExist() {

        ExtentReportsManager.setTestName("Checking the \"cookie_notice_accepted\" cookie");

        Cookie cookie = getDriver().manage().getCookieNamed("cookie_notice_accepted");

        Assert.assertEquals(cookie.getName(), "cookie_notice_accepted", "The \"cookie_notice_accepted\" cookie does not exist");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the 'cookie_notice_accepted' value is not null")
    @Story("Checking the 'cookie_notice_accepted' value")
    public void theExpiryValueShouldNotBeNull() {

        ExtentReportsManager.setTestName("Checking the \"cookie_notice_accepted\" value");

        Cookie cookie = getDriver().manage().getCookieNamed("cookie_notice_accepted");
        String value = cookie.getValue();

        Assert.assertNotNull(value, "The \"cookie_notice_accepted\" value is null");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the domain is correct")
    @Story("Checking the domain")
    public void theDomainShouldBeCorrect() {

        ExtentReportsManager.setTestName("Checking the domain");

        Cookie cookie = getDriver().manage().getCookieNamed("cookie_notice_accepted");

        Assert.assertEquals(cookie.getDomain(), "bazylika-pszow.pl", "Incorrect domain");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if a new cookie has the valid value and path")
    @Story("Checking the newly created cookie")
    public void theNewCookieShouldExist() {

        ExtentReportsManager.setTestName("Checking the newly created cookie");

        String name = "created_cookie";
        String value = String.format("%d_", new Random().nextInt());
        String path = "/";

        Cookie cookie = new Cookie(name, value, path);
        getDriver().manage().addCookie(cookie);

        Set<Cookie> cookies = getDriver().manage().getCookies();

        Assert.assertTrue(cookies.contains(cookie));

        Cookie given = getDriver().manage().getCookieNamed(name);
        Assert.assertEquals(given.getValue(), value, "Incorrect the new cookie value");
        Assert.assertEquals(given.getPath(), path, "Incorrect the new cookie path");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: Check if there is a new cookie with a date in the past")
    @Story("Creating a cookie with a date in the past")
    public void expiryInThePast() {

        ExtentReportsManager.setTestName("Creating a cookie with a date in the past");

        String name = "bad_cookie";
        String value = String.format("exp_%d_", new Random().nextInt());
        String path = "/";
        Date expiry = new Date(System.currentTimeMillis() - 100000);

        Cookie cookie = new Cookie(name, value, path, expiry);
        getDriver().manage().addCookie(cookie);

        Set<Cookie> cookies = getDriver().manage().getCookies();

        Assert.assertFalse(cookies.contains(cookie), "A new cookie with a date in the past exists");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: Checking whether cookies exist after deleting them")
    @Story("Deleting all cookies")
    public void deleteAllCookies() {

        ExtentReportsManager.setTestName("Deleting all cookies");

        getDriver().manage().deleteAllCookies();

        Set<Cookie> cookies = getDriver().manage().getCookies();

        Assert.assertTrue(cookies.isEmpty(), "The cookie exists");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: Checking if a cookie has been deleted by name")
    @Story("Deleting a cookie by name")
    public void deleteCookieByItsName() {

        ExtentReportsManager.setTestName("Deleting a cookie by name");

        getDriver().manage().deleteCookieNamed("PHPSESSID");

        Assert.assertNull(getDriver().manage().getCookieNamed("PHPSESSID"), "The cookie has not been deleted");
    }
}