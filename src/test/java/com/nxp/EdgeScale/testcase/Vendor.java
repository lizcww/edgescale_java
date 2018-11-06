package com.nxp.EdgeScale.testcase;

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
import com.nxp.EdgeScale.business.MirrorPagePro;
import com.nxp.EdgeScale.business.VendorPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class Vendor extends CaseBase {

	private DriverBase driverBase;
	private VendorPagePro vendorPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(Vendor.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		vendorPagePro = new VendorPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.VENDOR);
		handleCookie.setCookie_rootUser1();
		driverBase.get(Url.BASE_URL + Url.VENDOR);
	}

	@Test(groups = {"createVendor"})
	public void testCreateVendor() {
		driverBase.get(Url.BASE_URL + Url.VENDOR);
		ThreadTime.sleep(5000);
		logger.info("创建vendor开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		vendorPagePro.createVendor(proUtil.getPro("vendor_create_name_3"));
		logger.info("创建vendor结束");
		vendorPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("创建vendor成功");
	}

	@Test(groups = {"editVendor"})
	public void testEditVendor() {
		driverBase.get(Url.BASE_URL + Url.VENDOR);
		ThreadTime.sleep(5000);
		logger.info("修改vendor开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		vendorPagePro.editVendor(proUtil.getPro("vendor_edit_name"));
		logger.info("修改vendor结束");
		vendorPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("修改vendor成功");
	}

	@Test(groups = {"deleteVendor"})
	public void testDeleteVendor() {
		driverBase.get(Url.BASE_URL + Url.VENDOR);
		ThreadTime.sleep(5000);
		logger.info("删除vendor开始");
		vendorPagePro.deleteVendor();
		logger.info("删除vendor结束");
		vendorPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除vendor成功");
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driverBase.close();
	}

}
