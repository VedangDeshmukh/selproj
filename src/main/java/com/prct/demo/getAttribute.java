package com.prct.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getAttribute {
	
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		// get attribute method is use to get the attribute value of the webElement 
		
		String placeholder= driver.findElement(By.id("Form_submitForm_Name")).getAttribute("placeholder");
		
		System.out.println(placeholder);
		

	}

}
