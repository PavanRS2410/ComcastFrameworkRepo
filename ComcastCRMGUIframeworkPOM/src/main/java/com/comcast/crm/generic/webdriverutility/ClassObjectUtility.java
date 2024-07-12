package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ClassObjectUtility 
	//this class helps to share static members to multiple threads therefore helping to achieve 
	//parallel execution with static 
{
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static ExtentTest getTest() 
	{
		return test.get();   //will give extent test obj for multiple tests which help for parallel execution
	}
	public static void setTest(ExtentTest act_test) 
	{
		test.set(act_test);
	}
	public static WebDriver getDriver() 
	{
		return driver.get();
	}
	public static void setDriver(WebDriver act_driver) 
	{
		driver.set(act_driver);
	}
}
