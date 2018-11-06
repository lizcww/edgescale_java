package com.nxp.EdgeScale.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nxp.EdgeScale.Common;
import com.nxp.EdgeScale.Url;
import com.nxp.EdgeScale.base.CaseBase;
import com.nxp.EdgeScale.base.DriverBase;
import com.nxp.EdgeScale.business.CreateSolutionPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;
import com.nxp.EdgeScale.util.ThreadTime;

public class CreateSolution extends CaseBase {

	private DriverBase driverBase;
	private CreateSolutionPagePro createSolutionPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(CreateSolution.class);

	@BeforeClass(alwaysRun = true)
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		createSolutionPagePro = new CreateSolutionPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.SOLUTION_CREATE);
		handleCookie.setCookie_commonUser1();
		driverBase.get(Url.BASE_URL + Url.SOLUTION_CREATE);
		ThreadTime.sleep(3000);
	}

	@Test(groups = "createSolution")
	public void testCreateSolution_1() {
		driverBase.get(Url.BASE_URL + Url.SOLUTION_CREATE);
		ThreadTime.sleep(3000);
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		logger.info("创建solution开始");
		createSolutionPagePro.createSolution(proUtil.getPro("create_solution_modelName_1"),
				proUtil.getPro("create_solution_solutionName_1"), proUtil.getPro("create_solution_version_1"),
				proUtil.getPro("create_solution_imageUrl_1"));
		logger.info("创建solution结束");
		//createSolutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("创建solution成功");
	}
	
	//@Test(groups = "createSolution")
	public void testCreateSolution_2() {
		driverBase.get(Url.BASE_URL + Url.SOLUTION_CREATE);
		ThreadTime.sleep(3000);
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		logger.info("创建solution开始");
		createSolutionPagePro.createSolution(proUtil.getPro("create_solution_modelName_2"),
				proUtil.getPro("create_solution_solutionName_2"), proUtil.getPro("create_solution_version_2"),
				proUtil.getPro("create_solution_imageUrl_2"));
		logger.info("创建solution结束");
		//createSolutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("创建solution成功");
	}
	
	//@Test(groups = "createSolution")
	public void testCreateSolution_3() {
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		logger.info("创建solution开始");
		createSolutionPagePro.createSolution(proUtil.getPro("create_solution_modelName_3"),
				proUtil.getPro("create_solution_solutionName_3"), proUtil.getPro("create_solution_version_3"),
				proUtil.getPro("create_solution_imageUrl_3"));
		logger.info("创建solution结束");
		//createSolutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("创建solution成功");
	}
	
	@AfterClass(alwaysRun = true)
	public void close() {
		driverBase.close();
	}


}
