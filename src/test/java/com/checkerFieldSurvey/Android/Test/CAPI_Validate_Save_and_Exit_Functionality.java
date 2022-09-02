package com.checkerFieldSurvey.Android.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.checkerSoftware.base.BaseClass;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class CAPI_Validate_Save_and_Exit_Functionality extends BaseClass{
	public static String Question_1_OptionSelectedInApp;
	public static String Question_2_OptionSelectedInApp_Choice_1;
	public static String Question_2_OptionSelectedInApp_Choice_2;
	public static int InProgressCount;
	public static String fileWeGetFromSaveAndExitInProgressTab;
	
	public static ArrayList<String> fileWeGetFromSaveAndExitAssignedTab;
	public static ArrayList<String> fileWeGetFromSaveAndExitInProgressTabfullString;
	
	@Test
	public void Validate_Save_and_Exit() throws InterruptedException, MalformedURLException {
		InProgressCount=0;
		fileWeGetFromSaveAndExitAssignedTab = new ArrayList<String>();
		fileWeGetFromSaveAndExitInProgressTabfullString = new ArrayList<String>();
		
		
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
	
	//validate_Save_And_Exit_Functionality
	//Assigned tab
			driver.findElement(By.id("com.mor.sa.android.activities:id/layout_tab_one")).click();
			
			//Select_Survey
			driver.findElement(By.xpath("//android.widget.TextView[@text='AutoDemo_CAPI_Updated']")).click();
			
			//Begin Interviews
			driver.findElement(By.id("com.mor.sa.android.activities:id/acceptbtn")).click();
			
			Thread.sleep(3000);
			//for Hyundai
			//driver.findElements(By.xpath("//android.widget.ImageView")).get(0).click();
			//Mahindra
			//driver.findElements(By.xpath("//android.widget.ImageView")).get(1).click();
			//Toyota
			//driver.findElements(By.xpath("//android.widget.ImageView")).get(2).click();
			//Tata
			//driver.findElements(By.xpath("//android.widget.ImageView")).get(3).click();
			
			Random rand = new Random();
			int optionChoice = rand.nextInt(3);
			driver.findElements(By.xpath("//android.widget.ImageView")).get(optionChoice).click();
			if(optionChoice==0) {
				Question_1_OptionSelectedInApp = "HYUNDAI";
				System.out.println("Question_1_OptionSelectedInApp :-"+Question_1_OptionSelectedInApp);
			}if(optionChoice==1) {
				Question_1_OptionSelectedInApp = "MAHINDRA";
				System.out.println("Question_1_OptionSelectedInApp :-"+Question_1_OptionSelectedInApp);
			}if (optionChoice==2) {
				Question_1_OptionSelectedInApp = "Toyota";
				System.out.println("Question_1_OptionSelectedInApp :-"+Question_1_OptionSelectedInApp);
			}if (optionChoice==3) {
				Question_1_OptionSelectedInApp = "TATA";
				System.out.println("Question_1_OptionSelectedInApp :-"+Question_1_OptionSelectedInApp);
			}
			
			
			Thread.sleep(2000);
			//Click- Information- Mandatory files
			driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		    //Click Select Files
			//For multiple camera images To select from PropertiesFiles
			//String cameraImagesString = prop.getProperty("NoOfCameraImages");
			//int cameraImages = (Integer.parseInt(cameraImagesString)+1);
			//scrollIteration = cameraImages*18;
			int cameraImages=1;
			if(cameraImages>0) {
			for (int i=0; i<cameraImages; i++) {
			driver.findElement(By.xpath("//android.widget.ImageButton")).click();
			              //0) Click Camera  Camera
			              driver.findElement(By.xpath("//android.widget.TextView[@text='Camera']")).click();
			              // Take Image
			              driver.findElement(By.id("com.mor.sa.android.activities:id/btnCapture")).click();
			              // Click to Yes
			              driver.findElement(By.id("com.mor.sa.android.activities:id/btnTick")).click();
			              Thread.sleep(2000);
		                                     	}
			}
		     
		     
		     //Click Select Files
			 // For Video
		     /*
		    int videoRecordTime = 4;
		    int numberOfVideos = 1;
		    for (int i=0; i<numberOfVideos; i++) {
			                  driver.findElement(By.xpath("//android.widget.ImageButton")).click();              
				              //1) Click Video
				              driver.findElement(By.xpath("//android.widget.TextView[@text='Video']")).click();
				              // To Start Video
				              driver.findElement(By.id("//com.android.camera:id/v9_shutter_button_internal")).click();
				                   // Wait Till
				                   Thread.sleep(videoRecordTime);
				              // To pause video
				              driver.findElement(By.id("//com.android.camera:id/v9_shutter_button_internal")).click();
				              // To Save 
				              driver.findElement(By.id("com.android.camera:id/inten_done_apply")).click();
				              Thread.sleep(2000);
		                                         }
			*/
			
		    //Click Select Files
			// For Gallery Images
			driver.findElement(By.xpath("//android.widget.ImageButton")).click();              
			              //1) Click Gallery
			              driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']")).click();
			              // To Choose File
			              // To scroll 
		                  // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"com.checker.Logs\"))");
		                  // or
		                  String containedText = "CheckerCAPI";
			              driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
		                  //To select CheckerCAPI
		                  driver.findElement(By.xpath("//android.widget.TextView[@text='CheckerCAPI']")).click();
		                  // To select image as per Answer selected for question 1 
		                  Thread.sleep(3000);
		                  driver.findElement(By.xpath("//android.widget.TextView[@text='"+Question_1_OptionSelectedInApp+".jpg']")).click();
		                  String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		                  String[] toastMessageSplited = toastMessage.split(" ");
		                  String toastMessageNeeded = toastMessageSplited[2];
		                  fileWeGetFromSaveAndExitAssignedTab.add(toastMessageNeeded);
		                  
		     Thread.sleep(5000); 
			                  
		     // To fectch file from Question page Itself
		     driver.findElement(By.xpath("//android.widget.ImageButton[@index=4]")).click();
		     List<AndroidElement> files = driver.findElements(By.xpath("//android.widget.TextView"));
			  System.out.println("-------------Files String it fectch from Question page Assigned Tab --------------");
				for(int a=3; a<files.size(); a+=2) {
					
						
					fileWeGetFromSaveAndExitAssignedTab.add(files.get(a).getText());
				}
				
				System.out.println(fileWeGetFromSaveAndExitAssignedTab.get(0));
				System.out.println(fileWeGetFromSaveAndExitAssignedTab.get(1));
				
		     // click on Cancal Button
				driver.findElement(By.id("com.mor.sa.android.activities:id/btnOk")).click();
		     
		     
			Thread.sleep(2000);
		    //Next  
		    driver.findElement(By.id("com.mor.sa.android.activities:id/nextimg")).click();
		  //2nd question on what basis you came to this
		  		//CostEffectivness
		  		//driver.findElements(By.xpath("//android.widget.CheckBox")).get(0).click();
		  		//Fuel Economy
		  		//driver.findElements(By.xpath("//android.widget.CheckBox")).get(1).click();
		  		//Looks
		  		//driver.findElements(By.xpath("//android.widget.CheckBox")).get(2).click();
		  		//Performance
		  		//driver.findElements(By.xpath("//android.widget.CheckBox")).get(3).click();
		  		//Safety
		  		//driver.findElements(By.xpath("//android.widget.CheckBox")).get(4).click();
		  		//Technology
		  		//driver.findElements(By.xpath("//android.widget.CheckBox")).get(5).click();
		    System.out.println("\n");
		    if(optionChoice==0) {
		    	driver.findElements(By.xpath("//android.widget.CheckBox")).get(0).click();
		    	Question_2_OptionSelectedInApp_Choice_1 = "CostEffectivness";
		    	System.out.println("Question_2_OptionSelectedInApp_Choice_1 :-"+Question_2_OptionSelectedInApp_Choice_1);
			}if(optionChoice==1) {
				driver.findElements(By.xpath("//android.widget.CheckBox")).get(1).click();
				Question_2_OptionSelectedInApp_Choice_1 = "Fuel economy";
				System.out.println("Question_2_OptionSelectedInApp_Choice_1 :-"+Question_2_OptionSelectedInApp_Choice_1);
			}if (optionChoice==2) {
				driver.findElements(By.xpath("//android.widget.CheckBox")).get(2).click();
				Question_2_OptionSelectedInApp_Choice_1 = "Looks";
				System.out.println("Question_2_OptionSelectedInApp_Choice_1 :-"+Question_2_OptionSelectedInApp_Choice_1);
		  		driver.findElements(By.xpath("//android.widget.CheckBox")).get(3).click();
		  		Question_2_OptionSelectedInApp_Choice_2 = "Performance";
		  		System.out.println("Question_2_OptionSelectedInApp_Choice_2 :-"+Question_2_OptionSelectedInApp_Choice_2);
			}if (optionChoice==3) {
				driver.findElements(By.xpath("//android.widget.CheckBox")).get(4).click();
				Question_2_OptionSelectedInApp_Choice_1 = "Safety";
				System.out.println("Question_2_OptionSelectedInApp_Choice_1 :-"+Question_2_OptionSelectedInApp_Choice_1);
		  		driver.findElements(By.xpath("//android.widget.CheckBox")).get(5).click();
		  		Question_2_OptionSelectedInApp_Choice_2 = "Technology";
		  		System.out.println("Question_2_OptionSelectedInApp_Choice_2 :-"+Question_2_OptionSelectedInApp_Choice_2);
			}
		    
		   
			
			//Next  
			driver.findElement(By.id("com.mor.sa.android.activities:id/nextimg")).click();
			
			//Thank You Page
			// Free Text
			driver.findElement(By.xpath("//android.widget.EditText[@index='4']")).sendKeys("Hey hi, I just complete the survey for "+Question_1_OptionSelectedInApp);
			
			//MenuBtn
			driver.findElement(By.id("com.mor.sa.android.activities:id/menubtn")).click();
			//PopUp
			//Save and Exit
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save and exit']")).click();
			//Back to jobList
			driver.findElement(By.id("com.mor.sa.android.activities:id/rejectbtn")).click();
			
			// In progress Count 
			System.out.println(" The IN progress Count Before: "+InProgressCount);
			String InProgressCountUpdatedString = driver.findElement(By.id("com.mor.sa.android.activities:id/txt_tab_three_balloon")).getText();
			Integer InProgressCountUpdated = Integer.parseInt(InProgressCountUpdatedString);
			System.out.println(" The IN progress Count Updated: "+InProgressCountUpdated);
			Assert.assertEquals(InProgressCountUpdated, InProgressCount+1, " The inprogress count defer ");
			InProgressCount=InProgressCountUpdated;
			
			// Validation of Saved Answers
			// Click In progress Tab
			driver.findElement(By.id("com.mor.sa.android.activities:id/layout_tab_three")).click();
			// Click On Survey
			driver.findElement(By.xpath("//android.widget.TextView[@text='AutoDemo_CAPI_Updated']")).click();
			//Begin Interviews
			driver.findElement(By.id("com.mor.sa.android.activities:id/acceptbtn")).click();
			// Do you want to resume from last state
			driver.findElement(By.xpath("//android.widget.Button[@text='No']")).click();
			//Question-1
			/*
			// Here it fetch files from In progress tab Question page
			
		     driver.findElement(By.xpath("//android.widget.ImageButton[@index=4]")).click();
		     Thread.sleep(5000);
		     List<AndroidElement> filesInProgressTab = driver.findElements(By.xpath("//android.widget.TextView"));
			  System.out.println("Files String it fectch from Question page In Progress Tab :-");
				for(int a=3; a<filesInProgressTab.size(); a+=2) {
					
					System.out.println(files.get(a).getText());	
					fileWeGetFromSaveAndExitInProgressTab.add(files.get(a).getText());
				}
				
				System.out.println(fileWeGetFromSaveAndExitInProgressTab.size());
				System.out.println(fileWeGetFromSaveAndExitInProgressTab.get(0));
				System.out.println(fileWeGetFromSaveAndExitInProgressTab.get(1));
		     // click on Cancal Button
				driver.findElement(By.id("com.mor.sa.android.activities:id/btnOk")).click();
			*/
			
			//Next  
		    driver.findElement(By.id("com.mor.sa.android.activities:id/nextimg")).click();
		    //Question -2
		    
		   /*
		    //driver.findElementsByAndroidUIAutomator("new UiSelector().checked(true)")
		    if(Question_1_OptionSelectedInApp.equalsIgnoreCase("HYUNDAI")) {
		    	String Question_2_option_Actual_1 = driver.findElementByAndroidUIAutomator("new UiSelector().checked(true)").getText();
		    	Assert.assertEquals(Question_2_option_Actual_1, Question_2_OptionSelectedInApp_Choice_1, "The options saved are Mismatched ");
		    } if(Question_1_OptionSelectedInApp.equalsIgnoreCase("MAHINDRA")) {
		    	String Question_2_option_Actual_1 = driver.findElementByAndroidUIAutomator("new UiSelector().checked(true)").getText();
		    	Assert.assertEquals(Question_2_option_Actual_1, Question_2_OptionSelectedInApp_Choice_1, "The options saved are Mismatched ");
		    }if(Question_1_OptionSelectedInApp.equalsIgnoreCase("Toyota")) {
		    	List<AndroidElement> Question_2_Options_Actual_List = driver.findElementsByAndroidUIAutomator("new UiSelector().checked(true)");
		    	String Question_2_option_Actual_1 = Question_2_Options_Actual_List.get(0).getText();
		    	Assert.assertEquals(Question_2_option_Actual_1, Question_2_OptionSelectedInApp_Choice_1, "The options saved are Mismatched ");
		    	
		    	String Question_2_option_Actual_2 = Question_2_Options_Actual_List.get(1).getText();
		    	Assert.assertEquals(Question_2_option_Actual_2, Question_2_OptionSelectedInApp_Choice_2, "The options saved are Mismatched ");
		    }if(Question_1_OptionSelectedInApp.equalsIgnoreCase("TATA")) {
		    	List<AndroidElement> Question_2_Options_Actual_List = driver.findElementsByAndroidUIAutomator("new UiSelector().checked(true)");
		    	String Question_2_option_Actual_1 = Question_2_Options_Actual_List.get(0).getText();
		    	Assert.assertEquals(Question_2_option_Actual_1, Question_2_OptionSelectedInApp_Choice_1, "The options saved are Mismatched ");
		    	
		    	String Question_2_option_Actual_2 = Question_2_Options_Actual_List.get(1).getText();
		    	Assert.assertEquals(Question_2_option_Actual_2, Question_2_OptionSelectedInApp_Choice_2, "The options saved are Mismatched ");
		    }
		    */
		  //Next  
		  driver.findElement(By.id("com.mor.sa.android.activities:id/nextimg")).click();
		  //MenuBtn
		  driver.findElement(By.id("com.mor.sa.android.activities:id/menubtn")).click();
		  //Finish
		  driver.findElement(By.xpath("//android.widget.TextView[@text='Finish']")).click();
		  Thread.sleep(5000);
		  
		  //Files From In progress Tab
		  List<AndroidElement> TextView = driver.findElements(By.xpath("//android.widget.TextView"));
			System.out.println("-----------Files String it fectch from In Progress Tab  -------------");
			for(int a=6; a<TextView.size()-2; a+=2) {
				fileWeGetFromSaveAndExitInProgressTabfullString.add(TextView.get(a).getText());
				System.out.println(TextView.get(a).getText());	
			}
			
			String[] file_0_inInProgressTab = fileWeGetFromSaveAndExitInProgressTabfullString.get(0).split("/");
			String[] file_0_split_2 = file_0_inInProgressTab[7].split("-");
			String InProgressTabFile_0= file_0_split_2[0].concat("-"+file_0_split_2[1]);
			
			String[] file_1_inProgressTab = fileWeGetFromSaveAndExitInProgressTabfullString.get(1).split("-");
			String InProgressTabFile_1 = file_1_inProgressTab[0];
	        // Valiadate 1st Attched file
		    Assert.assertEquals(InProgressTabFile_1, fileWeGetFromSaveAndExitAssignedTab.get(0));
		    // Validate 2nd Attched file
		    Assert.assertEquals(InProgressTabFile_0, fileWeGetFromSaveAndExitAssignedTab.get(1));
			
			//Next  
			driver.findElement(By.id("com.mor.sa.android.activities:id/nextimg")).click();
		
			Thread.sleep(3000);
			//Back to jobList
			driver.findElement(By.id("com.mor.sa.android.activities:id/rejectbtn")).click();
			
			Thread.sleep(3000);
			//Sync Tab
			driver.findElement(By.id("com.mor.sa.android.activities:id/layout_tab_sync")).click();
					
			//Upload Jobs
			driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
			
			// explicit wait condition
		     WebDriverWait w = new WebDriverWait(driver,240);
		     // presenceOfElementLocated condition
		     w.until(ExpectedConditions.presenceOfElementLocated (By.id("com.mor.sa.android.activities:id/layout_tab_one")));
		     driver.quit();
	
			
	}
}
