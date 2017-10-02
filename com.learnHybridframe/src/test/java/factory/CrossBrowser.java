package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
		
		@Test
		@Parameters("Browser")
		public void getBrowser(String browser){
			
			if(browser.equalsIgnoreCase("firefox")){
				
				WebDriver driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get("http://www.facebook.com");
				
				driver.findElement(By.id("email")).click();
				driver.findElement(By.id("email")).clear();
				driver.findElement(By.id("email")).sendKeys("rupa.debnath1987@gmail.com");
				
				driver.findElement(By.id("pass")).click();
				driver.findElement(By.id("pass")).clear();
				driver.findElement(By.id("pass")).sendKeys("rupa_infosys");
				driver.quit();
			}
			
			else if(browser.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
		        //options.addArguments("--test-type");
		        options.addArguments("--disable-extensions");
				WebDriver driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.get("http://www.facebook.com");
				
				driver.findElement(By.id("email")).click();
				driver.findElement(By.id("email")).clear();
				driver.findElement(By.id("email")).sendKeys("rupa.debnath1987@gmail.com");
				
				driver.findElement(By.id("pass")).click();
				driver.findElement(By.id("pass")).clear();
				driver.findElement(By.id("pass")).sendKeys("rupa_infosys");
				driver.quit();
			}
			
			else if(browser.equalsIgnoreCase("ie")){
				
				System.setProperty("webdriver.ie.driver","C:\\Drivers\\IEDriverServer.exe");
				WebDriver driver=new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.get("http://www.facebook.com");
				
				driver.findElement(By.id("email")).click();
				driver.findElement(By.id("email")).clear();
				driver.findElement(By.id("email")).sendKeys("rupa.debnath1987@gmail.com");
				
				driver.findElement(By.id("pass")).click();
				driver.findElement(By.id("pass")).clear();
				driver.findElement(By.id("pass")).sendKeys("rupa_infosys");
				driver.quit();
			}
			
		}

}
