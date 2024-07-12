package com.comcast.crm.Contact.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(linkText =  "Contacts")
	private WebElement contacts_link;
	
	@FindBy(linkText =  "Organizations")
	private WebElement org_link;

	@FindBy(xpath = "//img[@src = 'themes/softed/images/user.PNG']")
	private WebElement img;
	
	@FindBy(xpath = "//a[. = 'Sign Out']")
	private WebElement sign_out;

	private WebDriver driver;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
	}
	
	
	public WebElement getContacts_link() 
	{
			return contacts_link;
	}
	
	public WebElement getOrg_link() 
	{
			return org_link;
	}

	public WebElement getImg() 
	{
		return img;
	}

	public WebElement getSign_out() 
	{
		return sign_out;
	}
	
	public void logout() throws Exception
	{
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(img).perform();
		sign_out.click();
	}
	
}
