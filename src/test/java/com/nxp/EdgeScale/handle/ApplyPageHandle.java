package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.ApplyPage;
import com.nxp.EdgeScale.page.LoginPage;

public class ApplyPageHandle {

	public DriverBase driverBase;
	public ApplyPage ap;

	public ApplyPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		ap = new ApplyPage(driverBase);
	}

	public void sendKeysFistName(String firstName) {
		ap.sendkeys(ap.getFistNameInput(), firstName);
	}

	public void sendKeysLastName(String lastName) {
		ap.sendkeys(ap.getLastNameInput(), lastName);
	}

	public void sendKeysEmail(String email) {
		ap.sendkeys(ap.getEmailInput(), email);
	}

	public void sendKeysCompanyName(String company) {
		ap.sendkeys(ap.getCompanyNameInput(), company);
	}

	public void submit() {
		ap.click(ap.getSubmitButton());
	}

	/**
	 * 获取提示文本
	 * 
	 * @return
	 */
	public String getNotice() {
		return ap.getNotice().getText();
	}

}
