package stepDefinition;

import org.junit.Assert;
import pages.Homepage;
import pages.LoginPage;
import pages.AccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login {
	
	//DriverFactory driverfactory = new DriverFactory();
	WebDriver driver = DriverFactory.getDriver();
	
	private Homepage homepage;
	private LoginPage loginpage;
	private AccountPage accountpage;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		homepage = new Homepage(driver);
		loginpage = homepage.clickOnLogin();
	}

	@When("^User has enters email address (.+)$")
	public void user_has_enters_email_address(String email) {
		
		loginpage.enterEmailId(email);
	}

	@When("^User has enters password (.+)$")
	public void user_has_enters_password(String password) {

		loginpage.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		
		accountpage = loginpage.clickOnLoginBtn();
	}

	@Then("User should get succesfully logged in")
	public void user_should_get_succesfully_logged_in() {

		Assert.assertEquals("My Account", accountpage.accountPageTitle());
		
	}

	@Then("User should not get logged in")
	public void user_should_not_get_logged_in() {
	    
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",loginpage.getTextForLoginError() );
	
	}




}
