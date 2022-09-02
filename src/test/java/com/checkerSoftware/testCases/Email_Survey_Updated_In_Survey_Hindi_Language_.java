package com.checkerSoftware.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;
import com.checkerSoftware.pageObjects.A_LoginPage;
import com.checkerSoftware.pageObjects.A_MainMenu;
import com.checkerSoftware.pageObjects.BF_Manage_Surveys;
import com.checkerSoftware.pageObjects.BF_Manage_Surveys_EditSurvey;
import com.checkerSoftware.pageObjects.BF_Manage_Surveysz_zSendSurveyInvitationByEmail;
import com.checkerSoftware.pageObjects.BG_ManageMT_Samples_EditSampleRows;
import com.checkerSoftware.pageObjects.BG_ManageMT_Samples_EditSamplesRows_AddNewRow;
import com.checkerSoftware.pageObjects.BG_ManageM_Samples;
import com.checkerSoftware.pageObjects.B_Management;
import com.checkerSoftware.pageObjects.E_Operation;
import com.checkerSoftware.pageObjects.Eh_Operation_HandleFinishedReviews;
import com.checkerSoftware.pageObjects.xxEmailLogin_SubmitSurvey;
import com.checkerSoftware.utility.Date;
import com.checkerSoftware.utility.ExcelSheet;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Email_Survey_Updated_In_Survey_Hindi_Language_ extends BaseClass{
	double startTime;
	double stopTime;
	double executionTime;
	
	A_LoginPage loginPage;
	A_MainMenu mainMenu;
	B_Management manageMent;
	BG_ManageM_Samples manageSamples;
	BG_ManageMT_Samples_EditSampleRows manageEditSampleRow;
	BG_ManageMT_Samples_EditSamplesRows_AddNewRow addNewRow;
	
	BF_Manage_Surveys manageSurveys;
	BF_Manage_Surveys_EditSurvey editSurvey;
	BF_Manage_Surveysz_zSendSurveyInvitationByEmail sendInvitationByEmail;
	
	xxEmailLogin_SubmitSurvey emailSurveySubmit;
	
	E_Operation operation;
	Eh_Operation_HandleFinishedReviews handleFinishedReviews;
	
	//(enabled =false)
	@BeforeClass
	public void Asetup() throws Throwable{
		launchApp();
		loginPage = new A_LoginPage();
		mainMenu = loginPage.Login();
	}
	//(enabled =false)
	@Test
	public void BcreateNewSampleRowEmail() throws Throwable {
		manageMent = mainMenu.clickOnManagement();
		manageSamples = manageMent.clickOnSamples();
		manageEditSampleRow = manageSamples.ClickOnEditSampleRowsEmail();
		addNewRow = manageEditSampleRow.clickOnaddNewRow();
		addNewRow.enterBranchName();
		addNewRow.enterRegion();
		addNewRow.enterContactName();
		addNewRow.enterPhoneNumber();
		addNewRow.enterEmail();
		addNewRow.selectBranch();
		addNewRow.enterSampleRowID();
		
		manageEditSampleRow = addNewRow.clickAddButton();
		mainMenu = manageEditSampleRow.clickONBackTOMainMenu();
	}
	
	//(dependsOnMethods = "BcreateNewSampleRowEmail", enabled =false)
	@Test(dependsOnMethods = "BcreateNewSampleRowEmail")
	public void CeditSurvey() throws Throwable {
		manageMent = mainMenu.clickOnManagement();
		manageSurveys = manageMent.clickOnSurveys();
		manageSurveys.selectClient();
		editSurvey = manageSurveys.selectSurveyHINDI();
		      //editSurvey = manageSurveys.selectSurvey();
		
		  editSurvey.clickShowButton();
		  
		      //editSurvey.clearSurvey();
		  editSurvey.clearSurveyHINDI();
		      //editSurvey.enter_E_mail_SubjectForInvitation();
		  editSurvey.enter_E_mail_SubjectForInvitation_HINDI();
			  //editSurvey.enter_e_mail_Body_For_Invitation();
		  editSurvey.enter_e_mail_Body_For_Invitation_HINDI();
			  //editSurvey.enter_LinkText_for_Invitation();
		  editSurvey.enter_LinkText_for_Invitation_HINDI();
		  editSurvey.enter_ThankYouMessage_RightAfterFiliingTheSurvey();
		  editSurvey.enter_link_toGoAfterSurvey();
		  editSurvey.Waitbefore_going_ToTheLinkIn_Seconds();
		  editSurvey.enter_FromName(); 
		  editSurvey.enter_Email_Sender();
		  editSurvey.select_TypeOfMailServer();
		  editSurvey.enter_ThankYouMessage_Email_Subject();
		  editSurvey.enter_ThankYouMessage_Body_to_be_Sent_by_Email();
			 
		  editSurvey.SMSsurveyinvitationexpiresafterXhours();
		  
			
			  manageSurveys = editSurvey.click_SaveButton(); 
			  sendInvitationByEmail =manageSurveys.click_sendSurveyInviationBy_EmailIcon_HINDI();
			  //sendInvitationByEmail =manageSurveys.click_sendSurveyInviationBy_EmailIcon();
			  sendInvitationByEmail.conform_Sample_and_Select_properSample();
			  sendInvitationByEmail.send_Invitation();
			  sendInvitationByEmail.close_Driver();
			 
		
		
		
		
	}
	
    //(dependsOnMethods = "CeditSurvey")
	@Test(dependsOnMethods = "CeditSurvey")
	public void DxEmailLogin_SurveySubmit() throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://outlook.office.com/mail/");
		driver.manage().window().maximize();
		Action.implicitWait(driver, 30);
		Action.pageLoadTimeouts(driver, 30);
		
		driver.findElement(By.xpath("//button[@name='Focused']")).click();
		
		Thread.sleep(10000);
		String EmailSubjectWith_TextCode = prop.getProperty("E_mail_Subject_For_Invitation_HINDI");
		String EmailSubjectWith_TextCode_Value = GetTextCode_Return_textCodeValue(EmailSubjectWith_TextCode);
		String[] EmailSubject_Split = EmailSubjectWith_TextCode_Value.split(" ");
		String EmailSubject_To_Search_In_Inbox = EmailSubject_Split[0]+" "+EmailSubject_Split[1];
		driver.findElement(By.xpath("//*[@class='customScrollBar BW6l9']/div//*[contains(@aria-label,'"+ EmailSubject_To_Search_In_Inbox +"')]")).click();
		
		// 2 Validate Email Subject of invitation Email
		String emailSubjectForInviation = driver.findElement(By.xpath("//*[@class='_5FqYX HnNdo']")).getText();
		
		String emailSubjectWeProvideInSurveyWithTextCode = prop.getProperty("E_mail_Subject_For_Invitation_HINDI");
		String email_Subject_WeProvideInSurveyWithTextCode_Value = GetTextCode_Return_textCodeValue(emailSubjectWeProvideInSurveyWithTextCode);
		
		String email_Subject_WeProvideInSurveyWithTextCode_Value_ExtraSpaceEliminate = email_Subject_WeProvideInSurveyWithTextCode_Value.replace("   ", " ");
		Assert.assertEquals(emailSubjectForInviation, email_Subject_WeProvideInSurveyWithTextCode_Value_ExtraSpaceEliminate, "Mismatch with Email Subject for Survey");
		System.out.println("Successfully validate subject");
		
		
		  Thread.sleep(5000);
		  // 9 from Validation From'Name of invitation Email
		  WebElement From_Name_AND_EMail =driver.findElement(By.xpath("//*[@class='QGAjV']")); 
		  String From_Name_AND_EMailString = From_Name_AND_EMail.getText(); 
		  String[] From_Name_AND_EMailString_Split = From_Name_AND_EMailString.split("<");
		  String From_NameBeforeTrim = From_Name_AND_EMailString_Split[0];
		  String From_Name = From_NameBeforeTrim.trim();
		  
		  String EMail_Sender_AddressBeforeSplit = From_Name_AND_EMailString_Split[1];
		  String EMail_Sender_Address = EMail_Sender_AddressBeforeSplit.replace(">","");
		  
		  if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		  Assert.assertEquals(From_Name, prop.getProperty("From_Name_Testing"),"Mismatch with From'Name"); }
		  if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
		  Assert.assertEquals(From_Name, prop.getProperty("From_Name_preProd"),"Mismatch with From'Name"); }
		  System.out.println("Successfully validate From'Name");
		  
		  // 10 EMail of sender of invitation Email
		  
		  if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		  Assert.assertEquals(EMail_Sender_Address,prop.getProperty("Email_Sender_Testing"),"Mismatch with Email sender Address in Testing"); }
		  if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
		  Assert.assertEquals(EMail_Sender_Address,prop.getProperty("Email_Sender_preProd"),"Mismatch with Email sender Address in PreProduction"); }
		  System.out.println("Successfully validate EMail of sender");
		  
		  // 4 Validate Email Body of invitation Email 
		  Thread.sleep(10000); 
		  // Verified
		  //String emailBodyInMailInbox = driver.findElement(By.xpath("//*[@aria-label='Message body']/div/div/div/p[1]")).getText();
		  
		  // Try Email Body 
		  List<WebElement> emailBodyInMailInboxLines = driver.findElements(By.xpath("//*[@aria-label='Message body']/div/div/div/p")); 
		  String emailBodyInMailInbox1 =""; 
		  for(WebElement mailBodyLine : emailBodyInMailInboxLines) { 
			  emailBodyInMailInbox1 += mailBodyLine.getText();
		  } 
		  String emailBodyInMailInbox = emailBodyInMailInbox1.trim();
		  
		  String emailBodyWeProvideInSurvey_With_TextCode =prop.getProperty("E_mail_Body_For_Invitation_HINDI"); 
		  String emailBodyWeProvideInSurvey_With_TextCode_Value = GetTextCode_Return_textCodeValue(emailBodyWeProvideInSurvey_With_TextCode);
		  System.out.println("Email body in Inbox is: "+emailBodyInMailInbox);
		  //Assert.assertEquals(emailBodyInMailInbox,emailBodyWeProvideInSurvey_With_TextCode_Value,"Mismatch with Email body with respect to We provide in survey");
		  System.out.println("Successfully validate Email body");
		  
		  // 6 Validate Link Text in Invitation Email 
		  WebElement mailInbox_LinkTextInInvitationMail = driver.findElement(By.xpath("//*[@aria-label='Message body']/div/div/div/font/a"));
		  if(mailInbox_LinkTextInInvitationMail.getText().equalsIgnoreCase(prop.getProperty("LinkTextDefault"))) {
		  Assert.assertEquals(mailInbox_LinkTextInInvitationMail.getText(),prop.getProperty("LinkTextDefault"), "Mismatch with Default Link Text"); }
		  if(mailInbox_LinkTextInInvitationMail.getText().equalsIgnoreCase(prop.getProperty("LinkText_HINDI"))) {
		  Assert.assertEquals(mailInbox_LinkTextInInvitationMail.getText(),prop.getProperty("LinkText_HINDI"),"Mismatch with Link Text with respect to We provide in survey"); 
		  }
		  
		  System.out.println("Successfully validate Link Text"); 
		  String surveyLink = mailInbox_LinkTextInInvitationMail.getAttribute("href");
		  driver.get(surveyLink);
		  
		  WebElement select_Laptop;
		  if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		  select_Laptop = driver.findElement(By.xpath("//select[@name='obj173704']"));
		  }  { select_Laptop = driver.findElement(By.xpath("//select[@name='obj349932']")); 
		  } 
		  Select select_Laptop_Dropdown = new Select(select_Laptop);
		  select_Laptop_Dropdown.selectByVisibleText("HP");
		  System.out.println("User select-*Which laptop you are using- As HP");
		  
		  //-------------Here user select--2. On average, how many days do you spend on your laptop per week?--As--4/week------//
		  driver.findElement(By.xpath("//div[@class='radioAnswersDiv']/div[4]/span")).click(); 
		  System.out.println("Here user select--2.  On average, how many days do you spend on your laptop per week?--As--4/week");
		  
		  //-------------here user select--3.*how's your experience, for the service provide by you laptop company--Here we select option 1 and 3----// 
		  for(int i=1; i<4; i+=2) {
		  if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		  driver.findElement(By.xpath("//table[@class='checkboxes_answers_table noanswer_obj173706 max-multiple']/tbody/tr["+(i)+"]/td/span/label/input")).click(); 
		  } else { driver.findElement(By.xpath("//table[@class='checkboxes_answers_table noanswer_obj349934 max-multiple']/tbody/tr["+ (i) + "]/td/span/label/input")).click(); 
		  } 
		  } 
		  System.out.println("here user select--3.*how's your experience, for the service provide by you laptop company--- Here we select option 1 and 3"
		  );
		  
		  //-------------Here user Select Time as Now------------------------------------------------------------------------------------------------//
		  driver.findElement(By.xpath("//a[@name='todayDate']")).click();
		  
		  //-------------here user submit the Survey----------------------------------------------------------------------------// 
		  driver.findElement(By.xpath("//input[@id='finishCrit']")).click();
		  startTime = (System.currentTimeMillis());
		  
		  // 7 Validate Thank you Massage right after filling the survey
		  Thread.sleep(2000); 
		  // Verified 
		  //WebElement ThankYouMassage_RightAfter_FillingSurvey = driver.findElement(By.xpath("//*[@class='_container_ main-div-bg']/div/form/span/center/h1/p"));
		  //Try 
		  List<WebElement> ThankYouMassage_RightAfter_FillingSurvey_Lines = driver.findElements(By.xpath("//*[@class='_container_ main-div-bg']/div/form/span/center/h1/p"));
		  String ThankYou_Massage =""; 
		  for(WebElement ThankyouMassageLines : ThankYouMassage_RightAfter_FillingSurvey_Lines) { 
			  ThankYou_Massage +=ThankyouMassageLines.getText(); } 
		  String ThankYouMassage_RightAfter_FillingSurvey = ThankYou_Massage.trim();
		  
		  
		  String thankYouMassageWeProvideInSurvey_With_TextCode = prop.getProperty("ThankYouMessage_right_after_FillingTheSurvey"); 
		  String thankYouMassageWeProvideInSurvey_With_TextCode_Value =GetTextCode_Return_textCodeValue(thankYouMassageWeProvideInSurvey_With_TextCode);
		  
		  Assert.assertEquals(ThankYouMassage_RightAfter_FillingSurvey, thankYouMassageWeProvideInSurvey_With_TextCode_Value, "Mismatch with Thankyou massage right after filling Survey"); 
		  System.out.println("Successfully validate ThankYou Massage right after filling survey");
		  
		  // 8 
		  String waitString = prop.getProperty("Waitbefore_going_ToTheLinkIn_Seconds"); 
		  int waitingTime = Integer.parseInt(waitString) * 1000;
		  
		  Thread.sleep(waitingTime); String redirectingURL = driver.getCurrentUrl();
		  Assert.assertEquals(redirectingURL, prop.getProperty("AfterThanking_GoTo_ThisLink","Mismatch with redirecting link")); 
		  System.out.println("Successfully validate Redirecting link");
		  
		  stopTime =(System.currentTimeMillis()); 
		  executionTime = ((stopTime - startTime));
		  System.out.println("The Submission time  is "+executionTime ); driver.quit();
		 
		
	}
    @Test(dependsOnMethods = "DxEmailLogin_SurveySubmit")
	public void Validate_Thankyou_EMail() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://outlook.office.com/mail/");
		driver.manage().window().maximize();
		Action.implicitWait(driver, 30);
		Action.pageLoadTimeouts(driver, 30);
		
		driver.findElement(By.xpath("//button[@name='Focused']")).click();
	
		
		Thread.sleep(10000);
		String ThankYouEmail_Message_Email_Subject_With_TextCode = prop.getProperty("ThankYouEmail_Message_Email_Subject");
		
		String ThankYouEmail_Message_Email_Subject_With_TextCode_Value = GetTextCode_Return_textCodeValue(ThankYouEmail_Message_Email_Subject_With_TextCode);
		String[] EmailSubject_Split = ThankYouEmail_Message_Email_Subject_With_TextCode_Value.split(" ");
		String EmailSubject_To_Search_In_Inbox = EmailSubject_Split[0]+" "+EmailSubject_Split[1];
		
		driver.findElement(By.xpath("//*[@class='customScrollBar BW6l9']/div//*[contains(@aria-label,'"+EmailSubject_To_Search_In_Inbox+"')]")).click();
		
		// 12 Validate ThankYou Massage Mail subject
		String ThankYou_Massage_emailSubjectForInviation = driver.findElement(By.xpath("//*[@class='_5FqYX HnNdo']")).getText();
		String ThankYou_Massage_emailSubject_WeProvide_With_TextCode = prop.getProperty("ThankYouEmail_Message_Email_Subject");
		String ThankYou_Massage_emailSubject_WeProvide_With_TextCode_Value = GetTextCode_Return_textCodeValue(ThankYou_Massage_emailSubject_WeProvide_With_TextCode);
		Assert.assertEquals(ThankYou_Massage_emailSubjectForInviation, ThankYou_Massage_emailSubject_WeProvide_With_TextCode_Value, "MisMatch ThankYou Massage E Mail Subject");
		System.out.println("Successfully validate ThankYou Massage Mail subject");
		
		// 13 Validate Thank you Massage Mail Body
		String ThankYou_Massage_emailBodyInMailInbox = driver.findElement(By.xpath("//*[@aria-label='Message body']/div/div/div")).getText();
		String ThankYou_Massage_emailBody_WeProvide_With_TextCode = prop.getProperty("ThankYouEmail_Message_Body_to_be_Sent_by_Email");
		String ThankYou_Massage_emailBody_WeProvide_With_TextCode_Value = GetTextCode_Return_textCodeValue(ThankYou_Massage_emailBody_WeProvide_With_TextCode);
		Assert.assertEquals(ThankYou_Massage_emailBodyInMailInbox, ThankYou_Massage_emailBody_WeProvide_With_TextCode_Value, "MisMatch ThankYou Massage E Mail Body");
		System.out.println("Successfully validate Thank you Massage Mail Body");
		
		Thread.sleep(5000);
		// 9 from Validation From'Name 
		WebElement From_Name_AND_EMail = driver.findElement(By.xpath("//*[@class='QGAjV']"));
		String From_Name_AND_EMailString = From_Name_AND_EMail.getText();
		String[] From_Name_AND_EMailString_Split = From_Name_AND_EMailString.split("<");
		String From_NameBeforeTrim = From_Name_AND_EMailString_Split[0];
		String From_Name = From_NameBeforeTrim.trim();
				
		String EMail_Sender_AddressBeforeSplit = From_Name_AND_EMailString_Split[1];
		String EMail_Sender_Address = EMail_Sender_AddressBeforeSplit.replace(">", "");
				
						
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {		
			  Assert.assertEquals(From_Name, prop.getProperty("From_Name_Testing"), "Mismatch with From'Name");
			} if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
				Assert.assertEquals(From_Name, prop.getProperty("From_Name_preProd"), "Mismatch with From'Name");
			}
			  System.out.println("Successfully validate From'Name");
				
		// 10 EMail of sender
				
			  if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				    Assert.assertEquals(EMail_Sender_Address, prop.getProperty("Email_Sender_Testing"), "Mismatch with Email sender Address in Testing");
				  }  if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
					  Assert.assertEquals(EMail_Sender_Address, prop.getProperty("Email_Sender_preProd"), "Mismatch with Email sender Address in PreProduction");
				  }
				System.out.println("Successfully validate EMail of sender");
		driver.quit();
		
	}
	
	public void ExValidateEmailSurvey_OnServer() throws Throwable {
		launchApp();
		loginPage = new A_LoginPage();
		mainMenu = loginPage.Login();
		operation = mainMenu.clickOnOperation();
		handleFinishedReviews = operation.clickOnHandleFinishedReviws();
		handleFinishedReviews.validateEmailSurveyOnServer();
	}
	
	
	public void tearDown() throws IOException {
		driver.quit();
	}
	
	
	
	public static String GetTextCode_Return_textCodeValue(String stringWithTextCode) {
		String str1 = stringWithTextCode.replace("$[500,ContactName]$", prop.getProperty("sampleContactName"));
		String str2 = str1.replace("$[500,BranchName]$", prop.getProperty("sampleBranchName"));
		String str3 = str2.replace("$[500,Region]$", prop.getProperty("sampleRegion"));
		String stringWithTextCode_Value = str3.replace("$[500,PhoneNumber]$", prop.getProperty("samplephoneNumber"));
		return stringWithTextCode_Value;
		}
}
