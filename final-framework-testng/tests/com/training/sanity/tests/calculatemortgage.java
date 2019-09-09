//test case 4
package com.training.sanity.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.training.generics.ScreenShot;
import com.training.pom.calculatemortgagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class calculatemortgage {

	private WebDriver driver;
	private String baseUrl;
	private calculatemortgagePOM calculatemortgagePOM;
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
		calculatemortgagePOM = new calculatemortgagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		//Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() 
	{
		//calculatemortgagePOM obj1 = new calculatemortgagePOM(driver);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		calculatemortgagePOM.rec_open();
		
		calculatemortgagePOM.sendsearch("Off Tumkur Bangalore Land, Yeshwanthpur Suburb II Stage, Yesvanpur Surburb, Peenya, Bengaluru, Karnataka, India");
		
		calculatemortgagePOM.property_type.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		calculatemortgagePOM.Plots_type.click();	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		calculatemortgagePOM.region.click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		calculatemortgagePOM.sendregion_typ("Central Bangalore");
		calculatemortgagePOM.region_typ.isSelected();
		calculatemortgagePOM.clicksearchBtn();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		String text=calculatemortgagePOM.txtmsg.getText();
					
	    String expectedText = "Matching data found";
	    
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 	  //Assertion on message on send button
	    Assert.assertEquals(text,expectedText);

		
				
		
      }        
		//calculatemortgagePOM.rec_openprptyp();
		
		
	}
	
