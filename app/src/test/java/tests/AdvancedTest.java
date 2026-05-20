package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.PrivacyPolicyPage;

public class AdvancedTest extends BaseTest {

    @Test(description = "Use JavascriptExecutor to scroll")
    public void testJavascriptScroll() {
        driver.get("https://www.cinemacity.hu/en/about-us");
        AboutUsPage aboutUsPage = new AboutUsPage(driver);
        aboutUsPage.scrollToContent();
        Assert.assertTrue(true);
    }

    @Test(description = "Test browser history navigation")
    public void testBrowserHistory() {
        driver.get("https://www.cinemacity.hu/en/about-us");
        String firstTitle = driver.getTitle();

        driver.get("https://www.cinemacity.hu/en/privacy-policy-hu");
        PrivacyPolicyPage privacyPage = new PrivacyPolicyPage(driver);
        privacyPage.navigateBack();

        Assert.assertEquals(driver.getTitle(), firstTitle);
    }

    @Test(dependsOnMethods = "testBrowserHistory", description = "Test with dependencies")
    public void testDependentAction() {
        Assert.assertTrue(driver.getCurrentUrl().contains("cinemacity"));
    }
}
