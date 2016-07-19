package testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class NewTest {

	public WebDriver driver;

	@Test
	public void main() {
		System.out.println("Now i am in test");
		WebElement unm = driver.findElement(By.id("uname"));
		unm.sendKeys("sonali");

		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("sonali");

		WebElement btn = driver.findElement(By.tagName("input"));
		btn.submit();

	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("I am in before method----------");
		System.setProperty("webdriver.chrome.driver", "D:/Testing/TEST/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://art.thephpprojects.com");
		Thread.sleep(60000);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am in after method-----------");
		//driver.quit();
	}

}
