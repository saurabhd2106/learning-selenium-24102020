package day3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTesting {
	
	@BeforeClass(alwaysRun = true)
	public void beforeAClass() {
		System.out.println("Execute as first method when this class load");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("Execute as last method of this class load");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeATestMethod() {
		System.out.println("Before every test case..");
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterATestMethod() {
		System.out.println("After every test case..");
	}
	
	@Test
	public void testcase1() {
		System.out.println("Test case 1");
	}
	
	@Test
	public void testcase4() {
		System.out.println("Test case 4");
	}
	
	
	@Test
	public void testcase7() {
		System.out.println("Test case 7");
	}
	
	@Test
	public void testcase2() {
		System.out.println("Test case 2");
	}
	
	@Test(groups = {"Sanity", "Feature 1"})
	public void testcase23() {
		System.out.println("Test case 1");
	}
	
	@Test(groups = {"Sanity"})
	public void testcase43() {
		System.out.println("Test case 43");
	}
	
	
	@Test(groups = {"Sanity"})
	public void testcase19() {
		System.out.println("Test case 19");
	}
	
	@Test
	public void testcase8() {
		System.out.println("Test case 8");
	}

}
