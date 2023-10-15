package SeleniumPractice.SeleniumPractice2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ShadowElement {

	public static void main(String[] args) throws InterruptedException {
		
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement shadowHost  = driver.findElement(By.xpath("//div[@id='userName']"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", shadowHost);
		 
		shadowHost.getShadowRoot().findElement(By.xpath("//input[@id='kils']")).sendKeys("Practice");
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}