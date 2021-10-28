package com.sgtesting.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
//		absoluteCSSSelector();
//		relativeCSSUsingTagNameAlone();
//		relativeCSSUsingTagNameWithIDAttributeValue();
//		relativeCSSUsingIDAttributeValue();
//		relativeCSSUsingTagNameWithClassAttributeValue();
//		relativeCSSUsingClassAttributeValue();
//		relativeCSSUsingTagNameWithAttributeNameAndValue();
//		relativeCSSUsingAttributeNameAndValue();
//		relativeCSSUsingTagNameWithMultipleAttributeNameAndValue();
//		relativeCSSUsingTagNameWithPartialAttributeValue();
//		relativeCSSUsingTagNameWithAttributeName1();
//		relativeCSSUsingTagNameWithAttributeName2();
//		relativeCSSUsingTagNameWithAttributeName3();
//		relativeCSSUsingParentTagReference();
//		relativeCSSUsingNthChildconcept();
		relativeCSSUsingFollowingSibling();
	}
	
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
			oBrowser.get("file:///H:/HTML/Sample.html");
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static void absoluteCSSSelector()
	{
		oBrowser.findElement(By.cssSelector("html body div form input")).sendKeys("DemoUser123");
	}
	
	/**
	 * Case 1: Relative CSS based on tag Name alone
	 * Syntax:
	 * tagname
	 */
	static void relativeCSSUsingTagNameAlone()
	{
		oBrowser.findElement(By.cssSelector("input")).sendKeys("DemoUser123");
	}
	
	/**
	 * Case 2: Relative CSS based on tagName with id attribute value
	 * Syntax:
	 * tagname#idattributevalue
	 */
	static void relativeCSSUsingTagNameWithIDAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input#pwd1pass1word1")).sendKeys("WelcomePassword123");
	}
	
	/**
	 * Case 3: Relative CSS based on id attribute value alone
	 * Syntax:
	 * #idattributevalue
	 */
	static void relativeCSSUsingIDAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("#pwd1pass1word1")).sendKeys("WelcomePassword123");
	}
	
	/**
	 * Case 4: Relative CSS based on tagName with class attribute value
	 * Syntax:
	 * tagname.classattributevalue
	 */
	static void relativeCSSUsingTagNameWithClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input.pass1word1")).sendKeys("WelcomePassword1");
	}
	
	/**
	 * Case 5: Relative CSS based on class attribute value
	 * Syntax:
	 * .classattributevalue
	 */
	static void relativeCSSUsingClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector(".pass1word1")).sendKeys("Welcome12345");
	}
	
	/**
	 * Case 6: Relative CSS based on tagname with attributename and attribute value combination
	 * Syntax:
	 * tagName[attributename=attributevalue]
	 */
	static void relativeCSSUsingTagNameWithAttributeNameAndValue()
	{
		oBrowser.findElement(By.cssSelector("input[value='Submit']")).click();
	}
	
	/**
	 * Case 7: Relative CSS based attributename and attribute value combination
	 * irrespective of any tag
	 * Syntax:
	 * *[attributename=attributevalue]
	 */
	static void relativeCSSUsingAttributeNameAndValue()
	{
		oBrowser.findElement(By.cssSelector("*[value='Submit']")).click();
	}
	
	/**
	 * Case 8: Relative CSS based on tagname with multiple attributename and attribute value combination
	 * Syntax:
	 * tagName[attributename=attributevalue][attributename=attributevalue]
	 */
	static void relativeCSSUsingTagNameWithMultipleAttributeNameAndValue()
	{
		oBrowser.findElement(By.cssSelector("input[value='Submit'][name='submit1btn1']")).click();
	}
	
	/**
	 * Case 9: Relative CSS based on tagname with partial matching of attribute value
	 * Syntax:
	 *     ^= starts-with
	 *     $= ends-with
	 *     *= contains
	 * tagName[attributename ^= partialattributevalue]
	 * tagName[attributename $= partialattributevalue]
	 * tagName[attributename *= partialattributevalue]
	 */
	static void relativeCSSUsingTagNameWithPartialAttributeValue()
	{
	//	oBrowser.findElement(By.cssSelector("input[id ^= 'btn1']")).click();
		oBrowser.findElement(By.cssSelector("input[id *= 'submit']")).click();
	}
	
	/**
	 * Case 10: Relative CSS based on tagname with attributename
	 * Syntax:
	 * tagName[attributename]
	 */
	static void relativeCSSUsingTagNameWithAttributeName1()
	{
		List<WebElement> olinks=oBrowser.findElements(By.cssSelector("a[href]"));
		System.out.println("# of Links :"+olinks.size());
	}
	
	static void relativeCSSUsingTagNameWithAttributeName2()
	{
		List<WebElement> olinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			System.out.println(link.getText());
		}
	}
	
	static void relativeCSSUsingTagNameWithAttributeName3()
	{
		List<WebElement> olinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			String content=link.getText();
			if(content.endsWith("POI"))
			{
				link.click();
				break;
			}
		}
	}
	
	/**
	 * Case 11: Relative CSS based on parent tag reference
	 * Syntax:
	 * parenttag > childtag
	 */
	static void relativeCSSUsingParentTagReference()
	{
		oBrowser.findElement(By.cssSelector("div#d2 > form#frm2 > input")).click();
	}

	/**
	 * Case 12: Relative CSS based on nth-child concept
	 * Syntax:
	 * parenttag > :nth-child(number)
	 */
	static void relativeCSSUsingNthChildconcept()
	{
		oBrowser.findElement(By.cssSelector("form#frm3 > :nth-child(3)")).sendKeys("DemoUser3");
	}
	
	/**
	 * Case 13: Relative CSS based on following sibling
	 * Syntax:
	 * parenttag > childtag + sibling1 + sibling2
	 */
	static void relativeCSSUsingFollowingSibling()
	{
		oBrowser.findElement(By.cssSelector("form#frm3 > input + input +input +input")).sendKeys("DemoUser4");
	}
}
