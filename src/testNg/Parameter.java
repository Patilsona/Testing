package testNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	private static WebDriver driver;

	@Test
	@Parameters({ "username", "password" })
	public void SignIn(String username, String password) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://art.thephpprojects.com");
		Thread.sleep(60000);

		WebElement usernm = driver.findElement(By.id("uname"));
		if (usernm.isDisplayed())
			;
		usernm.sendKeys(username);

		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(password);

		WebElement btn = driver.findElement(By.tagName("input"));
		btn.submit();

	}
}
