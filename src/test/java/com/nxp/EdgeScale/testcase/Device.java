package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class Device extends CaseBase {

	private DriverBase driverBase;
	private DevicePagePro devicePagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(Device.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		devicePagePro = new DevicePagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		handleCookie.setCookie();
		
	}
	
	@BeforeMethod
	public void afterMethod() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 0)
	public void testAddTagToDevice() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("添加tag开始");
		devicePagePro.addTagToDevice(new ProUtil(Common.PARAMETER).getPro("device_add_tag_newTag"));
		logger.info("添加tag结束");
		devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("添加tag成功");
	}

	@Test(priority = 1)
	public void testDeleteTagFromDevice() {
		logger.info("删除tag开始");
		devicePagePro.deleteTag();
		logger.info("删除tag结束");
		devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除tag成功");
	}

	@Test(priority = 2)
	public void testInactiveDevice() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("取消注册device开始");
		devicePagePro.inactiveDevice();
		logger.info("取消注册device结束");
		devicePagePro.verifyTopNotice(new ProUtil(Common.PARAMETER).getPro("device_inactive_active_notice"));
		logger.info("取消注册device成功");
	}

	@Test(priority = 3)
	public void testActiveDevice() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("注册device开始");
		devicePagePro.activeDevice();
		logger.info("注册device结束");
		devicePagePro.verifyTopNotice(new ProUtil(Common.PARAMETER).getPro("device_inactive_active_notice"));
		logger.info("注册device成功");
	}

	@Test(priority = 4)
	public void testBindTag() {
		logger.info("bind tag开始");
		devicePagePro.bingTag(new ProUtil(Common.PARAMETER).getPro("device_bind_tag_tag"));
		logger.info("bind tag结束");
		devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("bind tag成功");
	}

	@Test(priority = 5)
	public void testDeleteDevice() {
		logger.info("删除device开始");
		devicePagePro.deleteDevice();
		logger.info("删除device结束");
		devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除device成功");
	}

	@AfterClass
	public void close() {
		driverBase.close();
	}

}
