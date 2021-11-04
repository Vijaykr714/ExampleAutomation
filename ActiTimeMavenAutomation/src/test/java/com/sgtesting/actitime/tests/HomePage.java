package com.sgtesting.actitime.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sgtesting.actitime.utility.ApplicationIndependent;

public class HomePage {
	
	/**
	 * Created By:
	 * Modified By:
	 * Reviewed By:
	 * Test Case ID:
	 * @Parameters :
	 * @return :
	 * Purpose:
	 * Description:
	 */
	public static String minimizeFlyOutWindow(WebDriver oBrowser)
	{
		String scriptStatus="Fail";
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			ApplicationIndependent.waitFor(2);
			scriptStatus="Pass";
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return scriptStatus;
	}

}
