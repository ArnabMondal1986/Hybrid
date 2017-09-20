package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver Idriver){
		this.driver=Idriver;
	}
	
	@FindBy(linkText="Sign In") WebElement SignInLink;
	@FindBy(linkText="My Account") WebElement MyAccLink;
	@FindBy(linkText="My cart") WebElement MyCartLink;
	@FindBy(linkText="Checkout") WebElement CheckoutLink;
	
	public void ClickOnSignIn(){
		SignInLink.click();
	}
	
	public void ClickOnMyAccount(){
		MyAccLink.click();
	}
	
	public void ClickOnMyCart(){
		MyCartLink.click();
	}
	
	public void ClickOnCheckout(){
		CheckoutLink.click();
	}
	
	public String getApplicationTitle(){
		
		return driver.getTitle();
	}
}
