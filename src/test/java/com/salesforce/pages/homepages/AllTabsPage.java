package com.salesforce.pages.homepages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class AllTabsPage extends BasePage{

	public AllTabsPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h1[contains(text(),'All Tabs')]") WebElement allTabs;
	@FindBy(xpath="//input[@title='Customize My Tabs']") WebElement customizeTab;
	@FindBy(xpath="//h1[contains(text(),'Customize My Tabs')]") WebElement customizeTabText;
	@FindBy(xpath="//div[@id='tabContainer']//nav/ul/li/a") List<WebElement> tabs;
	
	public void checkAllTabsPage()
	{

		pageLoad(allTabs,"All Tabs");
	}
	
	public void clickCustomizeTab()
	{
		
		clickElement(customizeTab);
	}
	
	public void checkCustomizeTab()
	{
		pageLoad(customizeTabText,"Customize My Tabs");
	}
	
	public void checkAllTabsOptions()
	{
	verifyRemovedOption(tabs,"Forecast");
	}
	
}
