//test case 5
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
import com.training.pom.NewLaunchTabPOM;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class NewLaunchTab {

	private WebDriver driver;
	private String baseUrl;
	private NewLaunchTabPOM NewLaunchTabPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private String text1;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		NewLaunchTabPOM = new NewLaunchTabPOM (driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
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
		NewLaunchTabPOM obj1 = new NewLaunchTabPOM(driver);
		driver.get("http://realestatem1.upskills.in/new-launch/");
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		NewLaunchTabPOM.sendUserName("mamta");
		NewLaunchTabPOM.sendemail("mamtanevrekar@gmail.com");
		NewLaunchTabPOM.sendsub("apartments");
		NewLaunchTabPOM.sendmsg("looking for an apartments");
		
		//send button
		obj1.rec_send();
		
			//Assertion code
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			String text=obj1.txtmsg.getText();
		    String expectedText = "Thank you for your message. It has been sent.";
			
		  //Assertion on message textbox
		    Assert.assertEquals(NewLaunchTabPOM.message.getAttribute("value"),("looking for an apartments"));
		    
		  //Assertion on message on send button
		    Assert.assertEquals(text,expectedText);
			
					
			screenShot.captureScreenShot("First");
	}
}