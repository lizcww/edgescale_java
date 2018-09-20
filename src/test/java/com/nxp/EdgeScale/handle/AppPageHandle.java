package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.AppPage;
import com.nxp.EdgeScale.page.CreateDevicePage;

public class AppPageHandle {

	public DriverBase driver;
	public AppPage ap;

	public AppPageHandle(DriverBase driverBase) {
		this.driver = driverBase;
		ap = new AppPage(driverBase);
	}

	public void clickMyAppButton() {
		ap.click(ap.getMyAppButton());
	}

	public void clickAppDeleteButton() {
		ap.click(ap.getAppDeleteButton());
	}

	public void clickAppDeleteConfirmationButton() {
		ap.click(ap.getAppDeleteConfirmationButton());
	}

	/**
	 * 获取页面右边提示文本
	 * 
	 * @return
	 */
	public String getPageRightNotice() {
		return ap.getPageRightNoitce().getText();
	}

	public void clickAppDelopyButton() {
		ap.click(ap.getAppDelopyButton());
	}

	public void clickAppDelopyDeviceCheckbox() {
		ap.click(ap.getAppDelopyDeviceCheckbox());
	}

	public void clickDeployAppButton() {
		ap.click(ap.getDeployAppButton());
	}

	public void clickAppDocumentButton() {
		ap.click(ap.getAppDocumentButton());
	}

	/**
	 * 获取页面顶部提示文本
	 * 
	 * @return
	 */
	public String getDevicePageTopNotice() {
		return ap.getDevicePageTopNotice().getText();
	}

	/**
	 * 点击公共app部署按钮
	 */
	public void clickPublicAppDeploy() {
		ap.click(ap.getPublicAppDeploy());
	}

	public void clickAppBatchDeployButton() {
		ap.click(ap.getAppBatchDeployButton());
	}
	
	public void clickAppDetailButton() {
		ap.click(ap.getAppDetailButton());
	}

}
