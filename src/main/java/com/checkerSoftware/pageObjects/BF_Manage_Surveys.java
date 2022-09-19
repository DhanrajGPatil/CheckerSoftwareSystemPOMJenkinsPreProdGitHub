package com.checkerSoftware.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class BF_Manage_Surveys extends BaseClass {

	public BF_Manage_Surveys() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//table[@id='TableEdit_filtering']/tbody/tr/td/div[text()='Linked client']/div/table/tbody/tr/td/span/button//span[@class='ui-icon ui-icon-triangle-2-n-s']") WebElement Client_Name_dropdownArrow;
	@FindBy(xpath = "//body[@class='page-surveys']/div/ul/li/label/span") List<WebElement> client_name_list;
	@FindBy(xpath= "//table[@id='table_rows']/tbody/tr/td[1]/a") List<WebElement> survey_Name_List;
	@FindBy(xpath= "//table[@id='table_rows']/tbody/tr/td[1]/a") WebElement surveyInviationBy_Email_Icon;
	

	public void selectClient() throws Throwable {
		Action.click(driver, Client_Name_dropdownArrow);
		for(WebElement client : client_name_list) {
			if(client.getText().equalsIgnoreCase(prop.getProperty("clientName"))) {
				client.click();
				System.out.println("Driver select the Client as per Data in properties file");
				break;
			}
		}
	}
	
	public BF_Manage_Surveys_EditSurvey selectSurveyHINDI() {
		for(WebElement survey :survey_Name_List) {
			if(survey.getText().equalsIgnoreCase(prop.getProperty("surveyNameHINDI"))) {
				survey.click();
				System.out.println("Driver select the Survey as per Data in properties file");
				break;
			}
		}
		return new BF_Manage_Surveys_EditSurvey();
	}
	
	public BF_Manage_Surveys_EditSurvey selectSurvey() {
		for(WebElement survey :survey_Name_List) {
			if(survey.getText().equalsIgnoreCase(prop.getProperty("surveyName"))) {
				survey.click();
				System.out.println("Driver select the Survey as per Data in properties file");
				break;
			}
		}
		return new BF_Manage_Surveys_EditSurvey();
	}
	
	public BF_Manage_Surveysz_zSendSurveyInvitationByEmail click_sendSurveyInviationBy_EmailIcon() {
		List<WebElement> survey_name_list = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr/td[1]/a"));
		for (int z = 0; z < survey_name_list.size(); z++) {
			WebElement survey_name = survey_name_list.get(z);
			if (survey_name.getText().equalsIgnoreCase(prop.getProperty("surveyName"))) {
				// ---------------Here we click Mail icon----//
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
					driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr[" + (z + 1) + "]/td[21]/a")).click();
					System.out.println("Driver Send Survey Invitation By Email for testing Enviornment");
					} else {
						driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr[" + (z + 1) + "]/td[20]/a"))
						.click();
						System.out.println("Driver Send Survey Invitation By Email for PreProduction Enviornment");
					}
				break;
			}
		}
		return new BF_Manage_Surveysz_zSendSurveyInvitationByEmail();
	}
	
	
	public BF_Manage_Surveysz_zSendSurveyInvitationByEmail click_sendSurveyInviationBy_EmailIcon_HINDI() {
		List<WebElement> survey_name_list = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr/td[1]/a"));
		for (int z = 0; z < survey_name_list.size(); z++) {
			WebElement survey_name = survey_name_list.get(z);
			if (survey_name.getText().equalsIgnoreCase(prop.getProperty("surveyNameHINDI"))) {
				// ---------------Here we click Mail icon----//
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
					driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr[" + (z + 1) + "]/td[21]/a")).click();
					System.out.println("Driver Send Survey Invitation By Email for testing Enviornment");
					} else {
						driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr[" + (z + 1) + "]/td[20]/a"))
						.click();
						System.out.println("Driver Send Survey Invitation By Email for PreProduction Enviornment");
					}
				break;
			}
		}
		return new BF_Manage_Surveysz_zSendSurveyInvitationByEmail();
	}
	public BF_Manage_Surveysz_zSendSurveyInvitationByEmail ClickOnClient_SelectSurvey_ToSendEmail() {
		driver.findElement(By.xpath(
				"//table[@id='TableEdit_filtering']/tbody/tr/td/div[text()='Linked client']/div/table/tbody/tr/td/span/button//span[@class='ui-icon ui-icon-triangle-2-n-s']"))
				.click();
		List<WebElement> client_name_list = driver
				.findElements(By.xpath("//body[@class='page-surveys']/div/ul/li/label/span"));

		for (int a = 0; a < client_name_list.size(); a++) {
			WebElement client_name = client_name_list.get(a);
			if (client_name.getText().equalsIgnoreCase("A New Client")) {
				client_name.click();

				// ----------Send Survey invitation by E-mail--------//
				List<WebElement> survey_name_list = driver
						.findElements(By.xpath("//table[@id='table_rows']/tbody/tr/td[1]/a"));
				for (int z = 0; z < survey_name_list.size(); z++) {
					WebElement survey_name = survey_name_list.get(z);
					System.out.println(survey_name.getText());
					if (survey_name.getText().equalsIgnoreCase("AutoDemo_EmailSurvey_PleaseDoNotDelete")) {
						// ---------------Here we click Mail icon----//
						if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
							driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr[" + (z + 1) + "]/td[21]/a"))
							.click();
							} else {
								driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr[" + (z + 1) + "]/td[20]/a"))
								.click();
							}
						
						
						break;
					}
				}
				break;
			}
		}
		return new BF_Manage_Surveysz_zSendSurveyInvitationByEmail();
	}

	public BF_Manage_Surveysz_zSendSurveyInvitationBySMS ClickOnClient_SelectSurvey_ToSendSMS() {
		driver.findElement(By.xpath("//table[@id='TableEdit_filtering']/tbody/tr/td/div[text()='Linked client']/div/table/tbody/tr/td/span/button//span[@class='ui-icon ui-icon-triangle-2-n-s']")).click();
		List<WebElement> client_name_list_In_Survey = driver.findElements(By.xpath("//body[@class='page-surveys']/div/ul/li/label/span"));
		String title = driver.getTitle();
		System.out.println("Titile page :"+title);
		for(int c=1; c<=client_name_list_In_Survey.size(); c++) {
			WebElement client_name_In_Survey = client_name_list_In_Survey.get(c);
			if(client_name_In_Survey.getText().equalsIgnoreCase("A New Client")) {
				client_name_In_Survey.click();
				
				//----------Send Survey invitation by SMS--------//
				List<WebElement> survey_name_list = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr/td[1]/a"));
				for(int d=0; d<survey_name_list.size(); d++) {
					WebElement survey_name = survey_name_list.get(d);
					
					if(survey_name.getText().equalsIgnoreCase("AutoDemo_SMSSurvey_PleaseDoNotDelete")) {
						//---------------Here we click Send Invitation by SMS icon----//
						if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
						driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(d+1)+"]/td[20]/a")).click();
						System.out.println("Driver Send Survey Invitation By SMS for Testing Enviornment");
						
						} else {
							driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(d+1)+"]/td[19]/a")).click();
							System.out.println("Driver Send Survey Invitation By SMS for PreProduction Enviornment");
						}
						break;
					}
				}
				break;
			}
		}
		return new BF_Manage_Surveysz_zSendSurveyInvitationBySMS();
	}

	
}
