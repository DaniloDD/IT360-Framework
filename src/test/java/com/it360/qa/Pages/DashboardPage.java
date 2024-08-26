package com.it360.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	public WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Offered Academies")
	private WebElement offeredAcademiesSection;
	
	@FindBy (xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[1]/form/div/button")
	private WebElement subscribeToChosenProduct;
	
	public void clickOnOfferedAcademiesSection() {
		offeredAcademiesSection.click();
	}
	
	public void clickOnSubscribeToChosenProduct() {
		subscribeToChosenProduct.click();
	}

}
