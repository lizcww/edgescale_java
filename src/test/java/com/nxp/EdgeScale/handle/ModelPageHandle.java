package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.ModelPage;
import com.nxp.EdgeScale.page.SolutionPage;

public class ModelPageHandle {

	public DriverBase driverBase;
	public ModelPage mp;

	public ModelPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		mp = new ModelPage(driverBase);
	}

	public void clickModelEditButton() {
		mp.click(mp.getModelEditButton());
	}

	public void clickModelDeleteButton() {
		mp.click(mp.getModelDeleteButton());
	}

	public void clickModelDeleteConfirmButton() {
		mp.click(mp.getModelDeleteConfirmButton());
	}

	/**
	 * 获取页面右边提示文本
	 * 
	 * @return
	 */
	public String getPageRightNotice() {
		return mp.getPageRightNoitce().getText();
	}

	// ---------------查找model 相关--------------------

	public void sendKeysFindByModelInput(String model) {
		mp.sendkeys(mp.getFindByModelInput(), model);
	}

	public void sendKeysFindByTypeInput(String type) {
		mp.sendkeys(mp.getFindByTypeInput(), type);
	}

	public void sendKeysFindByPlatformInput(String platform) {
		mp.sendkeys(mp.getFindByPlatformInput(), platform);
	}

	public void sendKeysFindByVendorInput(String platform) {
		mp.sendkeys(mp.getFindByVendorInput(), platform);
	}

	public void clickFindModelsButton() {
		mp.click(mp.getFindModelsButton());
	}
}
