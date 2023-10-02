package stepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.*;

public class Registration {
	
	WebDriver driver = DriverFactory.getDriver();
	
	Homepage homepage = new Homepage(driver);
	
	private RegistrationPage regsitrationpage;
	
	@Given("User navigates to register account page")
	public void user_navigates_to_register_account_page() {
		
		regsitrationpage = homepage.clickOnRegistration();
		
	}

	@When("user enters the belwo details")
	public void user_enters_the_belwo_details(DataTable dataTable) {
		
		Map<String,String> dataMap = dataTable.asMap(String.class,String.class);
		
		regsitrationpage.enterRegistrationDetails(dataMap.get("firstname"), 
				dataMap.get("lastname"),
				dataMap.get("email"),
				dataMap.get("telephone"),
				dataMap.get("password"),
				dataMap.get("confirm"));
		
	}

	@When("user select privacy Policy")
	public void user_select_privacy_policy() {
	    
		regsitrationpage.clicksOnPrivacyPolicy();
	}

	@When("user clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		regsitrationpage.clicksOnContinuebtn();
	}

	@Then("user account should get created successfull")
	public void user_account_should_get_created_successfull() {
		
		Assert.assertEquals("Your Account Has Been Created!", regsitrationpage.userAccountCretedMsg());
	
	}

	@When("User select Yes for newsletter")
	public void user_select_yes_for_newsletter() {
		
		regsitrationpage.clickOnYes();
	}

	@Then("user account should get warning message for duplicate email")
	public void user_account_should_get_warning_message_for_duplicate_email() {
	   
		Assert.assertEquals("Warning: E-Mail Address is already registered!", regsitrationpage.duplicateUserEmail());
		
	}

	@Then("user account should get warning message for every mandatory field")
	public void user_account_should_get_warning_message_for_every_mandatory_field() {
	    
		Assert.assertTrue(regsitrationpage.validateFieldErrorMsg());
		
	}


}
