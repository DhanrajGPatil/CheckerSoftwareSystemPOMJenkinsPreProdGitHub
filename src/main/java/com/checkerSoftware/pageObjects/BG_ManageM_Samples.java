package com.checkerSoftware.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;


public class BG_ManageM_Samples extends BaseClass {

	public BG_ManageM_Samples() {
		PageFactory.initElements(driver, this);
	}

	// ---------------------------------------Client_Selection-----------------------------------------------//
	@FindBy(xpath = "//table[@id='TableEdit_filtering']/tbody/tr/td/div[text()='Linked client']/div/table/tbody/tr/td/span/button//span[@class='ui-icon ui-icon-triangle-2-n-s']")
	WebElement LinkedClientDropDown;
	@FindBy(xpath = "//body[@class='page-samples']/div/ul/li/label/span") List<WebElement> Client_Name_List;

	

                                      

	public BG_ManageMT_Samples_EditSampleRows ClickOnEditSampleRowsSMS() throws Throwable {
		
		Action.click(driver, LinkedClientDropDown);
		  
		
		
		List<WebElement> client_name_list = driver.findElements(By.xpath("//body[@class='page-samples']/div/ul/li/label/span"));
		
			
   		for(int a=0; a<client_name_list.size(); a++) {
   			WebElement client_name = client_name_list.get(a);
   			if(client_name.getText().equalsIgnoreCase("A New Client")) {
   				client_name.click();
   				System.out.println("Driver Select the Client to add Sample");
   				
   				
   				Thread.sleep(4000);
   				
 				List<WebElement> sample_Name_List = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr"));
 				
                 for(int b=1; b<=sample_Name_List.size(); b++) {
                 	
                 	WebElement sample_Name = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(b)+"]/td[1]/a"));
                 	
                 	if(sample_Name.getText().equalsIgnoreCase("AutoDemo_SMSSamples_PleaseDoNotDelete")) {
                 		
                 		driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(b)+"]/td[10]/a")).click();
                 		System.out.println("Driver Select survey to add Sample");
                 		
                 		break;
                 	}
                 }
   				
             break;
   			}
   		}	
			
		
		
		return new BG_ManageMT_Samples_EditSampleRows();
		
	}
	
	public BG_ManageMT_Samples_EditSampleRows ClickOnEditSampleRowsEmail() {
		 driver.findElement(By.xpath("//table[@id='TableEdit_filtering']/tbody/tr/td/div[text()='Linked client']/div/table/tbody/tr/td/span/button//span[@class='ui-icon ui-icon-triangle-2-n-s']")).click();
	        
	        List<WebElement> client_name_list = driver.findElements(By.xpath("//body[@class='page-samples']/div/ul/li/label/span"));
			
			for(int a=0; a<client_name_list.size(); a++) {
				WebElement client_name = client_name_list.get(a);
				if(client_name.getText().equalsIgnoreCase("A New Client")) {
					client_name.click();
					System.out.println("Driver Select the Client to add Sample");
					List<WebElement> sample_Name_List = driver.findElements(By.xpath("//table[@id='table_rows']/tbody/tr"));
	                for(int b=1; b<=sample_Name_List.size(); b++) {
	                	
	                	WebElement sample_Name = driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(b)+"]/td[1]/a"));
	                	if(sample_Name.getText().equalsIgnoreCase("AutoDemo_EmailSamples_PleaseDoNotDelete")) {
	                		
	                		driver.findElement(By.xpath("//table[@id='table_rows']/tbody/tr["+(b)+"]/td[10]/a")).click();
	                		System.out.println("Driver Select survey to add Sample");
	                          break;
	                	}
	                }	
	               break;
				}
			}	
			
			return new BG_ManageMT_Samples_EditSampleRows();
			
	}
}
