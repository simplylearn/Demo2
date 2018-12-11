package com.test.objectMap;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMapping {
	
	
	 Properties prop;
	
	
	public ObjectMapping(String str)
	{
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(str);
			prop.load(fis);
			fis.close();
			
		}catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

	
	public  By getLocator(String element) throws Exception{
		
		
		String locator = prop.getProperty(element);
		
		String locatorKey = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		
		
		System.out.println(" REtriving key  " + locatorKey  +" Retriving value  "  + locatorValue);
		
		if(locatorKey.toLowerCase().equals("id"))
				return By.id(locatorValue);
		else if(locatorKey.toLowerCase().equals("name"))
				return By.name(locatorValue);
		else if(locatorKey.toLowerCase().equals("class"))
				return By.name(locatorValue);
		
		
		else
			throw new Exception("Unknown locator type '" + locatorKey + "'");
		
		
	}
	

}
