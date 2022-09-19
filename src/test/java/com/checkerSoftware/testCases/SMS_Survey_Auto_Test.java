package com.checkerSoftware.testCases;



import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.checkerSoftware.base.BaseClass;
import com.checkerSoftware.pageObjects.A_LoginPage;
import com.checkerSoftware.pageObjects.A_MainMenu;
import com.checkerSoftware.pageObjects.BF_Manage_Surveys;
import com.checkerSoftware.pageObjects.BF_Manage_Surveysz_zSendSurveyInvitationBySMS;
import com.checkerSoftware.pageObjects.BG_ManageMT_Samples_EditSampleRows;
import com.checkerSoftware.pageObjects.BG_ManageMT_Samples_EditSamplesRows_AddNewRow;
import com.checkerSoftware.pageObjects.BG_ManageM_Samples;
import com.checkerSoftware.pageObjects.B_Management;
import com.checkerSoftware.pageObjects.FN_Notifiaction_Report;
import com.checkerSoftware.utility.Date;
import com.checkerSoftware.utility.ExcelSheet;


public class SMS_Survey_Auto_Test extends BaseClass {
	long startTime = System.currentTimeMillis();
	A_LoginPage loginPage;
	A_MainMenu mainMenu;
	B_Management manageMent;
	BG_ManageM_Samples manageSamples;
	BG_ManageMT_Samples_EditSampleRows manageEditSampleRow;
	BG_ManageMT_Samples_EditSamplesRows_AddNewRow addNewRow;
	
	BF_Manage_Surveys manageSurveys;
	BF_Manage_Surveysz_zSendSurveyInvitationBySMS sendInvitationBySMS;
	
	FN_Notifiaction_Report notificationReport;
	
	@BeforeClass
	public void setup() throws Throwable{
		System.out.println("================= Test Case 01 SetUp ==== Starts=================");
		launchApp();
		loginPage = new A_LoginPage();
		mainMenu = loginPage.Login();
		System.out.println("================= Test Case 01 SetUp ==== Ends=================");
	}
	
	
	
	@Test
	public void createNewSampleRowSMS() throws Throwable {
		System.out.println("================= Test Case 02 Create New Sample ==== Start=================");
		manageMent = mainMenu.clickOnManagement();
		manageSamples = manageMent.clickOnSamples();
		manageEditSampleRow = manageSamples.ClickOnEditSampleRowsSMS();
		addNewRow = manageEditSampleRow.clickOnaddNewRow();
		addNewRow.enterPhoneNumber();
		addNewRow.enterSampleRowID();
		manageEditSampleRow = addNewRow.clickAddButton();
		mainMenu = manageEditSampleRow.clickONBackTOMainMenu();	
		      
	}
	
	@Test(dependsOnMethods = "createNewSampleRowSMS")
	public void sendSurveyInvitationBySMS() throws Throwable {
		manageMent = mainMenu.clickOnManagement();
		manageSurveys = manageMent.clickOnSurveys();
		sendInvitationBySMS = manageSurveys.ClickOnClient_SelectSurvey_ToSendSMS();
		notificationReport = sendInvitationBySMS.validatePhoneNumber_and_sendSMSSurvey();
		notificationReport.validateSMSsurvey();
		
		
	}
	
	

	//@Test(dependsOnMethods = "sendSurveyInvitationBySMS")
	@AfterClass
	public void tearDown() throws IOException {
		driver.quit();
		long stopTime = System.currentTimeMillis();
		float executionTime = ((stopTime - startTime)/1000);
		System.out.println("The time elapsed is "+executionTime );
		String sheetName ="SMS_survey";
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
			String time = Date.systemTime();
			ExcelSheet.ExcelTesting(sheetName, time, executionTime);
		}
		
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			String time = Date.systemTime();
			ExcelSheet.ExcelpreProd(sheetName, time, executionTime);
			
		}
	}
	
}
