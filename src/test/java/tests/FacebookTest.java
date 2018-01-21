package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookHomePage;
import pages.FacebookLoginPage;
import utils.ExtentReports.ExtentTestManager;

public class FacebookTest extends BaseTest {

    @Test(priority = 0, description = "Login To Facebook using username and password")
    public void loginToFacebook() throws InterruptedException {
        //ExtentReports Description
        ExtentTestManager.getTest().setDescription("Login To Facebook:  User Name:" + System.getProperty("fb_user_name") + " Password:" + System.getProperty("fb_user_password"));

        //*************PAGE INSTANTIATIONS*************
        FacebookLoginPage loginPage = new FacebookLoginPage();

        //Navigate to application login page
        loginPage.navigateTo();
        loginPage.performLogin(System.getProperty("fb_user_name"), System.getProperty("fb_user_password"), true);
        Assert.assertTrue(driver.findElement(By.cssSelector("[id^=profile]")).isDisplayed());
    }

    @Test(priority = 1, description = "Post Hello World on wall", dependsOnMethods = {"loginToFacebook"})
    public void postAMessageOnWall() throws InterruptedException {
        String textToSet = "Firefox posting message";
        FacebookHomePage homePage = new FacebookHomePage();
        homePage.navigateToHome();
        homePage.postOnWall(textToSet);
        homePage.validatePostIsPosted(textToSet);
    }

}
