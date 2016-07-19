package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeGridTest {
	WebDriver driver = null;
	private StringBuffer verificationErrors = new StringBuffer();

	// Pass plateform, browser and url parameters to launch browser and URL in
	// given plateform.
	@Parameters({ "platform", "browser", "url" })
	@BeforeTest(alwaysRun = true)
	public void setup(String platform, String browser, String url) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		// Set Platforms based on parameter received from testng.xml.
		caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);

		// Set browser capability based on parameter received from testng.xml.
		if (browser.equalsIgnoreCase("Internet Explorer"))
			caps = DesiredCapabilities.internetExplorer();
		if (browser.equalsIgnoreCase("Firefox"))
			caps = DesiredCapabilities.firefox();
		if (browser.equalsIgnoreCase("chrome"))
			caps = DesiredCapabilities.chrome();

		// Open browser on grid node.
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Open URL of Application
		driver.get(url);
	}

	// Simple test method to execute.
	@Test(description = "Wait for button enabled")
	public void waitForButtonEnabled() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submitButton")));
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	}

	// Simple test method to execute.
	@Test(description = "Wait for button enabled", dependsOnMethods = { "waitForButtonEnabled" })
	public void testCalc() throws InterruptedException {
		driver.navigate().to("http://only-testing-blog.blogspot.in/2014/04/calc.html");
		driver.findElement(By.xpath("//input[@id='2']")).click();
		driver.findElement(By.xpath("//input[@id='plus']")).click();
		driver.findElement(By.xpath("//input[@id='5']")).click();
		driver.findElement(By.xpath("//input[@id='equals']")).click();
		String result = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");

		// Get Browser name and version.
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();

		// Get OS name.
		String os = System.getProperty("os.name").toLowerCase();

		// Print test result with browser and OS version detail.
		System.out.println(
				"OS = " + os + ", Browser = " + browserName + " " + browserVersion + " Test Result = " + result);
	}

	@AfterTest
	public void afterTest() {
		// Close the browser
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
