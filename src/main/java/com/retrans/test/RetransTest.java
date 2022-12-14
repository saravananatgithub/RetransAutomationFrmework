package com.retrans.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.retrans.framework.pageobjects.EditLiteraturesPage;

public class RetransTest extends TestBase {

	// @Test
	public void editLiteratureItemAddAction() {
		threadwait(5000);
		String fromDate = "11";
		String fromMonth = "Oct";
		String fromYear = "2022";

		String toDate = "13";
		String toMonth = "Nov";
		String toYear = "2022";
		listLiteItemsPage.navigateToListLitItemsPage();
		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiterature("2022_W37_9");
		threadwait(3000);
		editLitPage.createAction("Internal review", "Open", fromDate, fromMonth, fromYear, toDate, toMonth, toYear);
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItemByTitleAddAction() {
		threadwait(5000);
		String fromDate = "28";
		String fromMonth = "Oct";
		String fromYear = "2022";

		String toDate = "13";
		String toMonth = "Nov";
		String toYear = "2022";
		String litTitle = "Imepitoin is well tolerated";

		listLiteItemsPage.navigateToListLitItemsPage();
		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiteratureByTitle(litTitle);
		threadwait(3000);
		editLitPage.createAction("Internal review", "Open", fromDate, fromMonth, fromYear, toDate, toMonth, toYear);
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItemAddNotes() {

		listLiteItemsPage.navigateToListLitItemsPage();
		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiterature("2022_W47_5");
		threadwait(3000);
		editLitPage.createNotes("Nodes Title Nov 22 2022", "Notes Description Nov 22 2022 Description", "");
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItemAddNotesWithAttachment() {

		listLiteItemsPage.navigateToListLitItemsPage();
		String attachmentFilePath = "C:/Users/I329775/Pictures/camprofiles.PNG";
		EditLiteraturesPage editLitPage = listLiteItemsPage.editLiterature("2022_W46_567");
		threadwait(3000);
		editLitPage.createNotes("Nodes Title Nov 22 2022", "Nodes Title Nov 22 2022 Description", attachmentFilePath);
		threadwait(3000);
	}

	// @Test
	public void editLiteratureItem() {
		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.editLiterature("2022_W37_9");
		threadwait(3000);
	}

	// @Test
	public void selectMultipleLiteratures() {
		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_9");
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_3");
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_8");
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_1");
		threadwait(3000);
	}

	// @Test
	public void viewLiteratureItemAndVerifyAuthor() {
		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.clickLiteratureByName("2022_W37_9");
		threadwait(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@value,'Hussar')]")).isDisplayed());
		listLiteItemsPage.closeLiteratureDialog();
	}

	// @Test
	public void claimLiterature() {
		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.selectLiteratureByCheckBox("2022_W37_9");
		listLiteItemsPage.claimSelectedLiteratureItems();
		threadwait(5000);
	}

	@Test
	public void filterLiteraturesByActivity() {
		listLiteItemsPage.navigateToListLitItemsPage();
		listLiteItemsPage.filterByActivity("Triage");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);
	}

	@Test
	public void filterLiteraturesByClassification() {
		listLiteItemsPage.navigateToListLitItemsPage();

		listLiteItemsPage.filterByClassification("ICSR");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);
	}

	@Test
	public void filterLiteraturesByBusinessUnit() {
		listLiteItemsPage.navigateToListLitItemsPage();

		listLiteItemsPage.filterByBusinessUnit("Testing-BU");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(6000);
	}

	@Test
	public void filterLiteraturesByClaims() {
		listLiteItemsPage.navigateToListLitItemsPage();

		listLiteItemsPage.filterByClaims("Claimed by me");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);
	}

	// @Test
	public void filterLiteratures() {
		listLiteItemsPage.navigateToListLitItemsPage();
//		listLiteItemsPage.filterByActivity("Triage");
//		threadwait(3000);
//		listLiteItemsPage.clearFilter();
//		threadwait(5000);

		listLiteItemsPage.filterByClassification("Duplicate");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);

		listLiteItemsPage.filterByBusinessUnit("Testing-BU");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(6000);

		listLiteItemsPage.filterByClaims("Unclaimed");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);

		listLiteItemsPage.filterByClaims("Claimed by me");
		threadwait(3000);
		listLiteItemsPage.clearFilter();
		threadwait(5000);

	}

}
