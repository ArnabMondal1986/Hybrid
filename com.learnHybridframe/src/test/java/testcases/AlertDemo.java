package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertDemo {
	
	@Test
	public void alertHandle() throws Exception{
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.ksrtc.in/oprs-web/");
		
		driver.findElement(By.cssSelector("input[id='searchBtn'][name='searchBtn']")).click();
		
		Thread.sleep(5000);
		
		String s=driver.switchTo().alert().getText();
		
		System.out.println(s);
		
		Assert.assertEquals("Please select start place.",s);
		
		driver.switchTo().alert().accept();
	}

}
