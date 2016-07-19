package testNg;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import mx4j.log.Log;

public class ReporterLog {
	private static WebDriver driver;
	 
	private static Logger Log = Logger.getLogger(Log.class.getName());
 
    @Test()
 
	public static void test() {
 
		DOMConfigurator.configure("log4j.xml");
		 PropertyConfigurator.configure("D:/TestingWorkspace/OnlineStrore/src/log/Log4j.properties");
        driver = new FirefoxDriver();
        
        Log.info("launching firefox drivers---");
        
        driver.get("http://art.thephpprojects.com");
        Log.info("the site is being opened in browser");
        WebElement unm = driver.findElement(By.id("uname"));
		unm.sendKeys("sonali");
		Log.info("User name has been field");

		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("sonali");
		Log.info("Password has field");
		

		WebElement btn = driver.findElement(By.tagName("input"));

		
		Assert.assertTrue(btn.isDisplayed());
		
		btn.submit();
		Reporter.log("SignIN in Successfully");
    }
}
