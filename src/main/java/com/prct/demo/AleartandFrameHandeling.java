package com.prct.demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AleartandFrameHandeling {

	
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
/*		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.name("submit")).click();
		
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		System.out.println(alt.getText());
		alt.accept();
		
		alt.sendKeys(null);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
	*/
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("testuu12");
		driver.findElement(By.name("password")).sendKeys("testuu12");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		
		
	/*	driver.switchTo().frame(0);
		driver.switchTo().frame(null);
		driver.switchTo().frame(WebElement); */
		

		By content = By.linkText("CONTACTS");
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(content)).perform();
		
		driver.findElement(By.linkText("New Contact")).click();
		
		
		By titledrop = By.xpath("//select[@name='title']");
		
		ElementUtil ele = new ElementUtil(driver);
		
		ele.doSelectDropDownValueByVisibaleText(titledrop, "Mr.");

	}

}
