package com.retrans.framework;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.retrans.framework.pageobjects.EditLiteraturesPage;
import com.retrans.framework.pageobjects.ListLiteraturesPage;
import com.retrans.framework.pageobjects.LoginPage;

public class RetransTest extends TestBase {

	private ListLiteraturesPage listLiteItemsPage;

	@Test
	public void editLiteratureItemAddAction() {
		if (listLiteItemsPage == null) {
			System.out.println("listLiteItemsPage 0:" + listLiteItemsPage);
			listLiteItemsPage = loginPage.login();
		}
		threadwait(5000);
		String fromDate = "11";
		String fromMonth = "Oct";
		String fromYear = "2022";

		String toDate = "13";
		String toMonth = "Nov";
		String toYear = "2022";

		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiterature("2022_W37_9");
		threadwait(3000);
		editLitPage.createAction("Internal review", "Open", fromDate, fromMonth, fromYear, toDate, toMonth, toYear);
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItemAddNotes() {
		if (listLiteItemsPage == null) {
			System.out.println("listLiteItemsPage 0:" + listLiteItemsPage);
			listLiteItemsPage = loginPage.login();
		}
		threadwait(5000);

		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiterature("2022_W37_9");
		threadwait(3000);
		editLitPage.createNotes("Nodes Title Sep 30", "Notes Description Sep 30");
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItem() {
		if (listLiteItemsPage == null) {
			System.out.println("listLiteItemsPage 0:" + listLiteItemsPage);
			listLiteItemsPage = loginPage.login();
		}
		threadwait(5000);

		listLiteItemsPage.editLiterature("2022_W37_9");
		threadwait(3000);
	}

	// @Test
	public void selectMultipleLiteratures() {
		if (listLiteItemsPage == null) {
			System.out.println("listLiteItemsPage 0:" + listLiteItemsPage);
			listLiteItemsPage = loginPage.login();
		}
		threadwait(5000);

		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_9");
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_3");
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_8");
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_1");
		threadwait(3000);
	}

	// @Test
	public void viewLiteratureItemAndVerifyAuthor() {
		if (listLiteItemsPage == null) {
			System.out.println("listLiteItemsPage 1:" + listLiteItemsPage);
			listLiteItemsPage = loginPage.login();
		}

		listLiteItemsPage.clickLiteratureByName("2022_W37_9");
		threadwait(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@value,'Hussar')]")).isDisplayed());
		listLiteItemsPage.closeLiteratureDialog();
	}

	// @Test
	public void claimLiterature() {

		if (listLiteItemsPage == null) {
			System.out.println("listLiteItemsPage 2:" + listLiteItemsPage);
			listLiteItemsPage = loginPage.login();
		}

		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_9");
		listLiteItemsPage.claimSelectedLiteratureItems();
		threadwait(5000);

	}

	// @Test
	public void filterLiteratures() {

		if (listLiteItemsPage == null) {
			System.out.println("listLiteItemsPage 3:" + listLiteItemsPage);
			listLiteItemsPage = loginPage.login();
		}

		listLiteItemsPage.filterByActivity("Triage");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(3000);

		listLiteItemsPage.filterByClassification("Duplicate");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(3000);

		listLiteItemsPage.filterByBusinessUnit("Testing-BU");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(6000);

		listLiteItemsPage.filterByClaims("Unclaimed");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(3000);

		listLiteItemsPage.filterByClaims("Claimed by me");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(3000);

	}

	// @Test
	public void loginToRetransPerfTest() {

		System.out.println("Before Test");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		// ChromeDriver driver = new ChromeDriver(options);

		System.setProperty("webdriver.chrome.driver", "C:/sarva/selenium/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		loginPage = new LoginPage(driver);
		driver.get(baseUrl);

		listLiteItemsPage = loginPage.login();

		listLiteItemsPage.filterByActivity("Triage");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(3000);

//		listLiteItemsPage.filterByClassification("Duplicate");
//		threadwait(3000);
//		listLiteItemsPage.clearFilter();
//		threadwait(3000);
//		
//		listLiteItemsPage.filterByBusinessUnit("Testing-BU");
//		threadwait(3000);
//		listLiteItemsPage.clearFilter();
//		threadwait(6000);
//		
//		listLiteItemsPage.filterByClaims("Unclaimed");
//		threadwait(3000);
//		listLiteItemsPage.clearFilter();
//		threadwait(3000);
//		
//		listLiteItemsPage.filterByClaims("Claimed by me");
//		threadwait(3000);
//		listLiteItemsPage.clearFilter();
//		threadwait(3000);

		listLiteItemsPage.logout();
		threadwait(5000);

		driver.close();
	}

}
