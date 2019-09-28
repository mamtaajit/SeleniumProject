package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean_066;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProvidersRE_066;
import com.training.generics.ScreenShot;
import com.training.pom.W3RE_066POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class loginExcel_W3RE_066 {
	private static WebDriver driver;
	private static String baseUrl;
	private static W3RE_066POM W3RE_066POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException 
	{
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		W3RE_066POM = new W3RE_066POM(driver);
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
		W3RE_066POM.sendUserName("mamtanevrekar@gmail.com");
		W3RE_066POM.sendPassword("sweethome@1223");
		
		W3RE_066POM.clickLoginBtn();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		

	}

	
	@Test(priority=2, dataProvider = "excel-inputs", dataProviderClass = LoginDataProvidersRE_066.class)
	public void rundata(String yourname, String youremail, String yoursubj, String yourmessage)
	{
		//System.out.print("yourname"+yourname+"youremail"+youremail+"ypursubj"+yoursubj+"ypurmessgae"+yourmessage);

		W3RE_066POM.open_clkplots();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W3RE_066POM.sendname(yourname);
		W3RE_066POM.sendemail(youremail);
		W3RE_066POM.sendsub(yoursubj);
		W3RE_066POM.sendmsg(yourmessage);
		W3RE_066POM.sendmsg(yourmessage);
		W3RE_066POM.rec_send();
		screenShot.captureScreenShot("First");
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 


	}

}