package com.retrans.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditLiteraturesPage extends BasePage {

	@FindBy(xpath = "//button[@id='litPanel:userNotesListForm:createNote']")
	private WebElement createNotesButton;

	@FindBy(xpath = "//button[@id='litPanel:actionListForm:createAction']")
	private WebElement createActionButton;

	//

	@FindBy(xpath = "//a[normalize-space()='Actions']")
	private WebElement actionTab;

	public EditLiteraturesPage(WebDriver driver) {
		super(driver);
	}

	public void createNotes(String title, String description, String attachmentFilePath) {
		driver.findElement(By.xpath("//button[@id='litPanel:userNotesListForm:createNote']")).click();
		CreateNotesPage notesPage = new CreateNotesPage(driver);
		notesPage.addNotes(title, description, attachmentFilePath);
		threadwait(3000);
	}

	public void createAction(String title, String status, String fromDate, String fromMonth, String fromYear,
			String toDate, String toMonth, String toYear) {
		driver.findElement(By.xpath("//a[normalize-space()='Actions']")).click();
		threadwait(5000);
		driver.findElement(By.xpath("//button[@id='litPanel:actionListForm:createAction']")).click();
		CreateActionsPage actionsPage = new CreateActionsPage(driver);
		actionsPage.createAction(title, status, fromDate, fromMonth, fromYear, toDate, toMonth, toYear);

	}

}
