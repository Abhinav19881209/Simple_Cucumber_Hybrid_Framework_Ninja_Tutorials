package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtils(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
//	DriverFactory.
	
	public  WebDriverWait getWait() {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
		return wait;
	}	
	
	public WebElement getElementPresence(By element) {
		 WebElement ele = null;
		try {
			
			ele =getWait().until(ExpectedConditions.presenceOfElementLocated(element));
			
			return ele;
			
		} catch (Exception e) {
			
			System.out.println("Element not located");
		}
		
		return null;
	}
	
	
	
	public WebElement eleToBeClickable(WebElement element) {
		
		WebElement ele = null;
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				 
		 ele = wait.until(ExpectedConditions.elementToBeClickable(element));
		 
		 return ele;
	}
	
	
	public void clickOnElement(WebElement element) {
		System.out.println("click method");
	//	WebElement ele = eleToBeClickable(element);
		element.click();
		
	}
	
	public void enterTheText(WebElement element,String text) {
	
		
	//	ele = elementIsClickable(element);
		element.clear();
		element.sendKeys(text);
		
	}
	
	public String getTheTextofElement(WebElement element) {
		 
		 String text = element.getText();
		 
		 return text;
		
	}
	
	public String getPageTitle(WebDriver driver) {
		
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public WebElement visibilityOfElement(WebElement element) {
		
		WebElement ele = null;
	//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIME_OUT));
		try {
			ele = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ele;
	}
	
	 public void javaScriptClick(WebElement element) {
		 
		 WebElement ele = visibilityOfElement(element);
		 
		 JavascriptExecutor jse = ((JavascriptExecutor)driver);
		 
		 jse.executeScript("arguments[0].click", ele);
	 }
	
	 public void enterTextUsingJavaScript(WebElement element,String text) {
		 
		 WebElement ele = visibilityOfElement(element);
		 
		 JavascriptExecutor jse = ((JavascriptExecutor)driver);
		 
		 jse.executeScript("arguments[0].value='"+text+"'", ele);
		 
	 }
	
}
