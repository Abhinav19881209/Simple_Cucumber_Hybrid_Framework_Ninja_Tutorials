package SeleniumPractice.SeleniumPractice2023;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSearch {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//span[@role ='button']")).click();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone");
//		
//		List <WebElement> list = driver.findElements(By.xpath("//li[@class='_3D0G9a']/div/a/div/following-sibling::div"));
//		
//		for(WebElement ele :list) {
//			
//			System.out.println(ele.getText());
//		}
//		
		//considering 7 as size of li tag
		for(int i =1;i<=7;i++) {
			
			WebElement ele = driver.findElement(By.xpath("//*[@id='container']//li["+i+"]/div/a/div[2]"));
			String text = ele.getText();
			
			System.out.println(text);
			
			if(text.contains("13")) {
				
				ele.click();
			}
			break;
		}
		
		Thread.sleep(2000);
		driver.quit();

	}

}
