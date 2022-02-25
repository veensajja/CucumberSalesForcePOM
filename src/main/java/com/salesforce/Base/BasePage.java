package com.salesforce.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.salesforce.utility.CommonUtilities;
import com.salesforce.utility.GenerateReports;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	protected static GenerateReports report=GenerateReports.getInstance();
	
	

	public BasePage(WebDriver driver1) {
		driver=driver1;
		PageFactory.initElements(driver1, this);
	}

public static void setUp() throws IOException
{
	String url = CommonUtilities.getApplicationProperty("url");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get(url);
	driver.manage().window().maximize();
	
	
}

public static void dropDownValidation(String[] exp,WebElement dropdown)
{
	Select select = new Select(dropdown);  

    List<WebElement> options = select.getOptions();  
    boolean check=false;
    for(WebElement we:options)  
    {  
     for (int i=0; i<exp.length; i++){
         if (we.getText().equals(exp[i])){
        	 check =true;
        	 report.logTestInfo(we.getText()+" exists");
         } 
        
       }
     if(check==false)
    	 System.out.println(we.getText()+" Option does not exist");
     } 
    
}

public static void multipleWindows(WebElement element)
{
	String currentwindow=driver.getWindowHandle();
	clickElement(element);
	Set<String> windows= driver.getWindowHandles();
	System.out.println("num of windows currently opned="+windows.size());
	for(String windowHandle:windows) {
		if(!windowHandle.equals(currentwindow)) {
			driver.switchTo().window(windowHandle);
			break;
		}	
	}
}

public static void elementTextCheck(String string, WebElement element)
{
	String expmsg = string;
	String actualmsg = element.getAttribute("value");
	Assert.assertEquals(actualmsg, expmsg);
	//softassert.assertEquals(actualmsg,expmsg,"text saved");
	//softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
//	softassert.assertTrue(string1.contains(string2),"Assert passed");
}

public static void clearElement(WebElement element) {
	if(element.isDisplayed()) {
		element.clear();
		//report.logTestInfo("Cleared");
	}
	else {
		//report.logTestInfo("Not cleared");
	}
}

public static void waitUntilVisible(WebElement element) {
	wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(element));
}
public static int getcurrenttime() {
	long currentDateMS = new Date().getTime();
	int seconds = (int) ((currentDateMS / 1000) % 3600);
	return seconds;
}
//Not correct and not being used
public static void waitUntilVisibleLoc(WebElement element, String path) 
{
	wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(element));
	WebElement forgot = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
}



public static void waitUntilAlertIsPresent() {
	wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.alertIsPresent());
}

public static void AcceptAlert() {
	waitUntilAlertIsPresent();
	Alert alert=driver.switchTo().alert();
	System.out.println("alert text="+alert.getText());
	alert.accept();
	
}
public static void dissmisAlert() {
	waitUntilAlertIsPresent();
	Alert alert=driver.switchTo().alert();
	alert.dismiss();
	
}


public static void enterText(WebElement element, String textvalue)
{
	
	if(element.isDisplayed()) {
		clearElement(element);
		element.sendKeys(textvalue);
		//report.logTestInfo(textvalue+" entered");
	}
	else {
		//report.logTestInfo(textvalue+" not entered");
	}
		
}
public static void frameElementSwitch(WebElement element)
{
	driver.switchTo().frame(element);
	report.logTestInfo("Switched to frame");
}

public static void frameIndexSwitch(int index)
{
	driver.switchTo().frame(index); 
}
public static void textCheck(WebElement element,String string)
{
	Assert.assertTrue(element.getText().contains(string));
		report.logTestInfo(string+" text saved");
	
}
public static void errorCheck(WebElement element,String string)
{
	waitUntilVisible(element);
	if(element.getText().contains(string))
		report.logTestInfo(string+" error message displayed");
	else
		report.logTestInfo(string+" error message not displayed");
}
public static void textCheckValue(WebElement element,String string)
{
	if(element.getAttribute("value").contains(string))
		report.logTestInfo(string+" text saved");
		else
		report.logTestInfo(string+" text not saved");
}
public static void textAssert(WebElement element,String string)
{
	waitUntilVisible(element);
	String stringact =element.getText();
	System.out.println("Error msg "+stringact);
	//softassert.assertTrue(stringact.contains(string),"Text assert Success");
	//softassert.assertAll();
}

public static void pageLoad(WebElement element,String string)
{
	
	Assert.assertTrue(element.getText().contains(string));
	report.logTestInfo(string+" Page is loaded");
	
}

