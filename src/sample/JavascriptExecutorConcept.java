package sample;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		
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
		driver.get("https://ui.freecrm.com/");
		  Thread.sleep(4000);

		  //Locating web elements using xpath
		  driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("test@gmail.com");
		    Thread.sleep(4000);
		    
		   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("welcome@123");
		   Thread.sleep(4000);
		    
		   //  Clicking on login button
		   
		   WebElement loginButton = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		   
		   // Calling flash method to highlight the element
		   flash(loginButton,driver);
		   
		   Thread.sleep(4000);
		   
		   //Calling drawBorder method to the create a circle 
		   
		   drawBorder(loginButton,driver);
		   
		   // Take a screenshot 
		   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   
		   FileUtils.copyFile(src, new File("D:\\Example.png"));
		   
		   //Get page title by calling getTitleByJs
		   
		   System.out.println(getTitleByJs(driver));
		   Thread.sleep(4000);
		   
		   //Get page inner text by using get below getInnerPageText method
		   
		   System.out.println(getInnerPageText(driver));
		   Thread.sleep(4000);

	}

	  // To higlight a button/element we have to create a method called flash 
	
	   public static void flash(WebElement element, WebDriver driver) throws InterruptedException
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		   
		    String bgcolor = element.getCssValue("backgroundColor");
		   
		   for (int i=0; i<2; i++)
		   {
			   changeColor("rgb(0,200,0)",element,driver);
			   changeColor(bgcolor,element,driver);
			   
		   }
		   
		   
	   }

	   public static void changeColor(String color, WebElement element, WebDriver driver) 
	
	{
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		   
		   js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element);
		   
		   try
		   {
			   Thread.sleep(2000);
		   } catch(InterruptedException e)
		   {
			   
		   }
		
	}
	   
	   public static void drawBorder(WebElement element, WebDriver driver)
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		   
		     js.executeScript("arguments[0].style.border='3px solid red'",element);
		     
	   }
	   
	   public static String getTitleByJs(WebDriver driver)
	   {
		   
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		      String title =  js.executeScript("return document.title").toString();
		       return title;
		   
	   }
	   
	   public static String getInnerPageText(WebDriver driver)

          { 
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		  String innertext = js.executeScript("return document.documentElement.innerText").toString();
		  
		     return innertext;
		     
		   }
}
