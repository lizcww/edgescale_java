package com.nxp.EdgeScale;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.nxp.EdgeScale.base.SelectDriver;

public class BaseDriver {
	
	protected WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("-----  beforeClass  -----");
		// 初始化driver
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
		//driver = new ChromeDriver();
		new SelectDriver().driverName(Common.BROWSER);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("-----  afterClass  -----");
	}
	
}
