package com.it360.qa.Utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReporter() {
		ExtentReports extentReports = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+ "/test-output/ExtentReports/extentreportsIT360.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Test IT360");
		sparkReporter.config().setReportName("Test Cases IT360");
		
		extentReports.attachReporter(sparkReporter);
	
		extentReports.setSystemInfo("Browser name", "Chrome");
		extentReports.setSystemInfo("URL", "");
		// add more info if needed
		
		return extentReports;
	}
}





/*
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\tutorialsninja\\qa\\ConfigData\\config.properties");
		try {
			prop.load(ip);
			extentReport.setSystemInfo("application url", prop.getProperty("url"));
			extentReport.setSystemInfo("browser name", prop.getProperty("browser"));
			extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
			extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
			extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
			extentReport.setSystemInfo("SDET Name", prop.getProperty("user.name"));
			extentReport.setSystemInfo("Java Version", prop.getProperty("java.version"));
			extentReport.setSystemInfo("SDET CountryName", prop.getProperty("user.country"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return extentReport;

	}
*/