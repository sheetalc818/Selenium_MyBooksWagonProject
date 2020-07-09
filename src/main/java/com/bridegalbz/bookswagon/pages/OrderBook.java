package com.bridegalbz.bookswagon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sheetal Chaudhari
 * @since  14/05/2020
 * @file   OrderBook.java - Written logic for Placing a Book Order feature
 */

public class OrderBook 
{
	public WebDriver driver;

	public OrderBook(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "BookCart_lvCart_ctrl0_txtQty")
	WebElement bookQuantity;

	@FindBy(id = "BookCart_lvCart_imgPayment")
	WebElement clickPlaceOrderBtn;

	public void placingBookOrder() throws InterruptedException 
	{
		// By executing a java script
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		// Switching on child window
		System.out.println("Before switching on frame");
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		System.out.println("After switching on frame");
		Thread.sleep(500);

		// Increasing the quantity of book
//		bookQuantity.sendKeys("2");
//		Thread.sleep(100);

		// Clicking on place order button
		clickPlaceOrderBtn.click();

		System.out.println("After Switch");
		driver.switchTo().parentFrame();
		Thread.sleep(4000);
	}

}
