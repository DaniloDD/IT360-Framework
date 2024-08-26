package com.it360.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement usernameTextBox;
	
	@FindBy (id="user_pass")
	private WebElement passwordTextBox;
	
	@FindBy (id="wp-submit")
	private WebElement loginButton;
	
	@FindBy (linkText = "Logout")
	private WebElement logoutButton;
	
	public void enterUsername(String username) {
		usernameTextBox.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public boolean logoutButtonIsDisplayed() {
		return logoutButton.isDisplayed();
	}
}
