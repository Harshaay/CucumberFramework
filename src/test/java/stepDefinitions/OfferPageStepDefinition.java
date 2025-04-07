package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public  String offerPageProductName;
    TestContextSetup testcontextsetup;
    public PageObjectManager pageObjectManager;
    OffersPage offersPage;
    //Single responsibility Principle
    //loosely coupled
    //Factory Design pattern
	
	public OfferPageStepDefinition(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup=testcontextsetup;
		offersPage=testcontextsetup.pageObjectManager.getOffersPage();
	}
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws Throwable {
		
		switchToOffersPage(); 
		offersPage.searchItems(shortName);
	    Thread.sleep(3000);
	     offerPageProductName = offersPage.getProductName();
	    
	}
	
	public void switchToOffersPage() throws Throwable
	{
		//if switched to offer page-> skip below part
		LandingPage landingPage = testcontextsetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		 Thread.sleep(3000);
		 testcontextsetup.genericUtils.SwitchWindowToChild();
	}
	
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_Landing_page() {
		
		 Assert.assertEquals(offerPageProductName, testcontextsetup.landingPageProductName);
		    
	}
	
}
