package com.bridegalbz.bookswagon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerShippingDetails {

	public static WebDriver driver;
	
	public CustomerShippingDetails(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "ctl00_cpBody_ddlNewCountry") 
	WebElement state;
	
	@FindBy(xpath="//option[@value='113']")
	WebElement country;
	
	public void addingCustomerDetails()
	{
		state.click();
		Select select=new Select(country);
		select.selectByVisibleText("India");
	}
}
