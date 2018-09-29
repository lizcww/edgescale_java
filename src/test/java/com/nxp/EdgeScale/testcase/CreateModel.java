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
import com.nxp.EdgeScale.business.CreateModelPagePro;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateModel extends CaseBase {

	private DriverBase driverBase;
	private CreateModelPagePro createModelPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(CreateModel.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		handleCookie = new HandleCookie(driverBase);
		createModelPagePro = new CreateModelPagePro(driverBase);
		driverBase.get(Url.BASE_URL + Url.MODEL_CREATE);
		handleCookie.setCookie();
		driverBase.get(Url.BASE_URL + Url.MODEL_CREATE);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateModel() {
		logger.info("创建model开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createModelPagePro.createModel(proUtil.getPro("create_model_modelNo"), proUtil.getPro("create_model_type"),
				proUtil.getPro("create_model_platform"), proUtil.getPro("create_model_vendor"));
		logger.info("创建model结束");
		createModelPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("创建model成功");
	}

	@AfterClass
	public void close() {
		driverBase.close();
	}

}
