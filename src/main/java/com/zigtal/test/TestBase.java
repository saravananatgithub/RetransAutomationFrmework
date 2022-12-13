package com.zigtal.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.zigtal.framework.pageobjects.ListLiteraturesPage;
import com.zigtal.framework.pageobjects.LoginPage;

public class TestBase {
	public static Properties properties = new Properties();
	static {
		java.net.URL url = ClassLoader.getSystemResource("env.properties");
		try {
			properties.load(url.openStream());
		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver driver;
	public static LoginPage loginPage = null;

	public static String username = properties.getProperty("username");
	public static String password = properties.getProperty("password");

	public static ListLiteraturesPage listLiteItemsPage = null;
	public static String hostIP = properties.getProperty("hostip");
	public static String context = properties.getProperty("context");
	public static String baseUrl = "http://" + hostIP + "/" + context + "/login.xhtml";
	public static String chromeDriverPath = properties.getProperty("driver-path");

	static {
		java.net.URL url = ClassLoader.getSystemResource("env.properties");
		try {
			properties.load(url.openStream());
		} catch (FileNotFoundException fie) {
			fie.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void threadwait(int k) {
		try {
			Thread.sleep(k);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void beforeTest() {
		System.out.println("Before Test");

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginPage = new LoginPage(driver);
		driver.get(baseUrl);
		listLiteItemsPage = loginPage.login();

	}

	@AfterClass
	public void afterTest() {
		System.out.println("After Test");

		WebElement testUserLink = driver.findElement(By.xpath("//span[contains(text(),'" + username + "')]"));
		WebElement logoutElement = driver.findElement(By.xpath("//span[normalize-space()='Logout']"));

		testUserLink.click();
		logoutElement.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();

	}

}
