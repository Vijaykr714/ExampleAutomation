package com.sgtesting.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class FirefoxBrowserTest{
	public static WebDriver oBrowser=null;
	static void launchBrowser(){
		try	{
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumAutomation\\Automation\\Web-Automation\\Library\\drivers\\geckodriver.exe");
			oBrowser=new FirefoxDriver();
		}catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	static void navigate(){
		try	{
			oBrowser.get("http://localhost:82/login.do");
			Thread.sleep(3000);
		}catch(Exception e)	{
			e.printStackTrace();
		}
	}
	
	static void closeApplication(){
		try	{
			oBrowser.close();
		}catch(Exception e)	{
			e.printStackTrace();
		}
	}
}
public class FirefoxBrowserDemo {
	public static void main(String[] args) {
		FirefoxBrowserTest.launchBrowser();
		FirefoxBrowserTest.navigate();
		FirefoxBrowserTest.closeApplication();
	}
}
