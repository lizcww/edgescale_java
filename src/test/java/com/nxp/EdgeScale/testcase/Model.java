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
import com.nxp.EdgeScale.business.ModelPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class Model extends CaseBase {

	private DriverBase driverBase;
	private ModelPagePro modelPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(Model.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		modelPagePro = new ModelPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.MODEL);
		handleCookie.setCookie_rootUser1();
		driverBase.get(Url.BASE_URL + Url.MODEL);
	}
	
	@Test(groups = {"editModel"}, dependsOnGroups = { "createModel" })
	public void testEditModel() {
		driverBase.get(Url.BASE_URL + Url.MODEL);
		ThreadTime.sleep(5000);
		logger.info("编辑model开始");
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		modelPagePro.editModel(proUtil.getPro("edit_model_modelNo"));
		logger.info("编辑model结束");
		modelPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("编辑model成功");
	}

	@Test(groups = {"findModel"}, dependsOnGroups = { "createModel" }, alwaysRun = true)
	public void testFindModelsByModel() {
		driverBase.get(Url.BASE_URL + Url.MODEL);
		ThreadTime.sleep(5000);
		logger.info("testFindModelsByModel...");
		modelPagePro.findModelsByModel(new ProUtil(Common.PARAMETER).getPro("find_models_model"));
	}

	@Test(groups = {"findModel"}, dependsOnGroups = { "createModel" }, alwaysRun = true)
	public void testFindModelsByType() {
		driverBase.get(Url.BASE_URL + Url.MODEL);
		ThreadTime.sleep(5000);
		logger.info("testFindModelsByType...");
		modelPagePro.findModelsByType(new ProUtil(Common.PARAMETER).getPro("find_models_type"));
	}

	@Test(groups = {"findModel"}, dependsOnGroups = { "createModel" }, alwaysRun = true)
	public void testFindModelsByPlatform() {
		driverBase.get(Url.BASE_URL + Url.MODEL);
		ThreadTime.sleep(5000);
		logger.info("testFindModelsByPlatform...");
		modelPagePro.findModelsByPlatform(new ProUtil(Common.PARAMETER).getPro("find_models_platform"));
	}

	@Test(groups = {"findModel"}, dependsOnGroups = { "createModel" }, alwaysRun = true)
	public void testFindModelsByVendor() {
		driverBase.get(Url.BASE_URL + Url.MODEL);
		ThreadTime.sleep(5000);
		logger.info("testFindModelsByVendor...");
		modelPagePro.findModelsByVendor(new ProUtil(Common.PARAMETER).getPro("find_models_vendor"));
	}

	@Test(groups = {"deleteModel"}, dependsOnGroups = { "findModel", "editModel", "createModel"})
	public void testDeleteModel() {
		driverBase.get(Url.BASE_URL + Url.MODEL);
		ThreadTime.sleep(5000);
		logger.info("删除model开始");
		modelPagePro.deleteModel();
		logger.info("删除model结束");
		modelPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除model成功");
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		 driverBase.close();
	}
}
