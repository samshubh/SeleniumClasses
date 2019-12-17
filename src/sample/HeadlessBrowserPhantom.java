package sample;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class HeadlessBrowserPhantom {

	public static void main(String args[]) throws InterruptedException
	{
	// Setting the path and property of chrome driver
	System.setProperty("phantomjs.binary.path","C:\\Users\\subham\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
	
	// Creating instance of webdriver 
	WebDriver driver = new PhantomJSDriver();
	
	//Maximizing the browser
	
	driver.manage().window().maximize();
	
	// clearing the browser cookies
	
	driver.manage().deleteAllCookies();
	
	//Setting the page load timeout for the web page 
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
	//Syntax for implicit wait
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	//Enter Url
	 driver.get("https://www.kiposcollective.com/");
	 Thread.sleep(4000);
	
	
	  String title =driver.getTitle();
	   System.out.println(title);
	  
	
}
}
