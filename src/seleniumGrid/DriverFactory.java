package seleniumGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class DriverFactory {
	private DriverFactory() {
		
	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		System.out.println("instance ==="+instance);
		return instance;
	}

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local
	{
		@Override
		protected WebDriver initialValue() {
			
			return new ChromeDriver(); 
		}
	};

	public WebDriver getDriver() // call this method to get the driver object
									// and launch the browser
	{
		System.out.println("driver.get----"+driver.get());
		return driver.get();
	}

	public void removeDriver() // Quits the driver and closes the browser
	{
		driver.get().quit();
		driver.remove();
	}

	@BeforeMethod
	public void setup() {
		WebDriver driver = DriverFactory.getInstance().getDriver();
		driver.get("http://www.google.com");
	}

	@Test
	public void testDriver() {
		WebDriver driver = DriverFactory.getInstance().getDriver();
		System.out.println("driver ----"+driver);
		
		System.out.println("Windows Title: " + driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().removeDriver();
	}
}

