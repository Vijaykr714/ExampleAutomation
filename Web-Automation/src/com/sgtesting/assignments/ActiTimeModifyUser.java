package com.sgtesting.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class ModifyUser{
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
	static void createUser() {
		try {
			launchBrowser();
			navigateURL();
			login();
			closePopUpWindow();
			wd.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click();
			Thread.sleep(500);
			wd.findElement(By.id("createUserDiv")).click();
			Thread.sleep(1000);
			wd.findElement(By.name("firstName")).sendKeys("Vijay");
			wd.findElement(By.name("lastName")).sendKeys("Kumar");
			wd.findElement(By.name("email")).sendKeys("vk@gmail.com");
			wd.findElement(By.name("username")).sendKeys("vk555");
			wd.findElement(By.name("password")).sendKeys("vk@555");
			wd.findElement(By.name("passwordCopy")).sendKeys("vk@555");
			wd.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']")).click();
			Thread.sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void modifyUser() {
		try {
			wd.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[4]")).click();
			Thread.sleep(1000);
			wd.findElement(By.xpath("/html/body/div[19]/div[2]/div[1]/div/table/tbody/tr[1]/td/div/div/div/img")).click();
			Thread.sleep(500);
			wd.findElement(By.xpath("//*[@id=\'usersForApproverDialog_submitButton\']")).click();
			Thread.sleep(1500);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void deleteUser() {
		try {
			wd.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click();
			Thread.sleep(500);
			wd.findElement(By.xpath("//*[@id=\'userListTableContainer\']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
			Thread.sleep(1000);
			wd.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(500);
			wd.switchTo().alert().accept();
			Thread.sleep(3000);
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
public class ActiTimeModifyUser {
	public static void main(String[] args) {
		ModifyUser.createUser();
		ModifyUser.modifyUser();
		ModifyUser.deleteUser();
	}
}
