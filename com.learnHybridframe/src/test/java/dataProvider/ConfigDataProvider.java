package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties p;
	
	public ConfigDataProvider(){
		
		//File src= new File("C:\\Users\\Rupa\\workspace\\com.learnHybridframe\\Configuration\\config.properties");
		File src= new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			p=new Properties();
			p.load(fis);
		} 
		
		catch (Exception e)
		{System.out.println("Exception is "+e.getMessage());
		}
	}
    
	public String getApplicationUrl(){
		return p.getProperty("url");
	}
	
	public String getChromePath(){
		return p.getProperty("chromePath");
	}
	
	public String getIEPath(){
		return p.getProperty("IEPath");
	}

}
