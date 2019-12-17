package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {
	
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
		
		// Creating instance of webdriver 
		WebDriver driver = new HtmlUnitDriver();
		
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
		
		String title = driver.getTitle();
		 System.out.println(title);
		
		
	}
}
