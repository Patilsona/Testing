package testNg;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelUtils;

public class DataProviderWithExcel_002 {

	private String sTestCaseName;

	private int iTestCaseRow;

	WebDriver driver;

	@Test(dataProvider = "Authentication")
	public void f(String username, String password) throws EncryptedDocumentException, InvalidFormatException, IOException {
		try{
		WebElement unm = driver.findElement(By.id("uname"));
		System.out.println("username i read from excel---" + username);
		unm.sendKeys(username);

		WebElement pwd = driver.findElement(By.id("password"));
		System.out.println("password-----" + password);
		pwd.sendKeys(password);

		WebElement btn = driver.findElement(By.tagName("input"));
		btn.submit();
		ExcelUtils.saveCellData("Pass", 1,3);
		}catch(Exception e){
			System.out.println("Exception-->>>>>>>>>"+e.getMessage());
			
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am in before method of DataProviderWithExcel_002");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://art.thephpprojects.com");
		System.out.println("BROWSER gets open----");

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("I am in after method");
		//ExcelUtils.setCellData("Pass", 1, 3);
		Thread.sleep(60000);
		// driver.quit();
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		System.out.println("I am in DataProviderWithExcel_002 ");
		ExcelUtils.setExcelFile("D:/TestingWorkspace/OnlineStrore/src/tetsData/TestData.xlsx", "Sheet1");


		
		sTestCaseName = this.toString();
		System.out.println("test case name----" + sTestCaseName);

		// From above method we get long test case name including package and
		// class name etc.

		// The below method will refine your test case name, exactly the name
		// use have used

		sTestCaseName = ExcelUtils.getTestCaseName(this.toString());

		// Fetching the Test Case row number from the Test Data Sheet

		// Getting the Test Case name to get the TestCase row from the Test Data
		// Excel sheet
		
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);
		System.out.println("iTestcaseRow------" + iTestCaseRow);
		Object[][] testObjArray = ExcelUtils
				.getTableArray("D:/TestingWorkspace/OnlineStrore/src/tetsData/TestData.xlsx", "Sheet1", iTestCaseRow);
		System.out.println("returned successfully" + testObjArray.toString());
		
		return (testObjArray);

	}
}
