package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    
    @FindBy(css = ".footer-links")
    private WebElement footer;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isFooterDisplayed() {
        return footer.isDisplayed();
    }
}
