package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.CreateModelPageHandle;
import com.nxp.EdgeScale.handle.CreateSolutionPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;

public class CreateModelPagePro {

	public CreateModelPageHandle cmph;
	public DriverBase driverBase;

	public CreateModelPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		cmph = new CreateModelPageHandle(driverBase);
	}

	/**
	 * 创建model
	 * 
	 * @param modelNo
	 * @param type
	 * @param platform
	 * @param vendor
	 */
	public void createModel(String modelNo, String type, String platform, String vendor) {
		cmph.clickModelNoInput();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cmph.sendKeysModelNoInput(modelNo);
		cmph.clickModelNoInputList(modelNo);
		cmph.clickModelTypeInput();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cmph.clickModelTypeInputList(type);
		cmph.clickModelPlatformInput();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cmph.clickModelPlatformInputList(platform);
		cmph.clickModelVendorInput();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cmph.clickModelVendorInputList(vendor);
		cmph.clickModelSubmit();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void vertifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = cmph.getPageRightNotice();
		assertTrue(right.contains(rightNotice));
	}

}
