package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.LoginPage;

public class LoginPageHandle {

	public DriverBase driverBase;
	public LoginPage lp;

	public LoginPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		lp = new LoginPage(driverBase);
	}

	/**
	 * 输入用户名
	 */
	public void sendKeysUser(String username) {
		lp.sendkeys(lp.getUserElement(), username);
	}

	/**
	 * 输入密码
	 */
	public void sendKeysPassword(String password) {
		lp.sendkeys(lp.getPasswordElement(), password);
	}

	/**
	 * 点击登陆
	 */
	public void clickLoginButton() {
		lp.click(lp.getLoginButtonElement());
	}

	/**
	 * 获取登录提示text
	 * @return
	 */
	public String getLoginNotice() {
		return lp.getLoginNotice().getText();
	}

}
