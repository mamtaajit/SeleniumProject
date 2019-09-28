package prjselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropby {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\IBM java\\Selenium jar\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();  
		//driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.get("http://realestatem1.upskills.in/region/villas-in-bangalore/?realteo_order=&keyword_search=Thane%2C+Maharashtra%2C+India&_property_type=&tax-region=");
	//	WebElement sortby=driver.findElement(By.xpath("//a[@class='button fullwidth margin-top-20']"));
		WebElement sortby1=driver.findElement(By.partialLinkText("Drop"));
				
		Actions action = new Actions(driver);
        action.moveToElement(sortby1).click().perform(); 
        sortby1.click();
		
	}

}
