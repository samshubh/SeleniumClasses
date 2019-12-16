package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import test.util.Xls_Reader;

public class DataDrivenConceptUsingSingleColumn {
	
	 public static WebDriver driver;
	
	
	public static void main(String args[]) throws InterruptedException
	
	{
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\subham\\eclipse-workspace\\SeleniumClass\\src\\com\\testdata\\ExcelSheet.xlsx");
		
		  
		
		String fname = reader.getCellData("TestData2", "Firstname", 2);
		
		  System.out.println(fname);
		  
		 String lname =  reader.getCellData("TestData2", "Lastname", 2);
		  
		   System.out.println(lname);
		   
		   String address =  reader.getCellData("TestData2", "Address", 2);
			  
		   System.out.println(address);
		   
		   String city =  reader.getCellData("TestData2", "City", 2);
			  
		   System.out.println(city);
		   
		   String state =  reader.getCellData("TestData2", "StateT", 2);
			  
		   System.out.println(state);
		   
		   String pincode =  reader.getCellData("TestData2", "Pincode", 2);
		  
		   System.out.println(pincode);
		   
		   
		// Setting the path and property of chrome driver
			System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
			
			// Creating instance of webdriver 
			WebDriver driver = new ChromeDriver();
			
			//Maximizing the browser
			
			driver.manage().window().maximize();
			
			// clearing the browser cookies
			
			driver.manage().deleteAllCookies();
			
			//Setting the page load timeout for the web page 
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//Syntax for implicit wait
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
			Thread.sleep(2000);
			
		   
		          
		          driver.findElement(By.id("firstname")).sendKeys(fname);
		            Thread.sleep(2000);
		            
		            driver.findElement(By.id("lastname")).sendKeys(lname);
		            Thread.sleep(2000);
		            
			            driver.findElement(By.id("address1")).sendKeys(address);
			            Thread.sleep(2000);
		            
		            driver.findElement(By.id("city")).sendKeys(city);
		            Thread.sleep(2000);
		            
		            Select state1= new Select(driver.findElement(By.id("state")));
		            state1.selectByVisibleText(state);
		            Thread.sleep(2000);
		            
		            driver.findElement(By.id("zip")).sendKeys(pincode);
		            Thread.sleep(2000);
		      
		      
		    driver.quit();
		   
	}

}
