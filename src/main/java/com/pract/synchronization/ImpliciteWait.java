package com.pract.synchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImpliciteWait {

	static WebDriver driver;
	
	public static void main(String[] args) {

		
		//Two types of wait 1- Static wait , 2- Dynamic wait 
		// static wait - Thread.sleep() : paus the execuation of the scrpit 
		// dynamic wait 
			//A- Implicite wait
			//B- Explicite wait
				//B.1 - WebDriverWait
				//B.2 - FluentWait
		
		//ImpliciteWait :
		//it is a dynamic wait , wait till the element is located 
		// it can be applied to only the webElement not non webElement
		// it is a global wait applied to all the webEleent
		
		//	**** driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS); ****

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.id("Form_submitForm_Name")).sendKeys("vedang");
		
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

		
		driver.findElement(By.id("Form_submitForm_Email")).sendKeys("ved@gmail.com");
		
		
	}

}
