package com.retrans.framework;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.retrans.framework.pageobjects.LoginPage;

public class TestBase {

	static WebDriver driver;
	static LoginPage loginPage = null;
	static String baseUrl = "http://35.87.98.64/ReTrans61/login.xhtml";

	protected void threadwait(int k) {
		try {
			Thread.sleep(k);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeClass
	public static void beforeTest() {
		System.out.println("Before Test");

		System.setProperty("webdriver.chrome.driver", "C:/sarva/selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginPage = new LoginPage(driver);
		driver.get(baseUrl);

	}

	@AfterClass
	public static void afterTest() {
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
