package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.CreateDevicePagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateDevice extends CaseBase {

	private DriverBase driverBase;
	private CreateDevicePagePro createDevicePagePro;
	public HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(CreateDevice.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		createDevicePagePro = new CreateDevicePagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.DEVICE_CREATE);
		handleCookie.setCookie();
		driverBase.get(Url.BASE_URL + Url.DEVICE_CREATE);
		
	}

	@Test
	public void testCreateDevice() {
		logger.info("创建device开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createDevicePagePro.createDevice(proUtil.getPro("create_device_SN"), proUtil.getPro("create_device_model"));
		logger.info("创建device结束");
		createDevicePagePro.vertifyNotice(proUtil.getPro("login_success_notice"));
		logger.info("创建device成功");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void close() {
		driverBase.close();
	}

}
