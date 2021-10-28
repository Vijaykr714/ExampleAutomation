package com.sgtesting.tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();

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
	/*
	static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			
			Wait<WebDriver> wait=new FluentWait<WebDriver>(oBrowser)
					.withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(TimeoutException.class,NoSuchElementException.class);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Login ']")));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
	private static WebElement oEle=null;
	static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			
			Wait<WebDriver> wait=new FluentWait<WebDriver>(oBrowser)
					.withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(TimeoutException.class,NoSuchElementException.class);
			
			 oEle=wait.until(new Function<WebDriver,WebElement>(){
				public WebElement apply(WebDriver oBrowser)
				{
					return oBrowser.findElement(By.id("username"));
				}
			});
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void login()
	{
		try
		{
			oEle.sendKeys("admin");
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
