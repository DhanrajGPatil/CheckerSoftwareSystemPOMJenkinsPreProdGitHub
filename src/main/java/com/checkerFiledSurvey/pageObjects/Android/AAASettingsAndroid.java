package com.checkerFiledSurvey.pageObjects.Android;
import com.checkerFiledSurvey.base.Android.baseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



public class AAASettingsAndroid extends baseTest{
	//driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
	
	

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='System URL']")
	private MobileElement SystemURL;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
	private MobileElement Save;
	
	
	
	public AAASettingsAndroid setSystemURL(String URL) 
	{
		sendKeys(SystemURL, URL);
		return this;
	}
	
	public AAASettingsAndroid ScrollToSave(String text) {
		scrollTo("Save");
		return this;
	}
	
	public AALoginPageAndroid clickOnSave() {
		click(Save);
		return new AALoginPageAndroid();
	}
	

	
}
