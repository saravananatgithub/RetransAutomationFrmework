package com.retrans.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.retrans.framework.pageobjects.ListLiteraturesPage;
import com.retrans.framework.pageobjects.LoginPage;

public class TestBase {

	public static WebDriver driver;
	public static LoginPage loginPage = null;
	public static ListLiteraturesPage listLiteItemsPage = null;
	public static String hostIP = "35.161.37.156";
	public static String baseUrl = "http://" + hostIP + "/ReTrans61/login.xhtml";
	public static String chromeDriverPath = "C:/sarva/selenium/chromedriver.exe";

	protected void threadwait(int k) {
		try {
			Thread.sleep(k);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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

		WebElement testUserLink = driver.findElement(By.xpath("//span[contains(text(),'Test_User')]"));
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
