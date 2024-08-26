package com.it360.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.it360.qa.Pages.CheckoutPage;
import com.it360.qa.Pages.DashboardPage;
import com.it360.qa.Pages.Homepage;
import com.it360.qa.Pages.LoginPage;
import com.it360.qa.TestBase.TestBase;

public class PaymentTest extends TestBase{
	
	public PaymentTest() throws IOException {
		super();
	}
	
	public WebDriver driver;
	public LoginPage loginpage;
	public Homepage homepage;
	public DashboardPage dashboardpage;
	public CheckoutPage checkoutpage;
	
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browser"));
		homepage = new Homepage(driver);
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		checkoutpage = new CheckoutPage(driver);
		
		homepage.clickOnLoginButton();
		loginpage.enterUsername(prop.getProperty("username"));
		loginpage.enterPassword(prop.getProperty("password"));
		loginpage.clickOnLoginButton();
		homepage.clickOnDropDownAccount();
		Assert.assertTrue(loginpage.logoutButtonIsDisplayed());
	}
	
	@Test (priority =1)
	public void verifySuccessfulPurchaseOfValidProduct() {
		homepage.clickOnDashboardButton();
		dashboardpage.clickOnOfferedAcademiesSection();
		dashboardpage.clickOnSubscribeToChosenProduct();
		checkoutpage.clickOnPaymentCheckbox();
		checkoutpage.clickOnPlaceOrderButton();
		
		checkoutpage.switchToiFramePayment();
		checkoutpage.insertCardNumberTextBox(dataProp.getProperty("invalidCreditCard"));
		checkoutpage.insertExpDateTextBox(dataProp.getProperty("validMonthEx"));
		checkoutpage.insertCvcTextBox(dataProp.getProperty("validCVC"));
		checkoutpage.switchToDefault();
		checkoutpage.clickOnPaymentButton();
		Assert.assertTrue(checkoutpage.cardInvalidWarningMessageIsDisplayed());
		
	}
	
	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}

}
