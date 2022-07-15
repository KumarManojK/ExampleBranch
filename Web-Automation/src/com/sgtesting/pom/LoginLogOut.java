package com.sgtesting.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogOut {
public static WebDriver oBrowser = null;
public static ActiTimePage oPage = null;
	public static void main(String[] args) {
		
		launchBrowser();
		navigate();
		login();
		minimizeFlyOutWindow();
		logout();
		closeApplication();
	}
	
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","E:\\SeleniumAutomation\\Automation\\Web-Automation\\Library\\Drivers\\chromedriver.exe");
			oBrowser = new ChromeDriver();
			oPage = new ActiTimePage(oBrowser);
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void navigate()
	{
		try
		{
			
			oBrowser.get("http://localhost:82/login.do");
			Thread.sleep(4000);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void login()
	{
		try
		{
			
			oPage.getuserName().sendKeys("admin");
			oPage.getPassword().sendKeys("manager");
			oPage.getLogin().click();
			Thread.sleep(5000);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	private static void minimizeFlyOutWindow()
	{
		try
		{
			oPage.getMinimizeFlyOutWindow().click();
			Thread.sleep(3000);
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void logout()
	{
		try
		{
			oPage.getLogout().click();
			Thread.sleep(3000);
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void closeApplication()
	{
		try
		{
			oBrowser.quit();
			Thread.sleep(2000);
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
