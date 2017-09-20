package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPage {

WebDriver driver;
ExtentReports report;
ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
	
	driver=BrowserFactory.getBrowser("firefox");
		
	driver.get(DataProviderFactory.getConfig().getApplicationUrl());//open URL link
	}
	
	@Test
	public void testLoginPage(){
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Demo Store"));
		
		home.ClickOnSignIn();
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 1, 0));
		
		login.verifySignOutLink();
	}
	
	@AfterMethod
	
	public void tearDown(){
		
	BrowserFactory.closeBrowser(driver);
	
	}
}
