package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.xpath("//input[@type='search']");

	By productName = By.cssSelector("h4.product-name");

	By topDeals = By.linkText("Top Deals");

	By greenkartlogo = By.xpath("//div[@class='brand greenLogo']");

	By plus = By.cssSelector("a.increment");
	
	By ADDTOCART = By.xpath("//button[text()='ADD TO CART']");
	
	By cartimage = By.xpath("//img[@alt='Cart']");
	
	By PROCEEDTOCHECKOUT = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

	public void searchItems(String Name) {
		driver.findElement(search).sendKeys(Name);

	}

	public void getSearchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}

	public void verifyGreenKartLogoDisplayed() throws Throwable {
		if(driver.findElement(greenkartlogo).isDisplayed()) {
			System.out.println("GreenKart Logo Displayed");
		}else {
			throw new Exception("Error in Loading Landing Page");
		}
	
	}
	
	public void addItems(int num)
	{
		for(int i =1 ;i<=num;i++)
		{
			driver.findElement(plus).click();
		}
	}
	
	public void addProductToKart()
	{
		driver.findElement(ADDTOCART).click();
	}
	
	public void proceedToCheckout()
	{
		driver.findElement(cartimage).click();
		driver.findElement(PROCEEDTOCHECKOUT).click();
		
	}
}
