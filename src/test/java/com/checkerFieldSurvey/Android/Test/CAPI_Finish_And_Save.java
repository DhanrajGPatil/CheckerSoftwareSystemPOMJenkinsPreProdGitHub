package com.checkerFieldSurvey.Android.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.checkerSoftware.base.BaseClass;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CAPI_Finish_And_Save extends BaseClass{
	
	public static ArrayList<String> filesAttchedOnAPPFullStringWithDuplicate;
	public static ArrayList<String> filesAttchedOnAPPFullStringUnique;
	
	public static ArrayList<String> filesAttchedOnAPP;
	public static ArrayList<String> filesAttchedOnServer;
	public static String Question_1_OptionSelectedInApp;
	public static String Question_2_OptionSelectedInApp_Choice_1;
	public static String Question_2_OptionSelectedInApp_Choice_2;
	public static int scrollIteration;
	
	
	@Test(priority=0)
	public void Finish_And_Save_Interview_OnApp() throws MalformedURLException, InterruptedException {
		filesAttchedOnAPPFullStringWithDuplicate =  new ArrayList<String>();
		
		
		File appdir = new File("sAPK");
		File app = new File(appdir,"CheckerFieldSurveyor.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "O8.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
        
        //https://eu.checker-soft.com/preproduction/login.php
        //https://eu.checker-soft.com/testing/
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
				String cameraImagesString = prop.getProperty("NoOfCameraImages");
				int cameraImages = (Integer.parseInt(cameraImagesString)+1);
				scrollIteration = cameraImages*18;
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
				 // For Audio
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			    String NoOfAudioString = prop.getProperty("NoOfAudio");
			    int numberOfAudio = Integer.parseInt(NoOfAudioString);
			    String audioRecordTimeString = prop.getProperty("AudioRecordTime");
			    int audioRecordTime = Integer.parseInt(audioRecordTimeString);
			    scrollIteration = scrollIteration + numberOfAudio*18;
			    if(numberOfAudio>0) {
			    for (int i=0; i<numberOfAudio; i++) {
				                  driver.findElement(By.xpath("//android.widget.ImageButton")).click();              
					              //1) Click Audio Recording
					              driver.findElement(By.xpath("//android.widget.TextView[@text='Ongoing audio recording']")).click();
					              // Information : Do you want to start recording ?  
					              driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
					              Thread.sleep(audioRecordTime);
					                   /*
					                   // Start Music to check audio recording
					                   File file = new File("Music\\Liu__GenX_-_Pirate_(Extended_mix).mp3");
					                   AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
					                   Clip clip = AudioSystem.getClip();
					                   clip.open(audioStream);
					                   clip.start();
					                   // Wait Till
					                   Thread.sleep(audioRecordTime);
					                   clip.close();
					                   //To Stop
					                    * 
					                    */
					                   
					              driver.findElement(By.id("com.mor.sa.android.activities:id/recordBtn")).click();
					              // To pause Audio and Save
					              // Information : Do you want to stop recording ?
					              driver.findElement(By.xpath("//android.widget.Button[@text='Yes']")).click();
					             
					              Thread.sleep(2000);
			                                         }
			    }
				}
			    
			    //Click Select Files
				// For Gallery Images
			    scrollIteration = scrollIteration + 11;
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
			                  System.out.println(toastMessageNeeded);
			     Thread.sleep(2000); 
				                  
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
				driver.findElement(By.xpath("//android.widget.EditText[@index='4']")).sendKeys(prop.getProperty("FreeText")+" "+Question_1_OptionSelectedInApp);
				
				//MenuBtn
				driver.findElement(By.id("com.mor.sa.android.activities:id/menubtn")).click();
				//Popup
				//Finish
				driver.findElement(By.xpath("//android.widget.TextView[@text='Finish']")).click();
				
				// By Toast Massage Way
				//String firstCameraImage = driver.findElements(By.xpath("//android.widget.TextView")).get(6).getText();
				//String[] firstCameraImageSplit= firstCameraImage.split("-");
				//String splitedEndfirstCameraImage = firstCameraImageSplit[2];
				//String Str = toastMessageNeeded+"-"+splitedEndfirstCameraImage;
				//System.out.println("Serching for this :"+Str);
				
				
				
				int screenScrollNoOfTime = ((scrollIteration/60)+2);
				for(int s=0; s<screenScrollNoOfTime; s++) {
				List<AndroidElement> files = driver.findElements(By.xpath("//android.widget.TextView"));
				System.out.println("Files String it fectch from App:-");
				for(int a=6; a<files.size()-2; a+=2) {
					filesAttchedOnAPPFullStringWithDuplicate.add(files.get(a).getText());
					System.out.println(files.get(a).getText());	
				}
				System.out.println("\n");
				//To scroll
				 Dimension d = driver.manage().window().getSize();
				    int height = d.getHeight();
				    int width = d.getWidth();
				    
				    int startx = width/2;
				    int endx = width/2;
				    int starty =  (int) (height*0.80);
				    int endy = (int) (height*0.20);
				    
				    TouchAction action = new TouchAction(driver);
				    action.press(PointOption.point(startx, starty))
				    .moveTo(PointOption.point(endx, endy))
				    .release()
				    .perform();
				}
				Thread.sleep(5000);
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
			
			@Test(priority=1, dependsOnMethods="Finish_And_Save_Interview_OnApp")
			public static void printFiles() {
				filesAttchedOnAPP = new ArrayList<String>();
				filesAttchedOnAPPFullStringUnique = (ArrayList<String>) filesAttchedOnAPPFullStringWithDuplicate.stream().distinct().collect(Collectors.toList());
				
				System.out.println("Files attched on app After Split And Extract:- ");
				for(int i=0; i<filesAttchedOnAPPFullStringUnique.size(); i++) {
					
					String[] filesAttchedSplit = filesAttchedOnAPPFullStringUnique.get(i).split("/");
					if(filesAttchedSplit.length==8) {
						String[] filesAttchedSplit1 =  filesAttchedSplit[7].split("-");
						 if(filesAttchedSplit1.length==3) {
						filesAttchedOnAPP.add(filesAttchedSplit1[0].concat("-"+filesAttchedSplit1[1]));
						 }if(filesAttchedSplit1.length==2) {
						filesAttchedOnAPP.add(filesAttchedSplit1[0]);
						 }
					}if(filesAttchedSplit.length==6) {
						String[] filesAttchedSplitGallery = filesAttchedSplit[5].split("-");
						filesAttchedOnAPP.add(filesAttchedSplitGallery[0]);
					}
					
					
					
				}
				System.out.println("The Unique Files Are :- ");
				for(int j=0; j<filesAttchedOnAPP.size(); j++) {
					System.out.println(j+"] "+filesAttchedOnAPP.get(j));
				}
				
				}
			
			
			@Test(priority=2, dependsOnMethods="printFiles")
			// dependsOnMethods="printFiles"
			public void Validate_CAPI_On_server() throws InterruptedException {
				
		        SoftAssert soft = new SoftAssert();
		        filesAttchedOnServer = new ArrayList<String>();
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				JavascriptExecutor je = (JavascriptExecutor) driver;
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				driver.get(prop.getProperty("urlCheckerTesting"));
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys(prop.getProperty("userNameTesting"));
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("passWordTesting"));
				driver.findElement(By.id("do_login")).click();
				}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
					driver.get(prop.getProperty("urlCheckerPreprod"));
					driver.manage().window().maximize();
					driver.findElement(By.xpath("//input[@name='username']")).sendKeys(prop.getProperty("userNamePreprod"));
					driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prop.getProperty("passWordPreprod"));
					driver.findElement(By.id("do_login")).click();
					}
				
				driver.findElement(By.xpath("//table[@id='menu_top_level']/tbody/tr/td//a[text()='Operation']")).click();
				driver.findElement(By.xpath("//div[@id='FiltersArea']//a[text()=' Handle finished reviews']")).click();
				driver.findElement(By.xpath("//select[@name='ClientID']//following-sibling::button//span[@class='ui-icon ui-icon-triangle-2-n-s']")).click();
				List<WebElement> client_Name_List = driver.findElements(By.xpath("//body[@class='page-crits-handling']/div[3]/ul/li"));
				for(int a=1; a<=client_Name_List.size(); a++) {
					WebElement client_Name = driver.findElement(By.xpath("//body[@class='page-crits-handling']/div[3]/ul/li["+(a)+"]/label/span"));
					
					if(client_Name.getText().equalsIgnoreCase("A New Client")) {
						client_Name.click();
					}
						driver.findElement(By.xpath("//input[@name='show']")).click();
						List<WebElement> HandleFinishedReviewList = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr"));
						Integer reviewCount = HandleFinishedReviewList.size();
						driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+reviewCount+"]/td[3]/a")).click();
						driver.findElement(By.xpath("//table[@id='side_menu']//a[text()='Edit entire review']")).click();
						
						// Question 1 Validation
						if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
						String question_1_AnswerExpected = Question_1_OptionSelectedInApp;
						String question_1_AnswerActual_OnServer = driver.findElement(By.xpath("//*[@id='side_menu']/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td/a//input[@checked='checked']/parent::a/parent::td/following-sibling::td/span/a")).getText();
						Assert.assertEquals(question_1_AnswerActual_OnServer, question_1_AnswerExpected);
						System.out.println("Successfully Validate Question 1 ");
						}if(prop.getProperty("WorkingURL").equalsIgnoreCase("testing")) {
							String question_1_AnswerExpected = Question_1_OptionSelectedInApp;
							String question_1_AnswerActual_OnServer = driver.findElement(By.xpath("//*[@id='side_menu']/tbody/tr/td/form/table[2]/tbody/tr[2]/td[2]/table/tbody/tr/td/span//input[@checked='checked']/parent::span/parent::td/following-sibling::td/label/span")).getText();
							Assert.assertEquals(question_1_AnswerActual_OnServer, question_1_AnswerExpected);
							System.out.println("Successfully Validate Question 1 ");
						}
						
						// Question 2 Validation
						if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
						String question_2_AnswerExpected = Question_2_OptionSelectedInApp_Choice_1;
						String question_2_AnswerActual_OnServer_Choice_1 = driver.findElement(By.xpath("//*[@id='side_menu']/tbody/tr/td/form/table[2]/tbody/tr[3]/td[2]/span/select//option[@selected]")).getText();
						Assert.assertEquals(question_2_AnswerActual_OnServer_Choice_1, question_2_AnswerExpected);
						System.out.println("Successfully Validate Question 2 ");
						}if(prop.getProperty("WorkingURL").equalsIgnoreCase("testing")) {
							
							String question_2_AnswerExpected = Question_2_OptionSelectedInApp_Choice_1;
							String question_2_AnswerActual_OnServer_Choice_1 = driver.findElement(By.xpath("//*[@id='side_menu']/tbody/tr/td/form/table[2]/tbody/tr[3]/td[2]/select//option[@Selected]")).getText();
							Assert.assertEquals(question_2_AnswerActual_OnServer_Choice_1, question_2_AnswerExpected);
							System.out.println("Successfully Validate Question 2 ");
						}
						
						
						WebElement freeTextComment = driver.findElement(By.xpath("//*[@id='CritFreeText']"));
						je.executeScript("arguments[0].scrollIntoView(true);",freeTextComment);
						
						// Free Text Validation
						String  freeTextCommentExpected = prop.getProperty("FreeText")+" "+Question_1_OptionSelectedInApp;
						String  freeTextCommentActual = freeTextComment.getText();
						Assert.assertEquals(freeTextCommentActual, freeTextCommentExpected);
						System.out.println("Successfully Validate Free Text ");
						
						
						/*
						if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {  */
						System.out.println("Files attched on Server:- ");
						int filesAttchedOnServerCount = driver.findElements(By.xpath("//*[@id='side_menu']/tbody/tr/td/form/table[2]/tbody/tr[2]/td[3]/div")).size();
						List<WebElement> filesAttchedOnServerList = driver.findElements(By.xpath("//*[@id='side_menu']/tbody/tr/td/form/table[2]/tbody/tr[2]/td[3]/div/a[2]"));
						for(int c=0; c<filesAttchedOnServerCount; c++) {
							System.out.println(c+"] "+filesAttchedOnServerList.get(c).getText());
							filesAttchedOnServer.add(filesAttchedOnServerList.get(c).getText());
							
						}
						
						
						if(filesAttchedOnServer.size()==filesAttchedOnAPP.size()) {
							for(int d=0; d<filesAttchedOnServer.size(); d++) {
								
							Assert.assertEquals(filesAttchedOnServer.get(d), filesAttchedOnAPP.get(d), "The File attched on App "+filesAttchedOnAPP.get(d)+" is not found On Server");
								
								
							}
							
						}else if(filesAttchedOnServer.size()!=filesAttchedOnAPP.size()) {
							Assert.assertTrue(false, "The Attched files on server are not as per Files Attched on App");
						}
						
						/*}  */
						/*
						 * if(prop.getProperty("WorkingSystem").equalsIgnoreCase("testing")) {
							
							for(int t=0; t<filesAttchedOnServer.size(); t++) {
								WebElement linkText = driver.findElement(By.linkText(filesAttchedOnAPP.get(t)));
								je.executeScript("arguments[0].scrollIntoView(true);",linkText);  
							    boolean  Status = driver.findElement(By.linkText(filesAttchedOnAPP.get(t))).isDisplayed();
								   if(Status) {
									   System.out.println("The File from app :"+filesAttchedOnAPP.get(t)+" is present on Server");
								   }
								   if(Status) {
									System.out.println("The File from App :"+filesAttchedOnAPP.get(t)+" is ---Not-- present on Server ");
								   }
								   Assert.assertTrue(Status, "The File is Not Present");
								}
								
							}
						*/
						
						
						// Click Save
						driver.findElement(By.xpath("//input[@id='save']")).click();
						
						Thread.sleep(4000);
						break;
					}
					
				
				driver.close();
	}
}
	


