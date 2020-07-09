package com.bridegalbz.bookswagon.test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bridegalbz.bookswagon.pages.OrderBook;
import com.bridegalbz.bookswagon.pages.ReviewOrder;
import com.bridegalbz.bookswagon.pages.SearchBook;
import com.bridegalbz.bookswagon.pages.CustomerShippingDetails;
import com.bridegalbz.bookswagon.pages.LoginToApplication;
import com.bridgelabz.bookswagon.base.BaseTest;
import com.bridgelabz.bookswagon.util.ReadingPropertiseFile;

/**
 * @author Sheetal Chaudhari
 * @since  14/05/2020
 * @file   BooksWagonTest.java - TestCases file
 */
public class BooksWagonTest extends BaseTest 
{

	@BeforeClass
	public void setup() throws InterruptedException, IOException 
	{
		initialize();
	}

	@Test
	public static void whenSearchBookByAutherName_AfterPlacingAOrder_UserShouldGetTheBillingPage() throws InterruptedException, AWTException, IOException 
	{
		LoginToApplication customer=new LoginToApplication(driver);
		SearchBook searchBook= new SearchBook(driver);
		OrderBook orderBook= new OrderBook(driver);
		CustomerShippingDetails details = new CustomerShippingDetails(driver);
		ReviewOrder order = new ReviewOrder(driver);
		
		//Login feature
		customer.existingCustomer();
		String userName = ReadingPropertiseFile.getCellValue(EXCEL_PATH, "Sheet1", 1, 0);
		String password = ReadingPropertiseFile.getCellValue(EXCEL_PATH, "Sheet1", 1, 1).toString();
		customer.mail(userName);
		Thread.sleep(1000);
		customer.password(password);
		customer.login();
		
		//Searching for the book
		searchBook.searchBar("Ravinder Singh");
		Thread.sleep(1000);
		searchBook.searchButtonClick();
		Thread.sleep(3000);
		searchBook.clickOnBook();
		Thread.sleep(5000);
		searchBook.clickOnBuyNow();
		Thread.sleep(10000);
		
		//Placing the order
		orderBook.placingBookOrder();
		
		//Click continue Button and Add customer details
		//details.clickContinueBtn();
		Thread.sleep(500);
		//details.addingCustomerDetails();
		
		//Review order
		//order.reviewOrder();
	}

	@AfterClass
	public void close()throws InterruptedException 
	{
		driver.close();
	}
}

