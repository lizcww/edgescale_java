package com.nxp.EdgeScale.util;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.nxp.EdgeScale.BaseDriver;
import com.nxp.EdgeScale.base.CaseBase;

public class TestngListenerScreen extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		CaseBase baseDriver = (CaseBase) (tr.getInstance());
		takeScreenShot(baseDriver.getDriverBase().driver, tr.getInstance().getClass().getSimpleName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		super.onTestSkipped(arg0);
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		super.onTestSuccess(arg0);
	}

	/**
	 * 截图
	 * 
	 * @param driver
	 */
	private void takeScreenShot(WebDriver driver, String className) {
		// 获取当前时间戳
		String dateTime = new SimpleDateFormat("yyyyMMddmmss").format(Calendar.getInstance().getTime());
		// 拼接路径
		String ScreenPath = System.getProperty("user.dir") + "/fail_screenshot/" + className + "_" + dateTime + ".png";
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// 把截图保存在指定路径
			FileUtils.copyFile(screenShot, new File(ScreenPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
