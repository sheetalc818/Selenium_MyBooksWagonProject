package com.bridgelabz.bookswagon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver=null;
	
	public static void initialize() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
	
		driver.get("https://www.bookswagon.com");
		Thread.sleep(2000);
	}
}


