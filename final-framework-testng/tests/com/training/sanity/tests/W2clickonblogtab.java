//Test case 3  week2 
package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.W2clickonblogtabPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class W2clickonblogtab
{

	private WebDriver driver;
	private String baseUrl;
	private W2clickonblogtabPOM W2clickonblogtabPOM;
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
		W2clickonblogtabPOM = new W2clickonblogtabPOM(driver); 
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
		
		W2clickonblogtabPOM.sendUserName("mamtanevrekar@gmail.com");
		W2clickonblogtabPOM.sendPassword("sweethome@1223");
		W2clickonblogtabPOM.clickLoginBtn();
		W2clickonblogtabPOM.clkblog.click();
		
		boolean gettxtbtn=driver.getPageSource().contains("Search Button");
		System.out.print(gettxtbtn);
		System.out.println("No search button found");
		
		Assert.assertEquals(gettxtbtn,true);
		System.out.println("GetTEXT"+ gettxtbtn);

		
	}
}
