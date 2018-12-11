package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.properties.GetProperties;

import com.test.objectMap.ObjectMapping;

public class TestClass {

	public GetProperties gp;

	WebDriver driver;
	ObjectMapping obj = new ObjectMapping("objectmap.properties");

	@BeforeTest
	public void beforeTest() throws Exception {

		String path = System.getProperty("user.dir");
		// +"/src/main/resources/drivers/chromedriver"
		System.setProperty("webdriver.gecko.driver", path + "\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.get(gp.getProperty("url"));
		Thread.sleep(1000);

	}

	@Test
	public void Test() throws Exception {

		WebElement element = driver.findElement(obj.getLocator("bing.homepage.textbox"));
		element.sendKeys(gp.getProperty("searchString"));

		// Retrieve search button from object map and click it
		element = driver.findElement(obj.getLocator("bing.homepage.searchbutton"));
		element.click();

		// Retrieve number of search results using results object from object map
		// element = driver.findElement(obj.getLocator("bing.resultspage.results"));
		// System.out.println("Search result string: " + element.getText());
		//

		// System.out.println("Error during test execution:\n" + e.toString());
Thread.sleep(4000);
	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();

	}

}
