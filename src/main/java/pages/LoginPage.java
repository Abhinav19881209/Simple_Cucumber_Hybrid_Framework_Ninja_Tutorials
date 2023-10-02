package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class LoginPage {
	

	WebDriver driver;
	
	ElementUtils utils = new ElementUtils(driver);
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement loginerrormsg;
	
	
	public void enterEmailId(String emailid) {
		
		utils.enterTheText(email, emailid);			
	}
	
	public void enterPassword(String pass) {
		
		utils.enterTheText(password, pass);
	}
	
	public AccountPage clickOnLoginBtn() {
		
		utils.clickOnElement(loginbtn);		
		
		return new AccountPage(driver);
	}
	
	public String getTextForLoginError() {
		
		return	utils.getTheTextofElement(loginerrormsg);
	}

}
