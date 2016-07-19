package gmailTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateAccount {
	public WebDriver driver;

	@Test
	public void login() throws InterruptedException, IOException {

		System.out.println("i am in login");
		WebElement FirstName = driver.findElement(By.id("FirstName"));
		FirstName.sendKeys("Sonap");

		WebElement LastName = driver.findElement(By.id("LastName"));
		LastName.sendKeys("Patil");

		WebElement GmailAddress = driver.findElement(By.id("GmailAddress"));
		GmailAddress.sendKeys("sonpatils2793");

		WebElement password = driver.findElement(By.id("Passwd"));
		password.sendKeys("Patil@123");

		WebElement PasswdAgain = driver.findElement(By.id("PasswdAgain"));
		PasswdAgain.sendKeys("Patil@123");
		Thread.sleep(2000);

		List<WebElement> month = driver.findElements(By.className("goog-inline-block"));

		Iterator itr = month.iterator();

		while (itr.hasNext())

		{
			WebElement element = (WebElement) itr.next();
			System.out.println("ELEMENT-----" + element.getText());
			System.out.println("status-----" + element.getAttribute("title"));
			if (element.getAttribute("title").equals("Birthday")) {
				element.click();
				WebElement birthMonth = driver.findElement(By.xpath(".//*[@id=':5']"));
				birthMonth.click();
				break;
			}
		}

		WebElement birthDay = driver.findElement(By.id("BirthDay"));
		birthDay.sendKeys("27");

		WebElement birthyear = driver.findElement(By.id("BirthYear"));
		birthyear.sendKeys("1995");

		List<WebElement> gender = driver.findElements(By.id(":d"));
		System.out.println("gendersize----" + gender.size());

		WebElement RecoveryPhoneNumber = driver.findElement(By.id("RecoveryPhoneNumber"));
		RecoveryPhoneNumber.sendKeys("9561774838");

		WebElement RecoveryEmailAddress = driver.findElement(By.id("RecoveryEmailAddress"));
		RecoveryEmailAddress.sendKeys("sonalibpatil27@gmail.com");

		WebElement SkipCaptcha = driver.findElement(By.id("SkipCaptcha"));
		SkipCaptcha.click();

		WebElement termsAndCondition = driver.findElement(By.id("terms-of-service-label"));
		termsAndCondition.click();
		Thread.sleep(600);
		// submitbutton
		WebElement submitbtn = driver.findElement(By.id("submitbutton"));
		submitbtn.submit();

		Thread.sleep(90);

	}

	@Parameters("params")
	@BeforeClass
	public void beforeMethod(String params) throws IOException {

		FileInputStream fileInput = new FileInputStream("D:/TestingWorkspace/OnlineStrore/src/dataFile.properties");
		Properties prop = new Properties();
		prop.load(fileInput); // load properties file

		if (params.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (params.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/Testing/TEST/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();

		}

		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void afterMethod() {
		try {
			// driver.quit();
		} catch (Exception e) {
			driver = null;
		}

	}

}
