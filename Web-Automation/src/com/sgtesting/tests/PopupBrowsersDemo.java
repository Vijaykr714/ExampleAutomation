package com.sgtesting.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class PopupBrowsersTest
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
	
	static void actiTimeLink()
	{
		try
		{
			System.out.println("Before Click on actiTIME Inc. the # of Child Browsers :"+getPopupCount());
			WebElement oLink=oBrowser.findElement(By.linkText("actiTIME Inc."));
			oLink.click();
			Thread.sleep(8000);
			System.out.println("After Click on actiTIME Inc. the # of Child Browsers :"+getPopupCount());
			if (getPopupCount()>=1)
			{
				handlePopUps();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void handlePopUps()
	{
		String parentBrowser;
		try
		{
			parentBrowser=oBrowser.getWindowHandle();
			System.out.println("Parent Browser :"+parentBrowser);
			
			Set<String> set=oBrowser.getWindowHandles();
			Object popups[]=set.toArray();
			for(int i=1;i<popups.length;i++)
			{
				String childBrowser=popups[i].toString();
				System.out.println("Child Browser :"+childBrowser);
				oBrowser.switchTo().window(childBrowser);
				Thread.sleep(2000);
				oBrowser.findElement(By.linkText("Start Using actiTIME")).click();
				Thread.sleep(5000);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static int getPopupCount()
	{
		int count=0;
		try
		{
			Set<String> set=oBrowser.getWindowHandles();
			count=set.size()-1;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
}
public class PopupBrowsersDemo {
	public static void main(String[] args) {
		PopupBrowsersTest.launchBrowser();
		PopupBrowsersTest.navigate();
		PopupBrowsersTest.actiTimeLink();
	//	PopupBrowsersTest.handlePopUps();
	}

}
