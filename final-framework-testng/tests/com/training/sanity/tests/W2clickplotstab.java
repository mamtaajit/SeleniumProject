//Test case 2  week2 
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
import com.training.pom.W2clickplotstabPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class W2clickplotstab
{

	private WebDriver driver;
	private String baseUrl;
	private W2clickplotstabPOM W2clickplotstabPOM;
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
		W2clickplotstabPOM = new W2clickplotstabPOM(driver); 
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
		
		W2clickplotstabPOM.sendUserName("mamtanevrekar@gmail.com");
		W2clickplotstabPOM.sendPassword("sweethome@1223");
		W2clickplotstabPOM.clickLoginBtn();
		W2clickplotstabPOM.clkplots.click();
		
		//W2clickplotstabPOM.sendsearch("Off Tumkur Bangalore Land, Yeshwanthpur Suburb II Stage, Yesvanpur Surburb, Peenya, Bengaluru, Karnataka, India");
		W2clickplotstabPOM.sendsearch("Thane, Maharashtra, India");
		
		W2clickplotstabPOM.property_type.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickplotstabPOM.Plots_type.click();	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickplotstabPOM.region.click();
		
		W2clickplotstabPOM.sendregion_typ("Central Bangalore");
		W2clickplotstabPOM.region_typ.isSelected();
		W2clickplotstabPOM.clicksearchBtn();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
		
		
		
		boolean gettxt1=driver.getPageSource().contains("Nothing Found");
		System.out.print(gettxt1);
		
		///if false go to next test point
		if (gettxt1==true) 
		{
			Assert.assertEquals(gettxt1,true);
			System.out.print("No data found.. hence test case stopped");
		}	
		else
		{		
			W2clickplotstabPOM.clickimage.click();
		}
			
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		boolean gettxtdrop=driver.getPageSource().contains("Drop Us a Line Link");
		System.out.println("gettxtdrop"+gettxtdrop);
		
		// if txt drop... is not found stop the test case
		if (gettxtdrop==false) 
		{
			Assert.assertEquals(gettxtdrop,true);	
			System.out.print("No Link of (Drop a line link) found");
		}
		else
		{
			W2clickplotstabPOM.clickdrpaline();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			W2clickplotstabPOM.submit_cfname("Selenium");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			W2clickplotstabPOM.submit_cfemail("selenium@gmail.com");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			W2clickplotstabPOM.submit_cfsub("apartment");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			W2clickplotstabPOM.submit_cfmessage("looking for apartment");
			
			
			W2clickplotstabPOM.clickfc_send();
			String text=W2clickplotstabPOM.txtmsg.getText();
			//System.out.print(text);
					
			String expectedText = "Thanks you for your message. It has been sent";
			    
			    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			 	  //Assertion on message on send button
			    Assert.assertEquals(text,expectedText);
		
		}

		screenShot.captureScreenShot("First");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		//String text=W2clickplotstabPOM.txtmsg.getText();
		//System.out.print(text);
				
		//String expectedText = "Thanks you for your message. It has been sent";
		    
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 	  //Assertion on message on send button
		  //  Assert.assertEquals(text,expectedText);
		
	}
}
