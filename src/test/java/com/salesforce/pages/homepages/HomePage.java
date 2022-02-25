package com.salesforce.pages.homepages;


import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.Base.BasePage;
import com.salesforce.utility.CommonUtilities;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className="dialogClose") WebElement dialog;
	@FindBy(id="userNavLabel") WebElement userMenu;
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logout;
	@FindBy(id="userNavMenu") WebElement userMenuOptions;
	@FindBy(xpath="//a[contains(text(),'My Profile')]") WebElement myProfile;
	@FindBy(xpath="//a[contains(text(),'My Settings')]") WebElement mySettings;
	@FindBy(xpath="//a[contains(text(),'Developer ')]") WebElement developerConsole;
	@FindBy(css="a[title='Accounts Tab']") WebElement accounts;
	@FindBy(xpath="//a[normalize-space()='Accounts']") WebElement viewAccounts;
	@FindBy(xpath="//a[normalize-space()='Opportunities']") WebElement viewOpportunities;
	@FindBy(xpath="//a[normalize-space()='Leads']") WebElement viewLeads;
	@FindBy(xpath="//input[@title='New']") WebElement newLead;
	@FindBy(xpath="//a[normalize-space()='Contacts']") WebElement contacts;
	@FindBy(xpath="//a[contains(text(),'Create New View')]") WebElement newContactView;
	@FindBy(xpath="//h1[@class='currentStatusUserName']/a") WebElement loggedUser;
	@FindBy(id="tailBreadcrumbNode") WebElement user;
	@FindBy(css="h1[class='currentStatusUserName'] a") WebElement reuser;
	@FindBy(xpath="//a[normalize-space()='Home']") WebElement home;
	@FindBy(xpath="//img[@title='All Tabs']") WebElement tabs;
	@FindBy(xpath="//span[@class='pageDescription']/a") WebElement homeDate;
	
	public String getTitleOfTheHomePage() {
		String title=getTitleOfThePage();
		return title;
	}
	
	public void clickHome()
	{
		clickElement(home);
	}
	public void closeDialogBox()
	{
		clickElement(dialog);
	}
	
	
	public void clickAllTabs()
	{
	
		clickElement(tabs);
	}
	
	public void clickHomeDate() 
	{
		try {
			dateFormatCheck(homeDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		clickElement(homeDate);
	}
	
	public String getUserMenuName()
	{
		String actUserMenuName = userMenu.getText();
		return actUserMenuName;
	}
	
	public void isUserMenuDisplayed()
	{
		Assert.assertTrue(userMenu.isDisplayed());
		report.logTestInfo("UserMenu displayed");
	}
	
	public void clickUserMenu()
	{
		
		mouseOverClick(userMenu);
	}
	
	public void verifyUserMenuOptions()
	{
		dropDownElements("//div[@id='userNavMenu']");
		
	}
	
	public void clickMyProfileMenu()
	{
		
		mouseOverClick(myProfile);
	}
	
	public void clickMySettings()
	{
		mouseOverClick(mySettings);
	}
	
	public void clickDeveloperConsole()
	{
   
		clickElement(developerConsole);
	}
	
	public void clickLogout()
	{
		clickElement(logout);
		//report.logTestInfo("Clicked logout");
	}
	
	public void clickAccounts()
	{

		clickElement(accounts);
		
	}
	
	public void clickViewAccounts()
	{

		clickElement(viewAccounts);
		
	}
	
	public void clickOpportunities()
	{
		mouseOverClick(viewOpportunities);
	}
	
	public void clickLeads()
	{
		
		clickElement(viewLeads);
		
	}
	
	public void clickNewLead()
	{
		
		clickElement(newLead);
	}
	
	public void clickContact()
	{

		clickElement(contacts);
	}
	
	public void clickNewContactView()
	{

		clickElement(newContactView);
	}
	
	public void clickLoggedUser()
	{
		String username = CommonUtilities.getApplicationProperty("usermenuname");
		String lastname = CommonUtilities.getApplicationProperty("lastnamechange");
		waitUntilVisible(loggedUser);
		report.logTestInfo(loggedUser.getText());
		textCheck(loggedUser,username+" "+lastname);
		report.logTestInfo("Logged username is correct");
		clickElement(loggedUser);
			
	}
	
	public String checkInitialLoggedUser()
	{
		String username = CommonUtilities.getApplicationProperty("usermenuname");
		String lastname = CommonUtilities.getApplicationProperty("lastnamechange");
		report.logTestInfo(user.getText());
		pageLoad(user,username+" "+lastname);
		return(user.getText());
	}
	
	public String checkReLoggedUser()
	{
		String username = CommonUtilities.getApplicationProperty("usermenuname");
		String lastname = CommonUtilities.getApplicationProperty("lastnamechange");
		report.logTestInfo(reuser.getText());
		pageLoad(reuser,username+" "+lastname);
		return(reuser.getText());
	}
	
}
