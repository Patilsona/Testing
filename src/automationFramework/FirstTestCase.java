package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// For Chrome Browser
		String exePath = "D:/Testing/TEST/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		System.out.println("Launching the Browser");
		WebDriver driver = new ChromeDriver();
		driver.get("http://art.thephpprojects.com");
		
		System.out.println("My First Selenium Program");
		String sTitle = driver.getTitle();
		System.out.println("Title is = '" + sTitle + "'");
		
		int sTitlelength = driver.getTitle().length();
		System.out.println("Title Length is = '" + sTitlelength + "'");
		
		System.out.println("Current page URL ---"+driver.getCurrentUrl());
		
		System.out.println("page source ---"+driver.getPageSource());
		
		
		Thread.sleep(5000);
		 driver.close();
	}

}
