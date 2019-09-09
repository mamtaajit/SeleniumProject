//Test case 3 RETC_008
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
import com.training.pom.calmortgagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class calmortgage 
{

	private WebDriver driver;
	private String baseUrl;
	private calmortgagePOM calmortgagePOM;
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
		calmortgagePOM = new calmortgagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	@Test
	public void validLoginTest() 
	{
				
		calmortgagePOM.rec_open();
			
		//calmortgagePOM.clkamount("1111");
		
		//calmortgagePOM.clkdownpayment("11");
		//calmortgagePOM.clkyears("20");
		//calmortgagePOM.clkinterest("7");
			
		calmortgagePOM.rec_send();
		calmortgagePOM.rec_send1();
		screenShot.captureScreenShot("First");
		
		
		System.out.print(calmortgagePOM.txtcalmsg);
		
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		String text=calmortgagePOM.txtcalmsg.getText();
	    String expectedText = "Monthly Payment: 3003.43 Rs.";
		
	  //Assertion on message textbox
	  //  Assert.assertEquals(NewLaunchTabPOM.message.getAttribute("value"),("looking for an apartments"));
	    
	  //Assertion on message on send button
	    Assert.assertEquals(text,expectedText);
		
	}		
}
