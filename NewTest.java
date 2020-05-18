package propackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	public String url = "https://vast-dawn-73245.herokuapp.com/";
	public WebDriver driver;
	
	
	 @BeforeTest
	  public void openwebsite() throws InterruptedException {
		 
		 System.setProperty("webdriver.chrome.driver", "/home/pawan/Downloads/selenium resources/chromedriver");
		 	 
		 System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");		//to hide chrome logs
		 driver = new ChromeDriver();		//ChromeDriver object
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);		//wait to  find next web element
		 driver.get(url);		//to open the url in browser	
	  }
	
	 @Test
	 public void test() throws InterruptedException 
	 {
	
		 String expectedtitle = "Propine Date Parser";
		 String actualtitle = driver.getTitle();		//To get page title
		 Assert.assertEquals(actualtitle, expectedtitle);		// To check the page title
		 System.out.println("Website Opened Successfully");
			
		 String[] date= {"01 01 2020 10:00 AM", "30/12/2020 10:00 PM" , 
				 		"12/30/2020 10:00 PM", "12 Jan, 2020 22:00 +4:0", 
				 		"Feb 30 2020 10:00 -2:00", "-12 01 2020 10:30 GMT+5:30"};		//Array of date strings.
			 
		 for(String i : date)
		 {
		 driver.findElement(By.name("date")).sendKeys(i);		//Enter date in field
		 driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();		//Click on Submit button
		 String result = driver.findElement(By.xpath("//*[@class='col-md-6'][2]/div")).getText();		//Get  result
		 System.out.println(i+ " is : " + result); // to print the result.
		 }
 
	 }

  @AfterTest
  public void afterTest() throws InterruptedException
  	{
			driver.quit();
  	}

}
