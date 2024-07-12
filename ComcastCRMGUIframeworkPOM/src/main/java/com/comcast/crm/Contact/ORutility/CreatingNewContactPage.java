package com.comcast.crm.Contact.ORutility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreatingNewContactPage extends JavaUtility
{
	@FindBy(name = "lastname")
	private WebElement LN_textfield;

	@FindBy(name = "support_start_date")
	private WebElement start_date;
	
	@FindBy(name = "support_end_date")
	private WebElement end_date;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_button;
	
	@FindBy(xpath = "//input[@name = 'account_name']/following-sibling::img")
	private WebElement image_lookup;

	WebDriver driver;
	

	public WebElement getStart_date() {
		return start_date;
	}

	public WebElement getEnd_date() {
		return end_date;
	}

	public WebElement getSave_button() {
		return save_button;
	}
	
	//initialization
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
	}

	public void setLastName(String LN)
	{
		LN_textfield.sendKeys(LN);
	}
	public void createContactWithSupportDate(String start,String end)
	{
		start_date.clear();
		start_date.sendKeys(start);
		end_date.clear();
		end_date.sendKeys(end);
	}
	public void lookup() throws InterruptedException
	{
		image_lookup.click();
		//Step 9: switch to child window because of integration between modules and perform actions
		Set<String> next = driver.getWindowHandles();   //will not follow order of insertion
		for(String string:next)
		{
			
			driver.switchTo().window(string);
			
			String act_title = driver.getTitle();
			if(act_title.equals(" Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM"))
			{
				break;
			}
		}	
		
	}
	public void window_back() throws InterruptedException
	{
		//Step 10: switch to parent window back and perform actions
		Set<String> next1 = driver.getWindowHandles();   //will not follow order of insertion
		Iterator<String> itr1 = next1.iterator();

		while(itr1.hasNext())
		{
			String w_ID1 = itr1.next();
			driver.switchTo().window(w_ID1);
			
			String act_title1 = driver.getTitle();
			if(act_title1.equals(" Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM"))
			{
				break;
			}
		}
		Thread.sleep(5000);
		save_button.click();			
	}
	
}
