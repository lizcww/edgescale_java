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
import com.nxp.EdgeScale.business.ManageUserPagePro;
import com.nxp.EdgeScale.business.ModelPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class ManageUser extends CaseBase {

	private DriverBase driverBase;
	private ManageUserPagePro manageUserPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(ManageUser.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		manageUserPagePro = new ManageUserPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.USER);
		handleCookie.setCookie();
		driverBase.get(Url.BASE_URL + Url.USER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 0)
	public void testCreateUser() {
		logger.info("创建user开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		manageUserPagePro.createUser(proUtil.getPro("create_user_userName"), proUtil.getPro("create_user_email"));
		logger.info("创建user结束");
		manageUserPagePro.verifyTopNotice(new ProUtil(Common.PARAMETER).getPro("create_user_success_notice"));
		logger.info("创建user成功");
	}

	@Test(priority = 1)
	public void testUserSetting() {
		logger.info("user limit开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		manageUserPagePro.setLimit(proUtil.getPro("user_limitType"), proUtil.getPro("user_maxLimit"));
		logger.info("user limit结束");
		manageUserPagePro.verifyTopNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("user limit成功");
	}

	@AfterClass
	public void close() {
		driverBase.close();
	}

}
