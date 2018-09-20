package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.CreateAppPagePro;
import com.nxp.EdgeScale.business.CreateDevicePagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateApp extends CaseBase {

	private DriverBase driverBase;
	private CreateAppPagePro createAppPagePro;
	public HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(CreateApp.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		createAppPagePro = new CreateAppPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.APP_CREATE);
		handleCookie.setCookie();
		driverBase.get(Url.BASE_URL + Url.APP_CREATE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateDevice() {
		logger.info("创建app开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createAppPagePro.createApp(proUtil.getPro("create_app_appName"),proUtil.getPro("create_app_desc"),proUtil.getPro("create_app_image_path"), proUtil.getPro("create_app_registry"),
				proUtil.getPro("create_app_imageName"));
		logger.info("创建app结束");
		createAppPagePro.vertifyRightNotice(proUtil.getPro("login_success_notice"));
		logger.info("创建app成功");
	}
	
	@AfterClass
	public void close() {
		driverBase.close();
	}

}
