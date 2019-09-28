package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.training.generics.ScreenShot;
import com.training.pom.W2clickVillastabPOM;
import com.training.pom.W3RE_070POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class loginExcel_W3RE_070 
{
	private static WebDriver driver;
	private static String baseUrl;
	private static W3RE_070POM W3RE_070POM;
	private static Properties properties;
	private static ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		W3RE_070POM = new W3RE_070POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}


	@AfterMethod
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	@Test(priority=1)
	public void checkdata()
	{
		W3RE_070POM.sendUserName("manipal");
		W3RE_070POM.sendPassword("manipal@123");
		
		W3RE_070POM.clickLoginBtn();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
		W3RE_070POM.open_clkproperties();
		W3RE_070POM.open_clkfeature();
	
		W3RE_070POM.sendtagname("W3 post");
		W3RE_070POM.sendtagslug("W3 post");
		W3RE_070POM.senddesc("W3 NL of plots post");
		W3RE_070POM.clicksubmitBtn();
		W3RE_070POM.open_clkaddnew();
		W3RE_070POM.sendtitle("W3 POST1234");
		W3RE_070POM.sendpostdesc("W3 POST1234 description");
		//W3RE_070POM.senddrpfeature();
		//W3RE_070POM.feature.click();
		W3RE_070POM.senddrpfeature();
		W3RE_070POM.senddrpfeature1();
		
		W3RE_070POM.clickpublishBtn();
		
		W3RE_070POM.clickpostview();
		
		//WebElement feature= driver.findElement(By.xpath("//div[@id='property_featurediv']//h2[@class='hndle ui-sortable-handle']"));
		//feature.click();
	
		 //WebElement drp_feature= driver.findElement(By.xpath("//li[@id='property_feature-494']"));
		 //drp_feature.click();


		String classname_cate= W3RE_070POM.feature.getAttribute("class");
		//String classname_cate= W3RE_070POM.feature.getAttribute("aria-expanded");

		System.out.println("Classname"+ classname_cate);
		//System.out.println("");
	
		//if (Boolean.parseBoolean(classname_cate="postbox closed"))
	//	{
			 //("//div[@id='categorydiv']//h2[@class='hndle ui-sortable-handle']" ));
		//	W3RE_070POM.feature.click();
			//W3RE_070POM.senddrpfeature();
	//}

		
	
				
	}

}
