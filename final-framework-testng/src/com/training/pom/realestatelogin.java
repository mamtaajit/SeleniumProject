//test case 1 POM pg
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class realestatelogin
{
	private WebDriver driver; 
	
	public realestatelogin(WebDriver driver) 
	{
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
		
	}
	

	
	@FindBy(id="user_login")
	private WebElement userName; 
			
						
	@FindBy(id="user_pass")
	private WebElement password;
	
	//@FindBy(id="formLogin_submitAuth")
	
	@FindBy(xpath="/html/body/div[1]/div[4]/div/article/div/div/div/div/div[1]/form/p[3]/input")
	private WebElement loginBtn; 
	
	
	@FindBy(xpath="//div[contains(@class, 'user-menu') ]")
//	@FindBy(className="user-menu")
	public WebElement profilebtn; 
	
	@FindBy(xpath="//ul[@class='my-account-nav']//a[contains(text(),'Log Out')]")
	public WebElement logbtn;
	
	@FindBy(xpath="//*[@id=\"post-133\"]/div/div/div/ul/li[1]/a")
	public WebElement txtmsg;
	
	
	
	public void sendUserName(String userName) 
	{
		//
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
	
	public void clickprofilebtn()
	{
		//System.out.println("/html/body/div[1]/header/div[2]/div[2]/div/div/div/div" +"mamta" );
		this.profilebtn.click(); 
		
		//http://realestatem1.upskills.in/my-profile/
		
			//driver.findElement(By.linkText("Hi, mamta!")).click();
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
