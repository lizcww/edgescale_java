package com.nxp.EdgeScale.business;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.AppMutipleDeployPageHandle;
import com.nxp.EdgeScale.handle.AppPageHandle;

public class AppMutipleDeployPagePro {

	private AppMutipleDeployPageHandle amdph;
	private AppPageHandle aph;
	private DriverBase driverBase;

	public AppMutipleDeployPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		amdph = new AppMutipleDeployPageHandle(driverBase);
		aph = new AppPageHandle(driverBase);
	}

	/**
	 * 部署多个app到多个device上
	 */
	public void mutipleDeployApp() {
		aph.clickAppBatchDeployButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		amdph.clickAppMutipleDeployCheckbox1();
		amdph.clickAppMutipleDeployCheckbox2();
		amdph.clickAppMutipleDeployNextStepButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		amdph.clickAppMutipleDeployChooseAppCheckbox1();
		amdph.clickAppMutipleDeployChooseAppCheckbox2();
		amdph.clickAppMutipleDeployNextStepDeployConfigButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		amdph.clickAppMutipleDeployNextStepPreviewButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		amdph.clickAppMutipleDeployNextStepDeployButton();
	}
}
