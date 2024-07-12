package com.comcast.crm.Baseclassutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.Contact.ORutility.HomePage;
import com.comcast.crm.Contact.ORutility.LoginPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.ClassObjectUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class BaseClassTest 
{
	public FileUtility flib = new FileUtility();
	
	public ExcelUtility elib = new ExcelUtility();
	
	public JavaUtility j = new JavaUtility();
	
	public WebdriverUtility w = new WebdriverUtility();
	
	public WebDriver driver = null;   //initially don't know which browser to be used
	
	public static WebDriver temp_driver = null;
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("-----connect to db, report config-----");
	}
	@BeforeClass
	public void BC() throws Exception
	{
		System.out.println("launch the broswer");
		String browser = flib.getDataFromPropFile("Browser");
		
		
		//write RTP program so as to when the user enters respective browser driver should launch it
		
		
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
		temp_driver = driver;        //after launching the browser re-initialize the temp_driver with browser session id
		//driver.manage().window().maximize();
		ClassObjectUtility.setDriver(driver);
		
	}
	@BeforeMethod
	public void BM() throws Exception
	{
		System.out.println("login to the app");
		//to login to the app and to locate th elements go OR, already elements are stored
		String URL = flib.getDataFromPropFile("URL");
		String UN = flib.getDataFromPropFile("UN");
		String PWD = flib.getDataFromPropFile("PWD");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, UN, PWD);

	}
	@AfterMethod
	public void AM() throws Exception
	{
		System.out.println("logout from the app");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	@AfterClass
	public void AC()
	{
		System.out.println("close the browser");
		driver.quit();
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("----close DB, report backup----");
	}
}
