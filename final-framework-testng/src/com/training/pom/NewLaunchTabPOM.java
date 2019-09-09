//test case 5
package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewLaunchTabPOM 
{
	private WebDriver driver; 
	
	public NewLaunchTabPOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	@FindBy(name="your-name")
	private WebElement name; 
	
	
	@FindBy(name="your-email")
	private WebElement email;
	
	@FindBy(name="your-subject")
	private WebElement subj;
	
	@FindBy(name="your-message")
	public WebElement message;
//	usernameTextbox.getAttribute("value").contains

	
	public void sendmsg(String message)
	{
		this.message.clear(); 
		this.message.sendKeys(message);
	}
	
	@FindBy(xpath=("//input[@class='wpcf7-form-control wpcf7-submit']"))
	public WebElement sendbtn; 
	
	
	// message text box
	@FindBy(xpath=("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']"))
	public WebElement txtmsg; 
	
	//public void txtmsg() 
	//{
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		//String text=txtmsg.getText();
	    //String expectedText = "Thank you for your message. It has been sent.";
		// TODO Auto-generated method stub
		//Assert.assertEquals(text,expectedText);		
//		System.out.println("txtmsg"+ txtmsg);		
	//}

	
	
	
	public void sendUserName(String name) 
	{
		this.name.clear();
		this.name.sendKeys(name);
		this.name.getText();
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
	
	
	public void rec_send()
    { 
        //msg send
		Actions action1 = new Actions(driver);
        action1.moveToElement(sendbtn).click().perform();
        
     }	
}
