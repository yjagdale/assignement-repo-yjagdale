package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser extends Browser {

    /**
     * Class to create Chrome driver with options specific to {@link ChromeDriver}.
     * Ex. ChromeBrowser ch  = new ChromeBrowser(); ch.getBrowser
     * or
     * Browser browser= new ChromeBrowser();
     * browser.getBrowser();
     * @Return (@Browser WebDriver type)
     */

    @Override
    public WebDriver getBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-web-security");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.setCapability("password_manager_enabled", false);
        options.setCapability("credentials_enable_service", false);
        options.setCapability("profile.password_manager_enabled", false);
        options.setCapability(ChromeOptions.CAPABILITY, options);
        return driver = new ChromeDriver(options);
    }

}
