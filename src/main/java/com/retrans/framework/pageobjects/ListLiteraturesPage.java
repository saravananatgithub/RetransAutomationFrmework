package com.retrans.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.retrans.test.TestBase;

public class ListLiteraturesPage extends BasePage {
	@FindBy(xpath = "//span[contains(text(),'Test_User')]")
	private WebElement testUserLink;

	@FindBy(xpath = "//span[normalize-space()='Logout']")
	private WebElement logoutElement;

	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:classificationid_label']/following::span[1]")
	private WebElement filterByClassification;

	@FindBy(xpath = "//span[normalize-space()='Claim']")
	private WebElement claimButton;
	
	@FindBy(xpath = "//span[@class='ui-button-icon-left ui-icon ui-c fa fa-check Fs16 white']")
	private WebElement dialogYesButton;

	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:comUnitfilid_label']/following::span[1]")
	private WebElement filterByBusinessUnit;

	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:claimid_label']/following::span[1]")
	private WebElement filterByClaims;
	
	@FindBy(xpath = "//label[@id='literaturListForm:literatureItemsGrid:statusid_label']/following::span[1]")
	private WebElement filterByActivity;

	@FindBy(xpath = "//span[normalize-space()='Clear']")
	private WebElement clearFilterElement;

	public ListLiteraturesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		System.out.println("logoutElement::::::" + logoutElement);
	}

	public void clearFilter() {
		clearFilterElement.click();
	}

	public void closeLiteratureDialog() {
		threadwait(3000);
		String xpath = "//span[contains(text(),'Close')]/preceding::button[@title='Close' and @role='button' and contains(@id,'readOnlyLitItemNotDupForm:j')]";
		// waituntilElementLocated(By.xpath(xpath));
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (Throwable th) {
			System.out.println("-------##############____________________");
			th.printStackTrace();
			driver.findElement(By.xpath(xpath)).click();

		}
	}

	public void claimSelectedLiteratureItems() {
		claimButton.click();
		threadwait(5000);
		dialogYesButton.click();
	}

	public void selectLiteratureByCheckBox(String litName) {
		String xpath = "//span[text()='" + litName + "']/preceding::td[@class='ui-selection-column'][1]";
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public EditLiteraturesPage editLiterature(String litName) {
		String xpath = "//span[text()='" + litName + "']/preceding::td[1]/button/span[1]";
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
		return new EditLiteraturesPage(driver);
	}

	public void clickLiteratureByName(String litName) {
		String xpath = "//span[contains(text(),'" + litName + "')]";
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterByActivity(String activityValue) {
		String xpath = "//td[normalize-space()='" + activityValue + "']";
		filterByActivity.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterByClassification(String classificationValue) {
		String xpath = "//tr[@data-label='" + classificationValue + "']/td";
		filterByClassification.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterByClaims(String claimStatus) {
		String xpath = "//td[normalize-space()='" + claimStatus + "']";
		filterByClaims.click();
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
	}

	public void filterByBusinessUnit(String businessUnit) {
		filterByBusinessUnit.click();
		String xpath = "//tr[@data-label='" + businessUnit + "']/td";
		waituntilElementLocated(By.xpath(xpath));
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("logoutElement::::::" + logoutElement);
	}

	public void logout() {

		testUserLink.click();
		logoutElement.click();

	}

	public void navigateToListLitItemsPage() {
		driver.get("http://" + TestBase.hostIP + "/" + TestBase.context + "/views/literatureItems/list.xhtml");
		threadwait(4000);

	}

}
