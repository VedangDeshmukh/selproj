package com.prct.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserutil {
	
	WebDriver driver;
	
	public WebDriver init_Driver(String browsername) {
		
		System.out.println("browser is launcging"+browsername);
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browsername.equals("safari")) {
			driver = new SafariDriver();
		}else {
			System.out.println("please pass the correct browser, browser is incorrect:"+browsername);
		}
		
		return driver;
	}
	
	public void launchUrl(String url) {
		
		if(url==null) {
			return;
		}else if (url.isEmpty()) {
			return;
		}else {
			driver.get(url);
		}
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode() {
		return driver.getPageSource();
	}
	
	public void closePage() {
		driver.close();
	}
	
	public void quitePage() {
		driver.quit();
	}

}
