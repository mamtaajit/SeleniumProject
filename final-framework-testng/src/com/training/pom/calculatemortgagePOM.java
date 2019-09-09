//test case 4 RETC_009

package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class calculatemortgagePOM 
{
	private WebDriver driver; 
	
	public calculatemortgagePOM(WebDriver driver) 
	{
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath=("/html/body/div[1]/header/div[2]/nav/div/ul/li[5]/a"))
	//@FindBy(id=("menu-item-570"))
	public WebElement aprtmnt; 
	
	@FindBy(id=("keyword_search"))
	public WebElement search; 
	
	@FindBy(xpath=("//span[contains(text(),'Property type')]"))	
	public WebElement property_type;
	
	@FindBy(xpath=("//div[@id='_property_type_chosen']//ul[@class='chosen-results']"))	
	public WebElement Plots_type;
	
	@FindBy(xpath=("//span[contains(text(),'Any Regions')]"))
	public WebElement region;
	
	@FindBy(xpath=("//*[@id=\"wrapper\"]/div[4]/div/div/div[1]/section/div/p"))
	public WebElement txtmsg;
	
	@FindBy(xpath=("//div[@class='chosen-container chosen-container-single chosen-with-drop chosen-container-active']//input[@class='chosen-search-input']"))
	public WebElement region_typ;
	
					
	
	@FindBy(xpath="//button[@class='button fullwidth']")
	private WebElement searchBtn;
	
	
	
	
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
	
	
	public void rec_open()
    { 
        
		Actions action = new Actions(driver);
        action.moveToElement(aprtmnt).click().perform();
     }

	
		public void clicksearchBtn() {
		// TODO Auto-generated method stub
		this.searchBtn.click();
		
	}
}
	
