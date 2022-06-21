package com.prct.demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLinks {
	
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		// count the no links on webpage and display also ignore the blank links 
		
		
		//to locate the no of elements on webPage we use findElements 
		// return type of webelements is List<WebElement>
		// to access the webelement need to iterate and then access
		
//	     List<WebElement> linksele=	driver.findElements(By.tagName("a"));
		
		By linksele = By.tagName("a");
		
		By ele = By.xpath("//div[@id='nav-xshop-container']//a");
	     
//	     System.out.println("Size of links are:"+linksele.size());
//	     
//	     for(int i = 0 ; i<linksele.size();i++) {
//	    	 
//	    	String linktext= linksele.get(i).getText();
//	    	if(!linktext.isEmpty()) {
//	    		System.out.println(linktext);
//	    	}
//	     }
	     
	    List<String> linkstext =    getLinksTextList(linksele);
	    
	   System.out.println("Links texts:"+linkstext);
	    
	   if( linkstext.contains("Shopbop Designer")) {
		   System.out.println("Test Case is Pass");
	   }else {
		   System.out.println("Test Cases is Fail");
	   }
	   
	   doClickonLink(ele, "Fashion");
	   
	}
	
	
	public static List<WebElement> getElements(By locator) {
		 return  driver.findElements(locator);
	}
	
	public static List<String> getLinksTextList(By locator) {
		
		List<String> linksText = new ArrayList<>();
		
		 List<WebElement> eleList = getElements(locator);
		 System.out.println("Size of elements is:"+eleList.size());
		 
		 for(WebElement e : eleList) {
			 String text= e.getText();
						 
			 if(!text.isEmpty()) {
				 linksText.add(text);
			 }
		 }
		 
		 return linksText;
	}
	
	
	public static void doClickonLink(By locator, String value) {

		List<WebElement> eleList = getElements(locator);
		System.out.println("Size of elements is:" + eleList.size());

		for (WebElement e : eleList) {

			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(text);
				if (text.equals(value)) {
					e.click();
					break;
				}
			}
		}

	}

}
