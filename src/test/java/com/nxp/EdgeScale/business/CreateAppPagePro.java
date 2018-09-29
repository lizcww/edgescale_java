package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.CreateAppPageHandle;
import com.nxp.EdgeScale.handle.CreateDevicePageHandle;
import com.nxp.EdgeScale.handle.DevicePageHandle;
import com.nxp.EdgeScale.util.GetByLocator;

public class CreateAppPagePro {
	public CreateAppPageHandle caph;
	public DriverBase driverBase;

	private static Logger logger = Logger.getLogger(DevicePagePro.class);

	public CreateAppPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		caph = new CreateAppPageHandle(driverBase);
	}

	public void createApp(String appName, String desc, String imagePath, String registry, String imageName) {
		caph.sendKeysAppNameInput(appName);
		caph.sendKeysAppDescInput(desc);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caph.clickAppUploadIcon();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 把上传图片的input显示出来
		String Jscript = "arguments[0].style.display = 'block';";
		JavascriptExecutor js = (JavascriptExecutor) caph.driver.driver;
		js.executeScript(Jscript, caph.getAppUploadInput());
		caph.sendKeysUploadInput(imagePath);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caph.clickSaveButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caph.clickNextButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caph.clickRegistryInput();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		caph.clickRegistryList(registry);
		caph.sendKeysImageName(imageName);
		caph.clickSubmitButton();
	}

	/**
	 * 验证右边提示
	 * 
	 * @param rightNotice
	 */
	public void verifyRightNotice(String rightNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("login_noitce")));
		String right = caph.getPageRightNotice();
		logger.info("device页面右边提示 ==== " + right);
		assertTrue(right.contains(rightNotice));
	}
}
