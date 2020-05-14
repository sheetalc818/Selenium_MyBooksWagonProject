package com.bridegalbz.bookswagon.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToApplication {

	public WebDriver driver;
	
	public LoginToApplication(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath ="//input[@id='ctl00_phBody_SignIn_txtEmail']")
    WebElement emailId;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
    WebElement pwsdNumber;

        
    @FindBy(xpath ="//div[@id='ctl00_divLogin']")
    WebElement optionTologin;
	
     
    public void existingCustomers() {
    	optionTologin.click();
    }    
	
	public void mail(String name) {
		emailId.sendKeys(name);
	}
	
	public void password(String psw) {
		pwsdNumber.sendKeys(psw);
	}
	
	public void login() throws AWTException,InterruptedException 
	{
		Robot robot = new Robot();
		robot.mouseMove(193, 414);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
	}
}

