package com.comcast.crm.contactTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.Baseclassutility.BaseClassTest;
import com.comcast.crm.Contact.ORutility.ContactInfoPage;
import com.comcast.crm.Contact.ORutility.ContactPage;
import com.comcast.crm.Contact.ORutility.CreatingNewContactPage;
import com.comcast.crm.Contact.ORutility.HomePage;
import com.comcast.crm.Contact.ORutility.ImageLookUpPage;
import com.comcast.crm.Organization.ORutility.CreatingNewOrgPage;
import com.comcast.crm.Organization.ORutility.OrgInfoPage;
import com.comcast.crm.Organization.ORutility.OrgPage;
public class CreateContactTest extends BaseClassTest
{
	@Test
	public void createContactTest() throws Exception
	{
		String LN =   elib.getDataFromExcel("contact", 7, 3);
		HomePage hp = new HomePage(driver);
		hp.getContacts_link().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreate_contact_button().click();
		CreatingNewContactPage cpn = new CreatingNewContactPage(driver);
		cpn.setLastName(LN);
		cpn.getSave_button().click();
		ContactInfoPage c_info = new ContactInfoPage(driver);
		String act_header = c_info.getHeader_info().getText();
		boolean status = act_header.contains(LN);
		//hard assert because mandatory verification
		Assert.assertEquals(status, true);        //verification for header info
		//Thread.sleep(3000);
		String act_last_name = c_info.getContact_name().getText();
		//soft assert because non mandatory verification
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(act_last_name, LN);;
		soft.assertAll();
	}
	
	
	@Test
	public void createContactWithSupportDateTest() throws Exception
	{
		String LN =   elib.getDataFromExcel("contact", 7, 3);
		HomePage hp = new HomePage(driver);
		hp.getContacts_link().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreate_contact_button().click();
		String start_date = j.getSystemDate();
		String end_date = j.getRequiredDate(30);
		CreatingNewContactPage cpn = new CreatingNewContactPage(driver);
		cpn.setLastName(LN);
		cpn.createContactWithSupportDate(start_date, end_date);;
		cpn.getSave_button().click();
		ContactInfoPage c = new ContactInfoPage(driver);
		String act_start_date = c.getStart().getText();
		Assert.assertEquals(act_start_date, start_date);
		String act_end_date = c.getEnd().getText();
		Assert.assertEquals(act_end_date, end_date);
	}
	
	@Test
	public void createContactWithOrgTest() throws Exception
	{
		String orgName =  elib.getDataFromExcel("contact", 7, 2);    
		int r_int = j.getRandomNum();
		String contact_LN =  elib.getDataFromExcel("contact", 7, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getOrg_link().click();
				
		OrgPage o = new OrgPage(driver);
		o.getCreate_org_button().click();
		
		CreatingNewOrgPage c = new CreatingNewOrgPage(driver);
		c.setOrgName(orgName+r_int);
		c.getSave_button().click();
		
		OrgInfoPage or = new OrgInfoPage(driver);
		String act_org_page = or.getHeader_info().getText();
		boolean status = act_org_page.contains(orgName+r_int);
		Assert.assertEquals(status, true);
		
		hp.getContacts_link().click();
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreate_contact_button().click();
		
		CreatingNewContactPage cpn = new CreatingNewContactPage(driver);
		cpn.setLastName(contact_LN);
		cpn.lookup();
		
		ImageLookUpPage i = new ImageLookUpPage(driver);
		i.lookupOperate(orgName+r_int);
		driver.findElement(By.xpath("//a[. = '"+orgName+r_int+"']")).click();
		cpn.window_back();
	}
}
