//test case 2 RETC_007
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
import com.training.pom.aprtmntenqPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class aprtmntenq {

	private WebDriver driver;
	private String baseUrl;
	private aprtmntenqPOM aprtmntenqPOM;
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
		aprtmntenqPOM = new aprtmntenqPOM(driver); 
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
		aprtmntenqPOM obj1 = new aprtmntenqPOM(driver);
		
		aprtmntenqPOM.rec_open();
		//aprtmntenqPOM.rec_open1();
		
	
		
		aprtmntenqPOM.sendUserName("mamta");
		aprtmntenqPOM.sendemail("mamtanevrekar@gmail.com");
		aprtmntenqPOM.sendsub("apartments");
		aprtmntenqPOM.sendmsg("Cost n details of apartments");
		
		//send button
		obj1.rec_send();
		
		//Assertion code
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		String text=obj1.txtmsg.getText();
	    String expectedText = "Thank you for your message. It has been sent.";
		
	  //Assertion on message textbox
	    Assert.assertEquals(aprtmntenqPOM.message.getAttribute("value"),("Cost n details of apartments"));
	    
	    
	  //Assertion on message on send button
	    Assert.assertEquals(text,expectedText);
	    
		screenShot.captureScreenShot("First");
		

		
}
	
		
}