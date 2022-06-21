package com.prct.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionList {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> eleList =	driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		System.out.println("size of ele:"+eleList.size());
		
		for(WebElement e : eleList) {
			System.out.println(e.getText());
			if(e.getText().equals("Casual Dresses > Printed Dress")) {
				e.click();
				break;
			}
		}
		
	}

}
