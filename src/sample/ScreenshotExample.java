package sample;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {
	
	public static WebDriver driver;
	
	public static void main(String args[]) throws InterruptedException, IOException
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
		
		// Creating instance of webdriver 
		driver = new ChromeDriver();
		
		//Maximizing the browser
		
		driver.manage().window().maximize();
		
		// clearing the browser cookies
		
		driver.manage().deleteAllCookies();
		
		//Setting the page load timeout for the web page 
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//Syntax for implicit wait
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.kiposcollective.com/#/");
		Thread.sleep(4000);
		
		takeScreenshot("Kipos_LandingPage");
		
		Thread.sleep(3000);
		
		driver.close();
	}
	
	
	public static void takeScreenshot(String fileName) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		  FileUtils.copyFile(src, new File("C:\\Users\\subham\\eclipse-workspace\\SeleniumClass\\Screenshots\\"+fileName+".png"));
	}

}
