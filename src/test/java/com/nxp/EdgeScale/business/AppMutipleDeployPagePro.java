package com.nxp.EdgeScale.business;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.AppMutipleDeployPageHandle;
import com.nxp.EdgeScale.handle.AppPageHandle;
import com.nxp.EdgeScale.util.ThreadTime;

public class AppMutipleDeployPagePro {

	private AppMutipleDeployPageHandle amdph;
	private AppPageHandle aph;
	public AppMutipleDeployPagePro(DriverBase driverBase) {
		amdph = new AppMutipleDeployPageHandle(driverBase);
		aph = new AppPageHandle(driverBase);
	}

	/**
	 * 部署多个app到多个device上
	 */
	public void mutipleDeployApp() {
		aph.clickAppBatchDeployButton();
		ThreadTime.sleep(5000);
		amdph.clickAppMutipleDeployCheckbox1();
		amdph.clickAppMutipleDeployCheckbox2();
		amdph.clickAppMutipleDeployNextStepButton();
		ThreadTime.sleep(5000);
		amdph.clickAppMutipleDeployChooseAppCheckbox1();
		amdph.clickAppMutipleDeployChooseAppCheckbox2();
		amdph.clickAppMutipleDeployNextStepDeployConfigButton();
		ThreadTime.sleep(5000);
		amdph.clickAppMutipleDeployNextStepPreviewButton();
		ThreadTime.sleep(5000);
		amdph.clickAppMutipleDeployNextStepDeployButton();
	}
}
