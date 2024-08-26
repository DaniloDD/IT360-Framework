package com.it360.qa.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.it360.qa.Utils.ExtentReporter;


public class MyListener implements ITestListener{

	public ExtentReports extentReports;
	public String testName;
	public ExtentTest extentTest;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Project Execution started");
		extentReports = ExtentReporter.generateExtentReporter();
	}

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		extentTest = extentReports.createTest(testName);
		extentTest.log(Status.INFO, testName + "--> Started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testName = result.getName();
		extentTest.log(Status.PASS, testName + "--> Executed Seccessfully");		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testName = result.getName();
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		// create screenshot of the driver
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/Screenshot/" + testName +".png";
		try {																	// use the Selenium class not the Util
			FileHandler.copy(source, new File(destinationFile));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// in the test failed it will attach the screenshot and past the details of the failed test
		extentTest.addScreenCaptureFromPath(destinationFile);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "got failed");		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testName = result.getName();
		extentTest.log(Status.SKIP, testName + "--> Test case execution Skipped");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Project Execution Finished");
		extentReports.flush();
		// opens up the report directly at the end of the execution
		String pathOfExtentReport = System.getProperty("user.dir") + "/test-output/ExtentReports/extentreportsIT360.html";
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}