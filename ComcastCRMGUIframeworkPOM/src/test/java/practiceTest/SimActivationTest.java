package practiceTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.Baseclassutility.BaseClassTest;

public class SimActivationTest extends BaseClassTest
{
	//retryAnalyzer only for failed test case
	@Test(retryAnalyzer = com.comcast.crm.generic.ListenerUtility.RetryListenerImplementation.class)
	public void activateSim()
	{
		System.out.println("execute activateSim");
		Assert.assertEquals("", "Login");
		System.out.println("step 1 to create invoice");
		System.out.println("step 2 to create invoice");
		System.out.println("step 3 to create invoice");
		System.out.println("step 4 to create invoice");
	}
}
