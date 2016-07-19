package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Testng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String expath = "D:/Testing/TEST/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", expath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		
		
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      driver.get("http://art.thephpprojects.com/timesheet");
	 
	      // Here driver will try to find out My Account link on the application
	 
	     // WebElement myAccount = driver.findElement(By.xpath(".//*[@id='account']/a"));
	 
	      //Test will only continue, if the below statement is true 
	 
	      //This is to check whether the link is displayed or not
	      WebElement unm =driver.findElement(By.id("uname"));
	      unm.sendKeys("sonali");
	      
	      WebElement pwd =driver.findElement(By.id("password"));
	      pwd.sendKeys("sonali");
	      
	      WebElement btn = driver.findElement(By.tagName("input"));
	      btn.submit();
	      
	      WebElement Image =driver.findElement(By.xpath("html/body/div[2]/header/div/div[1]/a/img"));
	    //Rihgt click on Image using contextClick() method.
	    Actions action= new Actions(driver);
	    action.contextClick(Image).build().perform();
	      
 
	}

}
