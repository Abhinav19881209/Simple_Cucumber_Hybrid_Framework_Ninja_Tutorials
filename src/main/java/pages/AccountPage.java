package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountPage {


	WebDriver driver;
	
	ElementUtils utils = new ElementUtils(driver);
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String accountPageTitle() {
		
		return	utils.getPageTitle(driver);
		
		//return driver.getTitle();
	}
	
	
	
}
