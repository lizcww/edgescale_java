package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.CreateModelPageHandle;
import com.nxp.EdgeScale.handle.ModelPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ThreadTime;

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
		ThreadTime.sleep(3000);
		cmph.sendKeysModelNoInput(newModelNo);
		ThreadTime.sleep(3000);
		cmph.clickModelSubmit();
		ThreadTime.sleep(1000);
	}

	/**
	 * 删除model
	 */
	public void deleteModel() {
		mph.clickModelDeleteButton();
		ThreadTime.sleep(3000);
		mph.clickModelDeleteConfirmButton();
		ThreadTime.sleep(1000);
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void verifyRightNotice(String rightNotice) {
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
		ThreadTime.sleep(3000);
		mph.clickFindModelsButton();
		ThreadTime.sleep(1000);
	}

	/**
	 * 通过type查找
	 * 
	 * @param model
	 */
	public void findModelsByType(String type) {
		mph.sendKeysFindByTypeInput(type);
		ThreadTime.sleep(3000);
		mph.clickFindModelsButton();
		ThreadTime.sleep(1000);
	}

	/**
	 * 通过Platform查找
	 * 
	 * @param model
	 */
	public void findModelsByPlatform(String platform) {
		mph.sendKeysFindByPlatformInput(platform);
		ThreadTime.sleep(3000);
		mph.clickFindModelsButton();
		ThreadTime.sleep(1000);
	}

	/**
	 * 通过Vendor查找
	 * 
	 * @param model
	 */
	public void findModelsByVendor(String vendor) {
		mph.sendKeysFindByVendorInput(vendor);
		ThreadTime.sleep(3000);
		mph.clickFindModelsButton();
		ThreadTime.sleep(1000);
	}
}
