package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class Homepage {

	WebDriver ldriver;
	
	ElementUtils utils = new ElementUtils(ldriver);
	
	public Homepage(WebDriver driver) {
		
	//	this.driver = driver;
		ldriver = driver;
		
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccount;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement Loginoption;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement Registeroption;
	
	public LoginPage clickOnLogin() {
		
		System.out.println("clcik on my account");
		
		System.out.println("clcik on  loginoption");

		utils.clickOnElement(MyAccount);
		
		utils.clickOnElement(Loginoption);
		
		return new LoginPage(ldriver);
		
	}
	
	public RegistrationPage clickOnRegistration() {
		
		utils.clickOnElement(MyAccount);
		utils.clickOnElement(Registeroption);
//		MyAccount.click();
//		Registeroption.click();
		
		return new RegistrationPage(ldriver);
		
	}


	
	
	
}
