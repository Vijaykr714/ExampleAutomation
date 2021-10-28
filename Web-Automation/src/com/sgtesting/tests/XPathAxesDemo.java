package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XPathAxesDemo {

	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	enterSalaryForThePersonSachinTendulkar();
	//	enterSalaryForThePersonWhoIsNextToRahulDravid();
	//	make_The_Indian_Freedom_Fighter_status_as_Active();
	//	from_SachinTendulkar_the_previous_2nd_record_select_the_City_Name();
	//	basedOnTexTfieldIn2ndRowGetIDAttributeValueOfTable();
		from_table_5th_Row_Enter_the_Salary();
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
			oBrowser.get("file:///H:/HTML/WebTableHTML.html");
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * following-sibling
	 */
	static void enterSalaryForThePersonSachinTendulkar()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following-sibling::td[4]/input")).sendKeys("25000");
	}
	/*
	 * following
	 */
	static void enterSalaryForThePersonWhoIsNextToRahulDravid()
	{
		oBrowser.findElement(By.xpath("//td[text()='Rahul Dravid']/following::tr[1]/td[6]/input")).sendKeys("25000");
	}

	/**
	 * preceding-sibling
	 */
	static void make_The_Indian_Freedom_Fighter_status_as_Active()
	{
		oBrowser.findElement(By.xpath("//td[text()='Indian Freedom Fighter']/preceding-sibling::td[1]/preceding-sibling::td[1]/input")).click();
	}
	
	/**
	 * preceding
	 */
	static void from_SachinTendulkar_the_previous_2nd_record_select_the_City_Name()
	{
		try
		{
			WebElement oDropDown=oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/preceding::tr[2]/td[4]/select"));
			Select oSelect=new Select(oDropDown);
			oSelect.selectByVisibleText("Bangalore");
			Thread.sleep(2000);
			oSelect.selectByIndex(1);
			Thread.sleep(2000);
			oSelect.selectByValue("pj");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * ancestor
	 */
	static void basedOnTexTfieldIn2ndRowGetIDAttributeValueOfTable()
	{
		WebElement oTable=oBrowser.findElement(By.xpath("//input[@id='edit2']/ancestor::tr[1]/ancestor::table"));
		String str=oTable.getAttribute("id");
		System.out.println(str);
	}
	
	/**
	 * descendant:
	 */
	static void from_table_5th_Row_Enter_the_Salary()
	{
		oBrowser.findElement(By.xpath("//table[@id='tbl1']/descendant::tr[6]/td[6]/input")).sendKeys("21000");
	}
}
