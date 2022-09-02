package com.checkerSoftware.testCases;

import java.io.IOException;


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

public class Email_Survey_Auto_Test extends BaseClass{
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
	BF_Manage_Surveysz_zSendSurveyInvitationByEmail sendInvitationByEmail;
	
	xxEmailLogin_SubmitSurvey emailSurveySubmit;
	
	E_Operation operation;
	Eh_Operation_HandleFinishedReviews handleFinishedReviews;
	
	@BeforeClass
	public void Asetup() throws Throwable{
		launchApp();
		loginPage = new A_LoginPage();
		mainMenu = loginPage.Login();
	}
	
	@Test
	public void BcreateNewSampleRowEmail() throws Throwable {
		manageMent = mainMenu.clickOnManagement();
		manageSamples = manageMent.clickOnSamples();
		manageEditSampleRow = manageSamples.ClickOnEditSampleRowsEmail();
		addNewRow = manageEditSampleRow.clickOnaddNewRow();
		addNewRow.enterEmail();
		addNewRow.enterSampleRowID();
		manageEditSampleRow = addNewRow.clickAddButton();
		mainMenu = manageEditSampleRow.clickONBackTOMainMenu();
	}
	
	@Test(dependsOnMethods = "BcreateNewSampleRowEmail")
	public void CsendSurveyInvitationByEmail() throws Throwable {
		manageMent = mainMenu.clickOnManagement();
		manageSurveys = manageMent.clickOnSurveys();
		sendInvitationByEmail = manageSurveys.ClickOnClient_SelectSurvey_ToSendEmail();
		sendInvitationByEmail.validateEmail_and_sendEmailSurvey();
		
	}
	

	@Test(dependsOnMethods = "CsendSurveyInvitationByEmail")
	public void DxEmailLogin_SurveySubmit() throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://outlook.office.com/mail/");
		driver.manage().window().maximize();
		Action.implicitWait(driver, 30);
		Action.pageLoadTimeouts(driver, 30);
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		driver.findElement(By.xpath("//button[@name='Focused']")).click();
		}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			driver.findElement(By.xpath("//button[@name='Other']")).click();
		}
		
		
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s0OAm']/div[1]/div"))).click();
		//driver.findElement(By.xpath("//div[@class='s0OAm']/div[1]/div")).click();
		driver.findElement(By.xpath("//span[text()='Hi, This is DhanrajQA from Checker, Please complete the survey asap.']")).click();
		
		WebElement clickHere_For_Survey = driver.findElement(By.xpath("//a[text()='clickHere_For_Survey']"));
		String email_Survey_URL = clickHere_For_Survey.getAttribute("href");
		driver.get(email_Survey_URL);
		//driver.get("https://eu.checker-soft.com/testing/s_login.php?urltoken=h110gotaLjHFTDAK%2FsqIYL6mdYTHadMVQTjVVKjdVas9iWvhwg8aQA8xIUD2684CAo%2F4PYGKyTubbVBK9gwig9ZTw8keMkzMtoNKeoW4alPHeVkMPWnK%2FAlsNg%2FakgSd03PrJitUsTszEyMM5usmzIkFFd6U0Ml%2BlvDzkhn9Jeb1WnX6U7CeqJlQVEFwsqrNzZXDx%2BCajMJCeRSh2trgiRy1pmETMKCxZ85Q9gwtI2Q%3D");
		WebElement select_Laptop;
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
			select_Laptop = driver.findElement(By.xpath("//select[@name='obj172546']"));
			} else {
				select_Laptop = driver.findElement(By.xpath("//select[@name='obj349813']"));
			}
	
		Select select_Laptop_Dropdown = new Select(select_Laptop);
		select_Laptop_Dropdown.selectByVisibleText("HP");
		System.out.println("User select-*Which laptop you are using- As HP");
		
		//-------------Here user select--2.  On average, how many days do you spend on your laptop per week?--As--4/week------//
		driver.findElement(By.xpath("//div[@class='radioAnswersDiv']/div[4]/span")).click();
		System.out.println("Here user select--2.  On average, how many days do you spend on your laptop per week?--As--4/week");
		
	
		//-------------here user select--3.*how's your experience, for the service provide by you laptop company--Here we select option 1 and 3----//
		for(int i=1; i<4; i+=2) {
			if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				driver.findElement(By.xpath("//table[@class='checkboxes_answers_table noanswer_obj172550 max-multiple']/tbody/tr["+(i)+"]/td/span/label/input")).click();
				} else {
					driver.findElement(By.xpath("//table[@class='checkboxes_answers_table noanswer_obj349815 max-multiple']/tbody/tr["+ (i) + "]/td/span/label/input")).click();
				}
			
		}
		System.out.println("here user select--3.*how's your experience, for the service provide by you laptop company--- Here we select option 1 and 3");
		
		//-------------Here user Select Time as Now------------------------------------------------------------------------------------------------//
		driver.findElement(By.xpath("//a[@name='todayDate']")).click();
		
		
		//-------------here user submit the Survey----------------------------------------------------------------------------//
		startTime = (System.currentTimeMillis()/10);
		driver.findElement(By.xpath("//input[@id='finishCrit']")).click();
		System.out.println("User sumbit the Survey");
		
		// -------Validation--------------------------------------//
		String ThankyouM= "Thank you, We appreciate your efforts.";
		String ThankYouMessage = driver.findElement(By.xpath("//span[@class='questText']/center/h1/p")).getText();
		Assert.assertEquals(ThankyouM, ThankYouMessage);
		stopTime = (System.currentTimeMillis()/10);
		
		executionTime = ((stopTime - startTime));
		System.out.println("The Submission time  is "+executionTime );
		String sheetName ="Email_survey";
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
			String time = Date.systemTime();
			ExcelSheet.ExcelTesting(sheetName, time , executionTime);
		}
		
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			String time = Date.systemTime();
			ExcelSheet.ExcelpreProd(sheetName, time, executionTime);
			
		}
		Thread.sleep(3000);
		driver.quit();
	}

	
	@Test(dependsOnMethods = "DxEmailLogin_SurveySubmit")
	public void ExValidateEmailSurvey_OnServer() throws Throwable {
		launchApp();
		loginPage = new A_LoginPage();
		mainMenu = loginPage.Login();
		operation = mainMenu.clickOnOperation();
		handleFinishedReviews = operation.clickOnHandleFinishedReviws();
		handleFinishedReviews.validateEmailSurveyOnServer();
	}
	
	//@Test(dependsOnMethods = "ExValidateEmailSurvey_OnServer")
	@AfterClass
	public void tearDown() throws IOException {
		driver.quit();
		
		
		
	}
}
