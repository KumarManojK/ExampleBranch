package com.sgtesting.tests;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class AssignEight {
	public static WebDriver oBrowser = null;
	public static void main(String[] args) {

		launchBrowser();
		navigate();
		login();
		minimizeFlyOutWindow();
		importTasks();
	}

	private static void launchBrowser()
	{
		try 
		{
			System.setProperty("webdriver.chrome.driver","E:\\SeleniumAutomation\\Automation\\Web-Automation\\Library\\Drivers\\chromedriver.exe");
			oBrowser = new ChromeDriver();



		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void navigate()
	{

		try {

			oBrowser.get("http://localhost:82/login.do");
			Thread.sleep(2000);
		} catch (InterruptedException e) 
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

	private static void importTasks()
	{
		try 
		{

			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[3]/a/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[1]/div[1]/div[3]/div/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("/html/body/div[13]/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'dropzoneClickableArea\']")).click();
			Thread.sleep(2000);
			String filename = "E:\\Selenium\\Sample.csv";
			copyFile(filename);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//*[@id=\'loadTasksFromCSVPopup_commitBtn\']/div/span")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//*[@id='closeLoadTasksFromCSVPopupButton']")).click();
			Thread.sleep(1000);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void copyFile(String filename) 
	{
		StringSelection strselection = new StringSelection(filename);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);
		
	}

}
