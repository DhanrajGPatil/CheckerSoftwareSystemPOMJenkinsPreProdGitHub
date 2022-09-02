package com.checkerSoftware.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class Ef_Operation_FieldSurvey extends BaseClass{
	
	public Ef_Operation_FieldSurvey() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Edit specific quotas']") WebElement EditSpecificQuotas;
	
	

	public ArrayList<Integer> getAllocation_SurveyCount_LeftToDo() throws Throwable {
        ArrayList<Integer> Allocation_SurveyCount_LeftToDo = new ArrayList<Integer>();
		List<WebElement> SurveyNameList = driver.findElements(By.xpath("//*[@id='table_rows']/tbody/tr"));
		for(int a=1; a<=SurveyNameList.size(); a++) {
			WebElement SurveyName = driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+a+"]/td[1]/a"));
			if(SurveyName.getText().equalsIgnoreCase(prop.getProperty("SurveyName"))) {
				/*
				String TargetQuotaString = driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+a+"]/td[5]")).getText();
				String SurveyCountString = driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+a+"]/td[6]")).getText();
				String LeftToDoString = driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+a+"]/td[7]")).getText();
				
				Integer TargetQuota= Integer.parseInt(TargetQuotaString);
				TargetQuota_SurveyCount_LeftToDo.add(0, TargetQuota);
				Integer SurveyCount= Integer.parseInt(SurveyCountString);
				TargetQuota_SurveyCount_LeftToDo.add(1, SurveyCount);
				Integer LeftToDo= Integer.parseInt(LeftToDoString);
				TargetQuota_SurveyCount_LeftToDo.add(2, LeftToDo);
				*/
				
				// Here it click Field Survey Allocation
				if(prop.getProperty("WorkingURL").equalsIgnoreCase("preProd")) {
				driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+a+"]/td[9]/a")).click();
				}if(prop.getProperty("WorkingURL").equalsIgnoreCase("testing")) {
					driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+a+"]/td[10]/a")).click();
				}
				
				
				//1st Check Surveyor and fetch allocation and interview Done.
				List<WebElement> SurveyorList = driver.findElements(By.xpath("//*[@id='table_rows']/tbody/tr"));
				for(int b=1; b<=SurveyorList.size(); b++) {
					WebElement SurveyorName = driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+b+"]/td/a"));
					if(SurveyorName.getText().equalsIgnoreCase("PatilRajG")) {
					
						String AllocationString = driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+b+"]/td[2]")).getText();
						Integer Allocation = Integer.parseInt(AllocationString);
						Allocation_SurveyCount_LeftToDo.add(0, Allocation);
						String SurveyCountString = driver.findElement(By.xpath("//*[@id='table_rows']/tbody/tr["+b+"]/td[3]")).getText();
						Integer SurveyCount = Integer.parseInt(SurveyCountString);
						Allocation_SurveyCount_LeftToDo.add(1, SurveyCount);
						
						Integer LeftToDo = Allocation-SurveyCount;
						Allocation_SurveyCount_LeftToDo.add(2, LeftToDo);
						
						//Go to Edit specific quota
						Action.click(driver, EditSpecificQuotas);
						
						
						// Go to specific surveyor and validate allocation and Survey Count
						List<WebElement> SurveyorListInSpecificQuota = driver.findElements(By.xpath("//*[@id=\"specific_quotas\"]/tbody[1]/tr"));
						for(int c=1; c<=SurveyorListInSpecificQuota.size(); c++) {
							WebElement SurveyorNameInSpecificQuota = driver.findElement(By.xpath("//*[@id='specific_quotas']/tbody[1]/tr["+c+"]/td[1]"));
							if(SurveyorNameInSpecificQuota.getText().equalsIgnoreCase("PatilRajG")) {
								// Validate Left To Do Count
								String LeftTODoINSpecificQuotaString = driver.findElement(By.xpath("//*[@id='specific_quotas']/tbody[1]/tr[1]/td[2]/center/table/tbody/tr[1]/td/center/b")).getText();
								Integer LeftTODoINSpecificQuota = Integer.parseInt(LeftTODoINSpecificQuotaString);
								Assert.assertEquals(LeftTODoINSpecificQuota, (Allocation-SurveyCount), " The left to do interview is not as per Field survey allocation in Edit specific quota");
								
								//Validate Survey Count 
								String SurveyCountInSpecificQuotaString = driver.findElement(By.xpath("//*[@id='specific_quotas']/tbody[1]/tr[1]/td[2]/center/table/tbody/tr[2]/td[1]")).getText();
						        Integer SurveyCountInSpecificQuota = Integer.parseInt(SurveyCountInSpecificQuotaString);
						        Assert.assertEquals(SurveyCountInSpecificQuota, SurveyCount, " The Survey Count interview is not as per Field survey allocation in Edit specific quota");
								
						        //Validate Allocation
						        /*
						        WebElement AllocationInSpecificQuotaString = driver.findElement(By.xpath("//*[@id='specific_quotas']/tbody[1]/tr[1]/td[2]/center/table/tbody/tr[2]/td[3]/text()"));
						        String AllocationInSpecificQuotaString1 = AllocationInSpecificQuotaString.getText();
						        Integer AllocationInSpecificQuota = Integer.parseInt(AllocationInSpecificQuotaString1);
						        Assert.assertEquals(AllocationInSpecificQuota, Allocation, " The Allocation Count of interview is not as per Field survey allocation in Edit specific quota");
						        
						        */
						        //Validate % Completion in Edit Specific quota
						        String percentageCompletionEditSpecificQuotaString = driver.findElement(By.xpath("//*[@id='specific_quotas']/tbody[1]/tr[1]/td[2]/center/table/tbody/tr[2]/td[3]/span/span[2]/a")).getText();
						        Double percentageCompletionEditSpecificQuota = Double.parseDouble(percentageCompletionEditSpecificQuotaString);
						         
						        
						        
						        
						        
								break;
							}
						}
						
						break;
					}
			}
		break;		
		}
		
		
		
	}
		return Allocation_SurveyCount_LeftToDo;
		
}
}