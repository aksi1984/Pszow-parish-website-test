import com.microsoft.playwright.options.Cookie;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;
import java.util.List;

@Epic("Smoke tests")
@Feature("Cookie tests")
public class CookieTest extends BaseTest {

    @BeforeMethod
    public void init() {

        goToPage(URLs.HOME_PAGE.getName());
    }

    private List<Cookie> getCookies() {

        return getBrowserContext().cookies();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if cookies are empty")
    @Story("Checking the set of cookies size")
    public void setOfCookiesShouldNotBeEmpty() {

        Assert.assertFalse(getCookies().isEmpty());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the 'secure' value is not null")
    @Story("Checking the 'cookie_notice_accepted' value")
    public void theSecureValueShouldNotBeNull() {

        getCookies().forEach(cookie -> Assert.assertNotNull(cookie.secure));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the 'secure' value is true")
    @Story("Checking the 'cookie_notice_accepted' value")
    public void theSecureValueShouldBeTrue() {

        getCookies().forEach(cookie -> Assert.assertTrue(cookie.secure));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the 'expiry' value is not null")
    @Story("Checking the 'cookie_notice_accepted' value")
    public void theExpiryValueShouldNotBeNull() {

        getCookies().forEach(cookie -> Assert.assertNotNull(cookie.expires));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the 'expiry' value is in the future")
    @Story("Checking the 'expiry' value")
    public void theExpiryValueShouldBeInTheFuture() {

        for (Cookie cookie : getCookies()) {

            String cookieName = cookie.name;

        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test description: checking if the domain is correct")
    @Story("Checking the domain")
    public void theDomainShouldBeCorrect() {

        String expectedDomainName = "bazylika-pszow.pl";

        getCookies().forEach(c -> Assert.assertEquals(c.domain, expectedDomainName));
    }
}