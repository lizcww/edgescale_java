package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.LoginPageHandle;
import com.nxp.EdgeScale.testcase.Login;
import com.nxp.EdgeScale.util.GetByLocator;

public class LoginPagePro {

	public LoginPageHandle lph;
	public DriverBase driverBase;

	private static Logger logger = Logger.getLogger(Login.class);

	public LoginPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		lph = new LoginPageHandle(driverBase);
	}

	public void login(String username, String password) {
		lph.sendKeysUser(username);
		lph.sendKeysPassword(password);
		lph.clickLoginButton();
	}

	/**
	 * 验证登录提示语
	 */
	public void vertifyLoginNotice(String notice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String loginNotice = lph.getLoginNotice();
		logger.info("登录提示 ==== " + loginNotice);
		assertTrue(loginNotice.contains(notice));

	}

}
