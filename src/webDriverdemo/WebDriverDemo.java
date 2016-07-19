package webDriverdemo;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverDemo {

	public static void main(String[] args) {
	
		WebDriver driver = new FirefoxDriver();
		// Puts an Implicit wait, Will wait for 10 seconds
		// before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launch website
		driver.navigate().to("http://www.calculator.net/");
		// Maximize the browser
		driver.manage().window().maximize();
	
		PageOnModule.mathClick(driver).click();
		PageOnModule.percentClick(driver).click();
		PageOnModule.firstText(driver).clear();
		PageOnModule.firstText(driver).sendKeys("10");
		PageOnModule.secondText(driver).clear();
		PageOnModule.secondText(driver).sendKeys("50");
		PageOnModule.calButton(driver).click();
		
		String result =PageOnModule.result(driver).getText();
		System.out.println("Result-----"+result);
		
		
		//To find links on web page
		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println("No. of links are"+links.size());
		if(links.size()>1){
			for(int i=0;i<links.size();i++){
				System.out.println("the links are as " +i +links.get(i).getText());
				
			}
			
		}
		
	
		
		}

}
