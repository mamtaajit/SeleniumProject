package com.training.pom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3RE_068POM 
{
	private WebDriver driver; 
	
	public W3RE_068POM(WebDriver driver) 
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
	
	@FindBy(id=("amount"))
	public WebElement amount; 
	
	@FindBy(id=("downpayment"))
	public WebElement downpayment; 
	
	@FindBy(id=("years"))
	public WebElement years; 
	
	@FindBy(id=("interest"))
	public WebElement interest; 
	
	@FindBy(xpath=("//button[@class='button calc-button']"))
	//button[@class='button calc-button']
	public WebElement calculate; 
	
	@FindBy(xpath=("//div[@class='notification success']"))
	public WebElement txtcalmsg; 
	
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
	
	
	public void open_clkplots()
    { 
        
		Actions action = new Actions(driver);
        action.moveToElement(clkplots).perform();
        driver.get("http://realestatem1.upskills.in/donec-quis/");
        //clkplots.click();
     }
	
	public void amount(String amount) 
	{
		this.amount.clear(); 
		this.amount.sendKeys(amount); 
	}
	public void downpayment(String downpayment) 
	{
		this.downpayment.clear(); 
		this.downpayment.sendKeys(downpayment); 
	}
	public void years(String years) 
	{
		this.years.clear(); 
		this.years.sendKeys(years); 
	}
	public void interest(String interest) 
	{
		this.interest.clear(); 
		this.interest.sendKeys(interest); 
	}

	public void rec_cal()
    { 
        JavascriptExecutor js = (JavascriptExecutor) driver;//create instance of javascript executor to do actions
        WebElement buttonSubmit= driver.findElement(By.xpath("//*[@id=\"widget_mortgage_calc_properties-4\"]/form/button"));
        js.executeScript("arguments[0].click();", buttonSubmit);
        
     }
		
}
