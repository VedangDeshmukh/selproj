package com.pract.synchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Fluentwait is the Dynamci wait 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(Duration.ofSeconds(10)).
				pollingEvery(Duration.ofMillis(2000)).
				ignoring(NoSuchElementException.class);
		
		By email = By.id("idddd");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("bbb");
		
	}

}
