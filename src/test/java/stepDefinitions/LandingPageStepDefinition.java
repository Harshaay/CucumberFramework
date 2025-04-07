package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

	TestContextSetup testcontextsetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testcontextsetup)
	{
		this.testcontextsetup=testcontextsetup;
		landingPage = testcontextsetup.pageObjectManager.getLandingPage();
	}
	
// Spring framework, EJB, 
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws Throwable {
//	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver.exe");
//	    testcontextsetup.driver = new ChromeDriver();
//	    testcontextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//	    testcontextsetup.driver.manage().window().maximize();
		landingPage.verifyGreenKartLogoDisplayed();
	    
	}
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws Throwable {
		landingPage.searchItems(shortName);
	    Thread.sleep(3000);
	    testcontextsetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testcontextsetup.landingPageProductName+ " is extracted from Home page");
	    
	   	    
	    }
	
	@Given("User is on greenKart Landing page")
	public void user_is_on_green_kart_landing_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		landingPage.verifyGreenKartLogoDisplayed();
	}
	@When("^user searched product with shortname for (.+) and extract actual name of product$")
	public void user_searched_product_with_shortname_for_tom_and_extract_actual_name_of_product(String shortName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		landingPage.searchItems(shortName);
	    Thread.sleep(3000);
	    testcontextsetup.landingPageProductName=landingPage.getProductName();
	    System.out.println(testcontextsetup.landingPageProductName+ " is extracted from Home page");
	   
	  
	}
	
	@When("^Add (.+) items of same product to Kart and proceed to check out$")
	public void Add_number_items_of_same_product_to_Kart_and_proceed_to_check_out(int num) {
		landingPage.addItems(num);
		landingPage.addProductToKart();
		landingPage.proceedToCheckout();
	}
}
