package com.comcast.crm.Organization.ORutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage 
{
	@FindBy(xpath = "//input[@alt = 'Create Product...']")
	private WebElement create_prod_button;
}
