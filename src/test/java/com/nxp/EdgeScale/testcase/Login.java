package com.nxp.EdgeScale.testcase;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.business.LoginPagePro;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.TestngListenerScreen;

@Listeners({ TestngListenerScreen.class })
public class Login extends CaseBase {

	private DriverBase driverBase;
	private LoginPagePro loginPagePro;
	private DevicePagePro devicePagePro;

	private static Logger logger = Logger.getLogger(Login.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPagePro = new LoginPagePro(driverBase);
		devicePagePro = new DevicePagePro(driverBase);
	}

	@Test
	public void testLogin() {
		logger.info("登录开始");
		driverBase.get(Url.BASE_URL + Url.LOGIN);
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		loginPagePro.login(proUtil.getPro("username"), proUtil.getPro("password"));
		logger.info("登录结束");
		loginPagePro.vertifyLoginNotice(proUtil.getPro("login_success_notice"));
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(devicePagePro.vertifyUsername(proUtil.getPro("username")));
		logger.info("登录成功");
		devicePagePro.logout();
		logger.info("退出登录");
		loginPagePro.vertifyLoginNotice(proUtil.getPro("logout_notice"));
		logger.info("退出登录成功");
	}

	@Test
	public void testLoginFail() {
		logger.info("登录开始");
		driverBase.get(Url.BASE_URL + Url.LOGIN);
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		loginPagePro.login(proUtil.getPro("username"), proUtil.getPro("wrongPassword"));
		logger.info("登录结束");
		loginPagePro.vertifyLoginNotice(proUtil.getPro("login_fail_notice"));
		logger.info("登录失败");
	}

	@AfterClass
	public void close() {
		driverBase.close();
	}

}
