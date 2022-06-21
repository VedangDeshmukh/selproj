package com.prct.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandelingAndSuggestionlist {

	
	static WebDriver driver;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.id("justAnInputBox")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		By options = By.xpath("//span[@class='comboTreeItemTitle']");
		
		//selectChoice(options, "choice 3","choice 5","choice 6");
		selectChoice(options, "all");
		

	}
	
	public static List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	public static void selectChoice(By locator , String... value) {
		
		List<WebElement> eleList = getElements(locator);
		 System.out.println("size of list:"+eleList.size());
		
		if(!value[0].equalsIgnoreCase("all")) {
					 
			 for(WebElement e : eleList) {
				 System.out.println(e.getText());
				 
				 for(int j=0;j<value.length;j++) {
					 if(e.getText().equals(value[j])) {
						 e.click();
						 break;
					 }
				 }
			 }
			
		}else {
			for(WebElement e : eleList) {				
				try {
				e.click();
				}catch (Exception ee) {
					// TODO: handle exception
				}
			}
		}
		
		 
	}

}
