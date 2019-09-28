//test case 5 POM pg  Week 2
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.W2clickpost1POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class W2clickpost1
{

	private WebDriver driver;
	private String baseUrl;
	private W2clickpost1POM W2clickpost1POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		W2clickpost1POM = new W2clickpost1POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.quit();
	}
	
 @Test (priority=1)	
	public void validLoginTest()
	{
		
	 System.out.println("First Priority");
		W2clickpost1POM.sendUserName("admin");
		W2clickpost1POM.sendPassword("adminuser@12345");
		W2clickpost1POM.clickLoginBtn();
	
	  System.out.println("Second Priority");
	  	W2clickpost1POM.openPost();
		W2clickpost1POM.opencate();
		
		W2clickpost1POM.sendtagname("Post1 ");
		W2clickpost1POM.sendtagslug("POST1 Slug");
		W2clickpost1POM.senddesc("POST1 description");
		W2clickpost1POM.clicksubmitBtn();
 
	  System.out.println("Third Priority");
	  	W2clickpost1POM.openallPost();
		W2clickpost1POM.open_addpost();
		W2clickpost1POM.sendtitle("POST1234");
		W2clickpost1POM.sendpostdesc("POST1234 description");
		//W2clickpost1POM.openpostcate();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	//	W2clickpost1POM.postcate.click();
		
				String classname_cate= W2clickpost1POM.catopen.getAttribute("class");
		System.out.println("Classname"+ classname_cate);
		System.out.println("");
		
		if (Boolean.parseBoolean(classname_cate="postbox closed"))
		{
				 //("//div[@id='categorydiv']//h2[@class='hndle ui-sortable-handle']" ));
		 		W2clickpost1POM.categories.click();
		}
		
		System.out.println("Classname2"+ classname_cate);
		System.out.println("");
		
		//W2clickpost1POM.categories1.click();
		
		W2clickpost1POM.clickpublish();
		//W2clickpost1POM.publish.click();
		//W2clickpost1POM.view.click();
		
		screenShot.captureScreenShot("First");
	
		
		//boolean gettxt=driver.getPageSource().contains("Blog");
		//System.out.print(gettxt);

		//Assertion on message on publish button view post
 		// Assert.assertEquals(gettxt,true);
		
	}
 
}
