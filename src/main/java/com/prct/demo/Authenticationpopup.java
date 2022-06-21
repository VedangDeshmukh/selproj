package com.prct.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authenticationpopup {

	
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		String username = "admin";
		String password= "admin";
		//driver.get("http://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		driver.get("http://"+ username +":"+ password+"@"+   "the-internet.herokuapp.com/basic_auth");
		
	}

}
