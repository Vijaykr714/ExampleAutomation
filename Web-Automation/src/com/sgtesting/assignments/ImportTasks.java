package com.sgtesting.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ImportDeleteTasks{
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
	static void importTasks() {
		try {
			launchBrowser();
			navigateURL();
			login();
			closePopUpWindow();
			wd.findElement(By.cssSelector("a.content.tasks")).click();
			Thread.sleep(1500);
			wd.findElement(By.className("addNewTaskButtonContainer")).click();
			Thread.sleep(1500);
			wd.findElement(By.cssSelector(".item.importTasks.ellipsis")).click();
			Thread.sleep(2000);
			WebElement browse = wd.findElement(By.xpath("/html/body/div[11]/div/div[3]/div[1]/div[2]/div[3]"));
			Thread.sleep(1000);
			browse.sendKeys("D:\\Sample.csv");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class ImportTasks {
	public static void main(String[] args) {
		ImportDeleteTasks.importTasks();
	}
}
