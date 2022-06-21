package com.prct.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionId {
	
	static WebDriver driver;

	public static void main(String[] args) {

			Browserutil br = new Browserutil();
			
			driver= br.init_Driver("chrome");// session id is generated when driver = new ChromeDriver() line execute
			br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/"); 
			
			System.out.println("Title of the Page is:"+br.getPageTitle());
			
			driver.findElement(By.id("Form_submitForm_Email")).sendKeys("TestNameEmail");
			
		/*	driver.close();
			
			driver.findElement(By.id("Form_submitForm_Name")).sendKeys("TestName");//Exception in thread "main" org.openqa.selenium.NoSuchSessionException: invalid session id

		*/
			
			driver.quit();
			

			driver.findElement(By.id("Form_submitForm_Name")).sendKeys("TestName");//Exception in thread "main" org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
			
			
			
	}

}
