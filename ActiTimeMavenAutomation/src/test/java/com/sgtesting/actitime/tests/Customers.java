package com.sgtesting.actitime.tests;

import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.sgtesting.actitime.driverscript.DriverScript;
import com.sgtesting.actitime.utility.ApplicationDependent;

public class Customers extends DriverScript{
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Test case ID:
	 * parameters:
	 * return type:
	 * Purpose:
	 * Description:
	 */
	public static String createCustomer(WebDriver oBrowser)
	{
		Pattern pattern=null;
		String[] arrTestData=null;
		String scriptStatus="Fail";
		try
		{
			log.info("The execution of method createCustomer started here ...");
			pattern=Pattern.compile(",");
			arrTestData=pattern.split(testdatacolumn);
			String customername=datatable.getCellData(excelTestScriptFile, "testdata", arrTestData[0],2);
			String customerdesc=datatable.getCellData(excelTestScriptFile, "testdata",arrTestData[1],2);
			
			oBrowser.findElement(By.cssSelector("a.content.tasks")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.cssSelector(".item.createNewCustomer.ellipsis")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("customerLightBox_nameField")).sendKeys(customername);
			Thread.sleep(1000);
			oBrowser.findElement(By.id("customerLightBox_descriptionField")).sendKeys(customerdesc);
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id='customerLightBox_commitBtn']")).click();
			Thread.sleep(2000);
			
			By by=By.xpath("//div[text()='"+customername+"']");
			if (ApplicationDependent.isObjectPresent(oBrowser, by)==true)
			{
				scriptStatus="Pass";
			}
			log.info("The execution of method createUser ended here ...");
		}catch(Exception e)
		{
			log.error("there is an exception arised during the execution of the method createUser,The Exception :"+e);
		}
		return scriptStatus;
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Test case ID:
	 * parameters:
	 * return type:
	 * Purpose:
	 * Description:
	 */
	public static String modifyCustomer(WebDriver oBrowser)
	{
		Pattern pattern=null;
		String[] arrTestData=null;
		String scriptStatus="Fail";
		try {
			log.info("The execution of method modifyCustomer started here ...");
			pattern=Pattern.compile(",");
			arrTestData=pattern.split(testdatacolumn);
			String customername=datatable.getCellData(excelTestScriptFile, "testdata", arrTestData[0],2);
			
			Actions action = new Actions(oBrowser);
			action.moveToElement(oBrowser.findElement(By.xpath("//div[text()='"+customername+"']"))).perform();
			Thread.sleep(500);
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.className("customerStatusButton")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.cssSelector(".item.archivedContainer")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[2]/div[1]/div[1]")).click();
			Thread.sleep(2000);
			scriptStatus="Pass";
			log.info("The execution of method modifyCustomer ended here ...");
		}catch(Exception e)
		{
			log.error("there is an exception arised during the execution of the method modifyCustomer,The Exception :"+e);
		}
		return scriptStatus;
	}
	
	/**
	 * Created By:
	 * Created Date:
	 * Reviewed By:
	 * Test case ID:
	 * parameters:
	 * return type:
	 * Purpose:
	 * Description:
	 */
	public static String deleteCustomer(WebDriver oBrowser)
	{
		Pattern pattern=null;
		String[] arrTestData=null;
		String scriptStatus="Fail";
		try
		{
			log.info("The execution of method deleteCustomer started here ...");
			pattern=Pattern.compile(",");
			arrTestData=pattern.split(testdatacolumn);
			String customername=datatable.getCellData(excelTestScriptFile, "testdata", arrTestData[0],2);
			
			Actions action = new Actions(oBrowser);
			action.moveToElement(oBrowser.findElement(By.xpath("//div[text()='"+customername+"']"))).perform();
			Thread.sleep(500);
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[4]/div/div")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[4]/div/div[3]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("customerPanel_deleteConfirm_submitBtn")).click();
			Thread.sleep(2000);
			
			scriptStatus="Pass";
			log.info("The execution of method deleteUser ended here ...");
		}catch(Exception e)
		{
			log.error("there is an exception arised during the execution of the method deleteUser,The Exception :"+e);
		}
		return scriptStatus;
	}

}
