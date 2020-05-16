package com.bridegalbz.bookswagon.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bridgelabz.bookswagon.util.IAutoConstant;
import com.bridgelabz.bookswagon.util.ReadingPropertiseFile;

/**
 * @author Sheetal Chaudhari
 * @since  14/05/2020
 * @file   CustomerShippingDetails.java - Written logic to add customer details
 */

public class CustomerShippingDetails implements IAutoConstant 
{

	public static WebDriver driver;
	
	public CustomerShippingDetails(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(partialLinkText = "Contin") 
	WebElement clickContinueBtn;
	
	@FindBy(id = "ctl00_cpBody_txtNewRecipientName")
	WebElement recipientName;
	
	@FindBy(id = "ctl00_cpBody_txtNewAddress")
	WebElement streetAddress;
	
	@FindBy(id = "ctl00_cpBody_ddlNewCountry")
	WebElement country;
	
	@FindBy(id = "ctl00_cpBody_ddlNewState") 
	WebElement state;
	
	@FindBy(id = "ctl00_cpBody_txtNewCity")
	WebElement cityName;
	
	@FindBy(id = "ctl00_cpBody_txtNewPincode")
	WebElement cityPin;
	
	@FindBy(id = "ctl00_cpBody_txtNewPhone")
	WebElement phoneNo;
	
	@FindBy(id = "ctl00_cpBody_imgSaveNew")
	WebElement saveAndContinue;
	
	public void clickContinueBtn() 
	{
		clickContinueBtn.click();
	}
	
	public Select selectFromDropDown(WebElement element) 
	{
		Select elementName = new Select(element);
		return elementName;
	}
	
	public void addingCustomerDetails() throws IOException, InterruptedException
	{
		recipientName.sendKeys(ReadingPropertiseFile.getProperty(PROPERTY_FILE_PATH, "recipientName"));
		Thread.sleep(300);
		streetAddress.sendKeys(ReadingPropertiseFile.getProperty(PROPERTY_FILE_PATH, "streetAddress"));
		Thread.sleep(300);
		
		Select countryName = selectFromDropDown(country);
		Thread.sleep(300);
		countryName.selectByVisibleText("India");
		
		Select stateName = selectFromDropDown(state);
        Thread.sleep(300);
        stateName.selectByVisibleText("Maharashtra");
		
		cityName.sendKeys(ReadingPropertiseFile.getProperty(PROPERTY_FILE_PATH, "cityName"));
		Thread.sleep(300);
		
		cityPin.sendKeys(ReadingPropertiseFile.getProperty(PROPERTY_FILE_PATH, "cityPin"));
		Thread.sleep(300);
		
		phoneNo.sendKeys(ReadingPropertiseFile.getProperty(PROPERTY_FILE_PATH, "phoneNo"));
		Thread.sleep(300);
		
		saveAndContinue.click();
		Thread.sleep(500);
	}
}
