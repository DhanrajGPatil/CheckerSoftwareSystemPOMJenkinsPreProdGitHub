package com.checkerFiledSurvey.Utility.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidActions {
	AndroidDriver<AndroidElement> driver;
	public static final long WAIT =180;
	
	public AndroidActions(AndroidDriver<AndroidElement> driver)
	{
	this.driver	=driver;
	
	}
	

	public void scrollToText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
	}
}
