package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.ExtentReports.CoreUIActions;
import utils.ExtentReports.ExtentTestManager;

public class FacebookHomePage {

    /**
     * All intractable object from Facebook home page
     * Type @By
     */
    By postArea = By.cssSelector("[data-testid=status-attachment-mentions-input]");
    By postButton = By.xpath(".//*[@data-testid='react-composer-post-button']");
    By homeButton = By.cssSelector("[data-click=bluebar_logo] > a");
    By composePost = By.xpath(".//*[contains(text(), 'Compose Post')]");
    By uploadStatusBar = By.xpath(".//span[text()='Uploading...']");

    /**
     * Method will be usefull to set post text/ messgae on facebook home page
     *
     * @Input(@String textToSet)
     * <p>
     * Usage
     * facebookHomePage.setPostText(textToSet);
     * where facebookHomePage is object of FacebookHomePage class.
     */
    public void setPostText(String textToSet) {
        CoreUIActions.waitUntilVisible(postArea);
        CoreUIActions.writeText(postArea, textToSet);
        ExtentTestManager.logStep(LogStatus.PASS, "SendKeys", "Successfully set text as " + textToSet);
    }

    /**
     * Method will be usefull to click On Post Area of facebook home page
     * <p>
     * Usage
     * facebookHomePage.clickOnPostArea();
     * where facebookHomePage is object of FacebookHomePage class.
     */
    public void clickOnPostArea() {
        CoreUIActions.click(composePost);
        ExtentTestManager.logStep(LogStatus.PASS, "Click", "Successfully clicked on post area");
    }

    /**
     * Method will be usefull to click On Post Button of facebook home page
     * <p>
     * Usage
     * facebookHomePage.clickOnPostButton();
     * where facebookHomePage is object of FacebookHomePage class.
     * After execution of this method Post button will get clicked from post message window of facebook
     */
    public void clickOnPostButton() {
        CoreUIActions.click(postButton);
        //   System.out.println(BrowserFactory.getBrowser().findElement(postButton).isEnabled());
        ExtentTestManager.logStep(LogStatus.PASS, "clickOnPostButton", "Successfully clicked on post button");
    }

    /**
     * Method will be conbination of steps which needs to be followed to post a message on facebook.
     *
     * @Input (String textToSet)
     * <p>
     * Function perform below steps:-
     * 1. click On Post Area
     * 2. set Post Text
     * 3. click On Post Button
     * <p>
     * <p>
     * Usage
     * facebookHomePage.postOnWall(textToPost);
     * where facebookHomePage is object of FacebookHomePage class.
     */
    public void postOnWall(String textToSet) {
        clickOnPostArea();
        setPostText(textToSet);
        clickOnPostButton();

    }

    /**
     * Method can be used to validate Post Is Posted or not on facebook page.
     *
     * @Input (String postedText)
     * Usage
     * facebookHomePage.validatePostIsPosted(textToPost);
     * This will assert if posted message is not available.
     * where facebookHomePage is object of FacebookHomePage class.
     */

    public void validatePostIsPosted(String postText) {
        By postMessage = By.xpath(".//p[text() = '" + postText + "']");
        CoreUIActions.waitUntilVisible(postMessage);
        Assert.assertTrue(CoreUIActions.getWebElement(postMessage).isDisplayed());
        ExtentTestManager.logStep(LogStatus.PASS, "validate post", "Post is shared on wall successfully");
    }

    /**
     * Method can be used to navigate to home page
     * <p>
     * Usage
     * facebookHomePage.navigateToHome();
     * This will redirect user to home page
     * where facebookHomePage is object of FacebookHomePage class.
     */
    public void navigateToHome() {
        CoreUIActions.click(homeButton);
        CoreUIActions.waitUntilNotVisible(uploadStatusBar);
    }
}
