package browserfactory;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
    private static WebDriver browser;

    /**
        A method @createBrowser will create a new browser instance and return it.
     @return (@WebDriver WebDriver)
     **/
    private static WebDriver createBrowser() {

        System.out.println("Browser: " + System.getProperty("browser").toUpperCase());
        switch (System.getProperty("browser").toUpperCase()) {
            case "CHROME":
                return new ChromeBrowser().getBrowser();
            case "FIREFOX":
                return new FirefoxBrowser().getBrowser();
            default:
                return null;
        }
    }


    /*
     * getBrowser() - Get the browser instanace if already created it will return it else
     * method will create and return the browser object
     *
     *@Return - WebDriver.
     *
     */
    public static WebDriver getBrowser() {
        if (browser == null) {
            browser = createBrowser();
        }
        return browser;
    }
}
