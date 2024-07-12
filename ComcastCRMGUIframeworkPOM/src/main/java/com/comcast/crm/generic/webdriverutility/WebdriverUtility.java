package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility 
	// all webdriver actions
{
	public void waitForPageToLoad(WebDriver driver)             //implicit wait
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void waitForElementPresent(WebDriver driver,WebElement ele)        //explicitwait
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void switchToTabUponURL(WebDriver driver,String partialURL)
	{
		Set<String> next = driver.getWindowHandles();   //will not follow order of insertion
		Iterator<String> itr = next.iterator();
		while(itr.hasNext())
		{
			String w_ID = itr.next();  
			driver.switchTo().window(w_ID);
			
			String act_URL = driver.getCurrentUrl();
			if(act_URL.contains(partialURL))
			{
				break;
			}
		}
	}
	public void switchToTabUponTitle(WebDriver driver,String title)
	{
		Set<String> next = driver.getWindowHandles();   //will not follow order of insertion
		Iterator<String> itr = next.iterator();
		while(itr.hasNext())
		{
			String w_ID = itr.next();  
			driver.switchTo().window(w_ID);
			
			String act_URL = driver.getTitle();
			if(act_URL.contains(title))
			{
				break;
			}
		}
	}
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	public void switchToAlertandAssert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertandCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement ele,String text)
	{
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement ele,int index)
	{
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}
	public void mouseMoveOnElement(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	public void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}
}
