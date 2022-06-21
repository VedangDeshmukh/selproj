package com.prct.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
	
	static WebDriver driver;

	public static void main(String[] args) {

		String browser = "chrome";
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equals("safari")) {
			driver = new SafariDriver();
		}
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
	}
	

}
