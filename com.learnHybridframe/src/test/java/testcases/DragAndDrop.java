package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
	
	public static void main(String[] arg) throws Exception{
	
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Actions act=new Actions(driver);
	WebElement src = driver.findElement(By.id("draggable"));
	WebElement trgt=driver.findElement(By.id("droppable"));
	act.dragAndDrop(src, trgt).build().perform();
	driver.quit();
	}
}
