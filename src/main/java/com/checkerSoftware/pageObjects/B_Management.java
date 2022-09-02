package com.checkerSoftware.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;


public class B_Management extends BaseClass{
	
	public B_Management() {
		PageFactory.initElements(driver, this);
	}
	//--------------------General--------------------------------//
	@FindBy(xpath = "//a[text()=' Clients']") WebElement Clients;
	
	//-------------------Phone Surveys---------------------------//
	@FindBy(xpath = "//a[text()=' Surveys']") WebElement Surveys;
	@FindBy(xpath = "//a[text()=' Samples']") WebElement Samples;
	
	//-------------------Client Actions--------------------------//
	
	
	public BA_Manage_Clients clickOnClients() throws Throwable {
		try {
		Action.click(driver, Clients);
		 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new BA_Manage_Clients();
	}
	
	public BF_Manage_Surveys clickOnSurveys() throws Throwable {
		try {
		Action.click(driver, Surveys);
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new BF_Manage_Surveys();
	}
	
	public BG_ManageM_Samples clickOnSamples() throws Throwable {
		try {
		Action.click(driver, Samples);
		   
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new BG_ManageM_Samples();
	}
	
	
	
}
