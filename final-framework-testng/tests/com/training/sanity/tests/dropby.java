package prjselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropby {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\IBM java\\Selenium jar\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();  
		//driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/");
		
		driver.findElement(By.linkText("Books")).click();
		WebElement sortby=driver.findElement(By.id("products-orderby"));
		Select sortbyselect=new Select(sortby);
		//sortbyselect.selectByVisibleText("Price: Low to High");
		//driver.findElement(name.)
		//sortbyselect.selectByIndex(3);
		sortbyselect.selectByValue("http://demowebshop.tricentis.com/notebooks?orderby=10");
		
	}

}
