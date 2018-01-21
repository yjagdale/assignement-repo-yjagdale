package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser extends Browser {

    /**
     * Class to create Chrome driver with options specific to {@link ChromeDriver}.
     * Ex. FirefoxBrowser ch  = new FirefoxBrowser(); ch.getBrowser
     * or
     * Browser browser= new ChromeBrowser();
     * browser.getBrowser();
     *
     * @Return (@ Browser WebDriver type)
     */
    @Override
    public WebDriver getBrowser() {
        return driver = new FirefoxDriver();
    }

}
