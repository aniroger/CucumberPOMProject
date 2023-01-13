package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSearch {
	
	private WebDriver driver;
	
	/*private By HomeSection = By.xpath("//span[text() = 'Home Improvement']");*/
	
	private By SearchBar = By.xpath("//input[@id='twotabsearchtextbox']");
	
	private By Search = By.xpath("//input[@type='submit']");
	
	public LoginSearch(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void DataTobeSearch(String data )
	{
		driver.findElement(SearchBar).sendKeys(data);
	}
	
	public void Search()
	{
		driver.findElement(Search).click();
	}
	
	public String getSearchPageTitle()
	{
		return driver.getTitle();
	}

}
