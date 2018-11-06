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
import com.nxp.EdgeScale.business.CreateDevicePagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class CreateDevice extends CaseBase {

	private DriverBase driverBase;
	public HandleCookie handleCookie;
	private CreateDevicePagePro createDevicePagePro;

	
	private static Logger logger = Logger.getLogger(CreateDevice.class);
	
	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("CreateDevice init()...");
		this.driverBase = initDriver(Common.BROWSER);
		this.driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.createDevicePagePro = new CreateDevicePagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.DEVICE_CREATE);
		handleCookie.setCookie_commonUser1();
		driverBase.get(Url.BASE_URL + Url.DEVICE_CREATE);
		
	}
	
	@Test(groups = "createDevice")
	public void testCreateDevice1() {
		logger.info("start testCreateDevice1...");
		this.driverBase.get(Url.BASE_URL + Url.DEVICE_CREATE);
		
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createDevicePagePro.createDevice(proUtil.getPro("create_device_SN"), proUtil.getPro("create_device_model"));
		logger.info("end testCreateDevice1 !");
		//createDevicePagePro.verifyNotice(proUtil.getPro("login_success_notice"));
		//logger.info("创建device成功");
		ThreadTime.sleep(3000);
	}
	@Test(groups = "createDevice")
	public void testCreateDevice2() {
		this.driverBase.get(Url.BASE_URL + Url.DEVICE_CREATE);
		
		logger.info("start testCreateDevice2...");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createDevicePagePro.createDevice(proUtil.getPro("create_device_SN_2"), proUtil.getPro("create_device_model_2"));
		logger.info("end testCreateDevice2 !");
		//createDevicePagePro.verifyNotice(proUtil.getPro("login_success_notice"));
		logger.info("创建device成功");
		ThreadTime.sleep(3000);
	}
	
	@AfterClass(alwaysRun = true)
	public void close() {
		driverBase.close();
	}

}
