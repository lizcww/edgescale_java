package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class Device extends CaseBase {

	private DriverBase driverBase;
	private DevicePagePro devicePagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(Device.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Device init()...");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		devicePagePro = new DevicePagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		handleCookie.setCookie_commonUser1();
		driverBase.get(Url.BASE_URL + Url.DEVICE);
	}

	@Test(groups = "addDeviceTag", dependsOnGroups = { "createDevice" })
	public void testAddTagToDevice1_1() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		
		ThreadTime.sleep(3000);
		logger.info("添加tag开始 testAddTagToDevice1_1...");
		devicePagePro.addTagToDevice(1, new ProUtil(Common.PARAMETER).getPro("device_add_tag_tag1"));
		logger.info("添加tag结束");
		//devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("添加tag成功");
	}
	
	@Test(groups = "addDeviceTag", dependsOnGroups = { "createDevice" })
	public void testAddTagToDevice1_2() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		
		ThreadTime.sleep(3000);
		logger.info("添加tag开始 testAddTagToDevice1_2...");
		devicePagePro.addTagToDevice(1, new ProUtil(Common.PARAMETER).getPro("device_add_tag_tag2"));
		logger.info("添加tag结束");
		//devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("添加tag成功");
	}
	
	@Test(groups = "addDeviceTag", dependsOnGroups = { "createDevice" })
	public void testAddTagToDevice2_1() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		
		ThreadTime.sleep(3000);
		logger.info("添加tag开始 testAddTagToDevice2_1...");
		devicePagePro.addTagToDevice(2, new ProUtil(Common.PARAMETER).getPro("device_add_tag_tag3"));
		logger.info("添加tag结束");
		//devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("添加tag成功");
	}
	
	@Test(groups = "addDeviceTag", dependsOnGroups = { "createDevice" })
	public void testAddTagToDevice2_2() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		
		ThreadTime.sleep(3000);
		logger.info("添加tag开始 testAddTagToDevice2_2...");
		devicePagePro.addTagToDevice(2, new ProUtil(Common.PARAMETER).getPro("device_add_tag_tag4"));
		logger.info("添加tag结束");
		//devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("添加tag成功");
	}
	
	@Test(groups = {"deleteDeviceTag"}, dependsOnGroups = { "addDeviceTag" })
	public void testDeleteTagFromDevice() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		ThreadTime.sleep(3000);
		logger.info("testDeleteTagFromDevice start...");
		devicePagePro.deleteTag();
		logger.info("testDeleteTagFromDevice end!");
		devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("testDeleteTagFromDevice succeed!");
	}
	
	@Test(groups = {"bindDeviceTag"}, dependsOnGroups = { "createDevice" })
	public void testBindDeviceTag() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		ThreadTime.sleep(3000);
		logger.info("bind tag开始");
		devicePagePro.bingTag(new ProUtil(Common.PARAMETER).getPro("device_bind_tag_tag"));
		logger.info("bind tag结束");
		devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("bind tag成功");
	}

	@Test(groups = {"inactiveDevice"}, dependsOnGroups = { "bindDeviceTag" })
	public void testInactiveDevice() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		ThreadTime.sleep(3000);
		logger.info("testInactiveDevice start...");
		devicePagePro.inactiveDevice();
		logger.info("testInactiveDevice end!");
		//devicePagePro.verifyTopNotice(new ProUtil(Common.PARAMETER).getPro("device_inactive_active_notice"));
		//logger.info("testInactiveDevice succeed!");
	}

	@Test(groups = {"activeDevice"}, dependsOnGroups = { "inactiveDevice" })
	public void testActiveDevice() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		ThreadTime.sleep(3000);
		logger.info("testActiveDevice start...");
		devicePagePro.activeDevice();
		logger.info("testActiveDevice end!");
		devicePagePro.verifyTopNotice(new ProUtil(Common.PARAMETER).getPro("device_inactive_active_notice"));
		logger.info("testActiveDevice succeed!");
	}

	@Test(groups = {"deleteDevice"}, dependsOnGroups = { "deleteDeviceTag", "activeDevice", "inactiveDevice"}, alwaysRun = true)
	public void testDeleteDevice1() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		ThreadTime.sleep(3000);
		logger.info("删除device开始");
		devicePagePro.deleteDevice();
		logger.info("删除device结束");
		devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除device成功");
	}
	
	@Test(groups = {"deleteDevice"}, dependsOnGroups = { "deleteDeviceTag", "activeDevice", "inactiveDevice"}, alwaysRun = true)
	public void testDeleteDevice2() {
		driverBase.get(Url.BASE_URL + Url.DEVICE);
		ThreadTime.sleep(3000);
		logger.info("删除device开始");
		devicePagePro.deleteDevice();
		logger.info("删除device结束");
		devicePagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除device成功");
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driverBase.close();
	}

}
