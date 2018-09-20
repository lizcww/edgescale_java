package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.VendorPage;

public class VendorPageHandle {

	public DriverBase driverBase;
	public VendorPage vp;

	public VendorPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		vp = new VendorPage(driverBase);
	}

	public void clickVendorCreateButton() {
		vp.click(vp.getVendorCreateButton());
	}

	public void sendKeysVendorNameInput(String name) {
		vp.sendkeys(vp.getVendorNameInput(), name);
	}

	public void clickVendorCreateSubmitInput() {
		vp.click(vp.getVendorCreateSubmitInput());
	}

	/**
	 * 获取页面右边提示文本
	 * 
	 * @return
	 */
	public String getPageRightNotice() {
		return vp.getPageRightNoitce().getText();
	}

	public void clickVendorEditButton() {
		vp.click(vp.getVendorEditButton());
	}
	
	public void clickVendorDeleteButton() {
		vp.click(vp.getVendorDeleteButton());
	}
	
	public void clickVendorDeleteConfirm() {
		vp.click(vp.getVendorDeleteConfirm());
	}

}
