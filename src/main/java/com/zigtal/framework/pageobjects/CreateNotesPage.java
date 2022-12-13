package com.zigtal.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNotesPage extends BasePage {

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:title']")
	private WebElement inputNotesTitle;

	@FindBy(xpath = "//input[@id='litPanel:createUserNotesForm:notes']")
	private WebElement inputDescription;

	@FindBy(xpath = "//button[@id='litPanel:createUserNotesForm:saveNote']//span[@class='ui-button-text ui-c'][normalize-space()='Save']")
	private WebElement saveNotesButton;

	private String addSupportingDocButtonXpath = "//input[@id='litPanel:createUserNotesForm:supDocUserNotes_input']";

	private String uploadButtonXpath = "//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-fileupload-upload']//span[@class='ui-button-text ui-c'][normalize-space()='Upload']";

	public CreateNotesPage(WebDriver driver) {
		super(driver);
	}

	public void addNotes(String title, String description, String attachmentFilePath) {

		if (attachmentFilePath != null && !"".equals(attachmentFilePath)) {
			driver.findElement(By.xpath(addSupportingDocButtonXpath)).sendKeys(attachmentFilePath);
			threadwait(3000);
			driver.findElement(By.xpath(uploadButtonXpath)).click();
			threadwait(5000);
		}

		driver.findElement(By.xpath("//input[@id='litPanel:createUserNotesForm:title']")).sendKeys(title);

		driver.findElement(By.xpath("//textarea[@id='litPanel:createUserNotesForm:notes']")).sendKeys(description);

		driver.findElement(By.xpath(
				"//button[@id='litPanel:createUserNotesForm:saveNote']//span[@class='ui-button-text ui-c'][normalize-space()='Save']"))
				.click();
	}

}
