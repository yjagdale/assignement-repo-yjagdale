package browserfactory;

import org.openqa.selenium.WebDriver;

public abstract class Browser{
	WebDriver driver;
 public Browser(){
	 
 }
 public abstract WebDriver getBrowser();
}
