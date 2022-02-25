package com.salesforce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="Login") WebElement btnLogin;
	@FindBy(id="error") WebElement passError;
	@FindBy(id="forgot_password_link") WebElement forgotPass;
	@FindBy(id="rememberUn") WebElement remember;
	@FindBy(id="idcard-identity") WebElement rememberusername;
	
	
	public void enterIntoUsername(String usrName) {
		enterText(username, usrName);
		
	}
	
	public void enterIntoPassword(String passwrd) {
		enterText(password, passwrd);
	}
	public void clickLoginButton() {
		clickElement(btnLogin);
	}
	public void clearPassword() {
		clearElement(password);
	}
	
	public void getPasswordErrMsg()
	{
		assertText(passError,"Please enter your password.");
		//report.logTestInfo("Password error message dispalyed");
	}
	public void getWrongUsernamePasswordErrMsg()

	{
		assertText(passError,"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		//report.logTestInfo("Wrong username and password error message dispalyed");
	}

	public void clickForgotPassword()
	{
		clickElement(forgotPass);
	}
	
	public void clickRememberMe()
	{
		clickElement(remember);
	}
	
	public void isRememberMeSelected()
	{
		Assert.assertTrue(remember.isSelected(),"Remember Me box is selected");
		//report.logTestInfo("Remember Me box is selected");
	}
	
	public String userNameCheck()
	{
	
		String usernamecheck = rememberusername.getText();
		return usernamecheck;
	}
	
	public void handleAlert() {
		AcceptAlert();
	}

	
	
}
