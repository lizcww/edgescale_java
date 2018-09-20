package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.MirrorPagePro;
import com.nxp.EdgeScale.business.VendorPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class Vendor extends CaseBase {

	private DriverBase driverBase;
	private VendorPagePro vendorPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(Vendor.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vendorPagePro = new VendorPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.VENDOR);
		handleCookie.setCookie();
	}
	

	@BeforeMethod
	public void afterMethod() {
		driverBase.get(Url.BASE_URL + Url.VENDOR);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 0)
	public void testCreateVendor() {
		logger.info("创建vendor开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		vendorPagePro.createVendor(proUtil.getPro("vendor_create_name"));
		logger.info("创建vendor结束");
		vendorPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("创建vendor成功");
	}

	@Test(priority = 1)
	public void testEditVendor() {
		logger.info("修改vendor开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		vendorPagePro.editVendor(proUtil.getPro("vendor_edit_name"));
		logger.info("修改vendor结束");
		vendorPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("修改vendor成功");
	}

	@Test(priority = 2)
	public void testDeleteVendor() {
		logger.info("删除vendor开始");
		vendorPagePro.deleteVendor();
		logger.info("删除vendor结束");
		vendorPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除vendor成功");
	}

	@AfterClass
	public void close() {
		driverBase.close();
	}

}
