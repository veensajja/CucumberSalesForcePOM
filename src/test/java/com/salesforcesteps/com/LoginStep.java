package com.salesforcesteps.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.salesforce.pages.homepages.HomePage;
import com.salesforce.pages.loginpages.CheckMailPage;
import com.salesforce.pages.loginpages.ForgotPasswordPage;
import com.salesforce.pages.loginpages.LoginPage;
import com.salesforce.utility.CommonUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep {

	WebDriver driver;
	LoginPage login;
	ForgotPasswordPage passForgot;
	HomePage home;
	CheckMailPage mail;
	//String username = CommonUtilities.getApplicationProperty("username");
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Given("launch Salesforce")
	public void getUrl() {
		
		driver.get("https://login.salesforce.com/");
	}
	
	@When("user is on the {string}")
	public void getPage(String page)
	{
		if(page.equalsIgnoreCase("loginpage"))
			login=new LoginPage(driver);
		if(page.equalsIgnoreCase("forgotpasswordpage"))
			passForgot=new ForgotPasswordPage(driver);
		if(page.equalsIgnoreCase("homepage"))
			home=new HomePage(driver);
		if(page.equalsIgnoreCase("checkmailpage"))
			mail=new CheckMailPage(driver);
	}

	@And("user enters {string} into username field")
	public void enterUserName(String username) {
		login.enterIntoUsername(username);
		System.out.println("user name entered");
	}

	@And("user enters {string} into password field")
	public void enterPassword(String password) {
		login.enterIntoPassword(password);
		System.out.println("password entered");
	}

	@And("user clicks on login button")
	public void clickLogin() {
		login.clickLoginButton();
		System.out.println("login button clicked"); 
	}

	@Then("verify wrong password error message {string}")
	public void verifyWrongPassword(String expectedString) {
		login.getWrongUsernamePasswordErrMsg();
		System.out.println("verified wrong password error message"); 
	}
	
	@And("user clears password field")
	public void clearPassword()
	{
		login.clearPassword();
	}
	
	@Then("verify empty password error message {string}")
	public void verifyEmptyPassword(String expectedString)
	{
		login.getPasswordErrMsg();
		System.out.println("verified empty password error message");
	}
	
	@Then("verify page title as {string}")
	public void verifyHomePageTitle(String title)
	{
		
		String pageTitle = home.getTitleOfTheHomePage();
		Assert.assertEquals(pageTitle,title);
		System.out.println("verified homepage title");
	}
	
	@And("user clicks Remember me checkbox")
	public void selectRememberMe()
	{
		login.clickRememberMe();
		System.out.println("Selected remember me");
	}
	
	@And("user clicks on usermenu")
	public void clickUserMenu()
	{
		home.clickUserMenu();
		System.out.println("clicked user menu");
	}
	
	@And("user clicks on logout")
	public void clickLogout()
	{
		home.clickLogout();
		System.out.println("clicked logout");
	}
	
	@Then("verify if Remember me checkbox is checked")
	public void verifyCheckRememberMe()
	{
		login.isRememberMeSelected();
		System.out.println("verified remember me checkbox");
	}
	
	@And("verify username {string}")
	public void verifyUsername(String username)
	{
		String actualusername = login.userNameCheck();
		Assert.assertEquals(actualusername, username);
		System.out.println("verified remember me username");
	}
	
	@And("user clicks on forgot password")
	public void clickForgotPassword()
	{
		login.clickForgotPassword();
		System.out.println("clicked forgot password");
	}
	
	@Then("verify forgot page title as {string}")
	public void verifyForgotPageTitle(String title)
	{
		String forgotpasswordTitle = passForgot.getTitleOfTheHomePage();
		Assert.assertEquals(forgotpasswordTitle,title);
		System.out.println("Verified forgot page title");
	}
	
	@And("user enters {string} into forgot username field")
	public void enterForgotUsername(String username)
	{
		passForgot.enterIntoForgotUsername(username);
		System.out.println("Enter username on forgot page");
	}
	
	@And("user clicks on continue")
	public void clickContinue()
	{
		passForgot.clickContinue();
		System.out.println("Clicked continue");
	}
	
	@Then("verify check mail page header as {string}")
	public void verifyMailPageTitle(String title)
	{
		String checkmailheader = mail.mailHeaderCheck();
		Assert.assertEquals(checkmailheader,title);
		System.out.println("Verified checkmail header");
	}
	
	@Then("verify wrong login error message {string}")
	public void verifyLoginErrorMessage(String string)
	{
		login.getWrongUsernamePasswordErrMsg();
		System.out.println("Verified wrong username and password message");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

	
}
