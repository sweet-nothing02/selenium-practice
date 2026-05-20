package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), 'Kapcsolat')]")
    private WebElement pageHeader;

    @FindBy(name = "contact_name")
    private WebElement nameInput;

    @FindBy(name = "contact_email")
    private WebElement emailInput;

    @FindBy(name = "contact_message")
    private WebElement messageArea;

    @FindBy(css = "select[name='subject']")
    private WebElement subjectDropdown;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderDisplayed() {
        return pageHeader.isDisplayed();
    }

    public void fillContactForm(String name, String email, String message) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        messageArea.sendKeys(message);
    }
}
