//Test case 3 RETC_008
package com.training.pom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class calmortgagePOM 
{
	private WebDriver driver; 
	
	public calmortgagePOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("/html/body/div[1]/header/div[2]/nav/div/ul/li[5]/a"))
	//@FindBy(id=("menu-item-570"))
	public WebElement aprtmnt; 
	
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
	
	public void rec_open()
    { 
    	Actions action = new Actions(driver);
        action.moveToElement(aprtmnt).perform();
        driver.get("http://realestatem1.upskills.in/donec-quis/");
    }
	
			///this.amount.sendKeys(amount);
		
	
	public void rec_send1()
    { 
        //msg send
		//Actions action1 = new Actions(driver);
        //action1.moveToElement(calculate).click().perform();
      //  driver.findElement(By.xpath("//*[@id=\"widget_mortgage_calc_properties-4\"]/form/button")).submit();
        
        
        JavascriptExecutor js = (JavascriptExecutor) driver;//create instance of javascript executor to do actions
        WebElement buttonSubmit= driver.findElement(By.xpath("//*[@id=\"widget_mortgage_calc_properties-4\"]/form/button"));
        js.executeScript("arguments[0].click();", buttonSubmit);
        
     }
	
	
	public void rec_send()
    { 
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		((JavascriptExecutor)driver).executeScript("document.getElementById('amount').value='400000';");	
		((JavascriptExecutor)driver).executeScript("document.getElementById('downpayment').value='20000';");	
		((JavascriptExecutor)driver).executeScript("document.getElementById('years').value='20';");	
		((JavascriptExecutor)driver).executeScript("document.getElementById('interest').value='7.5';");	
		//((JavascriptExecutor)driver).executeScript("document.getElementById('calculate').click()");
		
        //System.out.println("calculate");
		//button calc-button
     }

	
}
