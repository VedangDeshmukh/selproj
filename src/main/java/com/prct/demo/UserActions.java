package com.prct.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UserActions {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("http://mrbool.com/");
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		
//		By parent = By.className("menulink");
//		By link = By.linkText("COURSES");
//		
//		twoLevelMenuHandel(parent, link);
		
		By rightclick = By.xpath("//span[text()='right click me']");
		By options = By.xpath("//ul[@class='context-menu-list context-menu-root']//li[contains(@class,'context-menu-item context-menu-icon ')]");
		
		rightClickandSelect(rightclick, options, "Copy");
		
//		Actions act = new Actions(driver);
//		act.clickAndHold(null).moveToElement(null).release().build().perform();

		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

		public static void twoLevelMenuHandel(By parentLocator, By child) {
			Actions act = new Actions(driver);
					act.moveToElement(getElement(parentLocator)).perform();
					getElement(parentLocator).click();
		}
		
		public static void threeLevelMenuHandel(By parentLocator,By subparent, By child) {
			Actions act = new Actions(driver);
					act.moveToElement(getElement(parentLocator)).perform();
					act.moveToElement(getElement(subparent)).perform();
					getElement(parentLocator).click();
		}
		
		public static void rightClickandSelect(By locator, By optionsLocator, String value) {
			Actions act = new Actions(driver);
			act.contextClick(getElement(locator)).perform();

			List<WebElement> eleList = getElements(optionsLocator);
			for (WebElement e : eleList) {
				if (e.getText().equals(value)) {
					e.click();
					break;
				}
			}

		}
		
		
		public static void doActionsSendKeys(By loator, String value) {
			Actions act = new Actions(driver);
			act.sendKeys(getElement(loator), value);
		}
		
		public static void doActionsClick(By locator) {
			Actions act = new Actions(driver);
			act.click(getElement(locator));
		}
		
		
}
