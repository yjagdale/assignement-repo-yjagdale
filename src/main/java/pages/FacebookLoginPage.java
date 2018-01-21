package pages;

import browserfactory.BrowserFactory;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import utils.ExtentReports.CoreUIActions;
import utils.ExtentReports.ExtentTestManager;


public class FacebookLoginPage {

    By userNameField = By.id("email");
    By passwordField = By.id("pass");
    /**
     * Method can be used to navigate to login page
     * <p>
     * Usage
     * facebookLoginPage.navigateTo(textToSet);
     * where facebookLoginPage is object of FacebookHomePage class.
     */
    public void navigateTo() {
        BrowserFactory.getBrowser().get(System.getProperty("appUrl"));
        ExtentTestManager.logStep(LogStatus.PASS, "Navigation", "Navigared to " + System.getProperty("appUrl") + " URL");
    }

    /**
     * Method can be used to set user name on login page
     * <p>
     *     @Input(@String userName)
     *
     * Usage
     * facebookLoginPage.setUserName(userName);
     * where facebookLoginPage is object of FacebookHomePage class.
     */

    public void setUserName(String userName) {
        CoreUIActions.writeText(userNameField, userName);
        ExtentTestManager.logStep(LogStatus.PASS, "sendKeys", "User Name setting done");
    }


    /**
     * Method can be used to set user password on login page
     * <p>
     *     @Input(@String password)
     *
     * Usage
     * facebookLoginPage.setPassword(userName);
     * where facebookLoginPage is object of FacebookHomePage class.
     */
    public void setPassword(String password) {
        CoreUIActions.writeText(passwordField, password);
        ExtentTestManager.logStep(LogStatus.PASS, "SendKeys", "Password setting done");
    }

    /**
     * Method can be used to click on sign in button on facebook page
     * <p>
     *     @Input(@null)
     *
     * Usage
     * facebookLoginPage.clickSignIn();
     * where facebookLoginPage is object of FacebookHomePage class.
     */
    public void clickSignIn() {
        CoreUIActions.click(By.cssSelector("[data-testid=royal_login_button]"));
        ExtentTestManager.logStep(LogStatus.PASS, "click", "Clicked on sign in button");
    }


    /**
     * Method will be conbination of steps which needs to be followed to login to facebook.
     *
     * @Input (String username, @String Password, @Boolean login_status)
     * @UserName will be user name which needs to be used while login
     * @Password  Password required for login
     * @Login_Status If case is to valid login need to pass true.
     *               If case is to invalid login then need to pass as false
     *
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
    public void performLogin(String userName, String password, boolean loginStatus) {
        System.out.println("Performing login with UserName:" + userName + " and Password:" + password);
        setUserName(userName);
        setPassword(password);
        clickSignIn();
        if (loginStatus) {
            CoreUIActions.waitUntilVisible(By.cssSelector("[id^=profile]"), 30);
            ExtentTestManager.logStep(LogStatus.PASS, "Login", "Home Page is displayed");
        }
    }
}
