package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.CreateSolutionPageHandle;
import com.nxp.EdgeScale.handle.DevicePageHandle;
import com.nxp.EdgeScale.util.GetByLocator;

public class CreateSolutionPagePro {

	public CreateSolutionPageHandle csph;
	public DriverBase driverBase;

	public CreateSolutionPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		csph = new CreateSolutionPageHandle(driverBase);
	}

	/**
	 * 创建solution
	 * 
	 * @param modelName
	 * @param solutionName
	 * @param version
	 * @param imageUrl
	 */
	public void createSolution(String modelName, String solutionName, String version, String imageUrl) {
		csph.clickModelNameInput();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		csph.clickModelNameInputList(modelName);
		csph.sendKeysSolutionNameInput(solutionName);
		csph.sendKeysVersionInput(version);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		csph.clickVersionInputList(version);
		csph.clickNextButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		csph.clickNext2Button();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		csph.sendKeysImageUrlInput(imageUrl);
		csph.clickSubmitButton();
	}
	
	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void vertifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = csph.getPageRightNotice();
		assertTrue(right.contains(rightNotice));
	}

}
