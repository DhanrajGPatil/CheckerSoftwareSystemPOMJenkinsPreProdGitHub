package com.checkerFiledSurvey.base.Android;

import org.testng.annotations.BeforeTest;

import com.checkerFiledSurvey.Utility.Android.AndroidActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class baseTest {
	protected static AppiumDriver driver;
	protected static Properties prop;
	InputStream inputStream;

	public baseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@BeforeTest
	public void beforeTest() throws Exception {
		try {
			prop = new Properties();
			String propFileName = "ConfigAndroid.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			
			File appdir = new File("sAPK");
			File app = new File(appdir, "CheckerFieldSurveyor.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "O8.1");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			// capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
			// "uiautomator2");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		// TODO Auto-generated method stub
				File appdir = new File("sAPK");
				File app = new File(appdir,"ApiDemos-debug (1).apk");
				DesiredCapabilities cap = new DesiredCapabilities();
		       // cap.setCapability(MobileCapabilityType.DEVICE_NAME, "P2");
		        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		        //cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		        */
	}

	public void waitForVisiblity(MobileElement e) {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void click(MobileElement e) {
		waitForVisiblity(e);
		e.click();
	}
	
	public void sendKeys(MobileElement e, String text) {
		waitForVisiblity(e);
		e.sendKeys(text);
	}
	
	public void getAttribute(MobileElement e, String attribute) {
		waitForVisiblity(e);
		e.getAttribute(attribute);
	}
	
	public void scrollTo(String text) {
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\" "+ text +" \"))");
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
