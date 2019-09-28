//test case 3 POM pg  Week 2
package com.training.pom;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W2clickonblogtabPOM
{
	private WebDriver driver; 
	
	public W2clickonblogtabPOM(WebDriver driver) 
	{
		this.setDriver(driver); 
		PageFactory.initElements(driver, this);
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	

	
	@FindBy(id="user_login")
	private WebElement userName; 
			
						
	@FindBy(id="user_pass")
	private WebElement password;
	
	//@FindBy(id="formLogin_submitAuth")
	
	@FindBy(xpath="/html/body/div[1]/div[4]/div/article/div/div/div/div/div[1]/form/p[3]/input")
	private WebElement loginBtn; 
	
		
	@FindBy(xpath="//a[contains(text(),'Blog')]")
	public WebElement clkblog;
	
	@FindBy(id=("keyword_search"))
	public WebElement search; 
		
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

	
	
}
