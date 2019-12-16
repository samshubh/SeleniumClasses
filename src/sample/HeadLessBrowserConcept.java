package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HeadLessBrowserConcept {

	public static void main(String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
		
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("window-size=1400,800");
		
		options.addArguments("headless");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		
		driver.get("https://ui.freecrm.com/");
		
		
		String title = driver.getTitle();
		
		   System.out.println(title);
		   
		   driver.findElement(By.name("email")).sendKeys("subhambiswas895@gmail.com");
		     Thread.sleep(4000);
		     
		     driver.findElement(By.name("password")).sendKeys("Welcome123$");
		       Thread.sleep(4000);
		       
		       driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		         Thread.sleep(4000);
		         
		        System.out.println("User has logged in sucessfully");
		        
		        driver.findElement(By.xpath("//div[@id='main-nav']//a[4]")).click();	
		            Thread.sleep(4000);
		            
		            driver.findElement(By.xpath("//div[@class='ui right corner labeled input']//input[@name='name']")).sendKeys("Srijay");
		              Thread.sleep(2000);
		              
//		              driver.findElement(By.xpath("")).sendKeys("Chette");
//		                Thread.sleep(2000);
		                
		                  driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
		                    Thread.sleep(4000);
		                   
		                    System.out.println("Company added sucessfully");
		                    driver.quit();
	}

 
}
