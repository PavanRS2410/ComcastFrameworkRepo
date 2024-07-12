package practiceTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.Baseclassutility.BaseClassTest;

public class InvoiceTest extends BaseClassTest
{
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		String act_title = driver.getTitle();
		Assert.assertEquals(act_title, "Login");
		System.out.println("step 1 to create invoice");
		System.out.println("step 2 to create invoice");
		System.out.println("step 3 to create invoice");
		System.out.println("step 4 to create invoice");
	}
	@Test
	public void createInvoiceWithContactTest()
	{
		System.out.println("execute createInvoiceWithContactTest");
		System.out.println("step 1 to create invoice with contact");
		System.out.println("step 2 to create invoice with contact");
		System.out.println("step 3 to create invoice with contact");
		System.out.println("step 4 to create invoice with contact");
	}
}
