package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testme 
{
public static void main(String[] args)
{
	System.setProperty("webdriver.chrome.driver","C:\\IBM java\\Selenium jar\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();  
	//driver.get("http://www.google.com");
	driver.get("http://realestatem1.upskills.in/region/plots-in-bangalore/");
	
//	WebElement sortby=driver.findElement(By.id("_property_type"));
	
	//sortby.click();

	//Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='_property_type']")));  
	//dropdown.selectByVisibleText("Plots");  
	
//	dropdown.selectByIndex(2);
	
	
	Actions actions = new Actions(driver);
WebElement dBox1= (new    WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='_property_type']")));
			actions.moveToElement(dBox1);
	actions.click();
	actions.perform();
	}
}
