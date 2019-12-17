package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import test.util.Xls_Reader;

public class DataDrivenUsingForLoop {
	
	 public static WebDriver driver;
	
	
	public static void main(String args[]) throws InterruptedException
	
	{
		   
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
					
					driver.get("https://www.kiposcollective.com/#/");
					Thread.sleep(2000);
					
					
				
		        //Reading the excel file from the test util class
		Xls_Reader reader = new Xls_Reader("C:\\Users\\subham\\eclipse-workspace\\SeleniumClass\\src\\com\\testdata\\ExcelSheet.xlsx");
		
		  int rowCount = reader.getRowCount("TestData1");
		   
		  for (int rowNum=2;rowNum<=rowCount;rowNum++)
		   {
			   
		   String fname = reader.getCellData("TestData1", "Firstname", rowNum);
		
		  System.out.println(fname);
		  
		   String lname =  reader.getCellData("TestData1", "Lastname",rowNum);
		  
		   System.out.println(lname);
		   
		   String address =  reader.getCellData("TestData1", "Address",rowNum);
			  
		   System.out.println(address);
		   
		   String city =  reader.getCellData("TestData1", "City",rowNum);
			  
		   System.out.println(city);
		   
		   String state =  reader.getCellData("TestData1", "StateT", rowNum);
			  
		   System.out.println(state);
		   
		   String pincode =  reader.getCellData("TestData1", "Pincode", rowNum);
		  
		   System.out.println(pincode);
		   
		   
		      // Here this is webdriver code for the registartion form
		   
		           driver.findElement(By.id("firstname")).clear();
		           driver.findElement(By.id("firstname")).sendKeys(fname);
		            Thread.sleep(2000);
		            
		            driver.findElement(By.id("lastname")).clear();
		            driver.findElement(By.id("lastname")).sendKeys(lname);
		            Thread.sleep(2000);
		            
		            driver.findElement(By.id("address1")).clear();
			        driver.findElement(By.id("address1")).sendKeys(address);
			            Thread.sleep(2000);
		            
			        driver.findElement(By.id("city")).clear();
		            driver.findElement(By.id("city")).sendKeys(city);
		            Thread.sleep(2000);
		            
		            Select state1= new Select(driver.findElement(By.id("state")));
		            state1.selectByVisibleText(state);
		            Thread.sleep(2000);
		            
		            driver.findElement(By.id("zip")).clear();
		            driver.findElement(By.id("zip")).sendKeys(pincode);
		            Thread.sleep(2000);
		      
		      
		          
		
		   }  
	
	      // here we are closing the browser
		  
		  driver.quit();
	}   
	
	
	
	

}
