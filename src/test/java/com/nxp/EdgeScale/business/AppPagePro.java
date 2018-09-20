package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.AppPageHandle;
import com.nxp.EdgeScale.handle.CreateAppPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;

public class AppPagePro {

	private AppPageHandle aph;
	private DriverBase driverBase;

	private static Logger logger = Logger.getLogger(DevicePagePro.class);

	public AppPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		aph = new AppPageHandle(driverBase);
	}

	public void deleteApp() {
		aph.clickMyAppButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aph.clickAppDeleteButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aph.clickAppDeleteConfirmationButton();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void vertifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = aph.getPageRightNotice();
		logger.info("device页面右边提示 ==== " + right);
		assertTrue(right.contains(rightNotice));
	}

	/**
	 * 验证顶部提示
	 * 
	 * @param topNotice
	 */
	public void vertifyTopNotice(String topNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("device_page_top_notice")));
		String top = aph.getDevicePageTopNotice();
		logger.info("device页面顶部提示 ==== " + top);
		assertTrue(top.contains(topNotice));
	}

	/**
	 * deploy app
	 */
	public void deployApp() {
		aph.clickMyAppButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aph.clickAppDelopyButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aph.clickAppDelopyDeviceCheckbox();
		aph.clickDeployAppButton();
	}

	/**
	 * 部署公共商店中的app
	 */
	public void deployPublicApp() {
		aph.clickPublicAppDeploy();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aph.clickAppDelopyDeviceCheckbox();
		aph.clickDeployAppButton();
	}

}
