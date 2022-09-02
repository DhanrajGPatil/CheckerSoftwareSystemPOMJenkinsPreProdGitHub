package com.checkerSoftware.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.checkerSoftware.base.BaseClass;

public class Eh_Operation_HandleFinishedReviews extends BaseClass{

	public Eh_Operation_HandleFinishedReviews() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateEmailSurveyOnServer() {
        driver.findElement(By.xpath("//select[@name='ClientID']//following-sibling::button//span[@class='ui-icon ui-icon-triangle-2-n-s']")).click();
		
		List<WebElement> client_Name_List = driver.findElements(By.xpath("//body[@class='page-crits-handling']/div[3]/ul/li"));
		for(int a=1; a<=client_Name_List.size(); a++) {
			WebElement client_Name = driver.findElement(By.xpath("//body[@class='page-crits-handling']/div[3]/ul/li["+(a)+"]/label/span"));
			System.out.println(client_Name.getText());
			if(client_Name.getText().equalsIgnoreCase("A New Client")) {
				client_Name.click();
				 
				driver.findElement(By.xpath("//input[@name='show']")).click();
				
				List<WebElement> HandleFinishedReviewList = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr"));
				Integer reviewCount = HandleFinishedReviewList.size();
				driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+reviewCount+"]/td[3]/a")).click();
				driver.findElement(By.xpath("//table[@id='side_menu']//a[text()='Edit entire review']")).click();
				
				//---------------Here comes Actual Validation part---------------------------//
				//---------------Review status must be -Finished, awaiting approval----------//
				String ExpectedReviewStatus = "Finished, awaiting approval";
				String ActualReviewStatus = driver.findElement(By.xpath("//span[text()='Review status']/following-sibling::span")).getText();
				Assert.assertEquals(ActualReviewStatus, ExpectedReviewStatus);
				System.out.println("Checked Staus succesfully it's Finished, awaiting approval ");
				
				//--------------We Check -2 *Which laptop you are using----------------------//
				String ExpectedLaptopSelected = "HP";
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				String ActualLaptopSelectedTesting = driver.findElement(By.xpath("//select[@name='obj172546']/option[@selected]")).getText();
				Assert.assertEquals(ActualLaptopSelectedTesting, ExpectedLaptopSelected);
				} else {
					String ActualLaptopSelectedpreProd = driver.findElement(By.xpath("//select[@name='obj349813']/option[@selected]")).getText();
					Assert.assertEquals(ActualLaptopSelectedpreProd, ExpectedLaptopSelected);
				}
				System.out.println("Successfuly checked -2 *Which laptop you are using- As-HP ");
				
