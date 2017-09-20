package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	public static WebDriver getBrowser(String browser){
		
		if(browser.contains("firefox") || browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}
		
		if(browser.contains("ie") || browser.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver",DataProviderFactory.getConfig().getIEPath());
			driver= new InternetExplorerDriver();
		}
		
		if(browser.contains("chrome") || browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--test-type");
	        options.addArguments("--disable-extensions");
			driver= new ChromeDriver(options);
		}
		
		//driver.get(config.getApplicationUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser(WebDriver Idriver){
		Idriver.quit();
	}

}
