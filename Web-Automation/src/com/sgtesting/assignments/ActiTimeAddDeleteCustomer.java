package com.sgtesting.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class AdddeleteCustomer{
	public static WebDriver wd=null;
	static void launchBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			wd=new ChromeDriver();
			wd.manage().window().maximize();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void navigateURL() {
		try {
			wd.get("http://localhost:82/login.do");
			Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void login() {
		try {
			wd.findElement(By.id("username")).sendKeys("admin");
			wd.findElement(By.name("pwd")).sendKeys("manager");
			wd.findElement(By.id("loginButton")).click();
			Thread.sleep(2500);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void closePopUpWindow() {
		try {
			wd.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
			Thread.sleep(1000);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void addCustomer() {
		try {
			launchBrowser();
			navigateURL();
			login();
			closePopUpWindow();
			wd.findElement(By.cssSelector("a.content.tasks")).click();
			Thread.sleep(1000);
			wd.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]")).click();
			Thread.sleep(1000);
			wd.findElement(By.cssSelector(".item.createNewCustomer.ellipsis")).click();
			Thread.sleep(2000);
			wd.findElement(By.id("customerLightBox_nameField")).sendKeys("Test Customer");
			Thread.sleep(1000);
			wd.findElement(By.id("customerLightBox_descriptionField")).sendKeys("Selenium Automation Test customer Description");
			Thread.sleep(2000);
			wd.findElement(By.xpath("//*[@id=\'customerLightBox_commitBtn\']")).click();
			Thread.sleep(1500);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void deleteCustomer() {
		try {
			Actions action = new Actions(wd);
			action.moveToElement(wd.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]"))).perform();
			Thread.sleep(500);
			wd.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(1000);
			wd.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[1]/div[4]/div/div")).click();
			Thread.sleep(1000);
			wd.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[4]/div/div[3]")).click();
			Thread.sleep(1000);
			wd.findElement(By.id("customerPanel_deleteConfirm_submitBtn")).click();
			Thread.sleep(2000);
			logout();
			closeBrowser();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void logout() {
		try {
			wd.findElement(By.id("logoutLink")).click();
			Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void closeBrowser() {
		try {
			wd.close();
			wd.quit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class ActiTimeAddDeleteCustomer {
	public static void main(String[] args) {
		AdddeleteCustomer.addCustomer();
		AdddeleteCustomer.deleteCustomer();
	}
}
