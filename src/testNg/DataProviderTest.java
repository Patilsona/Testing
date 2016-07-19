package testNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelUtils;

public class DataProviderTest {
	public WebDriver driver;

	@DataProvider
	public Object[][] credentials() {
		System.out.println("I am in DataProviderTest");
		return new Object[][] { { "sonali", "soffffnali" ,"status"} };
	}

	@Test(dataProvider = "Authentication")
	public void test(String username, String password) {
		System.out.println("I am in test");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://art.thephpprojects.com");
		System.out.println("browser gets launched----");
		WebElement unm = driver.findElement(By.id("uname"));
		System.out.println("username i read from excel---" + username);
		unm.sendKeys(username);

		WebElement pwd = driver.findElement(By.id("password"));
		System.out.println("password-----" + password);
		pwd.sendKeys(password);

		WebElement btn = driver.findElement(By.tagName("input"));
		btn.submit();
		
	}

}
