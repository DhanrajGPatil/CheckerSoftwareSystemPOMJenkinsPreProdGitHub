package com.checkerSoftware.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class BF_Manage_Surveys_EditSurvey extends BaseClass{
	
	public BF_Manage_Surveys_EditSurvey() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p") WebElement content_InFrame_Testing;
	@FindBy(xpath= "//body[@class='cke_show_borders']/p") WebElement content_InFrame_preProd;
	@FindBy(tagName= "a") List<WebElement> tagName_a_List;
	@FindBy(xpath= "//input[@name='field_EmailSubj']") WebElement emailSubjectForInvitation;
	@FindBy(xpath= "//input[@name='_SurveysSubjAltLangs_AltLangID_38']") WebElement emailSubjectForInvitation_HINDI_Testing;
	@FindBy(xpath= "//input[@name='_SurveysSubjAltLangs_AltLangID_63']") WebElement emailSubjectForInvitation_HINDI_preProd;
	@FindBy(xpath= "//input[@name='field_EmailLinkText']") WebElement LinkText_for_Invitation;
	@FindBy(xpath= "//input[@name='_SurveysLinkAltLangs_AltLangID_38']") WebElement LinkText_for_Invitation_HINDI_Testing;
	@FindBy(xpath= "//input[@name='_SurveysLinkAltLangs_AltLangID_63']") WebElement LinkText_for_Invitation_HINDI_preProd;
	
	@FindBy(xpath= "//input[@name='field_LandingPage']") WebElement linkToGoAfterFillingSurvey;
	@FindBy(xpath= "//input[@name='field_RedirectAfter']") WebElement wait;
	@FindBy(xpath= "//input[@name='field_FromName']") WebElement FromName;
	@FindBy(xpath= "//input[@name='field_Email']") WebElement Email_Sender;
	@FindBy(xpath= "//*[@name='field_EmailServerType']/following-sibling::button/span[@class]") WebElement typeOfMailServerDownArrow;
	@FindBy(xpath= "(//*[@class='ui-multiselect-checkboxes ui-helper-reset'])[8]/li/label/span") List<WebElement> serverList;
	@FindBy(xpath= "//input[@name='field_EmailThankYouSubject']") WebElement enter_ThankYouMessage_Email_Subject;
	@FindBy(xpath= "//*[@id='field_EmailThankYouMessage']") WebElement enter_ThankYouMessage_Body_to_be_Sent_by_Email;
	@FindBy(xpath= "//input[@name='field_SMSSurveyValidityDuration']") WebElement field_SMSSurveyValidityDuration;
	@FindBy(xpath= "//input[@name='save']") WebElement saveButton;
	
	
	
	
	public void clickShowButton() {
		for(WebElement link : tagName_a_List) {
			if(link.getAttribute("href").equalsIgnoreCase("javascript:ShowHideFileds();")) {
				link.click();
				System.out.println("Click show button");
				break;
			}
		}
	}
	
	public void clearSurveyHINDI() throws InterruptedException {
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
	    	  int[] frames = {2, 12};  
		    	//List<WebElement> frames = driver.findElements(By.tagName("iframe"));
					for(int k=0; k<frames.length; k++) {
						Thread.sleep(2000);
					driver.switchTo().frame(frames[k]);
					driver.findElement(By.tagName("p")).sendKeys("ABC");
				    driver.switchTo().defaultContent();
					}
	    	  
	      }if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
	    	  int[] frames = {5, 8};
	    	//List<WebElement> frames = driver.findElements(By.tagName("iframe"));
				for(int k=0; k<frames.length; k++) {
					Thread.sleep(2000);
				driver.switchTo().frame(frames[k]);
				driver.findElement(By.tagName("p")).sendKeys("ABC");
			    driver.switchTo().defaultContent();
				}
	      }
				
		Thread.sleep(2000);
		List<WebElement> bodyies = driver.findElements(By.xpath("//*[@class='cke_path']/a[1]"));
		for(WebElement body : bodyies) {
			Thread.sleep(3000);
			body.click();
			}
		Thread.sleep(2000);
		List<WebElement> cutList;
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		cutList = driver.findElements(By.xpath("//*[@class='cke_button cke_button__cut cke_button_off']"));
		for(WebElement cut : cutList) {
			Thread.sleep(2000);
			cut.click();
		   }
		}
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			cutList = driver.findElements(By.xpath("//*[@class='cke_button_cut cke_off']"));
			for(WebElement cut : cutList) {
				Thread.sleep(2000);
				cut.click();
		               }
		    }
		System.out.println("Driver Clear's the privious data in survey");
	}		
		
	public void clearSurvey() throws InterruptedException {
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
	    	  int[] frames = {1, 12};  // 2 not required in hindi
		    	//List<WebElement> frames = driver.findElements(By.tagName("iframe"));
					for(int k=0; k<frames.length; k++) {
						Thread.sleep(2000);
					driver.switchTo().frame(frames[k]);
					driver.findElement(By.tagName("p")).sendKeys("ABC");
				    driver.switchTo().defaultContent();
					}
	    	  
	      }if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
	    	  int[] frames = {1, 8};
	    	//List<WebElement> frames = driver.findElements(By.tagName("iframe"));
				for(int k=0; k<frames.length; k++) {
					Thread.sleep(2000);
				driver.switchTo().frame(frames[k]);
				driver.findElement(By.tagName("p")).sendKeys("ABC");
			    driver.switchTo().defaultContent();
				}
	      }
				
		Thread.sleep(2000);
		List<WebElement> bodyies = driver.findElements(By.xpath("//*[@class='cke_path']/a[1]"));
		for(WebElement body : bodyies) {
			Thread.sleep(3000);
			body.click();
			}
		Thread.sleep(2000);
		List<WebElement> cutList;
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		cutList = driver.findElements(By.xpath("//*[@class='cke_button cke_button__cut cke_button_off']"));
		for(WebElement cut : cutList) {
			Thread.sleep(2000);
			cut.click();
		   }
		}
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			cutList = driver.findElements(By.xpath("//*[@class='cke_button_cut cke_off']"));
			for(WebElement cut : cutList) {
				Thread.sleep(2000);
				cut.click();
		               }
		    }
		System.out.println("Driver Clear's the privious data in survey");
	}
	
	
	public void enter_E_mail_SubjectForInvitation() throws Throwable {
		Action.type(emailSubjectForInvitation, prop.getProperty("E_mail_Subject_For_Invitation"));
		System.out.println("Enter E mail Subject for Invitaion as: ["+prop.getProperty("E_mail_Subject_For_Invitation")+"]");
	}
	
	public void enter_E_mail_SubjectForInvitation_HINDI() throws Throwable {
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		Action.type(emailSubjectForInvitation_HINDI_Testing, prop.getProperty("E_mail_Subject_For_Invitation_HINDI"));
		       System.out.println("Enter E mail Subject in HINDI for Invitaion as: ["+prop.getProperty("E_mail_Subject_For_Invitation_HINDI")+"]");
		}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			Action.type(emailSubjectForInvitation_HINDI_preProd, prop.getProperty("E_mail_Subject_For_Invitation_HINDI"));
			   System.out.println("Enter E mail Subject in HINDI for Invitaion as: ["+prop.getProperty("E_mail_Subject_For_Invitation_HINDI")+"]");
		}
		
	}
	
	public void enter_e_mail_Body_For_Invitation() throws Throwable {
		Thread.sleep(5000);
		if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		driver.switchTo().frame(1);
		//driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p[1]")).clear();
		Action.type(content_InFrame_Testing, prop.getProperty("E_mail_Body_For_Invitation"));
		   System.out.println("Enter E mail Body for Invitaion as: ["+prop.getProperty("E_mail_Body_For_Invitation")+"]");
		driver.switchTo().defaultContent();
		}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			driver.switchTo().frame(1);
			Action.type(content_InFrame_preProd, prop.getProperty("E_mail_Body_For_Invitation"));
			  System.out.println("Enter E mail Body for Invitaion as: ["+prop.getProperty("E_mail_Body_For_Invitation")+"]");
			driver.switchTo().defaultContent();	
		}
		
	}
	
    public void enter_e_mail_Body_For_Invitation_HINDI() throws Throwable {
    	Thread.sleep(5000);
    	if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		driver.switchTo().frame(2);	
		//driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p[1]")).clear();
		Action.type(content_InFrame_Testing, prop.getProperty("E_mail_Body_For_Invitation_HINDI"));
		System.out.println("Enter E mail Body in HINDI for Invitaion as: ["+prop.getProperty("E_mail_Body_For_Invitation_HINDI")+"]");
		driver.switchTo().defaultContent();
    	}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			driver.switchTo().frame(5);
			
			Action.type(content_InFrame_preProd, prop.getProperty("E_mail_Body_For_Invitation_HINDI"));
			  System.out.println("Enter E mail Body in HINDI for Invitaion as: ["+prop.getProperty("E_mail_Body_For_Invitation_HINDI")+"]");
			driver.switchTo().defaultContent();	
		}
    	
	}
	
    public void enter_LinkText_for_Invitation() throws Throwable {
    	Action.type(LinkText_for_Invitation, prop.getProperty("LinkText"));
    	System.out.println("Enter Link Text for Invitaion as: ["+prop.getProperty("LinkText")+"]");
    }
    
    public void enter_LinkText_for_Invitation_HINDI() throws Throwable {
    	if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
    	Action.type(LinkText_for_Invitation_HINDI_Testing, prop.getProperty("LinkText_HINDI"));
    	System.out.println("Enter Link Text in HINDI for Invitaion as: ["+prop.getProperty("LinkText_HINDI")+"]");
    	}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
    	Action.type(LinkText_for_Invitation_HINDI_preProd, prop.getProperty("LinkText_HINDI"));
    	System.out.println("Enter Link Text in HINDI for Invitaion as: ["+prop.getProperty("LinkText_HINDI")+"]");
    	}
    	
    }
    
    
    public void enter_ThankYouMessage_RightAfterFiliingTheSurvey() throws Throwable {
    	Thread.sleep(5000);
    	if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
		driver.switchTo().frame(12);
		//driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p[1]")).clear();
		Action.type(content_InFrame_Testing, prop.getProperty("ThankYouMessage_right_after_FillingTheSurvey"));
		System.out.println("Enter Thank you massage Right After filling the survey as: ["+prop.getProperty("ThankYouMessage_right_after_FillingTheSurvey")+"]");
		driver.switchTo().defaultContent();
    	}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
			driver.switchTo().frame(8);
			
			Action.type(content_InFrame_preProd, prop.getProperty("ThankYouMessage_right_after_FillingTheSurvey"));
			System.out.println("Enter Thank you massage Right After filling the survey as: ["+prop.getProperty("ThankYouMessage_right_after_FillingTheSurvey")+"]");
			driver.switchTo().defaultContent();	
		}
    	
    }
	
    public void enter_link_toGoAfterSurvey() throws Throwable {
    	Action.type(linkToGoAfterFillingSurvey, prop.getProperty("AfterThanking_GoTo_ThisLink"));
    	System.out.println("Enter link Where driver should go after waiting some time as: ["+prop.getProperty("AfterThanking_GoTo_ThisLink")+"]");
    }
	
    public void Waitbefore_going_ToTheLinkIn_Seconds() throws Throwable {
    	Action.type(wait, prop.getProperty("Waitbefore_going_ToTheLinkIn_Seconds"));
    	System.out.println("Enter pause seconds as: ["+prop.getProperty("Waitbefore_going_ToTheLinkIn_Seconds")+"]");
    }
    
    public void enter_FromName() throws Throwable {
    	if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
    	Action.type(FromName, prop.getProperty("From_Name_Testing"));
    	System.out.println("Enter From Name as: ["+prop.getProperty("From_Name_Testing")+"]");
    	}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
    		Action.type(FromName, prop.getProperty("From_Name_preProd"));
    		System.out.println("Enter From Name as: ["+prop.getProperty("From_Name_preProd")+"]");
    	}
    	
    }
    
    public void enter_Email_Sender() throws Throwable {
    	if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
    	Action.type(Email_Sender, prop.getProperty("Email_Sender_Testing"));
    	System.out.println("Enter Email sender as: ["+prop.getProperty("Email_Sender_Testing")+"]");
    	}if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
    		Action.type(Email_Sender, prop.getProperty("Email_Sender_preProd"));
    		System.out.println("Enter Email sender as: ["+prop.getProperty("Email_Sender_preProd")+"]");
    	}
    	
    }

    public void select_TypeOfMailServer() throws Throwable {
    	Action.click(driver, typeOfMailServerDownArrow);
    	for(WebElement server : serverList) {
    		if(server.getText().equalsIgnoreCase(prop.getProperty("TypeOf_Mail_server"))) {
    			server.click();
    			System.out.println("Enter type of mail server as: ["+prop.getProperty("TypeOf_Mail_server")+"]");
    			break;
    		}
    	}
    	
    	
    }
    
    public void enter_ThankYouMessage_Email_Subject() throws Throwable {
    	Action.type(enter_ThankYouMessage_Email_Subject, prop.getProperty("ThankYouEmail_Message_Email_Subject"));
    }
    
    public void enter_ThankYouMessage_Body_to_be_Sent_by_Email() throws Throwable {
    	Action.type(enter_ThankYouMessage_Body_to_be_Sent_by_Email, prop.getProperty("ThankYouEmail_Message_Body_to_be_Sent_by_Email"));
    	System.out.println("Enter thank you massage mail Subject as: "+prop.getProperty("ThankYouEmail_Message_Body_to_be_Sent_by_Email")+"]");
    }
    
    public void SMSsurveyinvitationexpiresafterXhours() throws Throwable {
    	Action.type(field_SMSSurveyValidityDuration, "1");
    }
    public BF_Manage_Surveys click_SaveButton() throws Throwable {
    	Action.click(driver, saveButton);
    	System.out.println("Click Save survey button");
    	return new BF_Manage_Surveys();
    }
    
    
}
