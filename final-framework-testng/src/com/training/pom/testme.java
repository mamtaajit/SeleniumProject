package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testme 
{
public static void main(String[] args)
{
	System.setProperty("webdriver.chrome.driver","C:\\IBM java\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();  
	//driver.get("http://www.google.com");
	driver.get("http://realestatem1.upskills.in/wp-admin/post-new.php");
	
	WebElement userlog= driver.findElement(By.id("user_login"));
	userlog.sendKeys("manipal");

	WebElement pass= driver.findElement(By.id("user_pass"));
	pass.sendKeys("manipal@123");
	
	WebElement clickLoginBtn= driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/article/div/div/div/div/div[1]/form/p[3]/input"));
	clickLoginBtn.click();
	
	driver.get("http://realestatem1.upskills.in/wp-admin/post-new.php?post_type=property");
	
	

	WebElement publish= driver.findElement(By.xpath("//div//input[@id='publish']"));
	Actions action = new Actions(driver);
    action.moveToElement(publish).perform();
    publish.click();
    
    
    WebElement post =driver.findElement(By.xpath("//a[contains(text(),'View post')]"));
  //  Actions action1 = new Actions(driver);
   // action1.moveToElement(post).perform();
    post.click();
    
		
//	WebElement gettxt= driver.findElement(By.id("//p[contains(text(),'Post updated.')]"));
	//System.out.print("Textdata");
//	boolean gettxt=driver.getPageSource().contains("Post");
	//System.out.print(gettxt);
	
	
	//WebElement pub= driver.findElement(By.id("publish"));
	//pub.click();
	
	
//	driver.findElement(By.xpath("//div[@class='updated notice notice-success is-dismissible']/p"));
	//txtpost_publish.getText();
	//System.out.print("Text data");
	//WebElement title=driver.findElement(By.xpath("//input[@name='post_title']"));
	//title.sendKeys("data added added");
	
	//WebElement pub= driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
	//pub.click();
	//pub.getAttribute("ASD");


	//if (driver.getPageSource().contains("Not found")) then
	 
	//WebElement desc=driver.findElement(By.xpath("//body[@id='tinymce']"));
	
	//desc.click();
	//desc.sendKeys("data");
	
	 driver.switchTo().frame(driver.findElement(By.id("content_ifr")));
	 System.out.print("Frames");
	 

	WebElement desc=driver.findElement(By.xpath("//body[@id='tinymce']//p"));
	desc.click();
	desc.sendKeys("data");
	 //WebElement desc= driver.findElement(By.id("tinymce"));
	 //desc.sendKeys("Lore");

	 driver.switchTo().defaultContent();
		 
	// WebElement feature= driver.findElement(By.xpath("//div[@id='property_featurediv']//h2[@class='hndle ui-sortable-handle']"));
	 		//+ "//div[@id='property_featurediv']//h2[@class='hndle ui-sortable-handle']"));
	// feature.click();
	 
	// System.out.Print(feature.getAttribute(String class));
	 
	 //String f1 =  feature.getAttribute("classname");
	WebElement f1= driver.findElement(By.xpath("//*[@id=\"property_featurediv\"]"));
	String f2= f1.getAttribute("class");
	System.out.println("Classname"+ f2);
	 
	//if (Boolean.parseBoolean(f2="postbox closed"))
	//{
		WebElement feature= driver.findElement(By.xpath("//div[@id='property_featurediv']//h2[@class='hndle ui-sortable-handle']"));
		 feature.click();
		 
	//}
	 
	// if(f1.getAttribute("aria-expanded"))=false
//	if (Boolean.parseBoolean(f2="false"))
//	{
		 WebElement drp_feature= driver.findElement(By.xpath("//li[@id='property_feature-494']"));
			drp_feature.click();
//			 System.out.println("buttn is clicked");
//	}
//	 System.out.println("buttn is not clicked");
//	
	 
		
	// WebElement desc= driver.findElement(By.xpath("//textarea[@id='content']"));
	 //desc.sendKeys("pppp");
	 
	
	 
	 //WebElement categories= driver.findElement(By.xpath("//div[@id='categorydiv']//h2[@class='hndle ui-sortable-handle']" ));
	// categories.click();
	 
	 
	 
	// driver.get("http://demo.guru99.com/test/facebook.html");					
     //WebElement chkFBPersist = driver.findElement(By.id("persist_box"));							
     //categories.click (); 
     
     
}
}

