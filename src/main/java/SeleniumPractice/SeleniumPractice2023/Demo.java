package SeleniumPractice.SeleniumPractice2023;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Demo {

	public static void main(String[] args) {
		
		 	ChromeOptions options = new ChromeOptions();
		 
		    WebDriver driver = new ChromeDriver(options);
		    
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		    driver.get("https://tutorialsninja.com/demo/");
		    
		    

	}

}
