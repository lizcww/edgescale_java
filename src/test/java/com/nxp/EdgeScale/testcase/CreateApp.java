package com.nxp.EdgeScale.testcase;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.CreateAppPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class CreateApp extends CaseBase {

	private DriverBase driverBase;
	private CreateAppPagePro createAppPagePro;
	public HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(CreateApp.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		createAppPagePro = new CreateAppPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.APP_CREATE);
		handleCookie.setCookie_commonUser1();
		driverBase.get(Url.BASE_URL + Url.APP_CREATE);
		ThreadTime.sleep(3000);
	}
	
	@Test(groups = {"createApp"})
	public void testCreateApp_1() {
		driverBase.get(Url.BASE_URL + Url.APP_CREATE);
		ThreadTime.sleep(5000);
		logger.info("创建app开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createAppPagePro.createApp(proUtil.getPro("create_app_appName_1"),
				proUtil.getPro("create_app_desc_1"),
				System.getProperty("user.dir") + File.separator + "images" + File.separator + proUtil.getPro("create_app_image_path_1"), 
				proUtil.getPro("create_app_registry_1"),
				proUtil.getPro("create_app_imageName_1"));
		logger.info("创建app结束");
		//createAppPagePro.verifyRightNotice(proUtil.getPro("login_success_notice"));
		logger.info("创建app成功");
	}
	
	@Test(groups = {"createApp"})
	public void testCreateApp_2() {
		driverBase.get(Url.BASE_URL + Url.APP_CREATE);
		ThreadTime.sleep(5000);
		logger.info("创建app开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createAppPagePro.createApp(proUtil.getPro("create_app_appName_2"),
				proUtil.getPro("create_app_desc_2"),
				System.getProperty("user.dir") + File.separator + "images" + File.separator + proUtil.getPro("create_app_image_path_2"), 
				proUtil.getPro("create_app_registry_2"),
				proUtil.getPro("create_app_imageName_2"));
		logger.info("创建app结束");
		createAppPagePro.verifyRightNotice(proUtil.getPro("login_success_notice"));
		logger.info("创建app成功");
		ThreadTime.sleep(3000);
	}
	
	//@Test(groups = {"createApp"})
	public void testCreateApp_3() {
		driverBase.get(Url.BASE_URL + Url.APP_CREATE);
		ThreadTime.sleep(5000);
		logger.info("创建app开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createAppPagePro.createApp(proUtil.getPro("create_app_appName_3"),
				proUtil.getPro("create_app_desc_3"),
				System.getProperty("user.dir") + File.separator + "images" + File.separator + proUtil.getPro("create_app_image_path_3"), 
				proUtil.getPro("create_app_registry_3"),
				proUtil.getPro("create_app_imageName_3"));
		logger.info("创建app结束");
		createAppPagePro.verifyRightNotice(proUtil.getPro("login_success_notice"));
		logger.info("创建app成功");
	}
	
	@AfterClass(alwaysRun = true)
	public void close() {
		driverBase.close();
	}

}
