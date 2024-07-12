package com.comcast.crm.Contact.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	@FindBy(xpath = "//img[@alt = 'Create Contact...']")
	private WebElement create_contact_button;
	WebDriver driver;

	public WebElement getCreate_contact_button() 
	{
		return create_contact_button;
	}
	
			//initialization
			public ContactPage(WebDriver driver)
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
			}
}
