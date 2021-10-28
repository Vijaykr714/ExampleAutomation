package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class JavaScriptTesting
{
	public static WebDriver oBrowser=null;
	static void launchBrowser()
	{
		try
		{
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
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
			oBrowser.get("file:///H:/HTML/Sample.html");
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void displayTitle()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			String title=(String) js.executeScript("var kk=document.title;return kk;");
			System.out.println("Title of Web Page:"+title);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void displayURL()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			String url=(String) js.executeScript("var kk=document.URL;return kk;");
			System.out.println("URL of Web Page:"+url);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void getLinksCount()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			long linkscount=(long) js.executeScript("var links=document.getElementsByTagName('A');return links.length;");
			System.out.println("# of Links :"+linkscount);		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void enterTextInTextField1()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			js.executeScript("document.getElementById('uid1user1name1').value='DemoUser1';");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void enterTextInTextField2()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			WebElement oEle=oBrowser.findElement(By.id("pwd1pass1word1"));
			js.executeScript("arguments[0].value='Welcome123'",oEle);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void clickOnButton1()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			js.executeScript("document.getElementById('btn1submit1button1').click();");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void clickOnButton2()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			WebElement oEle=oBrowser.findElement(By.id("btn1submit1button1"));
			js.executeScript("arguments[0].click();",oEle);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void clickOnCheckBox1()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			js.executeScript("document.getElementById('chk1windows').click();");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void clickOnCheckBox2()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			WebElement oEle=oBrowser.findElement(By.id("chk2linux"));
			js.executeScript("arguments[0].click();",oEle);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void clickOnRadiobutton1()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			js.executeScript("document.getElementById('rad1chrome').click();");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void clickOnRadiobutton2()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			WebElement oEle=oBrowser.findElement(By.id("rad2firefox"));
			js.executeScript("arguments[0].click();",oEle);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void selectItemFromDropDown()
	{
		try
		{
			JavascriptExecutor js=(JavascriptExecutor) oBrowser;
			String str="var links=document.getElementById('tools');";
			str+="for(var i=0;i<links.length;i++)";
			str+="{";
			str+="if(links[i].text='Selenium RemoteControl')";
			str+="{";
			str+="links[i].selected='1';";
			str+="}";
			str+="}";
			js.executeScript(str);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
public class JavaScriptDemo {

	public static void main(String[] args) {
		JavaScriptTesting.launchBrowser();
		JavaScriptTesting.navigate();
		JavaScriptTesting.displayTitle();
		JavaScriptTesting.displayURL();
		JavaScriptTesting.getLinksCount();
		JavaScriptTesting.enterTextInTextField1();
		JavaScriptTesting.enterTextInTextField2();
	//	JavaScriptTesting.clickOnButton1();
	//	JavaScriptTesting.clickOnButton2();
		JavaScriptTesting.clickOnCheckBox1();
		JavaScriptTesting.clickOnCheckBox2();
		JavaScriptTesting.clickOnRadiobutton1();
		JavaScriptTesting.clickOnRadiobutton2();
		JavaScriptTesting.selectItemFromDropDown();
	}

}
