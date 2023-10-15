package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class DriverFactory {
	
	// to use threadlocal we have to use best pratice approach - Singleton Class
	// to acchive singleton we have to make class constructor as private and create a static method to have the global access to it by creating object 
	
	Browserfactory bf = new Browserfactory();
	
	private DriverFactory() {}
	
	public static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance() {
		return instance;
			
	}
	
	// now to make the driver thread safe we are using Threadlocal class
	// it has 3 methods set(),get() and remove() methods
	//factory design pattern  - we are going to def seperate factory methods for creating objects
	//and creating object by calling methods
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	public WebDriver getDriverThreadLocal() {
		
		return driver.get();
	}
	
	public void setDriverThreadLocal(WebDriver driverparam) {
		
		driver.set(driverparam);
	}
	
	public void closeBrowser() {
		
		driver.get().close();
		driver.remove();
	}
	
	public WebDriver getDriver() {
		
	//	DriverFactory.getInstance().setDriverThreadLocal(bf.browserInstance(ConfigReader.initializedProperties().getProperty("browser")));
		
		return  DriverFactory.getInstance().getDriverThreadLocal();
		
	}

}
 