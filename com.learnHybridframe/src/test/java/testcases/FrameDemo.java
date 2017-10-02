package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FrameDemo {
	
	@Test
	public void testFrame(){
				
		WebDriver driver = new FirefoxDriver();
		
		Actions act= new Actions(driver);
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		driver.switchTo().frame("IF1");
		driver.findElement(By.xpath("//input[@type='radio'][@value='Female']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("iframe2");
		driver.findElement(By.id("ui-id-2")).click();;
		driver.switchTo().defaultContent();
		
		act.moveToElement
		(driver.findElement(By.className("menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-27920 has-children")))
		.build().perform();
		
	}

}