				//--------------We check -3 On average, how many days do you spend on your laptop per week?--//
				String ExpectedHourPerWeek = "4 day/week";
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				String ActualHourPerWeekTesting = driver.findElement(By.xpath("//span[text()='On average, how many days do you spend on your laptop per week?']/parent::td/table/tbody/tr/td[2]//label[@class='radioAnswers radioAnswersChecked']/span")).getText();
				Assert.assertEquals(ActualHourPerWeekTesting, ExpectedHourPerWeek);
				} else {
					String ActualHourPerWeekpreProd = driver.findElement(By.xpath("//span[text()='On average, how many days do you spend on your laptop per week?']/parent::span/table/tbody/tr[5]/td[2]//span[@class='radioAnswers radioAnswersChecked']/a")).getText();
					Assert.assertEquals(ActualHourPerWeekpreProd, ExpectedHourPerWeek);
				}
				System.out.println("Sucessfully Checked -3 On average, how many days do you spend on your laptop per week?- AS 4 day/week");
				
				//------------We check -4 *how's your experience, for the service provide by you laptop company--//
				
				
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				String ExpectedServiceAnswer1ID = "75662";
				String ActualServiceAnswer1= driver.findElement(By.xpath("//p[text()='You can only select 3 choice(s) below']/parent::span/table/tbody/tr[1]/td/span/label//input[@class='checkboxAnswers checkboxAnswersChecked']")).getAttribute("value");
				Assert.assertEquals(ActualServiceAnswer1, ExpectedServiceAnswer1ID);
				} else {
					String ExpectedServiceAnswer1ID = "99735";
					String ActualServiceAnswer1= driver.findElement(By.xpath("//p[text()='You can only select 3 choice(s) below']/parent::span/table/tbody/tr[1]/td/span/label//input[@class='checkboxAnswers checkboxAnswersChecked']")).getAttribute("value");
					Assert.assertEquals(ActualServiceAnswer1, ExpectedServiceAnswer1ID);
				}
				
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				String ExpectedServiceAnswer2ID = "75664";
				String ActualServiceAnswer2= driver.findElement(By.xpath("//p[text()='You can only select 3 choice(s) below']/parent::span/table/tbody/tr[3]/td/span/label//input[@class='checkboxAnswers checkboxAnswersChecked']")).getAttribute("value");
				Assert.assertEquals(ActualServiceAnswer2, ExpectedServiceAnswer2ID);
				} else {
					String ExpectedServiceAnswer2ID = "99737";
					String ActualServiceAnswer2= driver.findElement(By.xpath("//p[text()='You can only select 3 choice(s) below']/parent::span/table/tbody/tr[3]/td/span/label//input[@class='checkboxAnswers checkboxAnswersChecked']")).getAttribute("value");
					System.out.println(ActualServiceAnswer2);
					Assert.assertEquals(ActualServiceAnswer2, ExpectedServiceAnswer2ID);
				}
				
				
				System.out.println("Successfully Checked -4 *how's your experience, for the service provide by you laptop company");
				
				
				driver.findElement(By.xpath("//input[@name='saveandapprove']")).click();
				
				//---------------Here we Click Edit entire Review------------//
				driver.findElement(By.xpath("//table[@id='side_menu']//a[text()='Edit entire review']")).click();
				
				//---------------Review status must be -Approved----------//
				String ExpectedReviewStatusAfterApprove = "Approved";
				String ActualReviewStatusAfterApprove = driver.findElement(By.xpath("//span[text()='Review status']/following-sibling::span")).getText();
				Assert.assertEquals(ActualReviewStatusAfterApprove, ExpectedReviewStatusAfterApprove);
				System.out.println("Checked Staus succesfully it's Approved");
				
				//--------------We Check -2 *Which laptop you are using----------------------//
				String ExpectedLaptopSelectedApprove = "HP";
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				String ActualLaptopSelectedTestingApprove = driver.findElement(By.xpath("//select[@name='obj172546']/option[@selected]")).getText();
				Assert.assertEquals(ActualLaptopSelectedTestingApprove, ExpectedLaptopSelectedApprove);
				} else {
					String ActualLaptopSelectedpreProdApprove = driver.findElement(By.xpath("//select[@name='obj349813']/option[@selected]")).getText();
					Assert.assertEquals(ActualLaptopSelectedpreProdApprove, ExpectedLaptopSelectedApprove);
				}
				System.out.println("Successfuly checked -2 *Which laptop you are using- As-HP ");
				
				//--------------We check -3 On average, how many days do you spend on your laptop per week?--//
				String ExpectedHourPerWeekApprove = "4 day/week";
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
				String ActualHourPerWeekTestingApprove = driver.findElement(By.xpath("//span[text()='On average, how many days do you spend on your laptop per week?']/parent::td/table/tbody/tr/td[2]//label[@class='radioAnswers radioAnswersChecked']/span")).getText();
				Assert.assertEquals(ActualHourPerWeekTestingApprove, ExpectedHourPerWeekApprove);
				} else {
					String ActualHourPerWeekpreProdApprove = driver.findElement(By.xpath("//span[text()='On average, how many days do you spend on your laptop per week?']/parent::span/table/tbody/tr[5]/td[2]//span[@class='radioAnswers radioAnswersChecked']/a")).getText();
					Assert.assertEquals(ActualHourPerWeekpreProdApprove, ExpectedHourPerWeekApprove);
				}
				System.out.println("Sucessfully Checked -3 On average, how many days do you spend on your laptop per week?- AS 4 day/week");
				
                //------------We check -4 *how's your experience, for the service provide by you laptop company--//
				
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
					String ExpectedServiceAnswer1IDApprove = "75662";
					String ActualServiceAnswer1Approve= driver.findElement(By.xpath("//p[text()='You can only select 3 choice(s) below']/parent::span/table/tbody/tr[1]/td/span/label//input[@class='checkboxAnswers checkboxAnswersChecked']")).getAttribute("value");
					Assert.assertEquals(ActualServiceAnswer1Approve, ExpectedServiceAnswer1IDApprove);
					} else {
						String ExpectedServiceAnswer1IDApprove = "99735";
						String ActualServiceAnswer1Approve= driver.findElement(By.xpath("//p[text()='You can only select 3 choice(s) below']/parent::span/table/tbody/tr[1]/td/span/label//input[@class='checkboxAnswers checkboxAnswersChecked']")).getAttribute("value");
						Assert.assertEquals(ActualServiceAnswer1Approve, ExpectedServiceAnswer1IDApprove);
					}
					
					if(prop.getProperty("WorkingURL").equalsIgnoreCase("Testing")) {
					String ExpectedServiceAnswer2IDApprove = "75664";
					String ActualServiceAnswer2Approve= driver.findElement(By.xpath("//p[text()='You can only select 3 choice(s) below']/parent::span/table/tbody/tr[3]/td/span/label//input[@class='checkboxAnswers checkboxAnswersChecked']")).getAttribute("value");
					Assert.assertEquals(ActualServiceAnswer2Approve, ExpectedServiceAnswer2IDApprove);
					} else {
						String ExpectedServiceAnswer2IDApproveApprove = "99737";
						String ActualServiceAnswer2Approve= driver.findElement(By.xpath("//p[text()='You can only select 3 choice(s) below']/parent::span/table/tbody/tr[3]/td/span/label//input[@class='checkboxAnswers checkboxAnswersChecked']")).getAttribute("value");
						
						Assert.assertEquals(ActualServiceAnswer2Approve, ExpectedServiceAnswer2IDApproveApprove);
					}
					
					
					System.out.println("Successfully Checked -4 *how's your experience, for the service provide by you laptop company");
				
		break;
	}
	}
		
	}
}
