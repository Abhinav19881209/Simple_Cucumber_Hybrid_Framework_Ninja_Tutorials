package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class Homepage {

	WebDriver driver;
	
	ElementUtils utils = new ElementUtils(driver);
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccount;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement Loginoption;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement Registeroption;
	
	public LoginPage clickOnLogin() {
		
		utils.clickOnElement(MyAccount);
		utils.clickOnElement(Loginoption);
		
		return new LoginPage(driver);
		
	}
	
	public RegistrationPage clickOnRegistration() {
		
		utils.clickOnElement(MyAccount);
		utils.clickOnElement(Registeroption);
//		MyAccount.click();
//		Registeroption.click();
		
		return new RegistrationPage(driver);
		
	}


	
	
	
}
