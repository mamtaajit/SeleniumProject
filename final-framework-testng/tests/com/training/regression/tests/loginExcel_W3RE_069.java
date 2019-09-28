package com.training.regression.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.training.dataproviders.LoginDataProvidersRE_068;
import com.training.generics.ScreenShot;
import com.training.pom.W3RE_068POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class loginExcel_W3RE_069 
{
	private static WebDriver driver;
	private static String baseUrl;
	private static W3RE_068POM W3RE_068POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException 
	{
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		W3RE_068POM = new W3RE_068POM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		// open the browser
		driver.get(baseUrl);
		screenShot = new ScreenShot(driver);
		
	}

	@AfterMethod
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	@Test(priority=1)
	public void checkdata()
	{
		W3RE_068POM.sendUserName("mamtanevrekar@gmail.com");
		W3RE_068POM.sendPassword("sweethome@1223");
		
		W3RE_068POM.clickLoginBtn();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W3RE_068POM.open_clkplots();

	}

	
	@Test(priority=2, dataProvider = "excel-inputs", dataProviderClass = LoginDataProvidersRE_068.class)
	public void rundata(String amount, String downpayment, String years, String interest) throws IOException
	{
		System.out.print("amount"+amount+"downpayment"+downpayment+"years"+years+"interest"+interest);
	 
	W3RE_068POM.amount(amount);
		
		W3RE_068POM.downpayment(downpayment);
		
		String msgtxt= W3RE_068POM.txtcalmsg.getText();
		System.out.println();
		System.out.println("Message"+msgtxt);
		W3RE_068POM.years(years);
		
		String expectedString = "Monthly Payment";
//		
		W3RE_068POM.years.clear();	
		W3RE_068POM.interest.clear();	
		switch (years) 
		{
		case "":
			{driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			System.out.println("years is blank");
			break;
		}
			
						
		default:
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			W3RE_068POM.years(years);
			W3RE_068POM.interest(interest);
			W3RE_068POM.rec_cal();
			System.out.println("years is not blank");
		}	
		switch (interest)
		{
		case "":
			{driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			System.out.println("interest is blank");
			break;}
		default:
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			W3RE_068POM.interest(interest);
			W3RE_068POM.rec_cal();
			System.out.println("interest is not blank");
		
		}
		
		
		screenShot.captureScreenShot("W3_068");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		
		boolean gettxt=driver.getPageSource().contains("fill");
		System.out.print("FFFFFF"+ gettxt);
//		
		//Assertion on message on publish button view post
 		// Assert.assertEquals(msgtxt,true);
		Assert.assertTrue(msgtxt.contains(expectedString));

	
		
		
		//String alertMsg = alert.getText();
		//System.out.println(alertMsg);
		
		
		
		

	}

}
