package com.it360.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	public WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Log in")
	private WebElement loginButton;
	
	@FindBy(id="gk-login-toggle") 
	private WebElement dropDownAccount;
	
	@FindBy (id="search_course")
	private WebElement searchBar;
	
	@FindBy (xpath = "//*[@id=\"primary_menu\"]/nav[1]/form/button")
	private WebElement searchButton;
	
	@FindBy (linkText = "Dashboard")
	private WebElement dashboardButton;
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnDropDownAccount() {
		dropDownAccount.click();
	}
	
	public void clicOnSearchBar() {
		searchBar.click();
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void insertProductInSearchBar(String product) {
		searchBar.sendKeys(product);
	}
	
	public void clickOnDashboardButton() {
		dashboardButton.click();
	}
}
