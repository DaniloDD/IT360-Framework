package com.it360.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"learn-press-payment\"]/ul/li/label")
	private WebElement paymentCheckbox;
	
	@FindBy (id="learn-press-checkout-place-order")
	private WebElement placeOrderButton;
	
	@FindBy(xpath = "//*[@id=\"card-element\"]/div/iframe")
	private WebElement iframePayment;
	
	@FindBy (name="cardnumber")
	private WebElement cardNumberTextBox;
	
	@FindBy (name="exp-date")
	private WebElement expDateTextBox;
	
	@FindBy (name="cvc")
	private WebElement cvcTextBox;
	
	@FindBy(id="payment-button")
	private WebElement paymentButton;
	
	@FindBy (id="card-errors")
	private WebElement cardInvalidWarningMessage;

	public void clickOnPaymentCheckbox() {
		paymentCheckbox.click();
	}
	
	public void clickOnPlaceOrderButton() {
		placeOrderButton.submit();
	}
	
	public void switchToiFramePayment() {
		driver.switchTo().frame(iframePayment);
	}
	
	public void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	
	public void insertCardNumberTextBox(String cardNumber) {
		cardNumberTextBox.sendKeys(cardNumber);
	}
	
	public void insertExpDateTextBox(String expDate) {
		expDateTextBox.sendKeys(expDate);
	}
	
	public void insertCvcTextBox(String cvc) {
		cvcTextBox.sendKeys(cvc);
	}
	
	public void clickOnPaymentButton() {
		paymentButton.submit();
	}
	
	public boolean cardInvalidWarningMessageIsDisplayed() {
		return cardInvalidWarningMessage.isDisplayed();
	}
}
