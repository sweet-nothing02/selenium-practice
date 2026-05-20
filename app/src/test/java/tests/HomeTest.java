package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {

    @Test(description = "Verify page title and basic elements")
    public void testHomePageTitleAndFooter() {
        HomePage homePage = new HomePage(driver);
        
        String title = homePage.getTitle();
        System.out.println("Page title: " + title);
        Assert.assertTrue(title.contains("Cinema City"), "Title should contain Cinema City");
        
        Assert.assertTrue(homePage.isFooterDisplayed(), "Footer should be displayed");
    }
}
