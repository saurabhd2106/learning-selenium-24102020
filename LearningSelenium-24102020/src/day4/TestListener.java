package day4;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("I am executing since test failed... " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("I am executing since test passed... " + result.getName());

	}

}
