package webDriverdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageOnModule {
	private static WebElement element = null;

	public static WebElement mathClick(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a"));
		return element;

	}

	public static WebElement percentClick(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='menu']/div[4]/div[3]/a"));
		return element;

	}
	public static WebElement firstText(WebDriver driver){
		element=driver.findElement(By.id("cpar1"));
		
		return element;
	}
	public static WebElement secondText(WebDriver driver){
		element=driver.findElement(By.id("cpar2"));
		
		return element;
	}
	public static WebElement calButton(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='content']/table[1]/tbody/tr[2]/td/input[2]"));
		
		return element;
	}
	
	public static WebElement result(WebDriver driver){
		driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b"));
		return element;
	}

}
