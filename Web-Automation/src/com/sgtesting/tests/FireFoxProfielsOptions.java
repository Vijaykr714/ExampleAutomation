package com.sgtesting.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FireFoxProfielsOptions {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();

	}
		
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.gecko.driver", ".\\Library\\drivers\\geckodriver.exe");
		/*	ProfilesIni profile= new ProfilesIni();
			FirefoxProfile ffprofile=profile.getProfile("default");
			FirefoxOptions options= new FirefoxOptions();
			options.setProfile(ffprofile);
		*/
			FirefoxProfile ffprofile=new FirefoxProfile();
			ffprofile.setPreference("browser.startup.homepage", "http://www.sgtestinginstitute.com");
			FirefoxOptions options= new FirefoxOptions();
			options.setProfile(ffprofile);
			oBrowser=new FirefoxDriver(options);
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
