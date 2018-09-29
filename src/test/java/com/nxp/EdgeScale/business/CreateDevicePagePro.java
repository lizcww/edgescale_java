package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.CreateDevicePageHandle;
import com.nxp.EdgeScale.handle.DevicePageHandle;
import com.nxp.EdgeScale.util.GetByLocator;

public class CreateDevicePagePro {

	public CreateDevicePageHandle cdph;
	public DriverBase driverBase;

	private static Logger logger = Logger.getLogger(CreateDevicePagePro.class);

	public CreateDevicePagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		cdph = new CreateDevicePageHandle(driverBase);
	}

	/**
	 * 创建device
	 * 
	 * @param SN
	 * @param modelName
	 */
	public void createDevice(String SN, String modelName) {
		cdph.sendKeysSN(SN);
		cdph.clickIDNO();
		cdph.clickModelInput();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cdph.selectModel(modelName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cdph.clickSubmitButton();

	}

	/**
	 * 验证提示文本
	 * 
	 * @param notice
	 */
	public void verifyNotice(String notice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String noticeText = cdph.getNoticeText();
		logger.info("device页面顶部提示 ==== " + noticeText);
		assertTrue(noticeText.contains(notice));
	}
}
