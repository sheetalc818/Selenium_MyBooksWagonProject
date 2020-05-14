package com.bridegalbz.bookswagon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderBook 
{
	public WebDriver driver;
	public OrderBook(WebDriver driver) 
	{
		this.driver  = driver;
	}

	public void placingBookOrder() throws InterruptedException 
	{
		//By executing a java script
		 JavascriptExecutor exe = (JavascriptExecutor) driver;
		 Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		 System.out.println("Number of iframes on the page are " + numberOfFrames);
		 
		 //Switching on child window
		 System.out.println("Before switching on frame");
		 Thread.sleep(1000);
		 driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		 System.out.println("After switching on frame");
		 Thread.sleep(500);
		 
		 //Increasing the quantity of book
		 driver.findElement(By.id("BookCart_lvCart_ctrl0_txtQty")).sendKeys("8");
		 Thread.sleep(100);
		 
		 driver.findElement(By.id("BookCart_lvCart_imgPayment")).click();
		 //Clicking on place order button
		 System.out.println("After Switch");
		 driver.switchTo().parentFrame();
		 Thread.sleep(4000);
	}

}
