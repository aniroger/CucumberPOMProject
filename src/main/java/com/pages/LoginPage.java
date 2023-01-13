package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1. By Locator
	private By emailId = By.xpath("//input[@id = 'ap_email']");
	
	private By Continue = By.xpath("//input[@id = 'continue']");
	
	private By password = By.id("ap_password");
	
	private By loginbutton = By.xpath("//input[@id ='signInSubmit']");
	
	private By forgotpasswordlink = By.linkText("Forgot Password");
	
	private By Improve = By.linkText("Home Improvement");
	
	//2. Constructor Of Page Class
	
	//this cons says u give me webdriver and then same webdriver will be passed to line no 8
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//3 . Page Actions
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public void ClickContinueButton()
	{
		driver.findElement(Continue).click();
	}
	
	public boolean isforgotpwdlinkexist() {
		
		return driver.findElement(forgotpasswordlink).isDisplayed();
		
	}
	
	public void enterusername(String username)
	{
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterpassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickonlogin()
	{
		driver.findElement(loginbutton).click();
	}
	
	public void dologin(String un , String pwd)
	{
		System.out.println("login with" + un + " " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(Continue).click();
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbutton).click();
	}
	
	public HomeImprove Home()
	{
		driver.findElement(Improve).click();
		return new HomeImprove(driver);
	}
	
}
