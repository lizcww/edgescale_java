package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.TextUtil;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.DevicePageHandle;
import com.nxp.EdgeScale.handle.LoginPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class DevicePagePro {

	public DevicePageHandle dph;
	public DriverBase driverBase;

	private static Logger logger = Logger.getLogger(DevicePagePro.class);

	public DevicePagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		dph = new DevicePageHandle(driverBase);
	}

	/**
	 * 判断用户名是否正确
	 * 
	 * @param username
	 */
	public boolean verifyUsername(String username) {
		if (username == null) {
			return false;
		}
		if (username.equals(dph.getUsername())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 登出
	 */
	public void logout() {
		dph.clickDownArrow();
		ThreadTime.sleep(3000);
		dph.clickLogoutButton();
	}

	/**
	 * 更改密码
	 * 
	 * @param oldPassword
	 * @param newPassword
	 */
	public void changePassword(String oldPassword, String newPassword) {
		dph.clickDownArrow();
		dph.clickAccountSettings();
		dph.sendKeysOldPassword(oldPassword);
		dph.sendKeysNewPassword(newPassword);
		dph.sendKeysEnterPassword(newPassword);
		ThreadTime.sleep(5000);
		dph.clickChangePasswordEnterButton();
		ThreadTime.sleep(5000);
	}

	/**
	 * 验证顶部提示
	 * 
	 * @param topNotice
	 */
	public void verifyTopNotice(String topNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("device_page_top_notice")));
		String top = dph.getDevicePageTopNotice();
		logger.info("device页面顶部提示 ==== " + top);
		assertTrue(top.contains(topNotice));
	}

	/**
	 * 删除Device
	 */
	public void deleteDevice() {
		dph.clickDeviceDeleteButton();
		ThreadTime.sleep(5000);
		dph.clickDeviceDeleteWindowButton();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void verifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = dph.getDevicePageRightNotice();
		logger.info("device页面右边提示 ==== " + right);
		assertTrue(right.contains(rightNotice));
	}

	/**
	 * 添加tag
	 * 
	 * @param tag
	 */
	public void addTagToDevice(int device_num, String tag) {
		dph.clickDeviceNewTagButton(device_num);
		dph.sendkeysDeviceNewTagInput(tag);
	}

	/**
	 * 删除tag
	 */
	public void deleteTag() {
		dph.clickDeviceDeleteTagButton();
	}

	/**
	 * 对device 取消注册
	 */
	public void inactiveDevice() {
		if ("Inactive".equals(dph.getDeviceInactiveAcitveButtonText())) {
			dph.clickDeviceInactiveAcitveButton();
			ThreadTime.sleep(3000);
			dph.clickDeviceInactiveAcitveWindow();
			ThreadTime.sleep(3000);
		} else {
			System.out.println("该device已经处于非注册状态，不能取消注册");
		}
	}

	/**
	 * 对device注册
	 */
	public void activeDevice() {
		if ("Active".equals(dph.getDeviceInactiveAcitveButtonText())) {
			dph.clickDeviceInactiveAcitveButton();
			ThreadTime.sleep(5000);
			dph.clickDeviceInactiveAcitveWindow();
		} else {
			System.out.println("该device已经处于注册状态，不能注册");
		}
	}

	/**
	 * bind tag
	 * 
	 * @param tag
	 */
	public void bingTag(String tag) {
		dph.clickDeviceCheckbox();
		dph.clickDeviceBindTagButton();
		ThreadTime.sleep(5000);
		//dph.sendKeysBindTagInput(tag);
		dph.clickBindTagInput(tag);
		ThreadTime.sleep(5000);
		dph.clickBindTagInputList(tag);
		ThreadTime.sleep(5000);
		dph.clickBindTagSubmitButton();
		ThreadTime.sleep(5000);
	}

}
