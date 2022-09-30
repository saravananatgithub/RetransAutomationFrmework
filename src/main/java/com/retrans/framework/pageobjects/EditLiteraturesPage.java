package com.retrans.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditLiteraturesPage extends BasePage {

	@FindBy(xpath = "//button[@id='litPanel:userNotesListForm:createNote']")
	private WebElement createNotesButton;

	@FindBy(xpath = "//button[@id='litPanel:userNotesListForm:createNote']")
	private WebElement createActionButton;

	public EditLiteraturesPage(WebDriver driver) {
		super(driver);
	}

	public void createNotes(String title, String description) {
		//createNotesButton.click();
		driver.findElement(By.xpath("//button[@id='litPanel:userNotesListForm:createNote']")).click();
		CreateNotesPage notesPage = new CreateNotesPage(driver);
		notesPage.addNotes(title, description);
		threadwait(3000);
	}

	public void createAction(String title, String description) {
		createActionButton.click();
		CreateActionsPage actionsPage = new CreateActionsPage(driver);
		actionsPage.createAction(title, description);
	}

}
