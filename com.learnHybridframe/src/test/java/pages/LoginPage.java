package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver Idriver){
		this.driver=Idriver;
	}
	
	@FindBy(id="account_sign_in_form_email_id") WebElement email;
	
	@FindBy(name="passwd") WebElement password;
	
	@FindBy(css="input[type='submit']") WebElement SignIn;
	
	@FindBy(linkText="Sign Out") WebElement SignOut;
	
	public void ClickOnSignIn(){
		SignIn.click();
	}
	
	public void loginApplication(String emailId, String pass){
		email.sendKeys(emailId);
		password.sendKeys(pass);
		ClickOnSignIn();	
	}
	
    public void verifySignOutLink(){
    	WebElement Element1 = (new WebDriverWait(driver, 10))
  			  .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign Out")));
    	
    	String strg=Element1.getText();
    	Assert.assertEquals(strg, "Sign Out");
    }
	
}
