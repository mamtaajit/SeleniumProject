//Test case 4 week2 
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.W2clickpostlinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class W2clickpostlink
{

	private WebDriver driver;
	private String baseUrl;
	private W2clickpostlinkPOM W2clickpostlinkPOM;
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
		W2clickpostlinkPOM = new W2clickpostlinkPOM(driver); 
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
	@Test
	public void validLoginTest()
	{
		
		W2clickpostlinkPOM.sendUserName("admin");
		W2clickpostlinkPOM.sendPassword("adminuser@12345");
		W2clickpostlinkPOM.clickLoginBtn();
		W2clickpostlinkPOM.openPost();
		W2clickpostlinkPOM.opencate();
		W2clickpostlinkPOM.sendtagname("NWL post");
		W2clickpostlinkPOM.sendtagslug("L post");
		W2clickpostlinkPOM.senddesc("NL of plots post");
		W2clickpostlinkPOM.clicksubmitBtn();
		W2clickpostlinkPOM.openallPost();
		W2clickpostlinkPOM.open_addpost();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickpostlinkPOM.sendtitle("POST1234");
		W2clickpostlinkPOM.sendpostdesc("POST1234 description");
		//W2clickpostlinkPOM.openpostcate();
		W2clickpostlinkPOM.clickpublish();
		//W2clickpostlinkPOM.view.click();
		screenShot.captureScreenShot("First");
	
		boolean gettxt=driver.getPageSource().contains("Post");
		System.out.print(gettxt);
		 	  //Assertion on message on send button
		    Assert.assertEquals(gettxt,true);
		    
		
	}
}
