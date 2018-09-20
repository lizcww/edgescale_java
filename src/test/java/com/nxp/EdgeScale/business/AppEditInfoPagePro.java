package com.nxp.EdgeScale.business;

import org.apache.log4j.Logger;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.AppEditInfoPageHandle;
import com.nxp.EdgeScale.handle.AppPageHandle;
import com.nxp.EdgeScale.handle.ApplyPageHandle;
import com.nxp.EdgeScale.handle.CreateAppPageHandle;

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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aph.clickAppDetailButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aeiph.clickAppEditButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aeiph.sendKeysAppEditAppNameInput(appName);
		aeiph.sendKeysAppEditAppDescInput(appDesc);
		aeiph.clickAppEditNextButton();
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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aph.clickAppDetailButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aeiph.clickAppAddDcokerButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caph.clickRegistryInput();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caph.clickRegistryList(registry);
		caph.sendKeysImageName(imageName);
		caph.sendKeysCreateAppVersionInput(version);
		caph.clickCreateAppVersionInputList(version);
		aeiph.clickAppAddDcokerSubmitButton();
	}

	/**
	 * 改变app 权限
	 */
	public void changeAppPermission() {
		aph.clickMyAppButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aph.clickAppDetailButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aeiph.clickAppChangePermissionButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aeiph.clickAppChangePermissionCheckbox();
		aeiph.clickAppChangePermissionSubmit();
	}
}
