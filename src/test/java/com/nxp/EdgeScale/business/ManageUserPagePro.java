package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.ManageUserPageHandle;
import com.nxp.EdgeScale.util.GetByLocator;
import com.nxp.EdgeScale.util.ThreadTime;

public class ManageUserPagePro {

	public DriverBase driverBase;
	private ManageUserPageHandle mph;

	public ManageUserPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		mph = new ManageUserPageHandle(driverBase);
	}

	/**
	 * 创建user
	 * 
	 * @param userName
	 * @param email
	 */
	public void createUser(String userName, String email) {
		mph.clickCreateUserButton();
		ThreadTime.sleep(5000);
		mph.sendKeysUserNameInput(userName);
		mph.sendKeysEmailInput(email);
		mph.clickCreateUserSubmitInput();
		ThreadTime.sleep(5000);
	}

	/**
	 * 验证顶部提示
	 * 
	 * @param topNotice
	 */
	public void verifyTopNotice(String topNotice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("device_page_top_notice")));
		String top = mph.getPageTopNotice();
		assertTrue(top.contains(topNotice));
	}

	/**
	 * 给user设置
	 * 
	 * @param limitType
	 * @param maxLimit
	 */
	public void setLimit(String limitType, String maxLimit) {
		mph.clickSettingButton();
		ThreadTime.sleep(5000);
		mph.clickLimitTypeInput();
		mph.clickLimitTypeInputList(limitType);
		mph.sendKeysMaxLimitInput(maxLimit);
		mph.clickLimitEnter();
	}

}
