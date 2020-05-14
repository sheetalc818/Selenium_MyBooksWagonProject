package com.bridegalbz.bookswagon.test;

import java.awt.AWTException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bridegalbz.bookswagon.pages.OrderBook;
import com.bridegalbz.bookswagon.pages.SearchBook;
import com.bridegalbz.bookswagon.pages.CustomerShippingDetails;
import com.bridegalbz.bookswagon.pages.LoginToApplication;
import com.bridgelabz.bookswagon.base.BaseTest;


public class BooksWagonTest extends BaseTest 
{

	@BeforeClass
	public void setup() throws InterruptedException 
	{
		initialize();
	}

	@Test
	public static void whenSearchBookByAutherName_AfterPlacingAOrder_UserShouldGetTheBillingPage() throws InterruptedException, AWTException 
	{
		LoginToApplication customer=new LoginToApplication(driver);
		SearchBook searchBook= new SearchBook(driver);
		OrderBook orderBook= new OrderBook(driver);
		CustomerShippingDetails details = new CustomerShippingDetails(driver);
		
		//Login feature
		customer.existingCustomers();
		customer.mail("testingtestdatablz@gmail.com");
		Thread.sleep(1000);
		customer.password("testdata@123");
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
		
		//Adding customer details
		details.addingCustomerDetails();
		
	}

	@AfterClass
	public void close()throws InterruptedException 
	{
		driver.close();
	}
}

