package com.bridegalbz.bookswagon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author sheetal
 * @since  16/05/2020
 */
public class ReviewOrder {

	public static WebDriver driver;
	
	@FindBy(name = "ctl00$cpBody$ShoppingCart$lvCart$savecontinue")
	WebElement saveAndContinue;
	
	public ReviewOrder(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public void reviewOrder() throws InterruptedException {
		saveAndContinue.click();
		Thread.sleep(500);
	}
}
