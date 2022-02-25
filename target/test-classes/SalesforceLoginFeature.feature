
Feature: Login to Salesforce application

	Background:
		Given launch Salesforce
		When user is on the "LoginPage"
		
		
		Scenario: Login with valid username and invalid password
		And user enters "veensajja@tekarch.com" into username field
		And user enters "123" into password field
		And user clicks on login button
		Then verify wrong password error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
		
		Scenario: Login with valid username and empty password
		And user enters "veensajja@tekarch.com" into username field
		And user clears password field
		And user clicks on login button
		Then verify empty password error message "Please enter your password."
		
		Scenario: Login to Salesforce
		And user enters "veensajja@tekarch.com" into username field
		And user enters "salesforce123" into password field
		And user clicks on login button
		When user is on the "HomePage"
		Then verify page title as "Home Page ~ Salesforce - Developer Edition"
		
		Scenario: Check Remember Me
		And user enters "veensajja@tekarch.com" into username field
		And user enters "salesforce123" into password field
		And user clicks Remember me checkbox
		And user clicks on login button
		When user is on the "HomePage"
		Then verify page title as "Home Page ~ Salesforce - Developer Edition"
		And user clicks on usermenu
		And user clicks on logout
		Then verify if Remember me checkbox is checked
		And verify username "veensajja@tekarch.com"
		
		Scenario: Forgot password
		And user clicks on forgot password
		When user is on the "ForgotPasswordPage"
		Then verify forgot page title as "Forgot Your Password | Salesforce"
		And user enters "veensajja@tekarch.com" into forgot username field
		And user clicks on continue
		When user is on the "CheckMailPage"
		Then verify check mail page header as "Check Your Email"
		
		Scenario: Login with invalid username and invalid password
		And user enters "123" into username field
		And user enters "22131" into password field
		And user clicks on login button
		Then verify wrong login error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator."