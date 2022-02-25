package com.salesforce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class CheckMailPage extends BasePage {

	public CheckMailPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="header") WebElement header;
	
	public String getTitleOfTheHomePage() {
		System.out.println("Into checkPage");
		String title=getTitleOfThePage();
		return title;
	}
	
	public String mailHeaderCheck()
	{
	
		String mailHeaderCheck = header.getText();
		return mailHeaderCheck;
	}
}
