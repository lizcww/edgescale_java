package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.ApplyPagePro;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.business.LoginPagePro;
import com.nxp.EdgeScale.util.ProUtil;

public class Register extends CaseBase {

	private DriverBase driverBase;
	private ApplyPagePro applyPagePro;

	private static Logger logger = Logger.getLogger(Register.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		applyPagePro = new ApplyPagePro(driverBase);
	}

	@Test
	public void testRegisterWithExistEmail() {
		logger.info("注册开始");
		driverBase.get(Url.BASE_URL + Url.REGISTER);
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		applyPagePro.register(proUtil.getPro("firstName"), proUtil.getPro("lastName"), proUtil.getPro("email"),
				proUtil.getPro("companyName"));
		logger.info("注册结束");
		applyPagePro.verifyNotice(proUtil.getPro("register_fail_notice"));
		logger.info("注册失败");
	}

	@AfterClass
	public void close() {
		driverBase.close();
	}

}
