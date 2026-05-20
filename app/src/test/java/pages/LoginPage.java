package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'user-account-tab')]")
    private WebElement userAccountTab;

    @FindBy(xpath = "//a[contains(@href, 'login')]")
    private WebElement loginLink;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit'].btn-primary")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginForm() {
        userAccountTab.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(user);
        passwordInput.sendKeys(pass);
        submitButton.click();
    }

    public String getUsernameError() {
        // Example of a locator that might exist on failure
        return wait.until(ExpectedConditions.visibilityOf(usernameInput)).getAttribute("validationMessage");
    }
}
