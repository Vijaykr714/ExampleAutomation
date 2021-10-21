package com.sgtesting.assignments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class CreateDeleteMultipleUser{
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
			Thread.sleep(1000);
			wd.findElement(By.name("pwd")).sendKeys("manager");
			Thread.sleep(1000);
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
	static void createUser(int cnt) {
		try {
			launchBrowser();
			navigateURL();
			login();
			closePopUpWindow();
			wd.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click();
			Thread.sleep(500);
			HashMap<String,String> obj=new HashMap<String,String>();
			for(int i=1;i<=cnt;i++) {
				wd.findElement(By.id("createUserDiv")).click();
				Thread.sleep(1000);
				String uName="user"+i;
				String pwd="User"+i+"Pwd";
				wd.findElement(By.name("firstName")).sendKeys("User"+i+"Fname");
				Thread.sleep(1000);
				wd.findElement(By.name("lastName")).sendKeys("User"+i+"Lname");
				Thread.sleep(1000);
				wd.findElement(By.name("email")).sendKeys("user"+i+"@gmail.com");
				Thread.sleep(1000);
				wd.findElement(By.name("username")).sendKeys(uName);
				Thread.sleep(1000);
				wd.findElement(By.name("password")).sendKeys(pwd);
				Thread.sleep(1000);
				wd.findElement(By.name("passwordCopy")).sendKeys(pwd);
				Thread.sleep(1000);
				wd.findElement(By.xpath("//*[@id=\'userDataLightBox_commitBtn\']")).click();
				Thread.sleep(3000);
				obj.put(uName, pwd);
			}
			logout();
			@SuppressWarnings("rawtypes")
			Set set=obj.entrySet();
			@SuppressWarnings("rawtypes")
			Iterator ite=set.iterator();
			while(ite.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<String, String> me=(Map.Entry<String, String>)ite.next();
				try {
					wd.findElement(By.id("username")).sendKeys(me.getKey());
					Thread.sleep(1000);
					wd.findElement(By.name("pwd")).sendKeys(me.getValue());
					Thread.sleep(1000);
					wd.findElement(By.id("loginButton")).click();
					Thread.sleep(4000);
					wd.findElement(By.xpath("/html/body/div[3]/div[3]/div")).click();
					Thread.sleep(3000);
					logout();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void deleteUser(int cnt) {
		try {
			login();
			while(cnt>0) {
				wd.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr[1]/td[5]/a")).click();
				Thread.sleep(500);
				wd.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td/span[1]/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
				Thread.sleep(2000);
				wd.findElement(By.id("userDataLightBox_deleteBtn")).click();
				Thread.sleep(500);
				wd.switchTo().alert().accept();
				Thread.sleep(3000);
				cnt--;
			}
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
public class CreateDeleteMultipleUsers {
	public static void main(String[] args) {
		int cnt=3;
		CreateDeleteMultipleUser.createUser(cnt);
		CreateDeleteMultipleUser.deleteUser(cnt);
	}
}
