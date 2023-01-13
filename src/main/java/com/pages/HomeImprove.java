package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeImprove {
	
	private WebDriver driver;
	
	/*private By HomeSection = By.xpath("//span[text() = 'Home Improvement']");*/
	
	private By HomeSection = By.xpath("//li[@class = 'a-spacing-micro apb-browse-refinements-indent-2']");
	
	public HomeImprove(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public int getHomeCount()
	{
		return driver.findElements(HomeSection).size();
	}
	
	public List<String> getHomeCountList()
	{
	
	List<String> accountlist = new ArrayList<>();	
	List<WebElement> headerlist = driver.findElements(HomeSection);
	for(WebElement h : headerlist)
	{
 
		String text = h.getText();
		System.out.println(text);
		accountlist.add(text);
     }
	
	return accountlist;
	
}

}