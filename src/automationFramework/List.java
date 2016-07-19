package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String exePath = "D:/Testing/TEST/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		System.out.println("Launching the Browser");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.indiatimes.com/");
	

	}

}
