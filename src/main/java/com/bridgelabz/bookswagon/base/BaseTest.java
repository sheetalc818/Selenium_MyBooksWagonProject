package com.bridgelabz.bookswagon.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bridgelabz.bookswagon.util.IAutoConstant;
import com.bridgelabz.bookswagon.util.ReadingPropertiseFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConstant
{
	public static WebDriver driver = null;
	
	public static void initialize() throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String appUrl = ReadingPropertiseFile.getProperty(PROPERTY_FILE_PATH,"URL");
		driver.get(appUrl);
		Thread.sleep(2000);
	}
}


