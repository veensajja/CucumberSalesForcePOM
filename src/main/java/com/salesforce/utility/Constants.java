package com.salesforce.utility;

public class Constants {
	
	//USER_DIR - will get -  /Users/praveenastandard/eclipse-workspace/SalesforcePOMAutomation
	public static final  String USER_DIR = System.getProperty("user.dir");
	public static final  String APPLICATION_PROPERTIES_PATH =USER_DIR+"/src/main/resources/SalesForceData.properties";
	//public static final  String APPLICATION_PROPERTIES_PATH ="/Users/praveenastandard/eclipse-workspace/SalesforceAutomation/src/main/resources/SalesForceData.properties";
	public static final String SCREENSHOT_PATH=USER_DIR+"/screenshots/";
	public static final String GENERATE_REPORT_PATH = USER_DIR+"/extentreports/report.html";
	

}
