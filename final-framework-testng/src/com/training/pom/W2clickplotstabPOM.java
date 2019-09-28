//test case 2 POM pg  Week 2
package com.training.pom;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W2clickplotstabPOM
{
	private WebDriver driver; 
	
	public W2clickplotstabPOM(WebDriver driver) 
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
	
		
	@FindBy(xpath="//a[contains(text(),'Plots')]")
	public WebElement clkplots;
		
	@FindBy(id=("keyword_search"))
	public WebElement search; 
	
	@FindBy(xpath=("//span[contains(text(),'Property type')]"))	
	public WebElement property_type;
	
	@FindBy(xpath=("//li[contains(text(),'Plots')]"))	
	public WebElement Plots_type;
	
	@FindBy(xpath=("//span[contains(text(),'Any Regions')]"))
	public WebElement region;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	public WebElement txtmsg;
	
	@FindBy(xpath=("//div[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']//input[@class='chosen-search-input']"))
	public WebElement region_typ;
					
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//span[@class='listing-compact-title']")
	public WebElement clickimage;
	
	@FindBy(partialLinkText="Drop")
	public WebElement drpaline;
	
	@FindBy(xpath=("//input[@placeholder='Your Name']"))
	private WebElement cf_name; 
	
	@FindBy(xpath=("//input[@placeholder='Email Address']"))
	private WebElement cf_email; 
	
	@FindBy(xpath=("//input[@placeholder='Subject']"))
	private WebElement cf_sub; 
	
	@FindBy(xpath=("//textarea[@placeholder='Message']"))
	private WebElement cf_message; 
	
	@FindBy(xpath=("//input[@class='wpcf7-form-control wpcf7-submit']"))
	private WebElement cf_send; 
	
	public void clickdrpaline()
	{
		Actions action = new Actions(driver);
        action.moveToElement(drpaline).click().perform(); 
        drpaline.click();
     
	}
	public void submit_cfname(String cf_name) 
	{
		this.cf_name.clear(); 
		this.cf_name.sendKeys(cf_name); 
	}
	
	public void submit_cfemail(String cf_email) 
	{
		this.cf_email.clear(); 
		this.cf_email.sendKeys(cf_email); 
	}
	
	public void submit_cfsub(String cf_sub) 
	{
		this.cf_sub.clear(); 
		this.cf_sub.sendKeys(cf_sub); 
	}
	
	public void submit_cfmessage(String cf_message) 
	{
		this.cf_message.clear(); 
		this.cf_message.sendKeys(cf_message); 
	}
	
	public void clickfc_send() 
	{
		// TODO Auto-generated method stub
		this.cf_send.click();
		
	}
	
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

	public void sendregion_typ(String region_typ) 
	{
		this.region_typ.clear();
		this.region_typ.sendKeys(region_typ);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	
	public void sendsearch(String search) 
	{
		this.search.clear();
		this.search.sendKeys(search+ Keys.TAB);
	}	
	public void clicksearchBtn() 
	{
		// TODO Auto-generated method stub
		this.searchBtn.click();
		
	}
	

	
}
