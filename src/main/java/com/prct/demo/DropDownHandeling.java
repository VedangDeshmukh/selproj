package com.prct.demo;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Sides;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandeling {
	
	static WebDriver driver;

	public static void main(String[] args) {

		//To handel the dropdown we use Select class 
		
		//Select s = new Select(WebElement);
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By countryoptions = By.id("//select[@id='Form_submitForm_Country']//option");
		By country = By.id("Form_submitForm_Country");
		
		//doSelectDropDownValueByVisibaleText(country, "India");
		
		
//	 List<String> countryoptionss = getDropDownOptions(country);
//	 System.out.println(countryoptionss);
	 
	 
	// selectDropDownValueByOptions(country, "India");
	 
	 //driver.findElement(country).click();
	 
	 Actions act = new Actions(driver);
	 act.click(driver.findElement(country)).click();
	 
	 try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 selectDropDownValueByOptions(country, "India");
	 
	}
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doSelectDropDownValueByIndex(By locator, int index) {
		Select s = new Select(getElement(locator));
		s.selectByIndex(index);
	}
	
	public static void doSelectDropDownValueByValue(By locator, String value) {
		Select s = new Select(getElement(locator));
		s.selectByValue(value);
	}
	
	public static void doSelectDropDownValueByVisibaleText(By locator, String text) {
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(text);
	}
	
	public static List<String> getDropDownOptions(By locator) {

		List<String> optionsList = new ArrayList<>();

		Select s = new Select(getElement(locator));
		List<WebElement> eleList = s.getOptions();
		System.out.println("Size of options:" + eleList.size());

		for (WebElement e : eleList) {
			String text = e.getText();
			optionsList.add(text);

		}

		return optionsList;

	}
	
	
	public static void selectDropDownValueByOptions(By locator, String value) {

		Select s = new Select(getElement(locator));
		List<WebElement> dropdownelements = s.getOptions();

		for (WebElement e : dropdownelements) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}
	
	public void selectDropDownValue(By locator, String value) {

		List<WebElement> dropdownelements = getElements(locator);

		for (WebElement e : dropdownelements) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}

		}

	}

}
