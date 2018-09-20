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
	public void vertifyRightNotice(String rightNotice) {
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sph.clickSolutionDeleteConfirmButton();
	}

	/**
	 * 部署solution
	 */
	public void deploySolution() {
		sph.clickSolutionDeployButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sph.clickQueryDeviceButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sph.clickDeviceCheckbox();
		sph.clickNextStepButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sph.clickDeployButton();
	}

	/**
	 * 下载image
	 */
	public void downImage() {
		sph.clickDownButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void editSolution() {
		sph.clickEditButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sph.clickSolutionPermissionButton();
		sph.clickSolutionEditSubmitButton();
	}
}
