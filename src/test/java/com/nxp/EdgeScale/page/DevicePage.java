package com.nxp.EdgeScale.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.base.BasePage;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.testcase.Login;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ProUtil;

public class DevicePage extends BasePage {

	public DevicePage(DriverBase driverBase) {
		super(driverBase);
	}

	/**
	 * 获取用户名
	 */
	public WebElement getUsername() {
		return element(GetByLocator.getLocator("nickname_text"));
	}

	/**
	 * 获取向下箭头
	 */
	public WebElement getDownArrow() {
		return element(GetByLocator.getLocator("arrow_down"));
	}

	/**
	 * 获取登出按钮
	 */
	public WebElement getLogoutButton() {
		return element(GetByLocator.getLocator("logout_button"));
	}

	/**
	 * 获取账户设置按钮
	 */
	public WebElement getAccountSettingsButton() {
		return element(GetByLocator.getLocator("account_settings_button"));
	}

	// -----------------修改密码相关-------------------

	public WebElement getOldPasswordInput() {
		return element(GetByLocator.getLocator("old_password_input"));
	}

	public WebElement getNewPasswordInput() {
		return element(GetByLocator.getLocator("password_input"));
	}

	public WebElement getEnterPasswordInput() {
		return element(GetByLocator.getLocator("enter_password"));
	}

	public WebElement getChangePasswordEnterButton() {
		return element(GetByLocator.getLocator("change_password_enter_button"));
	}

	/**
	 * 获取device 页面顶部提示元素
	 * 
	 * @return
	 */
	public WebElement getDevicePageTopNotice() {
		return element(GetByLocator.getLocator("device_page_top_notice"));
	}

	/**
	 * 获取device页面右边提示元素
	 * 
	 * @return
	 */
	public WebElement getDevicePageRightNoitce() {
		return element(GetByLocator.getLocator("login_noitce"));
	}

	/**
	 * 获取删除device按钮
	 * 
	 * @return
	 */
	public WebElement getDeviceDeleteButton() {
		return element(GetByLocator.getLocator("device_delete_button"));
	}

	/**
	 * 获取删除Device确认框中删除按钮
	 * 
	 * @return
	 */
	public WebElement getDeviceDeleteWindowButton() {
		return element(GetByLocator.getLocator("device_delete_window_button"));
	}

	/**
	 * 获取Device添加tag按钮
	 * 
	 * @return
	 */
	public WebElement getDeviceNewTagButton(int device_num) {
		return element(GetByLocator.getLocator("device_new_tag_button_" + device_num));
	}

	/**
	 * 获取Device添加tag输入框
	 * 
	 * @return
	 */
	public WebElement getDeviceNewTagInput() {
		return element(GetByLocator.getLocator("device_new_tag_input"));
	}

	/**
	 * 获取Device删除tag按钮
	 * 
	 * @return
	 */
	public WebElement getDeviceDeleteTagButton() {
		return element(GetByLocator.getLocator("device_delete_tag"));
	}

	/**
	 * 获取Device inactive active按钮
	 * 
	 * @return
	 */
	public WebElement getDeviceInactiveActiveButton() {
		return element(GetByLocator.getLocator("device_inactive_active"));
	}

	/**
	 * 获取Device inactive active确认按钮
	 * 
	 * @return
	 */
	public WebElement getDeviceInactiveActiveWindow() {
		return element(GetByLocator.getLocator("device_inactive_active_window"));
	}

	// ----------------bind tag相关-----------------------

	/**
	 * 获取Device checkbox 单选框
	 * 
	 * @return
	 */
	public WebElement getDeviceCheckBox() {
		return element(GetByLocator.getLocator("device_checkbox"));
	}

	/**
	 * 获取Device bindtag按钮
	 * 
	 * @return
	 */
	public WebElement getBindTagButton() {
		return element(GetByLocator.getLocator("device_bindTag_button"));
	}

	/**
	 * 获取Device bindtag输入框
	 * 
	 * @return
	 */
	public WebElement getBindTagInput() {
		return element(GetByLocator.getLocator("device_bindTag_input"));
	}

	/**
	 * 获取Device bindtag输入框下拉列表
	 * 
	 * @return
	 */
	public WebElement getBindTagInputList(String tag) {
		ProUtil pro = new ProUtil(Common.ELEMENT);
		String locator = pro.getPro("device_bindTag_list");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		String newValue = locatorValue.replace("tag", tag);
		System.out.println("替换后  ==========" + newValue);
		return element(GetByLocator.getLocator(locatorType, newValue));
	}

	/**
	 * 获取Device bindtag提交按钮
	 * 
	 * @return
	 */
	public WebElement getBindTagSubmit() {
		return element(GetByLocator.getLocator("device_bindTag_submit"));
	}

}
