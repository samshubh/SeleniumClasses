package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingModalPopUp {

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
		
		//Enter Url
		driver.get("https://www.goindigo.in/");
		
		Thread.sleep(3000);
		
		Actions action= new Actions(driver);
		
		action.moveToElement(driver.findElement(By.id("ym-notification"))).build().perform();
		
		 driver.findElement(By.xpath("//div[@class='close']")).click();
		 
		  Thread.sleep(3000);
		  
		  driver.close();
		
		 
		
	}
}
