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
import com.nxp.EdgeScale.business.CreateSolutionPagePro;
import com.nxp.EdgeScale.business.SolutionPagePro;
import com.nxp.EdgeScale.util.HandleCookie;
import com.nxp.EdgeScale.util.ProUtil;

public class CreateSolution extends CaseBase {

	private DriverBase driverBase;
	private CreateSolutionPagePro createSolutionPagePro;
	private HandleCookie handleCookie;

	private static Logger logger = Logger.getLogger(CreateSolution.class);

	@BeforeClass
	public void init() {
		this.driverBase = initDriver(Common.BROWSER);
		driverBase.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		createSolutionPagePro = new CreateSolutionPagePro(driverBase);
		handleCookie = new HandleCookie(driverBase);
		driverBase.get(Url.BASE_URL + Url.SOLUTION_CREATE);
		handleCookie.setCookie();
		driverBase.get(Url.BASE_URL + Url.SOLUTION_CREATE);
		// 防止出现页面加载完但是数据没有加载完的情况
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateSolution() {
		ProUtil proUtil = new ProUtil(Common.PARAMETER);
		logger.info("创建solution开始");
		createSolutionPagePro.createSolution(proUtil.getPro("create_solution_modelName"),
				proUtil.getPro("create_solution_solutionName"), proUtil.getPro("create_solution_version"),
				proUtil.getPro("create_solution_imageUrl"));
		logger.info("创建solution结束");
		createSolutionPagePro.verifyRightNotice(new ProUtil(Common.PARAMETER).getPro("login_success_notice"));
		logger.info("创建solution成功");
	}
	
	@AfterClass
	public void close() {
		driverBase.close();
	}


}
