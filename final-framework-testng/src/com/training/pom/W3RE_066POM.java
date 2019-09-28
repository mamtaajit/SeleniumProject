package com.training.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3RE_066POM 
{
	private WebDriver driver; 
	
	public W3RE_066POM(WebDriver driver) 
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
	
	
	@FindBy(xpath="//a[contains(text(),'Plots')]")
	public WebElement clkplots;
	
	@FindBy(name="your-name")
	public WebElement yourname; 
	
	@FindBy(name="your-email")
	private WebElement youremail;
	
	@FindBy(name="your-subject")
	private WebElement yoursubj;
	
	@FindBy(name="your-message")
	public WebElement yourmessage;
	
	@FindBy(xpath=("//input[@class='wpcf7-form-control wpcf7-submit']"))
	public WebElement sendbtn; 
	

	
	public void sendUserName(String userName)
	{
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	
	public void open_clkplots()
    { 
        
		Actions action = new Actions(driver);
        action.moveToElement(clkplots).perform();
        driver.get("http://realestatem1.upskills.in/donec-quis/");
        //clkplots.click();
     }
	
	public void sendname(String yourname) {
		this.yourname.clear();
		this.yourname.sendKeys(yourname);
		
	}
	
	public void sendemail(String youremail) 
	{
		this.youremail.clear(); 
		this.youremail.sendKeys(youremail); 
	}
	public void sendsub(String yoursubj)
	{

		this.yoursubj.sendKeys(yoursubj); 
	}
	public void sendmsg(String yourmessage)
	{
		this.yourmessage.clear(); 
		this.yourmessage.sendKeys(yourmessage); 
	}
	public void rec_send()
    { 
        //msg send
		Actions action1 = new Actions(driver);
        action1.moveToElement(sendbtn).click().perform();
     }

	
}
