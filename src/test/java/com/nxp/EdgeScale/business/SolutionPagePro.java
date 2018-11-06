package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.LoginPageHandle;
import com.nxp.EdgeScale.handle.SolutionPageHandle;
import com.nxp.EdgeScale.testcase.Login;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ThreadTime;

public class SolutionPagePro {

	public SolutionPageHandle sph;
	public DriverBase driverBase;

	public SolutionPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		sph = new SolutionPageHandle(driverBase);
	}

	/**
	 * 添加tag
	 * 
	 * @param tag
	 */
	public void addNewTag(String tag) {
		sph.clickNewTagButton();
		sph.sendKeysNewTagInput(tag);
		sph.sendEnterNewTagInput();
	}

	/**
	 * 删除tag
	 */
	public void deleteTag() {
		sph.clickDeleteTagButton();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void verifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = sph.getPageRightNotice();
		assertTrue(right.contains(rightNotice));
	}

	/**
	 * 删除solution
	 */
	public void deleteSolution() {
		sph.clickSolutionDeleteButton();
		ThreadTime.sleep(5000);
		sph.clickSolutionDeleteConfirmButton();
	}

	/**
	 * 部署solution
	 */
	public void deploySolution() {
		sph.clickSolutionDeployButton();
		ThreadTime.sleep(5000);
		sph.clickQueryDeviceButton();
		ThreadTime.sleep(5000);
		sph.clickDeviceCheckbox();
		sph.clickNextStepButton();
		ThreadTime.sleep(5000);
		sph.clickDeployButton();
	}

	/**
	 * 下载image
	 */
	public void downImage() {
		sph.clickDownButton();
		ThreadTime.sleep(5000);
	}

	public void editSolution() {
		sph.clickEditButton();
		ThreadTime.sleep(5000);
		sph.clickSolutionPermissionButton();
		sph.clickSolutionEditSubmitButton();
	}
}
