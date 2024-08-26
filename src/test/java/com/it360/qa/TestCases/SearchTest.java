package com.it360.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.it360.qa.Pages.Homepage;
import com.it360.qa.Pages.SearchPage;
import com.it360.qa.TestBase.TestBase;

public class SearchTest extends TestBase{

	public SearchTest() throws IOException {
		super();
	}
	
	public WebDriver driver;
	public Homepage homepage;
	public SearchPage searchpage;
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowser(prop.getProperty("browser"));
		homepage = new Homepage(driver);
		searchpage = new SearchPage(driver);
		
	}
	
	@Test
	public void verifySearchOfValidProduct() {
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
