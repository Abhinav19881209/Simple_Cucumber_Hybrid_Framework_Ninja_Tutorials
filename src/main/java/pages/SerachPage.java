package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SerachPage {
	
	WebDriver driver;
	
	public SerachPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//div[@class='caption']/h4/a")
	private WebElement searchProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement errormsgforNoProduct;
	
	
	public void enterProductNameInSearchBox(String productname) {
		
		SearchBox.sendKeys(productname);
	}
	
	public void clickOnSearchbtn() {
		
	SearchBtn.click();
	}
	
	public String validateForMatchedProduct() {
		
		return searchProduct.getText();
	}
	
	public String validateErrorMsgforNoProduct() {
		
		return errormsgforNoProduct.getText();
	}
	
}
