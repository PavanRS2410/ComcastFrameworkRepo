package com.comcast.crm.Organization.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage 
{
	@FindBy(xpath = "//img[@title= 'Create Organization...']")
	private WebElement create_org_button;
	WebDriver driver;

	@FindBy(name = "search_text")
	private WebElement search_textfield;
	
	@FindBy(name = "search_field")
	private WebElement org_dd;
	
	@FindBy(name = "submit")
	private WebElement search_now_button;
	
	public WebElement getSearch_textfield() {
		return search_textfield;
	}

	public void setSearch_textfield(WebElement search_textfield) {
		this.search_textfield = search_textfield;
	}

	public WebElement getOrg_dd() {
		return org_dd;
	}

	public void setOrg_dd(WebElement org_dd) {
		this.org_dd = org_dd;
	}

	public WebElement getSearch_now_button() {
		return search_now_button;
	}

	public void setSearch_now_button(WebElement search_now_button) {
		this.search_now_button = search_now_button;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreate_org_button() {
		return create_org_button;
	}
	
	//initialization
			public OrgPage(WebDriver driver)
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
			}
}
