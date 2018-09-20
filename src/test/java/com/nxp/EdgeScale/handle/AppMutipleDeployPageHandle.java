package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.AppMutipleDeployPage;
import com.nxp.EdgeScale.page.AppPage;

public class AppMutipleDeployPageHandle {
	public DriverBase driver;
	public AppMutipleDeployPage amdp;

	public AppMutipleDeployPageHandle(DriverBase driverBase) {
		this.driver = driverBase;
		amdp = new AppMutipleDeployPage(driverBase);
	}

	public void clickAppMutipleDeployCheckbox1() {
		amdp.click(amdp.getAppMutipleDeployCheckbox1());
	}

	public void clickAppMutipleDeployCheckbox2() {
		amdp.click(amdp.getAppMutipleDeployCheckbox2());
	}

	public void clickAppMutipleDeployNextStepButton() {
		amdp.click(amdp.getAppMutipleDeployNextStepButton());
	}

	public void clickAppMutipleDeployChooseAppCheckbox1() {
		amdp.click(amdp.getAppMutipleDeployChooseAppCheckbox1());
	}

	public void clickAppMutipleDeployChooseAppCheckbox2() {
		amdp.click(amdp.getAppMutipleDeployChooseAppCheckbox2());
	}

	public void clickAppMutipleDeployNextStepDeployConfigButton() {
		amdp.click(amdp.getAppMutipleDeployNextStepDeployConfigButton());
	}

	public void clickAppMutipleDeployNextStepPreviewButton() {
		amdp.click(amdp.getAppMutipleDeployNextStepPreviewButton());
	}

	public void clickAppMutipleDeployNextStepDeployButton() {
		amdp.click(amdp.getAppMutipleDeployNextStepDeployButton());
	}

}
