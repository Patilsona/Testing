package testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class MultiBrowsing {
	public WebDriver driver;

	@Test
	public void Login() {

		System.out.println("Now i am in test");
		WebElement unm = driver.findElement(By.id("uname"));
		unm.sendKeys("sonali");

		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("sonali");

		WebElement btn = driver.findElement(By.tagName("input"));
		btn.submit();
	}

	@Parameters("params")
	@BeforeClass
	public void beforeTest(String param) {
		if (param.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (param.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Testing/TEST/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();

		}
		driver.get("http://art.thephpprojects.com");
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
