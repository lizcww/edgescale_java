package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.business.ModelPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class Model extends CaseBase {

	private DriverBase driverBase;
	private ModelPagePro modelPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(Model.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		modelPagePro = new ModelPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.MODEL);
		handleCookie.setCookie();
		driverBase.get(Url.BASE_URL + Url.MODEL);
	}


	@BeforeMethod
	public void afterMethod() {
		driverBase.get(Url.BASE_URL + Url.MODEL);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	@Test(priority = 0)
	public void testEditModel() {
		logger.info("编辑model开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		modelPagePro.editModel(proUtil.getPro("edit_model_modelNo"));
		logger.info("编辑model结束");
		modelPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("编辑model成功");
	}

//	@Test(priority = 1)
	public void testDeleteModel() {
		logger.info("删除model开始");
		modelPagePro.deleteModel();
		logger.info("删除model结束");
		modelPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除model成功");
	}

	@Test
	public void testFindModelsByModel() {
		modelPagePro.findModelsByModel(new ProUtil(Common.PARAMETER).getPro("find_models_model"));
	}

	@Test
	public void testFindModelsByType() {
		modelPagePro.findModelsByType(new ProUtil(Common.PARAMETER).getPro("find_models_type"));
	}

	@Test
	public void testFindModelsByPlatform() {
		modelPagePro.findModelsByPlatform(new ProUtil(Common.PARAMETER).getPro("find_models_platform"));
	}

	@Test
	public void testFindModelsByVendor() {
		modelPagePro.findModelsByVendor(new ProUtil(Common.PARAMETER).getPro("find_models_vendor"));
	}

	@AfterClass
	public void close() {
		 driverBase.close();
	}
}
