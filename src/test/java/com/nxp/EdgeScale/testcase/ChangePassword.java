package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class ChangePassword extends CaseBase {

	private DriverBase driverBase;
	private DevicePagePro devicePagePro;
	public HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(ChangePassword.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		devicePagePro = new DevicePagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL);
		handleCookie.setCookie_commonUser1();
		driverBase.get(Url.BASE_URL);
	}

	@Test(groups = {"chagePassword"})
	public void testChangePassword() {
		logger.info("更改密码开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		devicePagePro.changePassword(proUtil.getPro("oldPassword"), proUtil.getPro("newPassword"));
		logger.info("更改密码结束");
		devicePagePro.verifyTopNotice(proUtil.getPro("changePassword_notice"));
		logger.info("更改密码成功");
	}

	@AfterClass(alwaysRun = true)
	public void changePasswordToOld() {
		driverBase.get(Url.BASE_URL);
		logger.info("还原密码开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		devicePagePro.changePassword(proUtil.getPro("newPassword"), proUtil.getPro("oldPassword"));
		logger.info("还原密码结束");
		devicePagePro.verifyTopNotice(proUtil.getPro("changePassword_notice"));
		logger.info("还原密码成功");
		driverBase.close();
	}
	
	

}
