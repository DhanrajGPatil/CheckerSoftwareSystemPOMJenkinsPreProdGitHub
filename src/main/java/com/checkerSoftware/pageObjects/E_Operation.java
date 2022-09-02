package com.checkerSoftware.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

public class E_Operation extends BaseClass{

	public E_Operation() {
		PageFactory.initElements(driver, this);
	}

	//---------------------------Scheduling---------------------------//
	@FindBy(xpath = "//a[text()=' Handle finished reviews']") WebElement handleFinishedReviews;
	
	//------------------------- Field surveys------------------------//
	@FindBy(xpath = "//a[text()=' Field surveys']") WebElement fieldSurvey;
	
	public Eh_Operation_HandleFinishedReviews clickOnHandleFinishedReviws() throws Throwable {

		Action.click(driver, handleFinishedReviews);
		return new Eh_Operation_HandleFinishedReviews();
	}
	
	
	public Ef_Operation_FieldSurvey clickFieldSurvey() throws Throwable {
		Action.click(driver, fieldSurvey);
		return new Ef_Operation_FieldSurvey();
	}
}
