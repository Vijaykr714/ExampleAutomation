package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		mouseActions();
	}
	
	
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
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
			oBrowser.get("https://www.flipkart.com/");
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void mouseActions()
	{
		try
		{
			Actions oMouse=new Actions(oBrowser);
			WebElement oClose=oBrowser.findElement(By.xpath("//button[text()='✕']"));
			oMouse.click(oClose).build().perform();
			Thread.sleep(2000);
			WebElement oEle=oBrowser.findElement(By.xpath("//div[text()='Fashion']"));
			
			oMouse.moveToElement(oEle).build().perform();
			Thread.sleep(2000);
			oBrowser.findElement(By.linkText("Women Ethnic")).click();
			Thread.sleep(2000);
			WebElement oEle1=oBrowser.findElement(By.xpath("//span[text()='Home & Furniture']"));
			oMouse.moveToElement(oEle1).build().perform();
			Thread.sleep(2000);
			oBrowser.findElement(By.linkText("Paintings")).click();
			Thread.sleep(2000);
			WebElement oEle2=oBrowser.findElement(By.xpath("//span[text()='Cart']"));
			oMouse.contextClick(oEle2).build().perform();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
