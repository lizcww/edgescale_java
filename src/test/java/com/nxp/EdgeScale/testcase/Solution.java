package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.DevicePagePro;
import com.nxp.EdgeScale.business.SolutionPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class Solution extends CaseBase {

	private DriverBase driverBase;
	private SolutionPagePro solutionPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(Solution.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		solutionPagePro = new SolutionPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.SOLUTION);
		handleCookie.setCookie_commonUser1();
	}

	@Test(groups = {"addSolutionTag"}, dependsOnGroups = { "createSolution" }, alwaysRun = true)
	public void aa_testAddSolutionTag() {
		driverBase.get(Url.BASE_URL + Url.SOLUTION);
		ThreadTime.sleep(5000);
		logger.info("添加tag开始");
		solutionPagePro.addNewTag(new ProUtil(Common.PARAMETER).getPro("solution_add_tag"));
		logger.info("添加tag结束");
		solutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("添加tag成功");
	}

	@Test(groups = {"deleteSolutionTag"}, dependsOnGroups = { "createSolution", "addSolutionTag" })
	public void ab_testDeleteTag() {
		driverBase.get(Url.BASE_URL + Url.SOLUTION);
		ThreadTime.sleep(5000);
		logger.info("删除tag开始");
		solutionPagePro.deleteTag();
		logger.info("删除tag结束");
		solutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除tag成功");
	}

	@Test(groups = {"deploySolution"}, dependsOnGroups = { "createSolution" })
	public void ac_testDeploySolution() {
		driverBase.get(Url.BASE_URL + Url.SOLUTION);
		ThreadTime.sleep(5000);
		logger.info("部署solution开始");
		solutionPagePro.deploySolution();
		logger.info("部署solution结束");
		solutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("部署solution成功");
	}

	@Test(groups = {"downloadImage"}, dependsOnGroups = { "createSolution" })
	public void ad_testDownImage() {
		driverBase.get(Url.BASE_URL + Url.SOLUTION);
		ThreadTime.sleep(5000);
		logger.info("下载image开始");
		solutionPagePro.downImage();
		logger.info("下载image成功");
	}

	@Test(groups = {"editSolution"}, dependsOnGroups = { "createSolution" }, alwaysRun = true)
	public void ae_testEditSolution() {
		driverBase.get(Url.BASE_URL + Url.SOLUTION);
		ThreadTime.sleep(5000);
		logger.info("编辑solution开始");
		solutionPagePro.editSolution();
		logger.info("编辑solution结束");
//		solutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
//		logger.info("编辑solution成功");
	}

	@Test(groups = "deleteSolution", dependsOnGroups = { "deleteSolutionTag", "editSolution", "downloadImage", "deploySolution"}, alwaysRun = true)
	public void zz_testDeleteSolution() {
		driverBase.get(Url.BASE_URL + Url.SOLUTION);
		ThreadTime.sleep(5000);
		logger.info("删除solution开始");
		solutionPagePro.deleteSolution();
		logger.info("删除solution结束");
		solutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("删除solution成功");
	}

	@AfterClass(alwaysRun = true)
	public void close() {
		driverBase.close();
	}

}
