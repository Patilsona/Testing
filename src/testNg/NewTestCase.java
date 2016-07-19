package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NewTestCase {
	
	public static void runTest(String username, String password) {
	    
	    // Start a browser driver and navigate to Google
	    WebDriver driver = new FirefoxDriver();
	    driver.get("http://art.thephpprojects.com");

	    WebElement unm = driver.findElement(By.id("uname"));
		System.out.println("username i read from excel---" + username);
		unm.sendKeys(username);

		WebElement pwd = driver.findElement(By.id("password"));
		System.out.println("password-----" + password);
		pwd.sendKeys(password);

		WebElement btn = driver.findElement(By.tagName("input"));
		btn.submit();
	     
	     System.out.println("test executed---");
	    //Close the browser
	    driver.quit();
	}
}
