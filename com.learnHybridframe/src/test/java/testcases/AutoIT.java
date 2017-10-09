package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoIT {
	
	WebDriver driver;

	@Test(enabled=false, groups={"Regression"})
	public void upload() throws Exception{
		
		driver = new FirefoxDriver();
		driver.get("https://www.indeed.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Upload your resume")).click();
		
		driver.findElement
		(By.cssSelector(".splash-upload-btn.btn.sg-btn.sg-btn-primary.sg-btn-block")).click();
		
		Thread.sleep(2000);
		
		Runtime.getRuntime().exec("C:\\Users\\Rupa\\Desktop\\Selenium\\AutoITNew\\Upload.exe");
	}
	
	@Test(groups={"Smoke"})
	public void authenticate() throws Exception{
		
	driver = new FirefoxDriver();
	driver.get("https://www.engprod-charter.net/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(2000);
	
	Runtime.getRuntime().exec("C:\\Users\\Rupa\\Desktop\\Selenium\\AutoITNew\\AuthenticateUrl.exe");
	}
}
