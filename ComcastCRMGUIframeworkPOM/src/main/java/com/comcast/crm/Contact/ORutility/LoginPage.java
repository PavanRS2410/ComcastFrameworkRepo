package com.comcast.crm.Contact.ORutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

public class LoginPage extends WebdriverUtility
{
	//steps
	//separate pom class for every page, identify objects using @findby, initialize them using pagefactory, provide encapn
	//ultilize them/provide actions
	
	//declaration
	@FindBy(name = "user_name")
	private WebElement UN_textfield;
	
	@FindBy(name = "user_password")
	private WebElement PWD_textfield;
	
	@FindBy(id = "submitButton")
	private WebElement login_button;
	
	//initialization
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);         //this keyword in each stage refers to this current object only
	}
	
	//utilization
	public WebElement getUN_textfield() {
		return UN_textfield;
	}

	public WebElement getPWD_textfield() {
		return PWD_textfield;
	}

	public WebElement getLogin_button() {
		return login_button;
	}

	public void loginToApp(String URL, String UN, String PWD)
	{
		waitForPageToLoad(driver);           //get this from webdriver utility 
		driver.get(URL);
		driver.manage().window().maximize();
		UN_textfield.sendKeys(UN);
		PWD_textfield.sendKeys(PWD);
		login_button.click();
	}
	
}
