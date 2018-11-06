package com.nxp.EdgeScale.business;

import org.apache.log4j.Logger;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.AppEditInfoPageHandle;
import com.nxp.EdgeScale.handle.AppPageHandle;
import com.nxp.EdgeScale.handle.ApplyPageHandle;
import com.nxp.EdgeScale.handle.CreateAppPageHandle;
import com.nxp.EdgeScale.util.ThreadTime;

public class AppEditInfoPagePro {

	public AppEditInfoPageHandle aeiph;
	public AppPageHandle aph;
	private CreateAppPageHandle caph;
	public DriverBase driverBase;

	public AppEditInfoPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		aeiph = new AppEditInfoPageHandle(driverBase);
		aph = new AppPageHandle(driverBase);
		caph = new CreateAppPageHandle(driverBase);
	}

	/**
	 * 修改app信息
	 * 
	 * @param appName
	 * @param appDesc
	 */
	public void editAppInfo(String appName, String appDesc) {
		aph.clickMyAppButton();
		ThreadTime.sleep(5000);
		aph.clickAppDetailButton();
		ThreadTime.sleep(7000);
		aeiph.clickAppEditButton();
		ThreadTime.sleep(5000);
		aeiph.sendKeysAppEditAppNameInput(appName);
		aeiph.sendKeysAppEditAppDescInput(appDesc);
		ThreadTime.sleep(2000);
		aeiph.clickAppEditNextButton();
		ThreadTime.sleep(2000);
	}

	/**
	 * 添加docker
	 * 
	 * @param registry
	 * @param imageName
	 * @param version
	 */
	public void appAddDocker(String registry, String imageName, String version) {
		aph.clickMyAppButton();
		ThreadTime.sleep(5000);
		aph.clickAppDetailButton();
		ThreadTime.sleep(7000);
		aeiph.clickAppAddDcokerButton();
		ThreadTime.sleep(5000);
		caph.clickRegistryInput();
		ThreadTime.sleep(5000);
		caph.clickRegistryList(registry);
		ThreadTime.sleep(1000);
		caph.sendKeysImageName(imageName);
		ThreadTime.sleep(1000);
		caph.sendKeysCreateAppVersionInput(version);
		ThreadTime.sleep(1000);
		caph.clickCreateAppVersionInputList(version);
		ThreadTime.sleep(5000);
		aeiph.clickAppAddDcokerSubmitButton();
	}

	/**
	 * 改变app 权限
	 */
	public void changeAppPermission() {
		aph.clickMyAppButton();
		ThreadTime.sleep(5000);
		aph.clickAppDetailButton();
		ThreadTime.sleep(5000);
		aeiph.clickAppChangePermissionButton();
		ThreadTime.sleep(5000);
		aeiph.clickAppChangePermissionCheckbox();
		aeiph.clickAppChangePermissionSubmit();
	}
}
