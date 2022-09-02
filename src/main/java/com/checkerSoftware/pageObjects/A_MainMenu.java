package com.checkerSoftware.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;


public class A_MainMenu extends BaseClass{
	public A_MainMenu() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Main menu']") WebElement MainMenu;
	
	@FindBy(xpath = "//a[text()='Management']") WebElement Management;
	
	@FindBy(xpath = "//a[text()='Questionnaires']") WebElement Questionnaires;
	
	@FindBy(xpath = "//a[text()='CheckerTificate']") WebElement CheckerTificate;
	
	@FindBy(xpath = "//a[text()='Operation']") WebElement Operation;
	
	@FindBy(xpath = "//a[text()='Reports']") WebElement Reports;
	
	@FindBy(xpath = "//a[text()='Import']") WebElement Import;
	
	@FindBy(xpath = "//a[text()='User guides']") WebElement UserGuides;
	
	@FindBy(xpath = "//a[text()='Settings']") WebElement Settings;
	
	@FindBy(xpath = "//a[text()='Log off']") WebElement LogOff;
	
	public B_Management clickOnManagement() throws Throwable {
		try {
		Action.click(driver, Management);
		    
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new B_Management();
	}
	
	public C_Questionnaires clickOnQuestionnaires() throws Throwable {
		Action.click(driver, Questionnaires);
		return new C_Questionnaires();
	}
	
	public D_Checkertificate clickOnCheckerTificate() throws Throwable {
		Action.click(driver, CheckerTificate);
		return new D_Checkertificate();
	}
	
	public E_Operation clickOnOperation() throws Throwable {
		try {
		Action.click(driver, Operation);
		   
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new E_Operation();
	}
	
	public F_Reports clickOnReports() throws Throwable {
		try {
		Action.click(driver, Reports);
		   
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new F_Reports();
	}
	
	public G_Import clickOnImport() throws Throwable {
		Action.click(driver, Import);
		return new G_Import();
	}
	
	public H_UserGuides clickOnUserGuides() throws Throwable {
		Action.click(driver, UserGuides);
		return new H_UserGuides();
	}
	
	public I_Settings clickOnUserSettings() throws Throwable {
		Action.click(driver, Settings);
		return new I_Settings();
	}
	
	public J_LogOff clickOnUserLogOff() throws Throwable {
		Action.click(driver, LogOff);
		return new J_LogOff();
	}
	
	
	
}

