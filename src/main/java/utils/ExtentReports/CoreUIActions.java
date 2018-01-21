package utils.ExtentReports;

import browserfactory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreUIActions {


    public static void click(By elementLocation) {
        BrowserFactory.getBrowser().findElement(elementLocation).click();
    }

    //Write Text
    public static void writeText(By elementLocation, String text) {
        BrowserFactory.getBrowser().findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public static String readText(By elementLocation) {
        return BrowserFactory.getBrowser().findElement(elementLocation).getText();
    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(BrowserFactory.getBrowser(), 20);
    }

    public static void waitUntilVisible(By webElement, int timeInSec) {
        if (timeInSec != 20) {
            new WebDriverWait(BrowserFactory.getBrowser(), timeInSec).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
        } else {
            getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
        }
    }

    public static void waitUntilVisible(By webElement) {
        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
    }

    public static WebElement getWebElement(By postMessage) {
        return BrowserFactory.getBrowser().findElement(postMessage);
    }

    public static void waitUntilNotVisible(By webElement) {
        getWait().until(ExpectedConditions.invisibilityOfElementLocated(webElement));
    }

    public static void waitUntilNotVisible(By webElement, int timeInSec) {
        if (timeInSec != 20) {
            new WebDriverWait(BrowserFactory.getBrowser(), timeInSec).until(ExpectedConditions.invisibilityOfElementLocated(webElement));
        } else {
            getWait().until(ExpectedConditions.invisibilityOfElementLocated(webElement));
        }
    }

}
