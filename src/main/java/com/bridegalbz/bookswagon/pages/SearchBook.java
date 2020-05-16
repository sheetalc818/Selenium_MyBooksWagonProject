package com.bridegalbz.bookswagon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sheetal Chaudhari
 * @since  14/05/2020
 * @file   SearchBook.java - Written logic to Search a Book by authorName
 */

public class SearchBook 
{
	public static WebDriver driver;
	
	public SearchBook(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "ctl00_TopSearch1_txtSearch") 
	WebElement profileSearch;
 
	@FindBy(id="ctl00_TopSearch1_Button1")
	WebElement clickedSearchIcon;
 
	@FindBy(xpath ="//a[contains(text(),'Will You Still Love Me?')]")
	WebElement searchBook;
 
	@FindBy(xpath ="//input[@value='Buy Now']")
	WebElement buyNow;
	
	@FindBy(xpath ="//input[@id='BookCart_lvCart_imgPayment']")
	WebElement clickOrderButton;
	
	public void searchBar(String authorName) 
	{
		profileSearch.sendKeys(authorName);	
	}

	public void searchButtonClick() 
	{
		clickedSearchIcon.click();
	}

	public void clickOnBook() 
	{
		searchBook.click();
	}
	
	public void clickOnBuyNow()
	{
		buyNow.click();
	}
}
