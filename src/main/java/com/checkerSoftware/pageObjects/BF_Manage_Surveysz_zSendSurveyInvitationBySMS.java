package com.checkerSoftware.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class BF_Manage_Surveysz_zSendSurveyInvitationBySMS extends BaseClass{

	public BF_Manage_Surveysz_zSendSurveyInvitationBySMS() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='go']") WebElement send;
	@FindBy(xpath = "//a[text()='Notifications report']") WebElement notificationReport;
	@FindBy(xpath = "//a[text()='Back to main menu']") WebElement backToMainMenu;
	
	
	public FN_Notifiaction_Report validatePhoneNumber_and_sendSMSSurvey() throws Throwable {
		
		//---------------Send Invitation------------------------------//
		List<WebElement> invitation_Samples_Row = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr"));
		for(int e=1; e<=invitation_Samples_Row.size(); e++) {
			WebElement samples = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(e)+"]/td[9]"));
			if(samples.getText().equalsIgnoreCase(prop.getProperty("phoneNumber"))) {
				WebElement sample_Click = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(e)+"]/td[1]/input"));
				sample_Click.click();
				//--------Here we click Send option-------------------//
				Action.click(driver, send);
				
			break;
			}
		}	
		Action.click(driver, notificationReport);
		return new FN_Notifiaction_Report();
	}
}
