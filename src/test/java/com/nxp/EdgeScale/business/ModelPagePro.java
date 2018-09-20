package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.CreateModelPageHandle;
import com.nxp.EdgeScale.handle.ModelPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;

public class ModelPagePro {

	private ModelPageHandle mph;
	private CreateModelPageHandle cmph;
	public DriverBase driverBase;

	public ModelPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		mph = new ModelPageHandle(driverBase);
		cmph = new CreateModelPageHandle(driverBase);
	}

	/**
	 * 编辑model
	 * 
	 * @param newModelNo
	 */
	public void editModel(String newModelNo) {
		mph.clickModelEditButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cmph.sendKeysModelNoInput(newModelNo);
		cmph.clickModelSubmit();
	}

	/**
	 * 删除model
	 */
	public void deleteModel() {
		mph.clickModelDeleteButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mph.clickModelDeleteConfirmButton();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void vertifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = mph.getPageRightNotice();
		assertTrue(right.contains(rightNotice));
	}

	/**
	 * 通过model查找
	 * 
	 * @param model
	 */
	public void findModelsByModel(String model) {
		mph.sendKeysFindByModelInput(model);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mph.clickFindModelsButton();
	}

	/**
	 * 通过type查找
	 * 
	 * @param model
	 */
	public void findModelsByType(String type) {
		mph.sendKeysFindByTypeInput(type);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mph.clickFindModelsButton();
	}

	/**
	 * 通过Platform查找
	 * 
	 * @param model
	 */
	public void findModelsByPlatform(String platform) {
		mph.sendKeysFindByPlatformInput(platform);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mph.clickFindModelsButton();
	}

	/**
	 * 通过Vendor查找
	 * 
	 * @param model
	 */
	public void findModelsByVendor(String vendor) {
		mph.sendKeysFindByVendorInput(vendor);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mph.clickFindModelsButton();
	}
}
