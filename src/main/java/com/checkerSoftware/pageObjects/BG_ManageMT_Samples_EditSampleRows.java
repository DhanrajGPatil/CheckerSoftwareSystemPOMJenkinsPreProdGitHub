package com.checkerSoftware.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;


public class BG_ManageMT_Samples_EditSampleRows extends BaseClass{
	
	public BG_ManageMT_Samples_EditSampleRows() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn-input']") WebElement addNewRow;
	@FindBy(xpath = "//a[text()='Back to main menu']") WebElement backToMainMenu;
	
	public BG_ManageMT_Samples_EditSamplesRows_AddNewRow clickOnaddNewRow() throws Throwable {
		
		Action.click(driver, addNewRow);
		System.out.println("Driver Click's Add New Row Tab");
		  
		
		return new BG_ManageMT_Samples_EditSamplesRows_AddNewRow();
	}
	
	public A_MainMenu clickONBackTOMainMenu() throws Throwable {
		
		Action.click(driver, backToMainMenu);
		System.out.println("Driver Click's Back to Main Menu Tab");
		  
		
		return new A_MainMenu();
	}
}
