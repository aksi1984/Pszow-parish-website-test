package qa.components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import qa.base.BasePage;

public class SearchEngine extends BasePage {

    private final Actions actions;
    public SearchEngine(WebDriver driver) {

        super(driver);

        actions = new Actions(getDriver());
    }

    @FindBy(id = "s")
    WebElement field;

    public void clickOnField() {

        actions.moveByOffset(field.getLocation().x + 30, field.getLocation().y + 5).click();
        actions.perform();
    }

    public String getFieldValue() {

        return field.getAttribute("value");
    }
    public void setPhrase(String phrase) {

        String script = "document.getElementById('s').value=" + "'" + phrase+ "'";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript(script);

        field.submit();
    }
}
