package com.nxp.EdgeScale.base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {

	/**
	 * 根据浏览器类型创建WebDriver
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver driverName(String browser) {
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver.exe");
			return new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
			return new ChromeDriver();
		}
	}

}
