package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider{
	
	WebDriver driver;
	
	@BeforeMethod
	public void startMethod(){
		
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test(dataProvider="value")
	public void Login(String username, String password){
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		WebElement ele =driver.findElement(By.name("xhpc_message"));
		Assert.assertNotNull(ele);
	}
	
	//@DataProvider(name="value")
	public Object[][] passData(){
		
		Object[][] obj = new Object[3][2];
		obj[0][0]="rupadebnath87@gmail.com";
		obj[0][1]="rupa_infosys";
		obj[1][0]="rupa";
		obj[1][1]="rupa_infosys";
		obj[2][0]="rupadebnath87@gmail.com";
		obj[2][1]="rupa";
		return obj;		
	}
}
