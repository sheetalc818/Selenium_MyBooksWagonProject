package com.bridgelabz.bookswagon.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.bridgelabz.bookswagon.util.IAutoConstant;
import com.bridgelabz.bookswagon.util.ReadingPropertiseFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConstant
{
	public static WebDriver driver = null;
	
	public static void initialize() throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--enable-precise-memory-info");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("--no-sandbox");
		options.addArguments("--headless");
		options.addArguments("--disable-dev-shm-usage");

		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		String appUrl = ReadingPropertiseFile.getProperty(PROPERTY_FILE_PATH,"URL");
		driver.get(appUrl);
		Thread.sleep(2000);
	}
}


