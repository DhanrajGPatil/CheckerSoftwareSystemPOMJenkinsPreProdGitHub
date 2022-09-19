package com.checkerSoftware.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;


public class A_LoginPage extends BaseClass {
	
	
	public A_LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']") WebElement Username;
	
	@FindBy(xpath = "//input[@name='password']") WebElement Password;
	
	@FindBy(id = "do_login") WebElement LOGIN;
	
	public A_MainMenu Login() throws Throwable {
		try {
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
			
		Action.type(Username, prop.getProperty("userNameTesting"));
		System.out.println("Driver Enter's the UserName for Testing Enviornment");
		    
		Action.type(Password, prop.getProperty("passWordTesting"));
		System.out.println("Driver Enter's the Password for Testing Enviornment");
		   
		Action.click(driver, LOGIN);
		System.out.println("Driver Click's the login button");
		   
		}else if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			
		Action.type(Username, prop.getProperty("userNamePreprod"));
		System.out.println("Driver Enter's the UserName for PreProduction Enviornment");
			 
		Action.type(Password, prop.getProperty("passWordPreprod"));
		System.out.println("Driver Enter's the Password for PreProduction Enviornment");
		    
		Action.click(driver, LOGIN);
		System.out.println("Driver Click's the login button");
		   
		}
		
		} catch (Exception e) {
			e.getStackTrace();
			
		}
		return new A_MainMenu();
	}	
}
