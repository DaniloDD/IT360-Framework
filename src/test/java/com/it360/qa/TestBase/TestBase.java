package com.it360.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {
	
	public WebDriver driver;
	public FileInputStream ip1;
	public FileInputStream ip2;
	public Properties prop;
	public Properties dataProp;
	
	public TestBase() throws IOException {
		prop = new Properties();
		try {
			ip1 = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/it360/qa/Config/config.properties");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		prop.load(ip1);
		
		dataProp = new Properties();
		try {
			ip2 = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/it360/qa/TestData/dataProp.properties");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		dataProp.load(ip2);
	}
	
	public WebDriver initializeBrowser(String browserName) {
		if (browserName.equals("Chrome")) {
			ChromeOptions op = new ChromeOptions();
			op.setPageLoadStrategy(PageLoadStrategy.EAGER);
			op.addArguments("--start-maximized");
			op.addArguments("--incognito");
			driver = new ChromeDriver(op);
		}
		else if (browserName.equals("Safari")) {
			driver = new SafariDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else {
			System.out.println("The browser name is incorrect.");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
