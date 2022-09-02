package com.checkerFiledSurvey.base.Android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.checkerFiledSurvey.pageObjects.Android.AAASettingsAndroid;
import com.checkerFiledSurvey.pageObjects.Android.HomePageAndroid;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseAndroid {
	
	public static Properties prop;
	public AndroidDriver<AndroidElement> driver;
	public HomePageAndroid homePage;
	
	@BeforeClass
	public static AndroidDriver getAndroidDriver() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = null;
		try {
		File appdir = new File("sAPK");
		File app = new File(appdir,"CheckerFieldSurveyor.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "O8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        //https://eu.checker-soft.com/preproduction/login.php
        //https://eu.checker-soft.com/testing/
        /*
        driver.findElementByXPath("//android.widget.EditText[@text='System URL']").sendKeys("https://eu.checker-soft.com/testing/");
        Thread.sleep(2000);
        driver.hideKeyboard();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save\"))");
        driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
        String userName = "RajTesting";
		driver.findElementByXPath("//android.widget.EditText[@text='User Name']").sendKeys(userName);
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(userName);
		driver.findElementByXPath("//android.widget.Button[@text='Sign in']").click();
		*/
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	@BeforeTest
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream("C:\\eclipse-workspace\\CheckerAndroidPractice\\Data\\Capi_Survey_Data.properties");
			prop.load(fip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			             System.out.println("Properties File Not Found");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
