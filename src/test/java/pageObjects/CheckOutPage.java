package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By productName = By.cssSelector("p.product-name");
	
	By Applybutton = By.xpath("//button[text()='Apply']");
	
	By PlaceOrderbutton = By.xpath("//button[text()='Place Order']");
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void verifyApplyButtonDisplayed() throws Throwable {
		if(driver.findElement(Applybutton).isDisplayed()) {
			System.out.println("Apply Button Displayed");
		}else {
			throw new Exception("Error in Apply Button");
		}
	
	}
	
	public void verifyPlaceOrderButtonDisplayed() throws Throwable {
		if(driver.findElement(PlaceOrderbutton).isDisplayed()) {
			System.out.println("Place Order Button Displayed");
		}else {
			throw new Exception("Error in Place Order Button");
		}
	
	}
}
