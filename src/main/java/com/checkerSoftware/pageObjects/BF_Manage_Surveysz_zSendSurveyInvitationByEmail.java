package com.checkerSoftware.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class BF_Manage_Surveysz_zSendSurveyInvitationByEmail extends BaseClass{
	
	public BF_Manage_Surveysz_zSendSurveyInvitationByEmail() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='go']") WebElement send;
	
	
	
	public void conform_Sample_and_Select_properSample() {
		List<WebElement> samples_List = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr"));
		for(int a=0; a<samples_List.size(); a++) {
			System.out.println("Checking samples with BranchName, Region, ContactName, PhoneNumber, Email");
			WebElement branchLink = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td[9]"));
			WebElement BranchName = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td[9]"));
			WebElement region = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td[10]"));
			WebElement contactName = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td[11]"));
			WebElement phoneNumber = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td[12]"));
			WebElement emailForSurveying = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td[13]"));
			if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
			     if(branchLink.getText().equalsIgnoreCase(prop.getProperty("sampleBranchID")) && region.getText().equalsIgnoreCase(prop.getProperty("sampleRegion")) && contactName.getText().equalsIgnoreCase(prop.getProperty("sampleContactName")) && phoneNumber.getText().equalsIgnoreCase(prop.getProperty("samplephoneNumber")) && emailForSurveying.getText().equalsIgnoreCase(prop.getProperty("sampleEmail"))) {
			         	WebElement select_Sample = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td[1]/input"));
			          	System.out.println("Sample found, select Sample");
			        	select_Sample.click();
			        	break;
			}
			}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
				if(BranchName.getText().equalsIgnoreCase(prop.getProperty("sampleBranchName")) && region.getText().equalsIgnoreCase(prop.getProperty("sampleRegion")) && contactName.getText().equalsIgnoreCase(prop.getProperty("sampleContactName")) && phoneNumber.getText().equalsIgnoreCase(prop.getProperty("samplephoneNumber")) && emailForSurveying.getText().equalsIgnoreCase(prop.getProperty("sampleEmail"))) {
		         	WebElement select_Sample = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td[1]/input"));
		         	System.out.println("Sample found, select Sample");
		        	select_Sample.click();
		        	break;
		}
				
			}
			
			
		}
		
	}
	
	public void send_Invitation() throws Throwable {
		System.out.println("Click send Survey button");
		Action.click(driver, send);
	}
	
	public void close_Driver() {
		driver.quit();
	}

	public void validateEmail_and_sendEmailSurvey() throws Throwable {
		List<WebElement> email_List = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr/td[13]"));
		for(int a=0; a<email_List.size(); a++) {
			WebElement email = email_List.get(a);
			
			if(email.getText().equalsIgnoreCase(prop.getProperty("email"))) {
				
				
				driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(a+1)+"]/td/input")).click();
				
				
				break;
			}
		}
		Action.click(driver, send);
		driver.quit();
		
	}
	
}
