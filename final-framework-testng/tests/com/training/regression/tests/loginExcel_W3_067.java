//test case 5
package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean_066;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProvidersRE_066;
import com.training.generics.ScreenShot;
import com.training.pom.W3RE_067POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class loginExcel_W3_067 {

	private WebDriver driver;
	private String baseUrl;
	private W3RE_067POM W3RE_067POM;
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
		W3RE_067POM = new W3RE_067POM (driver); 
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
		W3RE_067POM.sendUserName("mamtanevrekar@gmail.com");
		W3RE_067POM.sendPassword("sweethome@1223");
		
		W3RE_067POM.clickLoginBtn();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		W3RE_067POM.open_clkplots();
		
		
		W3RE_067POM.sendname("mamta");
		W3RE_067POM.sendemail("mamtanevrekar@gmail.com");
		W3RE_067POM.sendsub("apartments");
		W3RE_067POM.sendmsg("looking for an apartments");
		
		
		//send button
		W3RE_067POM.rec_send();
//		
//			//Assertion code
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
			String text=W3RE_067POM.txtmsg.getText();
			
			String expectedText = "Thank you for your message. It has been sent.";
//			
//		  //Assertion on message textbox
		 //   Assert.assertEquals(NewLaunchTabPOM.message.getAttribute("value"),("looking for an apartments"));
//		    
//		  //Assertion on message on send button
	    Assert.assertEquals(text,expectedText);
//			
//					
//			screenShot.captureScreenShot("First");
	}
}