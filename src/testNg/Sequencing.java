package testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sequencing {
	
	@Test
	 
	public void testCase1() {

		System.out.println("This is the Test Case 1");

	}

	@Test

	public void testCase2() {

		System.out.println("This is the Test Case 2");

	}
	@Test

	public void testCase3() {

		System.out.println("This is the Test Case 3");

	}

	@BeforeMethod

	public void beforeMethod() {

		System.out.println("beforeMethod");

	}

	@AfterMethod

	public void afterMethod() {

		System.out.println("@AfterMethod");

	}

	@BeforeClass

	public void beforeClass() {

		System.out.println("@BeforeClass");

	}

	@AfterClass

	public void afterClass() {

		System.out.println("@AfterClass");

	}

	@BeforeTest

	public void beforeTest() {

		System.out.println("@BeforeTest");

	}

	@AfterTest

	public void afterTest() {

		System.out.println("@AfterTest");

	}

	@BeforeSuite

	public void beforeSuite() {

		System.out.println("@BeforeSuite");

	}

	@AfterSuite

	public void afterSuite() {

		System.out.println("@AfterSuite");

	}

}


