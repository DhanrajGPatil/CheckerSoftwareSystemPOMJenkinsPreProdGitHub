package com.checkerSoftware.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class F_Reports extends BaseClass{
	public F_Reports() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Notifications report']") WebElement notificationReport;
	
	public FN_Notifiaction_Report clickOnNotificationReport() throws Throwable {
		Action.click(driver, notificationReport);
		return new FN_Notifiaction_Report();
	}

}
