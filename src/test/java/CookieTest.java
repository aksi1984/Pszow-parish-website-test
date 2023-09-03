import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.components.CookiesSection;

import java.util.Date;
import java.util.Random;
import java.util.Set;

public class CookieTest extends BaseTest {

    @BeforeClass
    public void init() {

        CookiesSection cookiesSection = new CookiesSection(getDriver());
        cookiesSection.acceptCookies();
    }

    @Test
    public void setOfCookiesShouldNotBeEmpty() {

        Set<Cookie> cookies = getDriver().manage().getCookies();

        Assert.assertFalse(cookies.isEmpty());
    }

    @Test
    public void theCookieNoticeAcceptedCookieShouldExist() {

        Cookie cookie = getDriver().manage().getCookieNamed("cookie_notice_accepted");

        Assert.assertEquals(cookie.getName(), "cookie_notice_accepted");
    }

    @Test
    public void theExpiryValueShouldNotBeEmpty() {

        Cookie cookie = getDriver().manage().getCookieNamed("cookie_notice_accepted");
        String value = cookie.getValue();

        Assert.assertNotNull(value);
    }

    @Test
    public void theDomainShouldBeCorrect() {

        Cookie cookie = getDriver().manage().getCookieNamed("cookie_notice_accepted");

        Assert.assertEquals(cookie.getDomain(), "bazylika-pszow.pl");
    }

    @Test
    public void theNewCookieShouldExist() throws InterruptedException {

        String name = "created_cookie";
        String value = String.format("%d_", new Random().nextInt());
        String path = "/";

        Cookie cookie = new Cookie(name, value, path);
        getDriver().manage().addCookie(cookie);

        Set<Cookie> cookies = getDriver().manage().getCookies();

        Assert.assertTrue(cookies.contains(cookie));

        Cookie given = getDriver().manage().getCookieNamed(name);
        Assert.assertEquals(given.getValue(), value);
        Assert.assertEquals(given.getPath(), path);
    }

    @Test
    public void expiryInThePast() {

        String name = "bad_cookie";
        String value = String.format("exp_%d_", new Random().nextInt());
        String path = "/";
        Date expiry = new Date(System.currentTimeMillis() - 100000);

        Cookie cookie = new Cookie(name, value, path, expiry);
        getDriver().manage().addCookie(cookie);

        Set<Cookie> cookies = getDriver().manage().getCookies();

        Assert.assertFalse(cookies.contains(cookie));
    }

    @Test
    public void deleteAllCookies() {

        getDriver().manage().deleteAllCookies();

        Set<Cookie> cookies = getDriver().manage().getCookies();

        Assert.assertTrue(cookies.isEmpty());
    }

    @Test
    public void deleteCookieByItsName() {

        getDriver().manage().deleteCookieNamed("PHPSESSID");

        Assert.assertNull(getDriver().manage().getCookieNamed("PHPSESSID"));
    }
}

/*
Domain: bazylika-pszow.pl
Expiry: Mon Oct 02 18:41:43 CEST 2023
Name: cookie_notice_accepted
Path: /
Value: true
Same site: Lax
-------------------
Domain: bazylika-pszow.pl
Expiry: null
Name: PHPSESSID
Path: /
Value: c0baf896f81df780c1f281034a8ab7f9
Same site: Lax
-------------------


 */