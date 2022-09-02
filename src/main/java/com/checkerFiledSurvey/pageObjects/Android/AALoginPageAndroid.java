package com.checkerFiledSurvey.pageObjects.Android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.checkerFiledSurvey.Utility.Android.AndroidActions;
import com.checkerFiledSurvey.base.Android.BaseAndroid;
import com.checkerFiledSurvey.base.Android.baseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AALoginPageAndroid extends baseTest{

	//driver.findElementByXPath("//android.widget.EditText[@text='User Name']").sendKeys(userName);
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='User Name']")
	private MobileElement UserName;
	
	//driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(userName);
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
	private MobileElement Password;
	
	//driver.findElementByXPath("//android.widget.Button[@text='Sign in']").click();
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Sign in']")
	private AndroidElement SignIn;
	
	public AALoginPageAndroid setUserName(String textUser) {
		sendKeys(UserName, textUser);
		return this;
	}
	
	public AALoginPageAndroid setPassWord(String textpass) {
		sendKeys(Password, textpass);
		return this;
	}
	
	public HomePageAndroid clickSignIn() {
		click(SignIn);
		return new HomePageAndroid();
	}
	
	
	
	
	
}
