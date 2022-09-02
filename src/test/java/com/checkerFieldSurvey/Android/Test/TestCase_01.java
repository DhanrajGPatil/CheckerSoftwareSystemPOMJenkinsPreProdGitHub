package com.checkerFieldSurvey.Android.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.checkerSoftware.base.BaseClass;
import com.checkerSoftware.pageObjects.A_LoginPage;
import com.checkerSoftware.pageObjects.A_MainMenu;
import com.checkerSoftware.pageObjects.E_Operation;
import com.checkerSoftware.pageObjects.Ef_Operation_FieldSurvey;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCase_01 extends BaseClass{
	public static String Question_2_OptionSelectedInApp_Choice_1;
	public static String Question_2_OptionSelectedInApp_Choice_2;
	public static String Question_1_OptionSelectedInApp;
	public static ArrayList<Integer> Allocation_Quota_From_server;
	public static Integer InProgressCountOld;
	A_LoginPage loginPage;
	A_MainMenu mainMenu;
	E_Operation operation;
	Ef_Operation_FieldSurvey fieldSurvey;
	
	@Test(priority=0)
	public void get_Allocation_And_Quota_from_Server() throws Throwable {
		launchApp();
		loginPage = new A_LoginPage();
		mainMenu = loginPage.Login();
		Allocation_Quota_From_server = new ArrayList<Integer>();
		operation = mainMenu.clickOnOperation();
		fieldSurvey = operation.clickFieldSurvey();
		Allocation_Quota_From_server = fieldSurvey.getAllocation_SurveyCount_LeftToDo();
		System.out.println("The allocations and quota from server are:- ");
		System.out.println("Allocation_Server:- "+Allocation_Quota_From_server.get(0));
		System.out.println("Survey_count_Server:- "+Allocation_Quota_From_server.get(1));
		System.out.println("Left_to_do_Server:- "+Allocation_Quota_From_server.get(2));
		driver.quit();
		
		
		}
	
	
	
	@Test(priority=1)
	public void Validate_allocation_and_Quota_matchwith_Server() throws InterruptedException, MalformedURLException {
		File appdir = new File("sAPK");
		File app = new File(appdir,"CheckerFieldSurveyor.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "O8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        
       
        if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
        driver.findElementByXPath("//android.widget.EditText[@text='System URL']").sendKeys(prop.getProperty("urlCheckerPreprod"));
        }if (prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
            driver.findElementByXPath("//android.widget.EditText[@text='System URL']").sendKeys(prop.getProperty("urlCheckerTesting"));
            }
        Thread.sleep(2000);
        driver.hideKeyboard();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Save\"))");
        driver.findElementByXPath("//android.widget.Button[@text='Save']").click();        
        
		Thread.sleep(2000);
		
		String userName = "RajTesting";
		driver.findElementByXPath("//android.widget.EditText[@text='User Name']").sendKeys(userName);
		driver.findElementByXPath("//android.widget.EditText[@text='Password']").sendKeys(userName);
		driver.findElementByXPath("//android.widget.Button[@text='Sign in']").click();
		
		//Language -Cancal
		driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
		
		//Assigned tab
				driver.findElement(By.id("com.mor.sa.android.activities:id/layout_tab_one")).click();
				
				//Select_Survey
				driver.findElement(By.xpath("//android.widget.TextView[@text='AutoDemo_CAPI_Updated']")).click();
				// Get Allocations and quota Remaining
				
				String allocation = driver.findElements(By.id("com.mor.sa.android.activities:id/text1")).get(4).getText();
				System.out.println(allocation);
				int[] allocations = quota(allocation);
				System.out.println("  Interviews remaining_Android  :- "+allocations[0]);
				System.out.println("  Interviews Done_Android       :- "+allocations[1]);
				System.out.println("  Interviews Allocate_Android   :- "+allocations[2]);
			
				Assert.assertEquals(allocations[2], Allocation_Quota_From_server.get(0));
				Assert.assertEquals(allocations[1], Allocation_Quota_From_server.get(1));
				Assert.assertEquals(allocations[0], Allocation_Quota_From_server.get(2));
				
				//Back to jobList
			    driver.findElement(By.id("com.mor.sa.android.activities:id/rejectbtn")).click();
			    driver.quit();
			   
			    
		}
	
	public static  int[] quota(String a) {
        int[] I = new int[3]; 
		
		String[] a1 =  a.split(" ");
		//System.out.println(a1[0]);
		
		int quotaRemaining = Integer.parseInt(a1[0]);
		I[0]= quotaRemaining;
		//System.out.println(a1[1]);
		
		String a1new = a1[1].replace("(", "");
		String a1new1 = a1new.replace(")", "");
		//System.out.println(a1new1);
		String[] a1new11 =  a1new1.split("/");
		//System.out.println(a1new11[0]);
		int quotaDone = Integer.parseInt(a1new11[0]);
		I[1]= quotaDone ;
		//System.out.println(a1new11[1]);
		int quotaAllocate = Integer.parseInt(a1new11[1]);
		I[2]= quotaAllocate ;
		
		return I;
	}

}
