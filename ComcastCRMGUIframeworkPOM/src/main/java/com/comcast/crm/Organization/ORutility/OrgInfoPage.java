package com.comcast.crm.Organization.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage 
{
	@FindBy(xpath = "//span[@class = 'dvHeaderText']")
	private WebElement header_info;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phone;
	
	WebDriver driver;

	public WebElement getHeader_info() {
		return header_info;
	}
	
	public WebElement getPhone() {
		return phone;
	}

		//initialization
		public OrgInfoPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
		}
	
}
