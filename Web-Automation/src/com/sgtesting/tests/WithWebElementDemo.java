package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class WithWebElement
{
	public static WebDriver oBrowser=null;
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "H:\\ExampleAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void login()
	{
		WebElement oUserName=null;
		try
		{
			oUserName=oBrowser.findElement(By.id("username"));
			oUserName.sendKeys("DemoUser1");
			Thread.sleep(1000);
			oUserName.clear();
			Thread.sleep(1000);
			oUserName.sendKeys("DemoUser2");
			Thread.sleep(1000);
			oUserName.clear();
			Thread.sleep(1000);
			oUserName.sendKeys("DemoUser3");
			Thread.sleep(1000);
			oUserName.clear();
			Thread.sleep(1000);
			oUserName.sendKeys("DemoUser1234567890");
			Thread.sleep(1000);
			String val=oUserName.getAttribute("value");
			System.out.println(val);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
public class WithWebElementDemo {

	public static void main(String[] args) {
		WithWebElement.launchBrowser();
		WithWebElement.navigate();
		WithWebElement.login();

	}

}
