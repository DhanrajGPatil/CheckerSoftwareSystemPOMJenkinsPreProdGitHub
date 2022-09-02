package qa.checkerField.Base;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class BaseTest {
	AndroidDriver driver;
	
  @Test
  public void config() throws InterruptedException {
	  //https://eu.checker-soft.com/preproduction/login.php
      //https://eu.checker-soft.com/testing/
      
      driver.findElementByXPath("//android.widget.EditText[@text='System URL']").sendKeys("https://eu.checker-soft.com/testing/");
      Thread.sleep(2000);
      driver.hideKeyboard();
      driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save\"))");
      driver.findElementByXPath("//android.widget.Button[@text='Save']").click();
      Thread.sleep(2000);
      String userName = "RajTesting";
	  driver.findElementByXPath("//android.widget.EditText[@text='User Name']").sendKeys(userName);
	  driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(userName);
	  driver.findElementByXPath("//android.widget.Button[@text='Sign in']").click();
  }
  @BeforeClass
  public void beforeClass() throws Exception  {
	  
		File appdir = new File("sAPK");
		File app = new File(appdir,"CheckerFieldSurveyor.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "O8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(10000);
	  driver.quit();
  }

}
