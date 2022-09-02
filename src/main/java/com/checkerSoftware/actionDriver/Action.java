package com.checkerSoftware.actionDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.checkerSoftware.base.BaseClass;


public class Action extends BaseClass{
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void pageLoadTimeouts(WebDriver driver, int timeouts) {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static boolean type(WebElement ele, String text) throws Throwable {
		boolean flag = false;
		try{
			flag= ele.isDisplayed();
		    ele.clear();
            ele.sendKeys(text);
            flag = true;
		} catch (Exception e) {
			System.out.println("Location Not Found");
			flag = false;
		}finally {
			if(flag) {
				System.out.println("Successfully entered value");
			}else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}
	
	public static void click(WebDriver driver, WebElement ele) throws Throwable {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	
	public static void pageScroll(Integer x, Integer y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public static void screenShot(String location) throws IOException {
		Date currentdate = new Date();
		String screenshotFileName = currentdate.toString().replace(" ", "-");
		System.out.println(screenshotFileName);
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File file  = ss.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File (location));
		
	}

	

}
