package com.nxp.EdgeScale.page;

import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ProUtil;

public class ManageUserPage extends BasePage {

	public ManageUserPage(DriverBase driverBase) {
		super(driverBase);
	}

	// ---------------创建user相关---------------------------

	public WebElement getCreateUserButton() {
		return element(GetByLocator.getLocator("manage_create_user_button"));
	}

	public WebElement getUserNameInput() {
		return element(GetByLocator.getLocator("manage_create_user_userName_input"));
	}

	public WebElement getEmailInput() {
		return element(GetByLocator.getLocator("manage_create_user_email_input"));
	}

	public WebElement getCreateUserSubmitInput() {
		return element(GetByLocator.getLocator("manage_create_user_submit"));
	}

	/**
	 * 获取 页面顶部提示元素
	 * 
	 * @return
	 */
	public WebElement getPageTopNotice() {
		return element(GetByLocator.getLocator("device_page_top_notice"));
	}

	// --------------设置相关------------------------

	public WebElement getSettingButton() {
		return element(GetByLocator.getLocator("manage_setting_button"));
	}

	public WebElement getLimitTypeInput() {
		return element(GetByLocator.getLocator("manage_limitType_input"));
	}

	public WebElement getLimitTypeInputList(String limitType) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("manage_limitType_input_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("limitType", limitType);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

	public WebElement getMaxLimitInput() {
		return element(GetByLocator.getLocator("manage_maxLimit_input"));
	}

	public WebElement getLimitEnter() {
		return element(GetByLocator.getLocator("manage_limit_enter"));
	}

}
