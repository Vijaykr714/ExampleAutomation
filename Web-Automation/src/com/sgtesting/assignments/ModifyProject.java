package com.sgtesting.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class ModifyProjectDemo{
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
	static void createProject() {
		try {
			launchBrowser();
			navigateURL();
			login();
			closePopUpWindow();
			addCustomer();
			wd.findElement(By.cssSelector("a.content.tasks")).click();
			Thread.sleep(1000);
			wd.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]")).click();
			Thread.sleep(1000);
			wd.findElement(By.cssSelector(".item.createNewProject.ellipsis")).click();
			Thread.sleep(2000);
			wd.findElement(By.id("projectPopup_projectNameField")).sendKeys("Demo Project");
			Thread.sleep(1000);
			wd.findElement(By.id("projectPopup_projectDescriptionField")).sendKeys("Demo Project Description");
			Thread.sleep(1000);
			wd.findElement(By.xpath("//*[@id=\'projectPopup_commitBtn\']")).click();
			Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void modifyProject() {
		try {
			Actions action = new Actions(wd);
			action.moveToElement(wd.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]"))).perform();
			Thread.sleep(500);
			wd.findElement(By.xpath("/html/body/div[12]/div[1]/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[3]/div[3]")).click();
			Thread.sleep(1000);
			wd.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[2]/div[1]/div[1]/div[1]/div/div[1]/div[3]/div/div[1]")).click();
			Thread.sleep(1000);
			wd.findElement(By.cssSelector(".item.archivedContainer")).click();
			Thread.sleep(2000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void deleteProject() {
		try {
			wd.findElement(By.xpath("/html/body/div[12]/div[2]/div[4]/div[1]/div[2]/div[3]")).click();
			Thread.sleep(2000);
			wd.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[4]/div[4]/div/div[3]")).click();
			Thread.sleep(1000);
			wd.findElement(By.id("projectPanel_deleteConfirm_submitTitle")).click();
			Thread.sleep(2000);
			deleteCustomer();
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
public class ModifyProject {
	public static void main(String[] args) {
		ModifyProjectDemo.createProject();
		ModifyProjectDemo.modifyProject();
		ModifyProjectDemo.deleteProject();
	}
}
