package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;

public class LoginPage extends BasePage {

	public LoginPage(DriverBase driverBase) {
		super(driverBase);
	}

	/**
	 * 获取用户名输入框
	 */
	public WebElement getUserElement() {
		return element(GetByLocator.getLocator("username_input"));
	}

	/**
	 * 获取密码输入框Element
	 */
	public WebElement getPasswordElement() {
		return element(GetByLocator.getLocator("userpassword_input"));
	}

	/**
	 * 获取登陆按钮element
	 */
	public WebElement getLoginButtonElement() {
		return element(GetByLocator.getLocator("login_button"));
	}

	/**
	 * 获取登录提示element
	 */
	public WebElement getLoginNotice() {
		return element(GetByLocator.getLocator("login_noitce"));
	}
}
