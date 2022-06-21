package com.pract.synchronization;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcp {

	
	static WebDriver driver;
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		// WebDriverWait is the Explictly wait 
		// WebDriverWait(c) extends FluentWait(c) implements Wait(I)
		// it can be applied to webElement as well as nonWebElements 
		// it is a custom wait 
		
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		By email = By.id("Form_submitForm_Email");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(email)).sendKeys("vedang");
	}
	
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static WebElement waitForElementPresence(By locator , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementPresence(By locator , int timeout, int intervaltime) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, intervaltime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static List<WebElement> waitForElementsPresence(By locator , int timeout, int intervaltime) {
		WebDriverWait wait = new WebDriverWait(driver, timeout, intervaltime);
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	
	public static Alert waitForAleart(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		 return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAleartText(int timeout) {
		return	 waitForAleart(timeout).getText();
	}
	
	public static void acceptAleart(int timeout) {
		waitForAleart(timeout).accept();
	}
	
	public static void dismissAleart(int timeout) {
		waitForAleart(timeout).dismiss();
	}
	
	public static void sendKeysOnAleart(int timeout, String value) {
		waitForAleart(timeout).sendKeys(value);
	}
	
	public static String waitForTitleContains(int timeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if( wait.until(ExpectedConditions.titleContains(value))){
			return driver.getTitle();
		}else {
			return null;
		}
	}
	
	public static String waitForTitleIs(int timeout, String value) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if( wait.until(ExpectedConditions.titleIs(value))){
			return driver.getTitle();
		}else {
			return null;
		}
	}
	
	public static String waitForUrlIs(int timeout, String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if(wait.until(ExpectedConditions.urlToBe(url))){
			return driver.getCurrentUrl();
		}else {
			return null;
		}
	}
	
	public static  String waitForUrlConatain(String urlvalue, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		if(	wait.until(ExpectedConditions.urlContains(urlvalue))) {
			return driver.getCurrentUrl();
		}else {
			return null;
		}
	}
	
	
	public  void waitForFrameAndSwitchToIt(String name,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
	}
	
	public  void waitForFrameAndSwitchToIt(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public  void waitForFrameAndSwitchToIt(int frameindex,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));
	}
	
	public  void waitForFrameAndSwitchToIt(WebElement element,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public  WebElement waitForElementVisible(By locator , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public  List<WebElement> waitForElementsToBeVisible(By locator , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public WebElement waitForElementToBeClickable(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
	 return	wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void clickWhenReady(By locator) {
		waitForElementToBeClickable(10, locator).click();
	}
	
	
}
