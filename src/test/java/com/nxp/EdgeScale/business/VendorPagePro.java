package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.VendorPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;

public class VendorPagePro {

	public DriverBase driverBase;
	private VendorPageHandle vph;

	public VendorPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		vph = new VendorPageHandle(driverBase);
	}

	/**
	 * 创建vendor
	 */
	public void createVendor(String name) {
		vph.clickVendorCreateButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vph.sendKeysVendorNameInput(name);
		vph.clickVendorCreateSubmitInput();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void vertifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = vph.getPageRightNotice();
		assertTrue(right.contains(rightNotice));
	}

	/**
	 * 修改vendor
	 * 
	 * @param name
	 */
	public void editVendor(String name) {
		vph.clickVendorEditButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vph.sendKeysVendorNameInput(name);
		vph.clickVendorCreateSubmitInput();
	}

	public void deleteVendor() {
		vph.clickVendorDeleteButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vph.clickVendorDeleteConfirm();
	}

}
