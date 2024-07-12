package com.comcast.crm.Contact.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	@FindBy(xpath = "//span[@class = 'dvHeaderText']")
	private WebElement header_info;
	
	@FindBy(xpath = "//span[@id= 'dtlview_Last Name']")
	private WebElement contact_name;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement start;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement end;
	
	WebDriver driver;

	public WebElement getHeader_info() {
		return header_info;
	}
	
	public WebElement getContact_name() {
		return contact_name;
	}

		public WebElement getStart() {
		return start;
	}

	public WebElement getEnd() {
		return end;
	}

		//initialization
		public ContactInfoPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
		}
	
}
