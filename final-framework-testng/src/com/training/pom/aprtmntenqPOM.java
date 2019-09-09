//test case 2 RETC_007
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class aprtmntenqPOM 
{
	private WebDriver driver; 
	
	public aprtmntenqPOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("/html/body/div[1]/header/div[2]/nav/div/ul/li[5]/a"))
	//@FindBy(id=("menu-item-570"))
	public WebElement aprtmnt; 
	
	

	@FindBy(name="your-name")
	private WebElement name; 
	
	
	@FindBy(name="your-email")
	private WebElement email;
	
	@FindBy(name="your-subject")
	private WebElement subj;
	
	@FindBy(name="your-message")
	public WebElement message;
	
	
	@FindBy(xpath=("//input[@class='wpcf7-form-control wpcf7-submit']"))
	public WebElement sendbtn; 
	
	@FindBy(xpath=("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']"))
	public WebElement txtmsg; 
	
	public void rec_open()
    { 
        
		Actions action = new Actions(driver);
        action.moveToElement(aprtmnt).perform();
        driver.get("http://realestatem1.upskills.in/donec-quis/");
    }
	
	public void rec_open1()
	{
		
	//driver.get("http://realestatem1.upskills.in/donec-quis/");
		
	}
	
	public void sendUserName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
		
	}
	
	public void sendemail(String email) 
	{
		this.email.clear(); 
		this.email.sendKeys(email); 
	}
	public void sendsub(String subj)
	{

		this.subj.sendKeys(subj); 
	}
	public void sendmsg(String message)
	{
		this.message.clear(); 
		this.message.sendKeys(message); 
	}
		
	public void rec_send()
    { 
        //msg send
		Actions action1 = new Actions(driver);
        action1.moveToElement(sendbtn).click().perform();
     }
	
}
