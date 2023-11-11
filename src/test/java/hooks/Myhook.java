package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import org.openqa.selenium.*;
import driverFactory.Browserfactory;

public class Myhook {
	
	WebDriver driver;
	Browserfactory bf = new Browserfactory();
	
	@Before
	public void setUp() {
		
	//	driver = DriverFactory.getInstance().getDriver();
	//	DriverFactory.getInstance().setDriverThreadLocal(bf.browserInstance(ConfigReader.initializedProperties().getProperty("browser")));
		
		DriverFactory.getInstance().setDriverThreadLocal(bf.browserInstance(ConfigReader.getBrowserType()));
		
		
		driver =  DriverFactory.getInstance().getDriverThreadLocal();
		
		System.out.println( 
	            "Current Thread ID: "
	            + Thread.currentThread().getId()); 
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(ConfigReader.initializedProperties().getProperty("URL"));
	}
	
	@After
		public void tearDown(Scenario scenario) {
		String scenarioname = scenario.getName().replace(" ","_");
		
		if(scenario.isFailed()) {
			
			byte[] srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcscreenshot, "image/png", scenarioname);
			
		}
		
		DriverFactory.getInstance().closeBrowser();
	}
	
//	@AfterStep
	public void takescreshotsOffailedTC(Scenario scenario) {
		
		String scenarioname = scenario.getName().replace(" ","_");
			
			byte[] srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcscreenshot, "image/png", scenarioname);
	
	}


}
