package com.retrans.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateActionsPage extends BasePage {

	public CreateActionsPage(WebDriver driver) {
		super(driver);
	}

	public void createAction(String title, String status, String fromDate, String fromMonth, String fromYear,
			String toDate, String toMonth, String toYear) {
		driver.findElement(By.xpath("//label[@id='litPanel:createActionForm:title_label']")).click();
		threadwait(2000);
		driver.findElement(By.xpath("//td[normalize-space()='" + title + "']")).click();
		threadwait(2000);

		driver.findElement(By.xpath("//label[@id='litPanel:createActionForm:status_label']")).click();
		threadwait(2000);
		driver.findElement(By.xpath("//tr[contains(@id,'createActionForm:status')]/td[text()='" + status + "']"))
				.click();
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='litPanel:createActionForm:plannedStartDate_input']")).sendKeys("");
		threadwait(3000);

		Select drpMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonth.selectByVisibleText(fromMonth);

		Select drpYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYear.selectByVisibleText(fromYear);
		threadwait(3000);
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + fromDate + "']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//input[@id='litPanel:createActionForm:plannedEndDate_input']")).sendKeys("");
		threadwait(3000);

		drpMonth = new Select(driver.findElement(By.className("ui-datepicker-month")));
		drpMonth.selectByVisibleText(toMonth);

		drpYear = new Select(driver.findElement(By.className("ui-datepicker-year")));
		drpYear.selectByVisibleText(toYear);
		threadwait(3000);

		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + toDate + "']")).click();
		threadwait(3000);

		driver.findElement(By.xpath("//button[@id='litPanel:createActionForm:saveAction']")).click();
		threadwait(3000);
	}
}
