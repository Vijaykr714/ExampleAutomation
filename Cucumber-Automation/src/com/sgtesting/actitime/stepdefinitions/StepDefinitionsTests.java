package com.sgtesting.actitime.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionsTests {
	public static WebDriver oBrowser=null;
	@Given("^I launch the Chrome Browser$")
	public void iLaunchTheChromeBrowser()
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


	@And("^I navigate the url of the Application$")
	public void i_navigate_the_url_of_the_Application() 
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@When("^I enter the username in username text field$")
	public void i_enter_the_username_in_username_text_field() 
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@And("^I enter the password in password text field$")
	public void i_enter_the_password_in_password_text_field()
	{
		try
		{
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@And("^I click on Login button in login page$")
	public void i_click_on_Login_button_in_login_page() 
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("^I find the Home Page$")
	public void i_find_the_Home_Page()
	{
		String expectedResult="actiTIME - Enter Time-Track";
		try
		{
			String actualResult=oBrowser.getTitle();
			Assert.assertEquals(expectedResult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	@When("^I click on Logout link$")
	public void i_click_on_Logout_link() 
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Then("^I find the login page$")
	public void i_find_the_login_page() 
	{
		String expectedResult="actiTIME - Login";
		try
		{
			String actualResult=oBrowser.getTitle();
			Assert.assertEquals(expectedResult, actualResult);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Given("^I minimized the flyout window$")
	public void I_minimized_the_flyout_window()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@And("^I close the browser$")
	public void i_close_the_Browser()
	{
		try
		{
			oBrowser.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
