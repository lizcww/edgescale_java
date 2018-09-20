package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.CreateModelPage;
import com.steadystate.css.dom.MediaListImpl;

public class CreateModelPageHandle {

	public DriverBase driver;
	public CreateModelPage cmp;

	public CreateModelPageHandle(DriverBase driverBase) {
		this.driver = driverBase;
		cmp = new CreateModelPage(driverBase);
	}

	public void clickModelNoInput() {
		cmp.click(cmp.getModelNoInput());
	}

	public void sendKeysModelNoInput(String modelNo) {
		cmp.sendkeys(cmp.getModelNoInput(), modelNo);
	}

	public void clickModelNoInputList(String modelNo) {
		cmp.click(cmp.getModelNoInputList(modelNo));
	}

	public void clickModelTypeInput() {
		cmp.click(cmp.getModelTypeInput());
	}

	public void clickModelTypeInputList(String type) {
		cmp.click(cmp.getModelTypeInputList(type));
	}

	public void clickModelPlatformInput() {
		cmp.click(cmp.getModelPlatformInput());
	}

	public void clickModelPlatformInputList(String platform) {
		cmp.click(cmp.getModelPlatformInputList(platform));
	}

	public void clickModelVendorInput() {
		cmp.click(cmp.getModelVendorInput());
	}

	public void clickModelVendorInputList(String vendor) {
		cmp.click(cmp.getModelVendorInputList(vendor));
	}

	public void clickModelSubmit() {
		cmp.click(cmp.getModelSubmit());
	}

	/**
	 * 获取页面右边提示文本
	 * 
	 * @return
	 */
	public String getPageRightNotice() {
		return cmp.getPageRightNoitce().getText();
	}

}
