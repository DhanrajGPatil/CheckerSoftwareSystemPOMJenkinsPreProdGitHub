package com.checkerSoftware.pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.checkerSoftware.actionDriver.Action;
import com.checkerSoftware.base.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xxEmailLogin_SubmitSurvey extends BaseClass{
	public static WebDriver driver;
	
	public xxEmailLogin_SubmitSurvey() {
		PageFactory.initElements(driver, this);
	}
	
	public void EmailLogin_SubmitSurvey() throws Throwable {
		launchAppOffice();
		driver.findElement(By.xpath("//div[contains(@class,'hero__buttons-container')]/a[1]")).click();
		driver.findElement(By.xpath("//small[text()='dhanraj.patil@checker-solutions.com']")).click();
		driver.findElement(By.xpath("//span[text()='Outlook']")).click();
		
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String office = it.next();
		String outBox = it.next();
		driver.switchTo().window(outBox);
		
		driver.findElement(By.xpath("//span[text()='Hi, This is DhanrajQA from Checker, Please complete the survey asap.']")).click();
		
		WebElement clickHere_For_Survey = driver.findElement(By.xpath("//a[text()='clickHere_For_Survey']"));
		String email_Survey_URL = clickHere_For_Survey.getAttribute("href");
		
		driver.get(email_Survey_URL);
		//driver.get("https://eu.checker-soft.com/testing/s_login.php?urltoken=h110gotaLjHFTDAK%2FsqIYL6mdYTHadMVQTjVVKjdVas9iWvhwg8aQA8xIUD2684CAo%2F4PYGKyTubbVBK9gwig9ZTw8keMkzMtoNKeoW4alPHeVkMPWnK%2FAlsNg%2FakgSd03PrJitUsTszEyMM5usmzIkFFd6U0Ml%2BlvDzkhn9Jeb1WnX6U7CeqJlQVEFwsqrNzZXDx%2BCajMJCeRSh2trgiRy1pmETMKCxZ85Q9gwtI2Q%3D");
		driver.manage().window().maximize();
		
		WebElement select_Laptop = driver.findElement(By.xpath("//select[@name='obj172546']"));
		Select select_Laptop_Dropdown = new Select(select_Laptop);
		select_Laptop_Dropdown.selectByVisibleText("HP");
		System.out.println("User select-*Which laptop you are using- As HP");
		
		//-------------Here user select--2.  On average, how many days do you spend on your laptop per week?--As--4/week------//
		driver.findElement(By.xpath("//div[@class='radioAnswersDiv']/div[4]/span")).click();
		System.out.println("Here user select--2.  On average, how many days do you spend on your laptop per week?--As--4/week");
		
	
		//-------------here user select--3.*how's your experience, for the service provide by you laptop company--Here we select option 1 and 3----//
		for(int i=1; i<4; i+=2) {
			driver.findElement(By.xpath("//table[@class='checkboxes_answers_table noanswer_obj172550 max-multiple']/tbody/tr["+(i)+"]/td/span/label/input")).click();
		}
		System.out.println("here user select--3.*how's your experience, for the service provide by you laptop company--- Here we select option 1 and 3");
		
		//-------------Here user Select Time as Now------------------------------------------------------------------------------------------------//
		driver.findElement(By.xpath("//a[@name='todayDate']")).click();
		
		//-------------here user submit the Survey----------------------------------------------------------------------------//
		driver.findElement(By.xpath("//input[@id='finishCrit']")).click();
		System.out.println("User sumbit the Survey");
		
		driver.quit();
	}

}
