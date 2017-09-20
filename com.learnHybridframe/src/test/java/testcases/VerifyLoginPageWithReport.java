package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LoginPage;

public class VerifyLoginPageWithReport {

WebDriver driver;

ExtentReports reports;
ExtentTest logger;
	
	@BeforeMethod
	public void setUp(){
		
	reports= new ExtentReports("C:\\Users\\Rupa\\workspace\\com.learnHybridframe\\Reports\\LoginPageReport.html", true);
	
	logger=reports.startTest("Verify test login");
		
	driver=BrowserFactory.getBrowser("firefox");
		
	driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	
	logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testLoginPage(){
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("Demo Store"));
		
		logger.log(LogStatus.PASS, "Home Page loaded and verified");
		
		home.ClickOnSignIn();
		
		logger.log(LogStatus.INFO, "Clicked on SignOut link");
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 1, 0));
		
		logger.log(LogStatus.INFO, "Login to application");
		
		login.verifySignOutLink();
		
		logger.log(LogStatus.PASS, "Verified SignOut link");
	}
	
	@AfterMethod
	
	public void tearDown(){
		
	BrowserFactory.closeBrowser(driver);
	reports.endTest(logger);
	reports.flush();
	}
}
