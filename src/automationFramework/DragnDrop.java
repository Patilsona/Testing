package automationFramework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragnDrop {
	public static void main(String[] args) throws Exception {

		// Initiate browser
		WebDriver driver = new FirefoxDriver();

		// maximize browser
		driver.manage().window().maximize();

		// Open webpage
		driver.get("http://art.thephpprojects.com");


		// Create object of actions class
		Actions action = new Actions(driver);

		action.contextClick().perform();
		Thread.sleep(60000);
	}

}
