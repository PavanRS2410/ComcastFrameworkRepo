package com.comcast.crm.orgTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.Baseclassutility.BaseClassTest;
import com.comcast.crm.Organization.ORutility.CreatingNewOrgPage;
import com.comcast.crm.Organization.ORutility.HomePage;
import com.comcast.crm.Organization.ORutility.OrgInfoPage;
import com.comcast.crm.Organization.ORutility.OrgPage;
import com.comcast.crm.generic.webdriverutility.ClassObjectUtility;

public class CreateOrganization_Listener_Test extends BaseClassTest
{
	@Test(groups =  "smoketest")
	public void createOrgTest() throws Exception
	{
		int r_int = j.getRandomNum();
		
		ClassObjectUtility.getTest().log(Status.INFO, " read data from excel");
		String orgName = elib.getDataFromExcel("org", 4, 2);
		
		ClassObjectUtility.getTest().log(Status.INFO, " navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrg_link().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, " navigate to create new org page");
		OrgPage o = new OrgPage(driver);
		o.getCreate_org_button().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, " create new org");
		CreatingNewOrgPage c = new CreatingNewOrgPage(driver);
		c.setOrgName(orgName+r_int);
		c.getSave_button().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, orgName+r_int+" new org");
		OrgInfoPage or = new OrgInfoPage(driver);
		String act_org_page = or.getHeader_info().getText();
		boolean status = act_org_page.contains(orgName);
		Assert.assertEquals(status, true);
	}
	
	
	@Test(groups =  "regressiontest")
	public void createOrganizationwithindustriesTest() throws Exception
	{
		int r_int = j.getRandomNum();
		
		ClassObjectUtility.getTest().log(Status.INFO, " read data from excel");
		String orgName = elib.getDataFromExcel("org", 4, 2);
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);
		
		ClassObjectUtility.getTest().log(Status.INFO, " navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrg_link().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, " navigate to create new org page");
		OrgPage o = new OrgPage(driver);
		o.getCreate_org_button().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, " create new org");
		CreatingNewOrgPage c = new CreatingNewOrgPage(driver);
		c.setOrgName(orgName+r_int);
		c.dropdown(industry, type);
		c.getSave_button().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, orgName+r_int+" new org");
		OrgInfoPage or = new OrgInfoPage(driver);
		String act_org_page = or.getHeader_info().getText();
		boolean status = act_org_page.contains(orgName+r_int);
		Assert.assertEquals(status, true);
	}
	
	
	@Test(groups =  "regressiontest")
	public void createOrgwithmobilenumberTest() throws Exception
	{
		int r_int = j.getRandomNum();
		ClassObjectUtility.getTest().log(Status.INFO, " read data from excel");
		String orgName = elib.getDataFromExcel("org", 7, 2);    
		String ph_no = elib.getDataFromExcel("org", 7, 3);
		
		ClassObjectUtility.getTest().log(Status.INFO, " navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrg_link().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, " navigate to create new org page");
		OrgPage o = new OrgPage(driver);
		o.getCreate_org_button().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, " create new org");
		CreatingNewOrgPage c = new CreatingNewOrgPage(driver);
		c.setOrgName(orgName+r_int);
		c.phone_number(ph_no);
		c.getSave_button().click();
		
		ClassObjectUtility.getTest().log(Status.INFO, ph_no+" phone number");
		OrgInfoPage or = new OrgInfoPage(driver);
		String act_ph_no = or.getPhone().getText();
		Assert.assertEquals(act_ph_no, ph_no);
	}
}
