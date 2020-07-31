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
import com.bridgelabz.bookswagon.util.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author Sheetal Chaudhari
 * @since  14/05/2020
 * @file   BooksWagonTest.java - TestCases file
 */
public class BooksWagonTest extends BaseTest 
{
	static ExtentReports report;
	static ExtentTest test;
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException 
	{
		initialize();
		report = new ExtentReports("/home/sheetal/eclipse-workspace/MyBooksWagon/Report/ExtentReport.html");
		test = report.startTest("BookswagonTest");
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
		test.log(LogStatus.PASS, "Login", "User loggedin successfully");
		
		//Searching for the book
		searchBook.searchBar("Ravinder Singh");
		Thread.sleep(1000);
		searchBook.searchButtonClick();
		Thread.sleep(3000);
		searchBook.clickOnBook();
		Thread.sleep(5000);
		searchBook.clickOnBuyNow();
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Searching", "User Searched book successfully");

		
		//Placing the order
		orderBook.placingBookOrder();
		test.log(LogStatus.PASS, "Placing Order", "User placed order successfully");
		
		//Click continue Button and Add customer details
		details.clickContinueBtn();
		Thread.sleep(500);
		details.addingCustomerDetails();
		test.log(LogStatus.PASS, "Adding details", "User added details successfully");
		
		//Review order
		order.reviewOrder();
		test.log(LogStatus.PASS, "Review Order ", "User order reviewd successfully");

		test.log(LogStatus.PASS,test.addScreenCapture(Screenshot.capture(driver))+ "Test Pass");
		
	}

	@AfterClass
	public void close()throws InterruptedException 
	{
		report.endTest(test);
		report.flush();
		driver.close();
	}
}

