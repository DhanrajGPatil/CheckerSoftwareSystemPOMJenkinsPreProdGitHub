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
		    
		Action.type(Password, prop.getProperty("passWordTesting"));
		   
		Action.click(driver, LOGIN);
		   
		}else if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			
		Action.type(Username, prop.getProperty("userNamePreprod"));
			 
		Action.type(Password, prop.getProperty("passWordPreprod"));
		    
		Action.click(driver, LOGIN);
		   
		}
		
		} catch (Exception e) {
			e.getStackTrace();
			
		}
		return new A_MainMenu();
	}	
}
