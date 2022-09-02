package com.checkerSoftware.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.BeforeTest;

import com.checkerSoftware.actionDriver.Action;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static Properties prop;
	public static WebDriver driver;
	 
    
	@BeforeTest
	public void loadConfig() {
		try {
			prop = new Properties();
			//FileInputStream fip = new FileInputStream("D:\\Checker_Auto\\Configuration\\Config.properties");
			FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+"/Configuration/Config.properties");
			prop.load(fip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			            
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void launchApp() {
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
		String browserName = prop.getProperty("browser");
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			              
		}else if(browserName.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	    }
		                   
		Action.implicitWait(driver, 15);
		Action.pageLoadTimeouts(driver, 15);
		driver.get(prop.getProperty("urlCheckerPreprod"));
		                  
		driver.manage().window().maximize();
     }	
		else if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
			String browserName = prop.getProperty("browser");
			if(browserName.contains("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(browserName.contains("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
		    }
			                
			Action.implicitWait(driver, 15);
			Action.pageLoadTimeouts(driver, 15);
			driver.get(prop.getProperty("urlCheckerTesting"));
			                
			driver.manage().window().maximize();
	     }	
		}
	
	

	public static void launchAppOffice() {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
	    
		
		Action.implicitWait(driver, 15);
		Action.pageLoadTimeouts(driver, 15);
		driver.get("https://www.office.com/");
		
		driver.manage().window().maximize();
     }
	public static void launchAppDemo() {
		String browserName = prop.getProperty("browser");
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	    }
		
		Action.implicitWait(driver, 120);
		Action.pageLoadTimeouts(driver, 120);
		driver.get(prop.getProperty("urlCheckerTesting"));
		
		driver.manage().window().maximize();
     }	
	
	
	
	
}
