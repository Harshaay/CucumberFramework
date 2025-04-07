package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import utils.TestContextSetup;

public class CheckOutPageStepDefinition {
	
	TestContextSetup testcontextsetup;
	CheckOutPage checkOutPage;
	public  String checkOutPageProductName;
	
	public CheckOutPageStepDefinition(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup=testcontextsetup;
		checkOutPage = testcontextsetup.pageObjectManager.getCheckOutPage();
	}
	
	@Then("validate product name in appeared in checkout")
	public void validate_product_name_in_appeared_in_checkout() throws Throwable {
		Thread.sleep(3000);
		
		String checkOutPageProductName = checkOutPage.getProductName();
		Assert.assertEquals(checkOutPageProductName, testcontextsetup.landingPageProductName);
	}
	
	
	@Then("verify user has the ability to enter promo code and place the order")
	public void verify_user_has_the_ability_to_enter_promo_code_and_place_the_order() throws Throwable {
		checkOutPage.verifyApplyButtonDisplayed();
		checkOutPage.verifyPlaceOrderButtonDisplayed();
	}

}
