package com.prct.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverBasic {

	public static void main(String[] args) {
		
		//start the seleniu server 
		//key and driver parth is madatory otherwise server will not start get the exception
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		
		// to launch the chrome browser 
		// session id is generated
		// WebDriver is the Interface and ChromeDriver is the class
		//this is the java top casting concepts child class object access by the parent interface referance varibale 
		
		WebDriver driver = new ChromeDriver();
		
		//to launch the url 
		//https:// is mandatory otherwise get the invalid argument excepation
		driver.get("https://www.google.com");
		
		//to the the url of the page
		String url =driver.getCurrentUrl();
		System.out.println("Url is"+url);
		
		//get the title of the webpage
		String title =driver.getTitle();
		System.out.println("Title is :"+title);
		
		//get the page source
		//System.out.println(driver.getPageSource());
		
		//to cloase and quite the browser
	//	driver.close();
		driver.quit();
		
	}

}
