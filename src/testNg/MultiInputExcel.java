package testNg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class MultiInputExcel {
	@Test
	public static void main () {
		 
	    try {
	        // Open the Excel file
	        FileInputStream fis = new FileInputStream("D:/TestingWorkspace/OnlineStrore/src/tetsData/TestData.xlsx");
	        // Access the required test data sheet
	        XSSFWorkbook wb = new XSSFWorkbook(fis);
	        XSSFSheet sheet = wb.getSheet("sheet1");
	        // Loop through all rows in the sheet
	        // Start at row 1 as row 0 is our header row
	        for(int count = 1;count<=sheet.getLastRowNum();count++){
	            XSSFRow row = sheet.getRow(count);
	            System.out.println("Running test case " + row.getCell(0).toString());
	            // Run the test for the current test data row
	            NewTestCase.runTest(row.getCell(1).toString(),row.getCell(2).toString());
	            
	        }
	        fis.close();
	    } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }  
	}



}
