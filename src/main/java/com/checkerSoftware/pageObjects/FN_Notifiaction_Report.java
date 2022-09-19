package com.checkerSoftware.pageObjects;





import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class FN_Notifiaction_Report extends BaseClass {
	public FN_Notifiaction_Report() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='go']") WebElement show;
	@FindBy(xpath = "//a[text()='Back to main menu']") WebElement backToMainMenu;
	
	public A_MainMenu validateSMSsurvey() throws Throwable {
		Action.click(driver, show);
		List<WebElement> sent_SMS_Survey_Records = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr"));
		for(int f=1; f<=sent_SMS_Survey_Records.size(); f++) {

			String sample_Phone_Number = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(f)+"]/td[5]")).getText();
		
				
				if(sample_Phone_Number.equalsIgnoreCase(prop.getProperty("phoneNumber"))) {
					String Actual_sms_Content = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(f)+"]/td[4]")).getText();
					String Expected_SMS_content ="Which laptop you are using currently 1)Apple 2)DELL 3)HP 4)None of Above";
					Assert.assertTrue(Actual_sms_Content.equalsIgnoreCase(Expected_SMS_content)," Mismatch with SMS Text ");
					System.out.println("SMS text:- "+Actual_sms_Content);
					System.out.println("Successfully validate SMS text");
					
					String Actual_Sent_Massage_Status = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(f)+"]/td[6]")).getText();
					String Expected_Sent_Massage_Status = "Yes";
					Assert.assertTrue(Actual_Sent_Massage_Status.equalsIgnoreCase(Expected_Sent_Massage_Status), " Expected sent massage ststus is not Yes ");
					System.out.println("Actual Sent Massage Status:- "+Actual_Sent_Massage_Status);
					System.out.println("Successfully validate Sent Massage Status as Yes");
					
					
					Assert.assertTrue(sample_Phone_Number.equalsIgnoreCase(prop.getProperty("phoneNumber"))," Mismatch with phone Number ");
					System.out.println("Sample Phone Number:- "+sample_Phone_Number);
					System.out.println("Successfully validate Phone Number");
					
					
					String sent_at_Records = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(f)+"]/td[8]")).getText();
					System.out.println("Sent Records:- "+sent_at_Records);
					
					System.out.println("We succssfully validate SMS survey");
					
					
					Action.pageScroll(0, 150);
					Action.screenShot("D://Checker_Auto//ScreenShot//SMS_Survey//ScreenShot.png");
					
					
					Thread.sleep(4000);
					
					break;
				}
		}
		Action.click(driver, backToMainMenu);
		return new A_MainMenu();
	}

}
