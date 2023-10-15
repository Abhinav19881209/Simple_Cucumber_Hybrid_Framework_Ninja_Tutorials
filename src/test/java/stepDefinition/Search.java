package stepDefinition;

import org.testng.Assert;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
//import driverFactory.DriverFactory;
import io.cucumber.java.en.*;
import pages.*;

public class Search {
	
	WebDriver driver = DriverFactory.getInstance().getDriver();
	
	SerachPage serachpage = new SerachPage(driver);
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		
		System.out.println("application is open");
	}

	@When("user enters product {string} in serach box")
	public void user_enters_product_in_serach_box(String prodname) {
		
		serachpage.enterProductNameInSearchBox(prodname);
		
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
	    
		serachpage.clickOnSearchbtn();
		
	}

	@Then("User should get valid product dispalyed in serch result")
	public void user_should_get_valid_product_dispalyed_in_serch_result() {

	Assert.assertEquals("HP LP3065", serachpage.validateForMatchedProduct());
	
	}

	@Then("User should get message about no product matching")
	public void user_should_get_message_about_no_product_matching() {
	 
		Assert.assertEquals("There is no product that matches the search criteria.", serachpage.validateErrorMsgforNoProduct());
	}


}
