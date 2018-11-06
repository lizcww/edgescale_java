package com.nxp.EdgeScale.testcase;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
import com.nxp.EdgeScale.util.ThreadTime;

@Listeners({ TestngListenerScreen.class })
public class Login extends CaseBase {

	private DriverBase driverBase;
	private LoginPagePro loginPagePro;
	private DevicePagePro devicePagePro;

	private static Logger logger = Logger.getLogger(Login.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPagePro = new LoginPagePro(driverBase);
		devicePagePro = new DevicePagePro(driverBase);
	}

	@Test(groups = {"login"})
	public void testLogin() {
		logger.info("testLogin start...");
		driverBase.get(Url.BASE_URL + Url.LOGIN);
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		loginPagePro.login(proUtil.getPro("username"), proUtil.getPro("password"));
		logger.info("testLogin end!");
		loginPagePro.verifyLoginNotice(proUtil.getPro("login_success_notice"));
		ThreadTime.sleep(8000);
		assertTrue(devicePagePro.verifyUsername(proUtil.getPro("username")));
		logger.info("testLogin succeed!");
		
	}
	
	@Test(groups = {"login"})
	public void testLogout() {
		logger.info("testLogin start...");
		driverBase.get(Url.BASE_URL + Url.LOGIN);
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		loginPagePro.login(proUtil.getPro("username"), proUtil.getPro("password"));
		logger.info("testLogin end!");
		loginPagePro.verifyLoginNotice(proUtil.getPro("login_success_notice"));
		ThreadTime.sleep(8000);
		assertTrue(devicePagePro.verifyUsername(proUtil.getPro("username")));
		logger.info("testLogin succeed!");
		devicePagePro.logout();
		logger.info("logout...");
		loginPagePro.verifyLoginNotice(proUtil.getPro("logout_notice"));
		logger.info("logout succeed!");
	}

	@Test(groups = {"login"})
	public void testLoginFail() {
		logger.info("testLoginFail start...");
		driverBase.get(Url.BASE_URL + Url.LOGIN);
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		loginPagePro.login(proUtil.getPro("username"), proUtil.getPro("wrongPassword"));
		logger.info("testLoginFail end!");
		loginPagePro.verifyLoginNotice(proUtil.getPro("login_fail_notice"));
		logger.info("login fail!");
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driverBase.close();
	}

}
