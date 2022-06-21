package com.prct.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	
	 static WebDriver driver;
	 
	public static void main(String[] args) {

		
		// 8 types of locator in Selenium
		//1-By.id, 2-By.name, 3-By.xpath , 4-By.cssSelector, 5-By.linkText, 6.By.partialLinkText, 7.By.tagName, By.className
		
	/*	By.id("");
		By.name("");
		By.linkText("");
		By.partialLinkText("");
		By.xpath("");
		By.cssSelector("");
		By.tagName("");
		By.className(""); */
		
		
		
		
		// Different locator Startegy 
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		
		//1 cretaing the webelemnt with action
		
		driver.findElement(By.id("Form_submitForm_Name")).sendKeys("Hello");
		
		//2 - create the webElement and then perform the action
		
		WebElement email =driver.findElement(By.id("Form_submitForm_Name"));
		email.sendKeys("hello");
		
		//3- By locator
		
		By name = By.id("Form_submitForm_Name");
		driver.findElement(name).sendKeys("helo");
		
		//4- generice method
		
		getElement(name).sendKeys("hello");
		
		// 5- generic method with actions
		
		doSendKeys(name, "hello");
		
		//6 - ElementUtil class
		
		
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}

}
