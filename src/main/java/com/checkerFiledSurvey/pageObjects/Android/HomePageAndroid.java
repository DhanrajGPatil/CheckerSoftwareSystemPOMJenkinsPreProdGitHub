package com.checkerFiledSurvey.pageObjects.Android;



import com.checkerFiledSurvey.base.Android.baseTest;


import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class HomePageAndroid extends baseTest{



	//driver.findElement(By.id("com.mor.sa.android.activities:id/layout_tab_one")).click();
	@AndroidFindBy(id = "com.mor.sa.android.activities:id/layout_tab_one")
	private AndroidElement AssignedTab;
	
	public void clickAssignedTab() 
	{
		AssignedTab.click();
	}
}
