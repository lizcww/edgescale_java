package com.nxp.EdgeScale.business;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.handle.ApplyPageHandle;
import com.nxp.EdgeScale.handle.LoginPageHandle;
import com.nxp.EdgeScale.testcase.Login;
import com.nxp.EdgeScale.util.GetByLocator;

public class ApplyPagePro {

	public ApplyPageHandle aph;
	public DriverBase driverBase;

	private static Logger logger = Logger.getLogger(ApplyPagePro.class);

	public ApplyPagePro(DriverBase driverBase) {
		this.driverBase = driverBase;
		aph = new ApplyPageHandle(driverBase);
	}

	/**
	 * 注册
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param companyName
	 */
	public void register(String firstName, String lastName, String email, String companyName) {
		aph.sendKeysFistName(firstName);
		aph.sendKeysLastName(lastName);
		aph.sendKeysEmail(email);
		aph.sendKeysCompanyName(companyName);
		aph.submit();
	}

	/**
	 * 验证注册提示语
	 */
	public void verifyNotice(String notice) {
		WebDriverWait wait = new WebDriverWait(driverBase.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(GetByLocator.getLocator("register_notice")));
		String registerNotice = aph.getNotice();
		logger.info("注册提示 ==== " + registerNotice);
		assertTrue(registerNotice.contains(notice));
	}

}
