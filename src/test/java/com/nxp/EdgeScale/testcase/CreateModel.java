package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.CreateModelPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class CreateModel extends CaseBase {

	private DriverBase driverBase;
	private CreateModelPagePro createModelPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(CreateModel.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		handleCookie = new HandleCookie(driverBase);
		createModelPagePro = new CreateModelPagePro(driverBase);
		driverBase.get(Url.BASE_URL + Url.MODEL_CREATE);
		handleCookie.setCookie_rootUser1();
		driverBase.get(Url.BASE_URL + Url.MODEL_CREATE);
		ThreadTime.sleep(3000);
	}

	@Test(groups = {"createModel"})
	public void testCreateModel() {
		driverBase.get(Url.BASE_URL + Url.MODEL_CREATE);
		ThreadTime.sleep(3000);
		logger.info("testCreateModel start...");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		createModelPagePro.createModel(proUtil.getPro("create_model_modelNo"), proUtil.getPro("create_model_type"),
				proUtil.getPro("create_model_platform"), proUtil.getPro("create_model_vendor"));
		logger.info("testCreateModel end!");
		createModelPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("testCreateModel succeed!");
		ThreadTime.sleep(3000);
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driverBase.close();
	}

}
