import com.microsoft.playwright.options.Cookie;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.base.BaseTest;
import qa.enums.URLs;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Epic("E2E")
@Feature("Cookie tests")
public class CookieTest extends BaseTest {

    @BeforeMethod
    public void init() {

        goToPage(URLs.HOME_PAGE.getName());
    }

    private List<Cookie> getCookies() {

        return getBrowserContext().cookies();
    }

    private boolean isUsingHTTPS() throws URISyntaxException {

        URI uri = new URI(getPage().url());
        return uri.getScheme().equalsIgnoreCase("https");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether the cookies list is not empty")
    @Story("Checking the list of cookies size")
    public void setOfCookiesShouldNotBeEmpty() {

        Assert.assertFalse(getCookies().isEmpty(),
                "No cookies found");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether the 'secure' value is not null")
    @Story("Checking the 'secure' value")
    public void theSecureValueShouldNotBeNull() throws URISyntaxException {

        if (isUsingHTTPS()) {

            getCookies().forEach(cookie -> Assert.assertNotNull(cookie.secure,
                    "The 'secure' value in the '" + cookie.name + "' cookie is null"));

        } else {

            throw new SkipException("The website does not use the 'https' protocol");
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether the 'secure' value is true")
    @Story("Checking the 'secure' value")
    public void theSecureValueShouldBeTrue() throws URISyntaxException {

        if (isUsingHTTPS()) {

            getCookies().forEach(cookie -> Assert.assertTrue(cookie.secure,
                    "The 'secure' value in the '" + cookie.name + "' cookie is false"));

        } else {

            throw new SkipException("The website does not use the 'https' protocol");
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether the expiration data is not null")
    @Story("Checking the expiration data")
    public void theExpirationDataShouldNotBeNull() {

        getCookies().forEach(cookie -> Assert.assertNotNull(cookie.expires,
                "The expiration data is null"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether the expiration date value is not infinite")
    @Story("Checking the expiration date value")
    public void expirationDateShouldNotBeInfinite() {

        getCookies().forEach(cookie -> Assert.assertFalse(Double.isInfinite(cookie.expires),
                "The expiration date value is infinite"));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether the expiration date is in the future")
    @Story("Checking the expiration date")
    public void theExpirationDataShouldBeInTheFuture() {

        for (Cookie cookie : getCookies()) {

            Instant instant = Instant.ofEpochSecond(cookie.expires.longValue());
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

            Assert.assertTrue(dateTime.isAfter(LocalDateTime.now()),
                    "The expiration date is in the past: " + dateTime);
        }
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Checking whether the domain is correct")
    @Story("Checking the domain")
    public void theDomainShouldBeCorrect() {

        String expectedDomainName = "bazylika-pszow.pl";

        getCookies().forEach(c -> Assert.assertEquals(c.domain, expectedDomainName,
                "Incorrect domain"));
    }
}