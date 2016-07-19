package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExampleTest {
	public WebDriver driver;


	@Parameters({ "browser", "platform", "URL" })
	@BeforeTest
	public void setup(String browser, String platform, String URL) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);

		if (browser.equalsIgnoreCase("Firefox"))
			caps = DesiredCapabilities.firefox();
		if (browser.equalsIgnoreCase("chrome"))
			caps = DesiredCapabilities.chrome();

		// Open browser on grid node.
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		// Open URL of Application
		driver.get(URL);
	}

	@Test
	public void mailTest() throws MalformedURLException, InterruptedException {

		driver.findElement(By.id("Email")).sendKeys("username");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("pass");
		driver.findElement(By.id("signIn")).submit();
		Thread.sleep(20000);

	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("driver is being closed...");
		//driver.close();
	}

}
