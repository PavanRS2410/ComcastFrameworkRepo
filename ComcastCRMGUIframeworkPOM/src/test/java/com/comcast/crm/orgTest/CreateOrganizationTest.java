package com.comcast.crm.orgTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.Baseclassutility.BaseClassTest;
import com.comcast.crm.Organization.ORutility.CreatingNewOrgPage;
import com.comcast.crm.Organization.ORutility.HomePage;
import com.comcast.crm.Organization.ORutility.OrgInfoPage;
import com.comcast.crm.Organization.ORutility.OrgPage;

public class CreateOrganizationTest extends BaseClassTest
{
	@Test(groups =  "smoketest")
	public void createOrgTest() throws Exception
	{
		int r_int = j.getRandomNum();
		String orgName = elib.getDataFromExcel("org", 4, 2);
		HomePage hp = new HomePage(driver);
		hp.getOrg_link().click();
		
		OrgPage o = new OrgPage(driver);
		o.getCreate_org_button().click();
		
		CreatingNewOrgPage c = new CreatingNewOrgPage(driver);
		c.setOrgName(orgName+r_int);
		c.getSave_button().click();
		
		OrgInfoPage or = new OrgInfoPage(driver);
		
		String act_org_page = or.getHeader_info().getText();
		boolean status = act_org_page.contains(orgName);
		Assert.assertEquals(status, true);
	}
	
	
	@Test(groups =  "regressiontest")
	public void createOrganizationwithindustriesTest() throws Exception
	{
		int r_int = j.getRandomNum();
		String orgName = elib.getDataFromExcel("org", 4, 2);
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);
		
		HomePage hp = new HomePage(driver);
		hp.getOrg_link().click();
		
		OrgPage o = new OrgPage(driver);
		o.getCreate_org_button().click();
		
		CreatingNewOrgPage c = new CreatingNewOrgPage(driver);
		c.setOrgName(orgName+r_int);
		c.dropdown(industry, type);
		c.getSave_button().click();
		
		OrgInfoPage or = new OrgInfoPage(driver);
		
		String act_org_page = or.getHeader_info().getText();
		boolean status = act_org_page.contains(orgName);
		Assert.assertEquals(status, true);
	}
	
	
	@Test(groups =  "regressiontest")
	public void createOrgwithmobilenumberTest() throws Exception
	{
		int r_int = j.getRandomNum();
		String orgName = elib.getDataFromExcel("org", 7, 2);    
		String ph_no = elib.getDataFromExcel("org", 7, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getOrg_link().click();
		
		OrgPage o = new OrgPage(driver);
		o.getCreate_org_button().click();
		
		CreatingNewOrgPage c = new CreatingNewOrgPage(driver);
		c.setOrgName(orgName+r_int);
		c.phone_number(ph_no);
		c.getSave_button().click();
		
		OrgInfoPage or = new OrgInfoPage(driver);
		String act_ph_no = or.getPhone().getText();
		Assert.assertEquals(act_ph_no, ph_no);
	}
}
