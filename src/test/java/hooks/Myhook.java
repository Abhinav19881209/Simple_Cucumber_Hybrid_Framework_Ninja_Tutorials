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

public class Myhook {
	
	WebDriver driver;
	DriverFactory driverfactory;
	
	@Before
	public void setUp() {
		
		//driverfactory = new DriverFactory();
		
		Properties prop = ConfigReader.initializedProperties();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		//driver = DriverFactory.getDriver();
	
		driver.get(prop.getProperty("URL"));
	
	}
	
	@After
		public void tearDown(Scenario scenario) {
		String scenarioname = scenario.getName().replace(" ","_");
		
		if(scenario.isFailed()) {
			
			byte[] srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcscreenshot, "image/png", scenarioname);
			
		}
		
		driver.close();
		driver.quit();
	}
	
//	@AfterStep
	public void takescreshotsOffailedTC(Scenario scenario) {
		
		String scenarioname = scenario.getName().replace(" ","_");
			
			byte[] srcscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcscreenshot, "image/png", scenarioname);
	
	}


}
