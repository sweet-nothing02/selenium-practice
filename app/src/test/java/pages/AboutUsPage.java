package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BasePage {

    @FindBy(css = ".about-us-content")
    private WebElement contentArea;

    public AboutUsPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contentArea);
    }
}
