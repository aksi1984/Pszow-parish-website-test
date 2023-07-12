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

    private void scrollIntoElement(WebElement element) {

        javascriptExecutor.executeScript("arguments[0].scrollIntoView", element);
    }

    public void clickNewArchbishopLink() {

        scrollIntoElement(newArchbishopLink);
        newArchbishopLink.click();
    }

    public void clickParishStatisticsLink() {

        scrollIntoElement(parishStatisticsLink);
        parishStatisticsLink.click();
    }

    public void clickRetransmissionLink() {

        scrollIntoElement(retransmission);
        retransmission.click();
    }

    public void clickForgivenessReportLink() {

        scrollIntoElement(forgivenessReport);
        forgivenessReport.click();
    }

    public void clickPlenaryIndulgenceLink() {

        scrollIntoElement(plenaryIndulgence);
        plenaryIndulgence.click();
    }

    public void clickLitanyLink() {

        scrollIntoElement(litany);
        litany.click();
    }

    public void clickParishHistoryLink() {

        scrollIntoElement(parishHistory);
        parishHistory.click();
    }

    public void clickBasilicaInsideLink() {

        scrollIntoElement(basilicaInside);
        basilicaInside.click();
    }

    public void clickParishCommunityLink() {

        scrollIntoElement(parishCommunity);
        parishCommunity.click();
    }

    public void clickSacramentsInfoLink() {

        scrollIntoElement(sacramentsInfo);
        sacramentsInfo.click();
    }

    public void clickPszowCalvaryLink() {

        scrollIntoElement(pszowCalvary);
        pszowCalvary.click();
    }

    public void clickPhotoGalleryLink() {

        scrollIntoElement(photoGallery);
        photoGallery.click();
    }

    public void clickFilmsLink() {

        scrollIntoElement(films);
        films.click();
    }

    public void clickEveningWithJesusLink() {

        scrollIntoElement(eveningWithJesus);
        eveningWithJesus.click();
    }

    public void clickCemeteryRegulationsLink() {

        scrollIntoElement(cemeteryRegulations);
        cemeteryRegulations.click();
    }

    public void clickDelegateLink() {

        scrollIntoElement(delegate);
        delegate.click();
    }

    public void clickParishCharitableActivitiesLink() {

        scrollIntoElement(parishCharitableActivities);
        parishCharitableActivities.click();
    }
}
