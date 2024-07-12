package com.comcast.crm.Organization.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreatingNewOrgPage extends JavaUtility
{
	@FindBy(xpath = "//input[@name = 'accountname']")
	private WebElement org_textfield;

	@FindBy(xpath = "(//input[@title= 'Save [Alt+S]'])")
	private WebElement save_button;
	
	@FindBy(name = "industry")
	private WebElement industry_dd;
	
	@FindBy(name = "accounttype")
	private WebElement type_dd;
	
	@FindBy(id = "phone")
	private WebElement phone_no;

	WebDriver driver;
	public WebElement getOrg_textfield() {
		return org_textfield;
	}

	public WebElement getSave_button() {
		return save_button;
	}
	
	public WebElement getIndustry_dd() {
		return industry_dd;
	}

	public WebElement getType_dd() {
		return type_dd;
	}

	public WebElement getPh_no() {
		return phone_no;
	}

	//initialization
	public CreatingNewOrgPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
	}

	public void phone_number(String ph_no)
	{
		phone_no.sendKeys(ph_no);
	}
	public void dropdown(String industry, String type)
	{
		Select sel = new Select(industry_dd);
		sel.selectByVisibleText(industry);
		Select sel1 = new Select(type_dd);
		sel1.selectByVisibleText(type);
	}
	public void setOrgName(String orgName)
	{
		org_textfield.sendKeys(orgName);
	}
}