public static void assertText(WebElement element,String string)
{
	waitUntilVisible(element);
	String expmsg = string;
	String actualmsg = element.getText();
	Assert.assertEquals(actualmsg,expmsg);
	//report.logTestInfo(string+" error message displayed");
	
}
public static void dialogBoxCheck(WebElement element,String string)
{
	waitUntilVisible(element);
	if(element.getText().contains(string))
		report.logTestInfo(string+" Window is open");
	else
		report.logTestInfo(string+" Window is not open");
}
public static void enableCheck(WebElement element)
{
	
	Assert.assertEquals(true,element.isEnabled());
		report.logTestInfo(element.getText()+" is dispalyed");
	
}

public static void uploadCheck(WebElement element)
{
	Assert.assertEquals(true,element.isDisplayed());
	report.logTestInfo("Element uploaded");

}
public static void checkImgAttribute(String actual,String expected)
{
	if(actual.contains(expected))
		report.logTestInfo("Img uploaded");
		else
			report.logTestInfo("Img not uploaded");

}

public static void clickElement(WebElement element) {
	if(element.isDisplayed()) {
		element.click();
		//report.logTestInfo("Clicked");
	}
	else {
		//report.logTestInfo("Not Clicked");
	}
}


public static void selectElement(WebElement element,String string) {
	if(element.isDisplayed()) {
		Select select = new Select(element);
		select.selectByVisibleText(string);
		report.logTestInfo("pass: element selected");
	}
	else {
		report.logTestInfo("fail: element not selected");
	}
}
public static void selectElementClick(WebElement element1, WebElement element2, String string)
{
	Select select = new Select(element1);
	List <WebElement> selectedtab = select.getOptions();
	for(WebElement seloptions:selectedtab)
	{
		if(seloptions.getText().contains(string))
		{
			clickElement(seloptions);
			element2.click();
			System.out.println(string+" clicked");
			break;
		}
	}
	System.out.println(string+" not clicked");
}

public static void selectElementCheck(WebElement element1,String string)
{
Select selectavail = new Select(element1);
List <WebElement> availabletab = selectavail.getOptions();
for(WebElement availoptions:availabletab)
{
	if(availoptions.getText().contains(string))
	{
		textCheck(availoptions,string);
		break;
	}
}

}

public static void selectTextData(WebElement element, String text)
{
	Select selectCity = new Select(element);
	selectCity.selectByVisibleText(text);
}

public static void selectByIndexData(WebElement element, int index)
{
	Select selectCity = new Select(element);
	selectCity.selectByIndex(index);
}

public static void verifyRemovedOption(List <WebElement> tabs,  String string)
{
	
	for(WebElement opelement:tabs)
	{
		if(opelement.getText().contains(string))
		{
			report.logTestInfo(string +" option not removed");
			break;
		}
		
	}
	report.logTestInfo(string+" option removed");
}
public static void dateFormatCheck(WebElement element) throws ParseException
{
	String datestring = element.getText();
	SimpleDateFormat sdf = new SimpleDateFormat("EEEE MMMM dd, yyyy");
    Date date = sdf.parse(datestring);
    System.out.println(sdf.format(date));
   if (!datestring.equals(sdf.format(date))) 
      System.out.println("The date is not in format");
   else
   	System.out.println("The date is in format");  
}
public static String getTitleOfThePage() {
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return driver.getTitle();
}
public static void getTitle(String string) throws InterruptedException
{
	String homeTitle=driver.getTitle();
	Thread.sleep(1000);
	if(homeTitle.contains(string))
		System.out.println(string+" Home page loaded");
	else
		System.out.println(string+" Home page not loaded");
	
}
public static void elementFocusCheck(WebElement element, String string)
{
	if(element.equals(driver.switchTo().activeElement()))
		System.out.println("Focus is on "+string);
	else
		System.out.println("Focus is not on "+string);	
}

public static void jsExecutor(WebElement element)
{
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
}
public static void isCheckboxChecked(WebElement element, String string)
{
	clickElement(element);
	if(element.isSelected())
		report.logTestInfo(string+ " Checkbox is checked");
	else
		report.logTestInfo(string+ " Checkbox is not checked");
}
public static void mouseOver(WebElement element) {
	waitUntilVisible(element);
	Actions action=new Actions(driver);
	action.moveToElement(element).build().perform();
}

public static void mouseOverClick(WebElement element) {
	waitUntilVisible(element);
	Actions action=new Actions(driver);
	action.click(element).perform();
	//report.logTestInfo("Clicked option");	
}

public static void dropDownElements(String path) {
	List <WebElement> umenu = driver.findElements(By.xpath(path));
	for(WebElement e: umenu)
	{
		report.logTestInfo("Drop down menu options are \n"+e.getText());
	}
}
public static void tearDown()
{
	driver.close();
}

public static void closeAll() 
{
	driver.quit();
}

}
