package com.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
	
	
public static String getProperty (String propName) {
		
		String propValue = "";
		
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			input = new FileInputStream("selenium.properties");

			prop.load(input);
			propValue = prop.getProperty(propName);
			System.out.println("Property value: " + propValue);
			

		}
		catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return propValue;
	}

}
