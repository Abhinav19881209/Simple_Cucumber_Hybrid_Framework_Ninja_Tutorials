package driverFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browserfactory {
	
	//WebDriver driver;
	
	public WebDriver browserInstance(String browsername) {
		
		WebDriver driver = null;
		
		if(browsername.equalsIgnoreCase("chrome")){
			
			ChromeOptions option = new ChromeOptions();
			//option.addArguments("--incognito");
			 driver = new ChromeDriver(option);
		}
		
		else if(browsername.equalsIgnoreCase("firefox")){
			
			 driver = new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("Edge")){
			
			 driver = new EdgeDriver();
		}

		return driver;
		
	}
	
}
