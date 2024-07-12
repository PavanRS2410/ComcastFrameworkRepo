package com.comcast.crm.generic.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImplementation implements IRetryAnalyzer
{
	int count = 0;
	int limit_count = 5;      //retry the execution for these many times
	public boolean retry(ITestResult result) 
	{
		if(count<limit_count)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
