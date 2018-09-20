package com.nxp.EdgeScale.handle;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.page.AppEditInfoPage;
import com.nxp.EdgeScale.page.ApplyPage;

public class AppEditInfoPageHandle {
	public DriverBase driverBase;
	public AppEditInfoPage aeip;

	public AppEditInfoPageHandle(DriverBase driverBase) {
		this.driverBase = driverBase;
		aeip = new AppEditInfoPage(driverBase);
	}

	public void clickAppEditButton() {
		aeip.click(aeip.getAppEditButton());
	}

	public void sendKeysAppEditAppNameInput(String appName) {
		aeip.sendkeys(aeip.getAppEditAppNameInput(), appName);
	}

	public void sendKeysAppEditAppDescInput(String appDesc) {
		aeip.sendkeys(aeip.getAppEditAppDescInput(), appDesc);
	}

	public void clickAppEditNextButton() {
		aeip.click(aeip.getAppEditNextButton());
	}
	
	public void clickAppAddDcokerButton() {
		aeip.click(aeip.getAppAddDcokerButton());
	}
	
	public void clickAppAddDcokerSubmitButton() {
		aeip.click(aeip.getAppAddDcokerSubmitButton());
	}
	
	public void clickAppChangePermissionSubmit() {
		aeip.click(aeip.getAppChangePermissionSubmit());
	}

	public void clickAppChangePermissionButton() {
		aeip.click(aeip.getAppChangePermissionButton());
	}
	
	public void clickAppChangePermissionCheckbox() {
		aeip.click(aeip.getAppChangePermissionCheckbox());
	}

}
