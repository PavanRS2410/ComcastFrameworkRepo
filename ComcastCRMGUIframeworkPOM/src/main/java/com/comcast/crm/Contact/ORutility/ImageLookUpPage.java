package com.comcast.crm.Contact.ORutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class ImageLookUpPage extends JavaUtility
{
	@FindBy(id = "search_txt")
	private WebElement search_textfield;
	
	@FindBy(name = "search")
	private WebElement search_button;
	
	public WebElement getSearch_textfield() {
		return search_textfield;
	}
	public WebElement getSearch_button() {
		return search_button;
	}
	private WebDriver driver;

	public void lookupOperate(String orgName)
	{
		search_textfield.sendKeys(orgName);
		search_button.click();
		 	
	}
	//initialization
	public ImageLookUpPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
	}
	
}
