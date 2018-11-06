package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.CreateDevicePage;
import com.nxp.EdgeScale.page.DevicePage;

public class CreateDevicePageHandle {

	public DriverBase driver;
	public CreateDevicePage cdph;

	public CreateDevicePageHandle(DriverBase driverBase) {
		this.driver = driverBase;
		cdph = new CreateDevicePage(driverBase);
	}

	public void sendKeysSN(String sn) {
		cdph.sendkeys(cdph.getSNInput(), sn);
	}

	public void clickIDNO() {
		cdph.click(cdph.getGenerateDeviceIDNoButton());
	}

	public void clickModelInput() {
		cdph.click(cdph.getModelInput());
	}

	public void selectModel(String modelName) {
		cdph.click(cdph.getDeviceModelList(modelName));
	}

	public void clickSubmitButton() {
		cdph.click(cdph.getSubmitButton());
	}
	
	public void clickCancelDownload() {
		cdph.click(cdph.getCancelDownloadCertificate());
	}

	public String getNoticeText() {
		return cdph.getNotice().getText();
	}
}
