package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
	
	static WebDriver driver = null;
	
	public  static WebDriver initializeBrowser(String browsername) {
		
		if(browsername.equalsIgnoreCase("chrome")){
			
			 driver = new ChromeDriver();
		}
		
		else if(browsername.equalsIgnoreCase("firefox")){
			
			 driver = new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("Edge")){
			
			 driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
//	public static WebDriverWait getWait() {
//			
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		
//		return wait;
//	}



}
 