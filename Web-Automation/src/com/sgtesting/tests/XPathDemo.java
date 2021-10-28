package com.sgtesting.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	absoluteXPathDemo();
	//	relativeXPathUsingTagNameAlone();
	//	relativeXPathUsingTagNameWithIndex();
	//	relativeXPathUsingTagNameWithAttributeNameAndValue();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameAndValue();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameAndValueByOROperator();
	//	relativeXPathUsingTagNameWithMultipleAttributeNameAndValueByAndOperator();
	//	relativeXPathAttributeNameAndValueAlone();
	//	relativeXPathAttributeValueAlone();
	//	relativeXPathUsingAttributeNameAlone();
	//	relativeXPathUsingAttributeNameAloneCase1();
	//	relativeXPathUsingAttributeNameAloneCase2();
	//	relativeXPathUsingAttributeNameAloneCase3();
	//	relativeXPathUsingAttributeNameAloneCase4();
	//	relativeXPathUsingPartialMatchingOfAttributeValue();
	//	relativeXPathUsingtextContent();
		relativeXPathUsingPartialMatchingtextContent();
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
	
	static void absoluteXPathDemo()
	{
		oBrowser.findElement(By.xpath("html/body/div/form/input")).sendKeys("DemoUser1");
	}
	
	/**
	 *  Case 1: Identify the Element based on tagName alone
	 *  Syntax:
	 *   //<tagName>
	 */
	static void relativeXPathUsingTagNameAlone()
	{
		oBrowser.findElement(By.xpath("//input")).sendKeys("DemoUser1");
	//	oBrowser.findElement(By.xpath("//a")).click();
	}
	
	/**
	 *  Case 2: Identify the Element based on tagName and index
	 *  Syntax:
	 *   //<tagName>[index]
	 *   in xpath index always starts with 1
	 */
	static void relativeXPathUsingTagNameWithIndex()
	{
		oBrowser.findElement(By.xpath("//input[2]")).sendKeys("DemoUser1");
	}

	/**
	 *  Case 3: Identify the Element based on tagName with attribute name and value combination
	 *  Syntax:
	 *   //<tagName>[@AttributeName='AttributeValue']
	 *   
	 */
	static void relativeXPathUsingTagNameWithAttributeNameAndValue()
	{
		oBrowser.findElement(By.xpath("//input[@class='pass1word1']")).sendKeys("DemoUser123");
	}
	
	/**
	 *  Case 4: Identify the Element based on tagName with 
	 *  Multiple attribute name and value combination
	 *  Syntax:
	 *   //<tagName>[@AttributeName='AttributeValue'][@AttributeName='AttributeValue']
	 *   
	 */
	static void relativeXPathUsingTagNameWithMultipleAttributeNameAndValue()
	{
		oBrowser.findElement(By.xpath("//input[@class='pass1word1'][@name='pass1word1']")).sendKeys("DemoUser123");
	}
	
	/**
	 *  Case 5: Identify the Element based on tagName with 
	 *  Multiple attribute name and value combination using "or" operator
	 *  Syntax:
	 *   //<tagName>[@AttributeName='AttributeValue' or @AttributeName='AttributeValue']
	 *   
	 */
	static void relativeXPathUsingTagNameWithMultipleAttributeNameAndValueByOROperator()
	{
		oBrowser.findElement(By.xpath("//input[@name='submit1btn1' or @value='Submit']")).click();
	}
	
	/**
	 *  Case 6: Identify the Element based on tagName with 
	 *  Multiple attribute name and value combination using "and" operator
	 *  Syntax:
	 *   //<tagName>[@AttributeName='AttributeValue' and @AttributeName='AttributeValue']
	 *   
	 */
	static void relativeXPathUsingTagNameWithMultipleAttributeNameAndValueByAndOperator()
	{
		oBrowser.findElement(By.xpath("//input[@name='submit1btn1' and @value='Submit']")).click();
	}
	
	/**
	 *  Case 7: Irrespective of tagName using only attribute name and value combination
	 *  Syntax:
	 *   //*[@AttributeName='AttributeValue']
	 *   
	 */
	static void relativeXPathAttributeNameAndValueAlone()
	{
		oBrowser.findElement(By.xpath("//*[@value='Submit']")).click();
	}
	
	/**
	 *  Case 8: Irrespective of tagName and attribute name 
	 *  based on attribute value alone
	 *  Syntax:
	 *   //*[@*='AttributeValue']
	 *   
	 */
	static void relativeXPathAttributeValueAlone()
	{
		oBrowser.findElement(By.xpath("//*[@*='Submit']")).click();
	}
	
	/**
	 *  Case 9: identify element based on attributeName alone
	 *  based on attribute value alone
	 *  Syntax:1
	 *   //*[@AttributeName]
	 *  Syntax:2
	 *   //<tagName>[@attributeName]
	 *   
	 */
	static void relativeXPathUsingAttributeNameAlone()
	{
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		System.out.println("# of Links :"+olinks.size());
	}
	
	/**
	 *  Case 9.0.1: identify element based on attributeName alone
	 *  based on attribute value alone
	 *  Syntax:1
	 *   //*[@AttributeName]
	 *  Syntax:2
	 *   //<tagName>[@attributeName]
	 *   
	 */
	static void relativeXPathUsingAttributeNameAloneCase1()
	{
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		System.out.println("Display Each Link Names...");
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			String linkname=link.getText();
			System.out.println(linkname);
		}
	}
	
	/**
	 *  Case 9.0.2: identify element based on attributeName alone
	 *  based on attribute value alone
	 *  Syntax:1
	 *   //*[@AttributeName]
	 *  Syntax:2
	 *   //<tagName>[@attributeName]
	 *   
	 */
	static void relativeXPathUsingAttributeNameAloneCase2()
	{
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		System.out.println("Click on 2nd link...");
		olinks.get(1).click();
	}
	
	/**
	 *  Case 9.0.3: identify element based on attributeName alone
	 *  based on attribute value alone
	 *  Syntax:1
	 *   //*[@AttributeName]
	 *  Syntax:2
	 *   //<tagName>[@attributeName]
	 *   
	 */
	static void relativeXPathUsingAttributeNameAloneCase3()
	{
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		System.out.println("Based on Partial MAtching of Text content...");
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			String linkname=link.getText();
			if(linkname.endsWith("POI"))
			{
				link.click();
				break;
			}
			
		}
	}
	
	/**
	 *  Case 9.0.4: identify element based on attributeName alone
	 *  based on attribute value alone
	 *  Syntax:1
	 *   //*[@AttributeName]
	 *  Syntax:2
	 *   //<tagName>[@attributeName]
	 *   
	 */
	static void relativeXPathUsingAttributeNameAloneCase4()
	{
		List<WebElement> olinks=oBrowser.findElements(By.xpath("//a[@href]"));
		System.out.println("org.openqa.selenium.StaleElementReferenceException: ");
		System.out.println("stale element reference: element is not attached to the page document");
		for(int i=0;i<olinks.size();i++)
		{
			WebElement link=olinks.get(i);
			String linkname=link.getText();
			if(linkname.startsWith("Selenium"))
			{
				link.click();
			}
			
		}
	}
	
	/**
	 *  Case 10: Identify the Element based on tagName with partial matching  of  Attribute value 
	 *  Syntax:
	 *  starts-with(@attributename,'attributevalue)
	 *  ends-with(@attributename,'attributevalue)
	 *  contains(@attributename,'attributevalue)
	 *   //<tagName>[starts-with(@attributename,'attributevalue)]
	 *   //<tagName>[ends-with(@attributename,'attributevalue)]
	 *   //<tagName>[contains(@attributename,'attributevalue)]
	 */
	static void relativeXPathUsingPartialMatchingOfAttributeValue()
	{
	//	oBrowser.findElement(By.xpath("//input[starts-with(@id,'btn1')]")).click();
		oBrowser.findElement(By.xpath("//input[contains(@id,'submit1')]")).click();
		
	}
	
	/**
	 *  Case 11: Identify the Element based on text content
	 *  Syntax:
	 *   //<tagName>[text()='text content']
	 *   
	 */
	static void relativeXPathUsingtextContent()
	{
		oBrowser.findElement(By.xpath("//a[text()='S G Software Testing Institute']")).click();
	}
	
	/**
	 *  Case 12: Identify the Element based on partial matching of text content 
	 *  Syntax:
	 *  starts-with(text(),'partial text content)
	 *  ends-with(text(),'partial text content)
	 *  contains(text(),'partial text content)
	 *   //<tagName>[starts-with(text(),'partial text content)]
	 *   //<tagName>[ends-with(text(),'partial text content)]
	 *   //<tagName>[contains(text(),'partial text content)]
	 */
	static void relativeXPathUsingPartialMatchingtextContent()
	{
		oBrowser.findElement(By.xpath("//a[contains(text(),'Software')]")).click();
	}
}
