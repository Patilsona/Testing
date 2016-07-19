package automationFramework;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import org.openqa.selenium.support.ui.Select;
public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String expath = "D:/Testing/TEST/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", expath);

		ChromeOptions options = new ChromeOptions();// To open window in //
													// fullscreen
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String appurl = "http://www.DemoQA.com";
		driver.get(appurl);

		// driver.findElement(By.xpath("//*[@id='menu-item-141']/a")).click();
		// //Using Xpath

		// JavascriptExecutor exec = (JavascriptExecutor) driver; //to add
		// javascript pop-up
		// exec.executeScript("alert('HI execution is started.....');");

		// to enable textboxes and disable as well
		//
		//WebElement Image =driver.findElement(By.xpath("//*[@id="site_navigation"]/div/div[1]/a/img"));
		
		WebElement element = driver.findElement(By.id("menu-item-374"));
		element.click();

		/*
		 * JavascriptExecutor javascript = (JavascriptExecutor) driver;
		 * 
		 * String todisable =
		 * "document.getElementsByName('first_name')[0].setAttribute('disabled', '');"
		 * ; javascript.executeScript(todisable); String toenable =
		 * "document.getElementsByName('last_name')[0].setAttribute('disabled','');";
		 * javascript.executeScript(toenable);
		 */

		// WebElement radio = driver.findElement(By.name("radio_4[]"));
		// radio.click();

		WebElement fname = driver.findElement(By.name("first_name"));
		fname.sendKeys("shonaaasffa");

		WebElement lname = driver.findElement(By.name("last_name"));
		lname.sendKeys("Patil");

		List<WebElement> list = driver.findElements(By.name("radio_4[]"));
		int size = list.size();
		System.out.println("radio buttons are----" + size);

		for (int i = 0; i < list.size(); i++) {

			String val = list.get(i).getAttribute("value");

			System.out.println("value---------" + val);
			if (val.matches("divorced")) {
				System.out.println("i am in if---------------");
				list.get(i).click();

				System.out.println("list.get(i)----------" + list.get(i).getAttribute("value"));
			}
		}

		List<WebElement> chkbox = driver.findElements(By.name("checkbox_5[]"));
		int chksize = chkbox.size();

		for (int i = 0; i < chksize; i++) {
			String chkboxname = chkbox.get(i).getAttribute("value");
			if (chkboxname.matches("cricket")) {
				System.out.println("I am in if of chkbox-------------");
				chkbox.get(i).click();
			} else {
				chkbox.get(i).click();
			}
		}
		WebElement sel = driver.findElement(By.id("dropdown_7"));
		Select oSelect = new Select(sel);
		List<WebElement> count=oSelect.getOptions();
		System.out.println("count======="+count.size());
		for(int i=0;i<count.size();i++){
			   System.out.println(String.format("Value is: ", count.get(i).getAttribute("value")));
		}
		
		
		oSelect.selectByValue("Algeria");

		WebElement phone = driver.findElement(By.id("phone_9"));
		phone.sendKeys("1345313131");

		WebElement uname = driver.findElement(By.id("username"));
		uname.sendKeys("ccc");

		WebElement email = driver.findElement(By.id("email_1"));
		email.sendKeys("sonalivvq@nbm.com");

		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("Siddhatech Software Services");

		WebElement pass = driver.findElement(By.id("password_2"));
		pass.sendKeys("Siddhatech");

		WebElement confirmpass = driver.findElement(By.id("confirm_password_password_2"));
		confirmpass.sendKeys("Siddhatech");

		WebElement submit = driver.findElement(By.name("pie_submit"));
		submit.click();

		// List rad = (List) driver.findElements(By.name("radio_4[]"));

		/// driver.navigate().to("http://www.DemoQA.com"); navigation commands

		// driver.navigate().back(); to navigate Back

		// driver.navigate().forward(); // to navigate one page forward

		// driver.navigate().to(appurl); //navigate to

		// driver.navigate().refresh(); // to refresh the page
		Thread.sleep(10000);

		// driver.quit();

	}

}
