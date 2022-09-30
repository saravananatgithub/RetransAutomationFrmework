package com.retrans.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver = null;
	

	@FindBy(id = "appUserLoginForm:loginUserId")
	private WebElement userNameElement;

	@FindBy(id = "appUserLoginForm:loginPassword")
	private WebElement passwordElement;

	@FindBy(css = ".ui-button-text.ui-c")
	private WebElement loginButton;

	@FindBy(css = "td[class='topnavbar-links'] a[rel='noopener']")
	private WebElement logoutElement;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//System.out.println("------logoutElement::::::" + logoutElement);
	}

	
	public ListLiteraturesPage login() {
		userNameElement.sendKeys("Test_User");
		passwordElement.sendKeys("Test@123");
		loginButton.click();
		return new ListLiteraturesPage(driver);
	}

}
