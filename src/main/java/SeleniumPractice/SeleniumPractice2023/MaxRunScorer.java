package SeleniumPractice.SeleniumPractice2023;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



//// I wrote teh code considering some assumptions due to time limit
public class MaxRunScorer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//div[@id='innings_1']//div[@class='cb-col cb-col-100 cb-scrd-itms'][3]/div[1]/a
		
		//div[@id='innings_1']
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/65805/aus-vs-ind-final-icc-world-test-championship-final-2023");
		
		
//		for(int i=1;i<=4;i++) {
//			
//		WebElement inning = driver.findElement(By.xpath("//div[@id='innings_"+i+"']//div[@class='cb-col cb-col-100 cb-scrd-itms'][1]/div[1]/a"));
//		System.out.println(inning.getText());
//		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i =1;i < 10;i++) {
			
		List<WebElement> batter = driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']["+i+"]/div[1]/a"));
		
		List<WebElement> runs = driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-itms']["+i+"]/div[2]/following-sibling::div[1]"));

			for(int j=0;j<4;j++) {
				
				//System.out.println(batter.get(j).getText()+"---runs---"+runs.get(j).getText());
				
				try {
					if(map.containsKey(batter.get(j).getText())) {
						
						map.put(batter.get(j).getText(), map.get(batter.get(j).getText())+Integer.parseInt(runs.get(j).getText()));
					}
					else
					map.put(batter.get(j).getText(), Integer.parseInt(runs.get(j).getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
	
		}
		
		
		Integer maxRuninmap = (Collections.max(map.values()));
		System.out.println(maxRuninmap);
		
		 for (Map.Entry entry : map.entrySet()) {
	           // System.out.println(entry.getKey() + " " + entry.getValue());
	            
	            if (entry.getValue() == maxRuninmap) {
	            	
	                System.out.println(entry.getKey());
	            }
	        }
		

		driver.quit();
	}

}
