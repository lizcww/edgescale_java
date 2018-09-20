package com.nxp.EdgeScale.handle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.DevicePage;
import com.nxp.EdgeScale.page.LoginPage;
import com.nxp.EdgeScale.util.GetByLocator;

public class DevicePageHandle {

	public DriverBase driver;
	public DevicePage dp;

	public DevicePageHandle(DriverBase driverBase) {
		this.driver = driverBase;
		dp = new DevicePage(driverBase);
	}

	/**
	 * 获取用户名
	 */
	public String getUsername() {
		return dp.getUsername().getText();
	}

	/**
	 * 点击向下箭头
	 */
	public void clickDownArrow() {
		dp.click(dp.getDownArrow());
	}

	/**
	 * 点击登出按钮
	 */
	public void clickLogoutButton() {
		dp.click(dp.getLogoutButton());
	}

	// -------------------修改密码相关----------------------

	public void clickAccountSettings() {
		dp.click(dp.getAccountSettingsButton());
	}

	public void sendKeysOldPassword(String oldPassword) {
		dp.sendkeys(dp.getOldPasswordInput(), oldPassword);
	}

	public void sendKeysNewPassword(String newPassword) {
		dp.sendkeys(dp.getNewPasswordInput(), newPassword);
	}

	public void sendKeysEnterPassword(String enterPassword) {
		dp.sendkeys(dp.getEnterPasswordInput(), enterPassword);
	}

	public void clickChangePasswordEnterButton() {
		dp.click(dp.getChangePasswordEnterButton());
	}

	/**
	 * 获取Device页面顶部提示文本
	 * 
	 * @return
	 */
	public String getDevicePageTopNotice() {
		return dp.getDevicePageTopNotice().getText();
	}

	/**
	 * 获取Device页面右边提示文本
	 * 
	 * @return
	 */
	public String getDevicePageRightNotice() {
		return dp.getDevicePageRightNoitce().getText();
	}

	/**
	 * 点击删除device按钮
	 */
	public void clickDeviceDeleteButton() {
		dp.click(dp.getDeviceDeleteButton());
	}

	/**
	 * 点击删除Device确认框中确认按钮
	 */
	public void clickDeviceDeleteWindowButton() {
		dp.click(dp.getDeviceDeleteWindowButton());
	}

	/**
	 * 点击device添加tag按钮
	 */
	public void clickDeviceNewTagButton() {
		dp.click(dp.getDeviceNewTagButton());
	}

	/**
	 * device输入tag
	 * 
	 * @param tag
	 */
	public void sendkeysDeviceNewTagInput(String tag) {
		dp.sendkeys(dp.getDeviceNewTagInput(), tag);
		dp.getDeviceNewTagInput().sendKeys(Keys.ENTER);
	}

	/**
	 * 点击device删除tag按钮
	 */
	public void clickDeviceDeleteTagButton() {
		dp.click(dp.getDeviceDeleteTagButton());
	}

	/**
	 * 点击device Inacitve active 按钮
	 */
	public void clickDeviceInactiveAcitveButton() {
		dp.click(dp.getDeviceInactiveActiveButton());
	}

	public String getDeviceInactiveAcitveButtonText() {
		String text = dp.getDeviceInactiveActiveButton().getText();
		System.out.println("getDeviceInactiveAcitveButtonText==============" + text);
		return text;
	}

	/**
	 * 点击device Inacitve active 确认按钮
	 */
	public void clickDeviceInactiveAcitveWindow() {
		dp.click(dp.getDeviceInactiveActiveWindow());
	}

	// -----------------bind  tag 相关----------------------

	/**
	 * 点击device checkbox
	 */
	public void clickDeviceCheckbox() {
		dp.click(dp.getDeviceCheckBox());
	}

	/**
	 * 点击device bindtag 按钮
	 */
	public void clickDeviceBindTagButton() {
		dp.click(dp.getBindTagButton());
	}

	/**
	 * 输入 bindtag
	 */
	public void sendKeysBindTagInput(String tag) {
		dp.sendkeys(dp.getBindTagInput(), tag);
	}

	/**
	 * 点击device bindtag 列表中tag
	 */
	public void clickBindTagInputList(String tag) {
		dp.click(dp.getBindTagInputList(tag));
	}

	/**
	 * 点击device bindtag 提交按钮
	 */
	public void clickBindTagSubmitButton() {
		dp.click(dp.getBindTagSubmit());
	}

}
