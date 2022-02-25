package com.salesforce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class ForgotPasswordPage extends BasePage{

	public ForgotPasswordPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="continue") WebElement continuePass;
	@FindBy(id="un") WebElement forgotusername;
	
	public String getTitleOfTheHomePage() {
		String title=getTitleOfThePage();
		return title;
	}
	public void enterIntoForgotUsername(String usrName) {
		enterText(forgotusername, usrName);
		
	}
	
	public void clickContinue()
	{
		clickElement(continuePass);
	}
	
}
