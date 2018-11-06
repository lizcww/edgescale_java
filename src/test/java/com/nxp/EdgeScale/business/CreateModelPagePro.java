package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.CreateModelPageHandle;
import com.nxp.EdgeScale.testcase.CreateModel;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ThreadTime;

public class CreateModelPagePro {

	public CreateModelPageHandle cmph;
	public DriverBase driverBase;
	private static Logger logger = Logger.getLogger(CreateModel.class);

	public CreateModelPagePro(DriverBase driverBase) {
		PropertyConfigurator.configure("log4j.properties");
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
		ThreadTime.sleep(5000);
		cmph.sendKeysModelNoInput(modelNo);
		cmph.clickModelNoInputList(modelNo);
		cmph.clickModelTypeInput();
		ThreadTime.sleep(5000);
		cmph.clickModelTypeInputList(type);
		cmph.clickModelPlatformInput();
		ThreadTime.sleep(5000);
		cmph.clickModelPlatformInputList(platform);
		cmph.clickModelVendorInput();
		ThreadTime.sleep(5000);
		cmph.clickModelVendorInputList(vendor);
		ThreadTime.sleep(3000);
		cmph.clickModelPermissionPrivate();
		ThreadTime.sleep(3000);
		cmph.clickModelSubmit();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void verifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = cmph.getPageRightNotice();
		logger.info("got message: " + right);
		assertTrue(right.contains(rightNotice));
	}

}
