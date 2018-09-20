package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.AppDocumentPagePro;
import com.nxp.EdgeScale.business.AppEditInfoPagePro;
import com.nxp.EdgeScale.business.AppMutipleDeployPagePro;
import com.nxp.EdgeScale.business.AppPagePro;
import com.nxp.EdgeScale.business.ApplyPagePro;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.business.LoginPagePro;
import com.nxp.EdgeScale.handle.AppMutipleDeployPageHandle;
import com.nxp.EdgeScale.page.AppEditInfoPage;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class App extends CaseBase {

	private DriverBase driverBase;
	private AppPagePro appPagePro;
	private AppDocumentPagePro appDocumentPagePro;
	private AppMutipleDeployPagePro appMutipleDeployPagePro;
	private AppEditInfoPagePro appEditInfoPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(App.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		appPagePro = new AppPagePro(driverBase);
		appDocumentPagePro = new AppDocumentPagePro(driverBase);
		appMutipleDeployPagePro = new AppMutipleDeployPagePro(driverBase);
		appEditInfoPagePro = new AppEditInfoPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.APP);
		handleCookie.setCookie();
		driverBase.get(Url.BASE_URL + Url.APP);
//		afterMethod();
	}

	@BeforeMethod
	public void afterMethod() {
		driverBase.get(Url.BASE_URL + Url.APP);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteApp() {
		logger.info("删除app开始");
		appPagePro.deleteApp();
		logger.info("删除app结束");
		appPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除app成功");
	}

	@Test
	public void testDeployApp() {
		logger.info("deploy app开始");
		appPagePro.deployApp();
		logger.info("deploy app结束");
		appPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("deploy app成功");
	}

	@Test
	public void testDeployPublicApp() {
		logger.info("deploy public app开始");
		appPagePro.deployPublicApp();
		logger.info("deploy public app结束");
		appPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("deploy public app成功");
	}

	@Test
	public void testAppMutipleDeploy() {
		logger.info("App Mutiple Deploy开始");
		appMutipleDeployPagePro.mutipleDeployApp();
		logger.info("App Mutiple Deploy结束");
		appPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("App Mutiple Deploy成功");
	}

	@Test
	public void testUpdateAppDocument() {
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		logger.info("更新app document开始");
		appDocumentPagePro.updateAppDocument(proUtil.getPro("app_document_content"));
		logger.info("更新app document结束");
		appPagePro.vertifyTopNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("更新app document成功");
	}

	@Test
	public void testEditAppInfo() {
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		logger.info("App Mutiple Deploy开始");
		appEditInfoPagePro.editAppInfo(proUtil.getPro("app_edit_appName"), proUtil.getPro("app_edit_appDesc"));
		logger.info("App Mutiple Deploy结束");
		appPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("App Mutiple Deploy成功");
	}

	@Test
	public void testAppAddDocker() {
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		logger.info("App add docker开始");
		appEditInfoPagePro.appAddDocker(proUtil.getPro("app_add_docker_registry"),
				proUtil.getPro("app_add_docker_imageName"), proUtil.getPro("app_add_docker_version"));
		logger.info("App add docker结束");
		appPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("App add docker成功");
	}

	@Test
	public void testChangeAppPermission() {
		logger.info("change app permission开始");
		appEditInfoPagePro.changeAppPermission();
		logger.info("change app permission结束");
		appPagePro.vertifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("change app permission成功");
	}

	@AfterClass
	public void close() {
		driverBase.close();
	}

}
