package com.it360.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.it360.qa.Pages.Homepage;
import com.it360.qa.Pages.LoginPage;
import com.it360.qa.TestBase.TestBase;
import com.it360.qa.TestData.ExcelCode;

public class LoginTest extends TestBase{
	
	public WebDriver driver;
	public Homepage homepage;
	public LoginPage loginpage;

	public LoginTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browser"));
		homepage = new Homepage(driver);
		loginpage = new LoginPage(driver);
		homepage.clickOnLoginButton();
	}
	
	@Test (priority=1, dataProvider = "LoginIT360", dataProviderClass = ExcelCode.class)
	public void verifyLoginWithValidCredentials(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickOnLoginButton();
		homepage.clickOnDropDownAccount();
		Assert.assertTrue(loginpage.logoutButtonIsDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
