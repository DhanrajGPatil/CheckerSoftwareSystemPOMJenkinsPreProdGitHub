package com.checkerSoftware.pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class BG_ManageMT_Samples_EditSamplesRows_AddNewRow extends BaseClass{
	public BG_ManageMT_Samples_EditSamplesRows_AddNewRow() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@name='field_BranchName']") WebElement BranchName;
	@FindBy(xpath = "//input[@name='field_Region']") WebElement Region;
	@FindBy(xpath = "//input[@name='field_ContactName']") WebElement ContactName;
	@FindBy(xpath = "//input[@name='field_PhoneNumber']") WebElement phoneNumber;
	@FindBy(xpath = "//input[@name='field_EmailForSurveying']") WebElement EmailForSurveying;
	@FindBy(xpath = "//*[@name='field_LinkedBranchName']/following-sibling::button//span[@class='ui-icon ui-icon-triangle-2-n-s']") WebElement linkedBranchDownArrow;
	
	@FindBy(xpath = "//input[@name='field_SmpRowID']") WebElement sampleRowID;
	@FindBy(xpath = "//input[@name='addnew']") WebElement addButton;
	
	
	public void enterBranchName() throws Throwable {
		try {
			if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
		
		Action.type(BranchName, prop.getProperty("sampleBranchName"));
			} 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public void enterRegion() throws Throwable {
		Action.type(Region, prop.getProperty("sampleRegion"));
	}
	public void enterContactName() throws Throwable {
		Action.type(ContactName, prop.getProperty("sampleContactName"));
	}
	
	public void enterPhoneNumber() throws Throwable {
		Action.type(phoneNumber, prop.getProperty("samplephoneNumber"));
	}
	
	public void enterEmail() throws Throwable {
		Action.type(EmailForSurveying, prop.getProperty("sampleEmail"));
	}
	
	public void selectBranch() throws Throwable {
		try {
			if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		Action.click(driver, linkedBranchDownArrow);
		List<WebElement> branchList = driver.findElements(By.xpath("(//ul[@class='ui-multiselect-checkboxes ui-helper-reset'])[2]/li/label/span"));
		for(WebElement branch : branchList) {
			System.out.println(branch.getText());
			if(branch.getText().equalsIgnoreCase(prop.getProperty("sampleBranchName"))) {
				branch.click();
				break;
			}
		}
			} 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void enterSampleRowID() throws Throwable {
		try {
			if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		Random rand = new Random();
		Integer sampleRowIDInt = rand.nextInt(1000000);
		String sampleRowIDString = Integer.toString(sampleRowIDInt);
		Action.type(sampleRowID, sampleRowIDString);
			} 
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public BG_ManageMT_Samples_EditSampleRows clickAddButton() throws Throwable {
		Action.click(driver, addButton);
		return new BG_ManageMT_Samples_EditSampleRows();
	}
	
}
