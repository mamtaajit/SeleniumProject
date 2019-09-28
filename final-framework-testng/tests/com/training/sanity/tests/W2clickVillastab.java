//Test case 1  week2 
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
import com.training.pom.W2clickVillastabPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class W2clickVillastab
{

	private WebDriver driver;
	private String baseUrl;
	private W2clickVillastabPOM W2clickVillastabPOM;
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
		W2clickVillastabPOM = new W2clickVillastabPOM(driver); 
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
	public void validLoginTest() {
		
		W2clickVillastabPOM.sendUserName("mamtanevrekar@gmail.com");
		W2clickVillastabPOM.sendPassword("sweethome@1223");
		W2clickVillastabPOM.clickLoginBtn();
		W2clickVillastabPOM.clkvillas.click();
		
		W2clickVillastabPOM.sendsearch("Off Tumkur Bangalore Land, Yeshwanthpur Suburb II Stage, Yesvanpur Surburb, Peenya, Bengaluru, Karnataka, India");
		
		W2clickVillastabPOM.property_type.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickVillastabPOM.Plots_type.click();	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickVillastabPOM.region.click();
		
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		W2clickVillastabPOM.sendregion_typ("Central Bangalore");
		W2clickVillastabPOM.region_typ.isSelected();
		W2clickVillastabPOM.clicksearchBtn();
		
		boolean gettxt1=driver.getPageSource().contains("found");
		System.out.print(gettxt1);
		Assert.assertEquals(gettxt1,true);
		
			
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		///deleted from here
		
		//Assertion after search button since dtaa is not diplayed
		boolean gettxt=driver.getPageSource().contains("Nothing Found");
		System.out.println(gettxt);
		Assert.assertEquals(gettxt,true);
		System.out.println("Assertion for search No data found,hence ");
	
	if (gettxt==false) 
	{
	
		System.out.println("Assertion for search failed and procceded..data found");
		screenShot.captureScreenShot("First");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		W2clickVillastabPOM.clickdrpaline();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickVillastabPOM.submit_cfname("Selenium");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickVillastabPOM.submit_cfemail("selenium@gmail.com");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickVillastabPOM.submit_cfsub("apartment");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W2clickVillastabPOM.submit_cfmessage("looking for apartment");
		
		
		W2clickVillastabPOM.clickfc_send();
		String text=W2clickVillastabPOM.txtmsg.getText();
		//System.out.print(text);
				
		String expectedText = "Thanks you for your message. It has been sent";
		    
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 	  //Assertion on message on send button
		    Assert.assertEquals(text,expectedText);
	}	    
		
	}

	
}
