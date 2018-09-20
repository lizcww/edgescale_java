package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.ManageUserPage;

public class ManageUserPageHandle {

	public DriverBase driverBase;
	public ManageUserPage mup;

	public ManageUserPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		mup = new ManageUserPage(driverBase);
	}

	// ---------------创建user相关----------------------

	public void clickCreateUserButton() {
		mup.click(mup.getCreateUserButton());
	}

	public void sendKeysUserNameInput(String userName) {
		mup.sendkeys(mup.getUserNameInput(), userName);
	}

	public void sendKeysEmailInput(String email) {
		mup.sendkeys(mup.getEmailInput(), email);
	}

	public void clickCreateUserSubmitInput() {
		mup.click(mup.getCreateUserSubmitInput());
	}

	/**
	 * 获取页面顶部提示文本
	 * 
	 * @return
	 */
	public String getPageTopNotice() {
		return mup.getPageTopNotice().getText();
	}

	// --------------设置相关------------------------

	public void clickSettingButton() {
		mup.click(mup.getSettingButton());
	}

	public void clickLimitTypeInput() {
		mup.click(mup.getLimitTypeInput());
	}

	public void clickLimitTypeInputList(String limitType) {
		mup.click(mup.getLimitTypeInputList(limitType));
	}

	public void sendKeysMaxLimitInput(String maxLimit) {
		mup.sendkeys(mup.getMaxLimitInput(), maxLimit);
	}

	public void clickLimitEnter() {
		mup.click(mup.getLimitEnter());
	}

}
