package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.AppPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ThreadTime;

public class AppPagePro {

	private AppPageHandle aph;
	private DriverBase driverBase;

	private static Logger logger = Logger.getLogger(AppPagePro.class);

	public AppPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		aph = new AppPageHandle(driverBase);
	}

	public void deleteApp() {
		aph.clickMyAppButton();
		ThreadTime.sleep(3000);
		aph.clickAppDeleteButton();
		ThreadTime.sleep(3000);
		aph.clickAppDeleteConfirmationButton();
		ThreadTime.sleep(3000);
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void verifyRightNotice(String rightNotice) {
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
	public void verifyTopNotice(String topNotice) {
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
		ThreadTime.sleep(4000);
		aph.clickAppDelopyButton();
		ThreadTime.sleep(5000);
		aph.clickAppDelopyDeviceCheckbox();
		aph.clickDeployAppButton();
	}

	/**
	 * 部署公共商店中的app
	 */
	public void deployPublicApp() {
		aph.clickPublicAppDeploy();
		ThreadTime.sleep(5000);
		aph.clickAppDelopyDeviceCheckbox();
		aph.clickDeployAppButton();
	}

}
