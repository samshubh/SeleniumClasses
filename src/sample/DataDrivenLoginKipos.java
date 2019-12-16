package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.util.Xls_Reader;

public class DataDrivenLoginKipos {
	
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
					
					driver.findElement(By.xpath("//div[@class='col-lg-4 col-xl-4 col-md-5 col-sm-4 col-8 sign-right order-aline-2 ng-scope']//span[@class='btn btn-sign'][contains(text(),'Login')]")).click();
					Thread.sleep(5000);
					
					
					// Now here calling the excel sheet
					
					 Xls_Reader reader= new Xls_Reader("C:\\Users\\subham\\eclipse-workspace\\SeleniumClass\\src\\com\\testdata\\ExcelSheet.xlsx");
					 
					   int rowCount =  reader.getRowCount("TestData3");
					   
					   
			             for(int rowNum=2;rowNum<=rowCount;rowNum++)
			             {
			            	 
			            	 String email = reader.getCellData("TestData3", "Email", rowNum);
			            	  // System.out.println(email);
			            	   
			            	    String password = reader.getCellData("TestData3", "Password", rowNum);
			                      // System.out.println(password);
			                       
			                       
			                       driver.findElement(By.xpath("//input[@id='email']")).clear();
			                       driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
			                         Thread.sleep(4000);

			                       
			                         driver.findElement(By.xpath("//input[@id='password_login']")).clear();
				                       driver.findElement(By.xpath("//input[@id='password_login']")).sendKeys(password);
				                         Thread.sleep(4000);
			            	    
			            	 
			             }
					
					driver.quit();
					
					

			}
			}
