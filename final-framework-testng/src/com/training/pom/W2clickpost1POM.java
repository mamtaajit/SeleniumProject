//test case 5 POM pg  Week 2
package com.training.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W2clickpost1POM
{
	private WebDriver driver; 
	
	public W2clickpost1POM(WebDriver driver) 
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
	
	
	@FindBy(xpath="/html/body/div[1]/div[4]/div/article/div/div/div/div/div[1]/form/p[3]/input")
	private WebElement loginBtn; 
	
		
	@FindBy(partialLinkText="Posts")
	public WebElement drpposts;
	
	@FindBy(id="tag-name")
	public WebElement tagname;
	
	@FindBy(id="tag-slug")
	public WebElement tagslug;

	@FindBy(id="tag-description")
	public WebElement desc;
	
	@FindBy(id="submit")
	public WebElement submit;
	
	@FindBy(linkText="All Posts")	
	public WebElement drpallpost;
	
	@FindBy(xpath="//a[@class='page-title-action']")
	//@FindBy(linkText="Add New")
	public WebElement addpost;
	
	@FindBy(xpath="//input[@id='title']")
	public WebElement posttitle;
	
//	@FindBy(id="tinymce")	
	@FindBy(xpath="//textarea[@id='content']")
	public WebElement postdesc;

	//select categories check box
	@FindBy(id="//li//label[contains(text(),'ASD')]")	
	public WebElement postcate;
	
	@FindBy(xpath="//div[@id='categorydiv']//h2[@class='hndle ui-sortable-handle']")	
	public WebElement categories;
	
	@FindBy(xpath="//div[@id='categorydiv']")
	public WebElement catopen;
	
	
	 @FindBy(xpath="//li//label[contains(text(),'ASD')]")
		public WebElement categories1;
	 
	// WebElement categories= driver.findElement(By.xpath(""));
		
	
//	@FindBy(xpath="//div//input[@id='publish']")
	
	@FindBy(id="publish")
	public WebElement publish; 
	
	public void clickpublish()
    { 
    	Actions action = new Actions(driver);
        action.moveToElement(publish).click();
        publish.click();
     }
	
	
//	@FindBy(xpath="//div//p[contains(text(),'Post published.')]")
	//public WebElement view;
	
	public void openPost()
    { 
    	Actions action = new Actions(driver);
        action.moveToElement(drpposts).perform();
     }
	
	@FindBy(partialLinkText="Categories")
	public WebElement drpCategories;
	
	public void opencate()
    { 
    	Actions action = new Actions(driver);
        action.moveToElement(drpCategories).perform();
        drpCategories.click();
    }
	public void openallPost()
    { 
    	Actions action = new Actions(driver);
        action.moveToElement(drpallpost).perform();
        drpallpost.click();
        
     }
	public void open_addpost()
    { 
    	Actions action = new Actions(driver);
        action.moveToElement(addpost).perform();
        addpost.click();
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

	public void sendtagname1() 
	{
		String txtnm= this.tagname.getText();
		System.out.print("Data to be diplayed");
		System.out.print(txtnm);
				
	}
	public void sendtitle(String posttitle) 
	{
		//
		this.posttitle.sendKeys(posttitle);
	}
	public void sendpostdesc(String postdesc) 
	{
		//
		//this.postdesc.sendKeys(postdesc);
		// driver.switchTo().frame(driver.findElement(By.id("content_ifr")));
		// WebElement desc= driver.findElement(By.id("tinymce"));
		 this.postdesc.sendKeys("postdesc");
		 
	}
	
//	public void sendpostcate(String postcate) -- not used
	//{
		// driver.switchTo().defaultContent();
		 //WebElement desc1= driver.findElement(By.xpath("//div[@id='categorydiv']//h2[@class='hndle ui-sortable-handle']"));
		 //desc1.click();		 
	//}
	
	public void openpostcate()
    { 
		//will open categories drop menu
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
        action.moveToElement(postcate).click().perform();
        postcate.click();
     }
	
	
	
	
}
