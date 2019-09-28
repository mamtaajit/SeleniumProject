package com.training.pom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3RE_070POM 
{
	private WebDriver driver; 
	
	public W3RE_070POM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	public WebElement userName; 
	
	@FindBy(id="user_pass")
	public WebElement password;
	
	@FindBy(xpath="/html/body/div[1]/div[4]/div/article/div/div/div/div/div[1]/form/p[3]/input")
	public WebElement loginBtn; 
	
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	public WebElement clkproperties;
	
	@FindBy(xpath="//ul[@class='wp-submenu wp-submenu-wrap']//a[contains(text(),'Features')]")
	public WebElement clkfeature; 
	
	@FindBy(id="tag-name")
	public WebElement tagname;
	
	@FindBy(id="tag-slug")
	public WebElement tagslug;

	@FindBy(id="tag-description")
	public WebElement desc;
	
	@FindBy(id="submit")
	public WebElement submit;
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	public WebElement clkaddnew;
	
	@FindBy(xpath="//input[@name='post_title']")
	public WebElement posttitle;
	
	//@FindBy(id="tinymce")
	@FindBy(xpath="//body[@id='tinymce']//p")
	public WebElement postdesc;
	
	//click drp fearture
	@FindBy(xpath="//div[@id='property_featurediv']//button[@class='handlediv']")
	public WebElement featureclass;

	@FindBy(xpath="//div[@id='property_featurediv']//h2[@class='hndle ui-sortable-handle']")
	public WebElement feature;

	@FindBy(xpath="//li[@id='property_feature-494']")
	public WebElement feature1;
	
	@FindBy(xpath="//div//input[@id='publish']")
	public WebElement publish;
	
	@FindBy(partialLinkText="post")
	public WebElement clkpost;
	
	public void sendUserName(String userName)
	{
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() 
	{
		this.loginBtn.click(); 
	}
	
	
	public void open_clkproperties()
    { 
        
		Actions action = new Actions(driver);
        action.moveToElement(clkproperties).perform();
       // driver.get("http://realestatem1.upskills.in/donec-quis/");
        //clkproperties.click();
     }
	
	public void open_clkfeature()
    { 
        
		Actions action = new Actions(driver);
        action.moveToElement(clkfeature).perform();
       // driver.get("http://realestatem1.upskills.in/donec-quis/");
        clkfeature.click();
     }
	public void sendtagname(String tagname) 
	{
		//
		this.tagname.sendKeys(tagname);
	}
	
	
	public void sendtagslug(String tagslug) 
	{
		//
		this.tagslug.sendKeys(tagslug);
	}
	public void senddesc(String desc) 
	{
		//
		this.desc.sendKeys(desc);
	}
	public void clicksubmitBtn()
	{
		this.submit.click();
	}
	public void open_clkaddnew()
    { 
        
		Actions action = new Actions(driver);
        action.moveToElement(clkaddnew).perform();
       // driver.get("http://realestatem1.upskills.in/donec-quis/");
        clkaddnew.click();
     }

	public void sendtitle(String posttitle) 
	{
		//
		this.posttitle.sendKeys(posttitle);
	}

	
	public void sendpostdesc(String postdesc) 
	{
		 driver.switchTo().frame(driver.findElement(By.id("content_ifr")));
		// WebElement desc= driver.findElement(By.id("tinymce"));
		 this.postdesc.sendKeys(postdesc);
	}
	public void senddrpfeature() 
	{
		driver.switchTo().defaultContent();
		// WebElement desc= driver.findElement(By.id("tinymce"));
		 this.feature.click();
	}
	public void senddrpfeature1() 
	{
		driver.switchTo().defaultContent();
		// WebElement desc= driver.findElement(By.id("tinymce"));
		 this.feature1.click();
	}
	public void clickpublishBtn() 
	{
		//this.publish.click(); 
		Actions action = new Actions(driver);
		action.moveToElement(publish).perform();
		publish.click();
	}
	
	public void clickpostview() 
	{
		//this.publish.click(); 
		Actions action = new Actions(driver);
		action.moveToElement(clkpost).perform();
		clkpost.click();
	}
}
