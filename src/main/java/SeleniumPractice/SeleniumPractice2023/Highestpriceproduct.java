package SeleniumPractice.SeleniumPractice2023;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Highestpriceproduct {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		List <WebElement> list = driver.findElements(By.xpath("//div[@class = 'product-grid home-page-product-grid']/div"));
		
		System.out.println(list.size());
		
		double max = 0 ;
		
			for(int i=2;i<=list.size();i++) {
				
			WebElement ele = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']/div["+i+"]/div[1]/div[2]//child::div[3]/div[1]/span"));
				
			double price = Double.parseDouble(ele.getText());
			
		System.out.println("price of product ---"+price);
			
			if(price > max) {
				
				max = price;
			}
			
		}
			
			System.out.println(max);
			
			for(int i=2;i<=list.size();i++) {
				
				WebElement ele = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']/div["+i+"]/div[1]/div[2]//child::div[3]/div[1]/span"));
					
				String price = ele.getText();
				price = price.substring(0,price.length()-1);
				
				if(price.equals(String.valueOf(max))) {
					
				WebElement product = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']/div["+i+"]/div[1]/div[2]//child::h2/a"));
				
				System.out.println(product.getText());
				}
				
			}
	driver.quit();		
	}
}