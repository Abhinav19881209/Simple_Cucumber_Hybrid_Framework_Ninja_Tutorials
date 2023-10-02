package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	

	WebDriver driver;
	
	public RegistrationPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailid;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmpass;
	
	@FindBy(xpath="//input[@name = 'agree']")
	private WebElement agreechkbox;
	
	@FindBy(xpath="//input[@value = 'Continue']")
	private WebElement continuebtn;
	
	@FindBy(xpath="//label[text() = 'Yes']")
	private WebElement yesradiobtn;
	

	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountcraetedmsg;
	
	@FindBy(xpath="//div[@class = 'alert alert-danger alert-dismissible']")
	private WebElement duplicateemailid;
	
	//fields error messages
	
	@FindBy(xpath="//*[@id='account']/div[2]/div/div")
	private WebElement fnameerrormsg;
	
	@FindBy(xpath="//*[@id='account']/div[3]/div/div")
	private WebElement lnameerrormsg;
	
	@FindBy(xpath="//*[@id='account']/div[4]/div/div")
	private WebElement emailerrormsg;
	
	@FindBy(xpath="//*[@id='account']/div[5]/div/div")
	private WebElement telephoneerrormsg;
	
	@FindBy(xpath="//*[@id='content']/form/fieldset[2]/div[1]/div/div")
	private WebElement passerrormsg;
	
	
	public void enterRegistrationDetails(String fname,String lname,String email,String phone,String pass,String cpass) {
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		emailid.sendKeys(email);
		telephone.sendKeys(phone);
		password.sendKeys(pass);
		confirmpass.sendKeys(cpass);
		
	}
	
	public void clicksOnPrivacyPolicy() {
		
		agreechkbox.click();
	}
	
	public void clicksOnContinuebtn() {
		
		continuebtn.click();
	}
	
	public String userAccountCretedMsg() {
		
		return accountcraetedmsg.getText();
	}
	
	public void clickOnYes() {
		
		yesradiobtn.click();
	}
	
	public String duplicateUserEmail() {
		
		return duplicateemailid.getText();
	}
	
	
	private String actualfnameerrmsg = "First Name must be between 1 and 32 characters!";
	private String actuallnameerrmsg = "Last Name must be between 1 and 32 characters!";
	private String actualemailerrmsg = "E-Mail Address does not appear to be valid!";
	private String actualtelephoneerrmsg = "Telephone must be between 3 and 32 characters!";
	private String actualpassworderrmsg = "Password must be between 4 and 20 characters!";
	
	public boolean validateFieldErrorMsg() {
	
		if (actualfnameerrmsg == fnameerrormsg.getText() && actuallnameerrmsg == lnameerrormsg.getText()
		 && actualemailerrmsg == lnameerrormsg.getText() && actualemailerrmsg == emailerrormsg.getText()
		 && actualtelephoneerrmsg == telephoneerrormsg.getText() && actualpassworderrmsg == passerrormsg.getText()) {
			
		}

		return true;
		
	}
	

	
}








