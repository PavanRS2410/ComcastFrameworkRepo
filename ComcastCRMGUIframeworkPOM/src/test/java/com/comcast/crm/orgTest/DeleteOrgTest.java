package com.comcast.crm.orgTest;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.Organization.ORutility.CreatingNewOrgPage;
import com.comcast.crm.Organization.ORutility.HomePage;
import com.comcast.crm.Organization.ORutility.LoginPage;
import com.comcast.crm.Organization.ORutility.OrgInfoPage;
import com.comcast.crm.Organization.ORutility.OrgPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class DeleteOrgTest 
{
	public static void main(String[] args) throws Exception 
	{
		//vtiger create organization scenario with getting common data form prop file and test script data 
		//from excel sheet
		
		//read common data from prop file
		
		FileUtility flib = new FileUtility();
		
		ExcelUtility elib = new ExcelUtility();
		
		JavaUtility j = new JavaUtility();
		
		WebdriverUtility w = new WebdriverUtility();
		
		String browser = flib.getDataFromPropFile("Browser");
		String URL = flib.getDataFromPropFile("URL");
		String UN = flib.getDataFromPropFile("UN");
		String PWD = flib.getDataFromPropFile("PWD");
		
		
		//generate random number 
		
		
		int r_int = j.getRandomNum();
		
		//read testscript data from excel file
		
		String orgName = elib.getDataFromExcel("org", 10, 2);
		
		//write RTP program so as to when the user enters respective browser driver should launch it
		
		WebDriver driver = null;   //initially don't know which browser to be used
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else 
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		
		//Step 1: login to application
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, UN, PWD);
		
		HomePage hp = new HomePage(driver);
		hp.getOrg_link().click();
		
		OrgPage o = new OrgPage(driver);
		o.getCreate_org_button().click();
		
		CreatingNewOrgPage c = new CreatingNewOrgPage(driver);
		c.setOrgName(orgName+r_int);
		c.getSave_button().click();
		
		OrgInfoPage or = new OrgInfoPage(driver);
		String act_org_page = or.getHeader_info().getText();
		if(act_org_page.contains(orgName+r_int))
		{
			System.out.println(orgName+r_int+" is verified--->pass");
		}
		else
		{
			System.out.println(orgName+r_int+" is not verified--->fail");
		}
		
		//go back to organizations page
		hp.getOrg_link().click();
		
		//search for organization
		o.getSearch_textfield().sendKeys(orgName+r_int);
		w.select(o.getOrg_dd(), "Organization Name");
		o.getSearch_now_button().click();
		
		
		// in dynamic web table select that org name and delete
		//cannot be handled by pom
		//so use driver.findElement only
		driver.findElement(By.xpath("(//a[. = '"+orgName+r_int+"'])[2]/../../td[8]/a[. = 'del']")).click();
		
		
		
		
		
		
		
		
		
		
		
		hp.logout();
		driver.quit();
	}
}
