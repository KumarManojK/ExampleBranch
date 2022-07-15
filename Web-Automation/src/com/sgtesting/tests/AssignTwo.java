package com.sgtesting.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignTwo {
public static WebDriver oBrowser = null;
	public static void main(String[] args) {

		launchBrowser();
		navigate();
		login();
		minimizeFlyOutWindow();
		createUser();
		modifyUser();
		deleteUser();
		logout();
		closeApplication();
		
		
	}
	private static void launchBrowser()
	{
		try
		{
			
			System.setProperty("webdriver.chrome.driver","E:\\SeleniumAutomation\\Automation\\Web-Automation\\Library\\Drivers\\chromedriver.exe");
			oBrowser = new ChromeDriver();
			Thread.sleep(2000);
			
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
			Thread.sleep(3000);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	private static void login()
	{
		try 
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
			oBrowser.findElement(By.xpath("//*[@id=\'loginButton\']/div")).click();
			Thread.sleep(3000);
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void minimizeFlyOutWindow()
	{
		try 
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	private static void createUser()
	{
		try
		{
			
			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'createUserDiv\']/div/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.name("firstName")).sendKeys("user");
			
			oBrowser.findElement(By.name("lastName")).sendKeys("demo1");
			
			oBrowser.findElement(By.name("email")).sendKeys("userdemo@gmail.com");
			
			oBrowser.findElement(By.id("userDataLightBox_usernameField")).sendKeys("demouser");
			
			oBrowser.findElement(By.name("password")).sendKeys("welcome");
			
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("welcome");
			
			oBrowser.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();
			Thread.sleep(2000);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void modifyUser()
	{
		try
		{
			
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.name("password")).sendKeys("password1");
			Thread.sleep(2000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("password1");
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']/div/span")).click();
			Thread.sleep(2000);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void deleteUser()
	{
		try 
		{
			
			oBrowser.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			Alert oAlert = oBrowser.switchTo().alert();
			String content=oAlert.getText();
			System.out.println(content);
			oAlert.accept();
			Thread.sleep(2000);
			
			
			
		} catch (Exception e) 
		{
			
		}
	}
	private static void logout()
	{
		try 
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void closeApplication()
	{
		try
		{
			
			oBrowser.close();
			Thread.sleep(2000);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
