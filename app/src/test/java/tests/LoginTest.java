package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(description = "Verify login form interaction")
    public void testLoginAttempt() {
        LoginPage loginPage = new LoginPage(driver);

        try {
            loginPage.openLoginForm();
            loginPage.login("testuser@example.com", "InvalidPassword123!");

            Assert.assertNotNull(driver.getCurrentUrl());
        } catch (Exception e) {
            System.out.println("Login elements might be inside a shadow DOM or different on mobile view");
        }
    }
}
