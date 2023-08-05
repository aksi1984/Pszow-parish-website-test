package qa.components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;


public class SideMenu extends BasePage {

    JavascriptExecutor javascriptExecutor;
    public SideMenu(WebDriver driver) {

        super(driver);
        javascriptExecutor = (JavascriptExecutor) getDriver();
    }

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=24016']")
    WebElement newArchbishopLink;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=22399']")
    WebElement parishStatisticsLink;

    @FindBy(xpath = "//a[@href='https://katowice.tvp.pl/62817326/miedzy-tajemnicami?fbclid=IwAR3UfBFvjaes7tKYnkO3FU2GYuG1BCe5LTu_46kzfuYGh4L9OYpWQjD3Q-w']")
    WebElement retransmission;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=22181']")
    WebElement forgivenessReport;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=22172']")
    WebElement plenaryIndulgence;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=13887']")
    WebElement litany;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=903']")
    WebElement parishHistory;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=901']")
    WebElement yesterdayAndNow;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=864']")
    WebElement basilicaInside;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=8138']")
    WebElement parishCommunity;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=17472']")
    WebElement sacramentsInfo;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=863']")
    WebElement pszowCalvary;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=7360']")
    WebElement photoGallery;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=862']")
    WebElement films;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=8079']")
    WebElement eveningWithJesus;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=1862']")
    WebElement cemeteryRegulations;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=16781']")
    WebElement delegate;

    @FindBy(xpath = "//a[@href='https://bazylika-pszow.pl/?page_id=927']")
    WebElement parishCharitableActivities;

    private void clickElement(WebElement element) {

        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public void clickNewArchbishopLink() {

        clickElement(newArchbishopLink);
    }

    public void clickParishStatisticsLink() {

        clickElement(parishStatisticsLink);
    }

    public void clickRetransmissionLink() {

        clickElement(retransmission);
    }

    public void clickForgivenessReportLink() {

        clickElement(forgivenessReport);
    }

    public void clickPlenaryIndulgenceLink() {

        clickElement(plenaryIndulgence);
    }

    public void clickLitanyLink() {

        clickElement(litany);
    }

    public void clickParishHistoryLink() {

        clickElement(parishHistory);
    }

    public void clickYesterdayAndNowLink() {

        clickElement(yesterdayAndNow);
    }

    public void clickBasilicaInsideLink() {

        clickElement(basilicaInside);
    }

    public void clickParishCommunityLink() {

        clickElement(parishCommunity);
    }

    public void clickSacramentsInfoLink() {

        clickElement(sacramentsInfo);
    }

    public void clickCalvaryLink() {

        clickElement(pszowCalvary);
    }

    public void clickPhotoGalleryLink() {

        clickElement(photoGallery);
    }

    public void clickFilmsLink() throws InterruptedException {

        clickElement(films);
    }

    public void clickEveningWithJesusLink() {

        clickElement(eveningWithJesus);
    }

    public void clickCemeteryRegulationsLink() {

        clickElement(cemeteryRegulations);
    }

    public void clickDelegateLink() {

        clickElement(delegate);
    }

    public void clickParishCharitableActivitiesLink() {

        clickElement(parishCharitableActivities);
    }
}
