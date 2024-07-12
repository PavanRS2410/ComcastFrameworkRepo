package com.comcast.crm.generic.ListenerUtility;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.Baseclassutility.BaseClassTest;
import com.comcast.crm.generic.webdriverutility.ClassObjectUtility;

public class ListenerImplementation implements ITestListener,ISuiteListener
{
	
	public static ExtentReports report;         //so that it can be called by classname.variablename anywhere
	public static WebDriver driver;
	public static ExtentTest test;
	
	
	public void onStart(ISuite suite)             //to configure the report
	{
		System.out.println("report configuration");
		//Step 1 - create spark config extent report
		String time = new Date().toString().replace(" ", "_").replace(":", "_"); //to give timestamp
		File f = new File("./AdvancedReport/extentreport_"+time+".html");
		ExtentSparkReporter spark = new ExtentSparkReporter(f);
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Step 2 - add environment info
		report = new ExtentReports();
		report.attachReporter(spark);  
		report.setSystemInfo("OS", "W-10");
		report.setSystemInfo("Browser", "Chrome 90");
		
	}

	public void onFinish(ISuite suite) 
	{
		System.out.println("report backup");
		report.flush();                    //mandatory to see the data saved/backed up
	}

	//use onTestStart() to create TC inside extent report as it will get executed before each tc
	public void onTestStart(ITestResult result)       
	{
		System.out.println("--->"+result.getMethod().getMethodName()+"<---start---");
		test = report.createTest(result.getMethod().getMethodName());
		ClassObjectUtility.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"--->TC started<---");
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("--->"+result.getMethod().getMethodName()+"<---end---");
		test.log(Status.PASS, result.getMethod().getMethodName()+"--->TC completed<---");

	}

	//use onTestFailure() to take ss if any testcase is failed
	public void onTestFailure(ITestResult result) 
	{
		String time = new Date().toString().replace(" ", "_").replace(":", "_"); //to give timestamp
		//write take ss code on test case failure
		String TC_name = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClassTest.temp_driver;   
 		String file_path = ts.getScreenshotAs(OutputType.BASE64);   
 		test.addScreenCaptureFromBase64String(file_path,TC_name+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"--->TC failed<---");
 		
	}

	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, result.getMethod().getMethodName()+"--->TC skipped<---");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		
	}

	public void onFinish(ITestContext context) 
	{
		
	}
	
}
